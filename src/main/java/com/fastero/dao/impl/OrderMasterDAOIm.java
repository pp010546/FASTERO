package com.fastero.dao.impl;

import java.sql.Connection;
<<<<<<< HEAD
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.fastero.dao.intf.OderMasterDAOIn;
import com.fastero.dao.sql.OrderMasterSQL;
import com.fastero.model.OrderMasterVO;

public class OrderMasterDAOIm implements OderMasterDAOIn {

	private static DataSource ds = null;
	private static OrderMasterSQL SQL = null;

	public OrderMasterDAOIm() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/FASTERO");
			SQL = new OrderMasterSQL();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderMasterVO> getAll() {
		List<OrderMasterVO> list = new ArrayList<>();
		OrderMasterVO vo = null;
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(SQL.GET_ALL);) {
			System.out.println("連線成功");
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
//							order_id, user_id, store_id, order_status, order_amount, 
//							order_time, update_time, order_remark
					vo = new OrderMasterVO();

					vo.setOrderId(rs.getInt("order_id"));
					vo.setUseId(rs.getInt("user_id"));
					vo.setStoreId(rs.getInt("store_id"));
					vo.setOrderStatus(rs.getInt("order_status"));
					vo.setOrderAmount(rs.getInt("order_amount"));
					vo.setOrderTime(rs.getString("order_time"));
					vo.setUpdateTime(rs.getString("update_time"));
					vo.setOrderRemark(rs.getString("order_remark"));
=======
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fastero.dao.intf.OrderMasterDAO;
import com.fastero.dao.sql.OrderMasterSQL;
import com.fastero.vo.OrderMasterVO;

public class OrderMasterDAOIm implements OrderMasterDAO {

	@Override
	public List<OrderMasterVO> getAll() throws Exception {
		List<OrderMasterVO> list = new ArrayList<OrderMasterVO>();

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(OrderMasterSQL.GET_ALL);) {
			System.out.println("連線成功");

			OrderMasterVO vo;

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					// order_id, user_id, store_id, order_status, order_amount, order_time,
					// update_time, order_remark
//					
					vo = new OrderMasterVO();
					vo.setOrderId(rs.getInt("order_id"));
					vo.setUserId(rs.getInt("user_id"));
					vo.setStoreId(rs.getInt("store_id"));
					vo.setOrderStatus(rs.getByte("order_status"));
					vo.setOrderAmount(rs.getInt("order_amount"));
					vo.setOrderTime(rs.getObject("order_time", LocalDateTime.class));
					vo.setUpdateTime(rs.getObject("update_time", LocalDateTime.class));
					vo.setOrderRemark(rs.getString("order_remark"));

>>>>>>> Philip
					list.add(vo);
				}
			}

<<<<<<< HEAD
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error();
		}

		return list;
=======
			return list;
		}
	}

	@Override
	public List<OrderMasterVO> getById(Integer id) throws Exception {
		List<OrderMasterVO> list = new ArrayList<OrderMasterVO>();

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(OrderMasterSQL.GET_BY_ID);) {
			System.out.println("連線成功");

			OrderMasterVO vo;

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					vo = new OrderMasterVO();
					vo.setOrderId(rs.getInt("order_id"));
					vo.setUserId(rs.getInt("user_id"));
					vo.setStoreId(rs.getInt("store_id"));
					vo.setOrderStatus(rs.getByte("order_status"));
					vo.setOrderAmount(rs.getInt("order_amount"));
					vo.setOrderTime(rs.getObject("order_time", LocalDateTime.class));
					vo.setUpdateTime(rs.getObject("update_time", LocalDateTime.class));
					vo.setOrderRemark(rs.getString("order_remark"));

					list.add(vo);
				}
			}
			return list;

		}
>>>>>>> Philip
	}

}
