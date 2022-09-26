package com.fastero.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.fastero.model.ProductVO;



public class ProductDAO {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/FASTERO");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	//product_id,store_id,product_name,product_introduction,product_price,
	//product_satus,product_wait_time,product_build_time,product_update_time
	private static final String INSERT_STMT = 
			"INSERT INTO Product (store_id, product_name, product_introduction, product_price, product_satus, product_wait_time) VALUES (?, ?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT product_id,store_id,product_name,product_introduction,product_price,product_satus,product_wait_time,product_build_time,product_update_time FROM Product order by product_id";
		private static final String GET_ONE_STMT = 
			"SELECT product_id,store_id,product_name,product_introduction,product_price,product_satus,product_wait_time,product_build_time,product_update_time FROM Product where product_id = ?";
		private static final String DELETE = 
			"DELETE FROM Product where product_id = ?";
		private static final String UPDATE = 
			"UPDATE Product set product_name=?, product_introduction=?, product_price=?, product_satus=?,product_wait_time=? where product_id = ?";
	
		
		public void insert(ProductVO productVO) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setInt(1, productVO.getStore_id());
				pstmt.setString(2, productVO.getProduct_name());
				pstmt.setString(3, productVO.getProduct_introduction());
				pstmt.setInt(4, productVO.getProduct_price());
				pstmt.setInt(5, productVO.getProduct_satus());
				pstmt.setDate(6, productVO.getProduct_wait_time());
				

				pstmt.executeUpdate();

				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
						
		}
		public void update(ProductVO productVO) {

			Connection con = null;
			PreparedStatement pstmt = null;
			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setString(1, productVO.getProduct_name());
				pstmt.setString(2, productVO.getProduct_introduction());
				pstmt.setInt(3, productVO.getProduct_satus());
				pstmt.setInt(4, productVO.getProduct_price());
				pstmt.setDate(5, productVO.getProduct_wait_time());
				pstmt.setInt(6, productVO.getProduct_id());
				pstmt.executeUpdate();

				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
			
		}
		
		public void delete(Integer product_id) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, product_id);

				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}

			
		}
		public ProductVO findByPrimaryKey(Integer product_id) {
			List<ProductVO> list = new ArrayList<ProductVO>();
			ProductVO productVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, product_id);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// empVo 也稱為 Domain objects
					productVO = new ProductVO();
					pstmt.setInt(1, productVO.getProduct_id());
					pstmt.setInt(2, productVO.getStore_id());
					pstmt.setString(3, productVO.getProduct_name());
					pstmt.setString(4, productVO.getProduct_introduction());
					pstmt.setInt(5, productVO.getProduct_satus());
					pstmt.setInt(6, productVO.getProduct_price());
					pstmt.setDate(7, productVO.getProduct_wait_time());
					pstmt.setDate(8, productVO.getProduct_update_time());
					list.add(productVO);
				}

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
		
			return productVO;
		}
		
		public List<ProductVO> getAll() {
			List<ProductVO> list = new ArrayList<ProductVO>();
			ProductVO productVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					// empVO 也稱為 Domain objects
					productVO = new ProductVO();
					pstmt.setInt(1, productVO.getProduct_id());
					pstmt.setInt(2, productVO.getStore_id());
					pstmt.setString(3, productVO.getProduct_name());
					pstmt.setString(4, productVO.getProduct_introduction());
					pstmt.setInt(5, productVO.getProduct_satus());
					pstmt.setInt(6, productVO.getProduct_price());
					pstmt.setDate(7, productVO.getProduct_wait_time());
					pstmt.setDate(8, productVO.getProduct_build_time());
					pstmt.setDate(9, productVO.getProduct_update_time());
					list.add(productVO); // Store the row in the list
				}

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
			return list;
		
		}
	
}
