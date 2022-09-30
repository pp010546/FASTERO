package com.fastero.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fastero.dao.intf.UserDAO;
import com.fastero.dao.sql.UserSQL;
import com.fastero.vo.UserVO;

public class UserDAOIm implements UserDAO {

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

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(UserSQL.GET_ALL);) {
			System.out.println("連線成功...準備查詢全部");
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
//					System.out.println(vo.getUserBuildTime());
					vo.setUserStatus(rs.getByte("user_status"));

					list.add(vo);
				}
			}
			System.out.println("資料查詢成功");
			return list;
		}
	}

	@Override
	public UserVO getById(Integer id) throws SQLException {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(UserSQL.GET_BY_ID);) {
			
			ps.setInt(1, id);
			
			try(ResultSet rs = ps.executeQuery();){
				
				UserVO vo = null;
				
				if(rs.next()) {
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
					vo.setUserStatus(rs.getByte("user_status"));
					
					return vo;
				}
				
			}
			
		}
		return null;
	}

	@Override
	public Integer insert(UserVO vo) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(UserSQL.INSERT);) {
			System.out.println("連線成功...準備寫入資料");

			ps.setString(1, vo.getUserAccount());
			ps.setString(2, vo.getUserPassword());
			ps.setString(3, vo.getUserName());
			ps.setString(4, vo.getUserPhone());

			ps.executeUpdate();
			System.out.println("資料寫入成功");
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("資料寫入失敗");
			return -1;
		}
	}

	@Override
	public UserVO getByAccount(String account) throws Exception {

		final String sql = "select * from `User` where user_account = ?";

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(sql);) {
			System.out.println("連線成功...準備查詢帳號密碼");

			ps.setString(1, account);

			try (ResultSet rs = ps.executeQuery()) {
				
				UserVO vo = null;
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
//					System.out.println(vo.getUserBuildTime());
					vo.setUserStatus(rs.getByte("user_status"));
				}
				return vo;
			}
		}
	}

	@Override
	public Integer update(UserVO vo) throws SQLException {

		final String sql = "update `User` set user_password = ?, user_name = ?, user_phone = ? where user_id = ?";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setString(1, vo.getUserPassword());
			ps.setString(2, vo.getUserName());
			ps.setString(3, vo.getUserPhone());
			ps.setInt(4, vo.getUserId());
			
			return ps.executeUpdate();
			
		}
	}

	@Override
	public Integer updateNoPassword(UserVO vo) throws SQLException {
		final String sql = "update `User` set user_name = ?, user_phone = ? where user_id = ?";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setString(1, vo.getUserName());
			ps.setString(2, vo.getUserPhone());
			ps.setInt(3, vo.getUserId());
			
			return ps.executeUpdate();
			
		}
	}

};
