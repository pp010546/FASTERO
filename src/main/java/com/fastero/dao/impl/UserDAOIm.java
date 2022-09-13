package com.fastero.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.fastero.dao.intf.UserDAOIn;
import com.fastero.dao.sql.UserSQL;
import com.fastero.model.UserVO;

public class UserDAOIm implements UserDAOIn {

//	private DataSource ds;

//	public UserDAOIm() {
//		try {
//			Context ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/FASTERO");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public List<UserVO> getAll() throws Exception {
		List<UserVO> list = new ArrayList<UserVO>();

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO",
															"root", 
															"password");
				PreparedStatement ps = con.prepareStatement(UserSQL.GET_ALL);) {
			System.out.println("連線成功");
			try (ResultSet rs = ps.executeQuery()) {
				UserVO vo;
				while (rs.next()) {

					// user_id user_account user_password user_name user_phone user_build_time
					// user_status
					// 'userId', 'userAccount', 'userPassword', 'userName', 'userPhone',
					// 'userBuildTime', 'userStatus'

					vo = new UserVO();
					vo.setUserId(rs.getInt("user_id"));
					vo.setUserAccount(rs.getString("user_account"));
					vo.setUserPassword(rs.getString("user_password"));
					vo.setUserName(rs.getString("user_name"));
					vo.setUserPhone(rs.getString("user_phone"));
					vo.setUserBuildTime(rs.getObject("user_build_time", LocalDateTime.class));
					System.out.println(vo.getUserBuildTime());
					vo.setUserStatus(rs.getByte("user_status"));

					list.add(vo);
				}
			}
			return list;
		}
	}

	@Override
	public List<UserVO> getById(Integer id) {

		return null;
	};
}
