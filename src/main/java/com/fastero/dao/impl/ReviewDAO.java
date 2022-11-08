package com.fastero.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.fastero.dao.intf.ReviewDAOIntf;
import com.fastero.model.ReviewVO;

//
public class ReviewDAO implements ReviewDAOIntf {

    // 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
    private static DataSource dataSource;
    static {
        try {
            Context ctx = new InitialContext();

            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/FASTERO");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ReviewVO> getById() {
        String sql = "SELECT review_id, store_id, user_id, review_point, review_text, review_store_response, review_time FROM Review WHERE store_id = 1;";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();) {
            List<ReviewVO> list = new ArrayList<>();
            while (rs.next()) {
                ReviewVO reviewVO = new ReviewVO();
                reviewVO.setReview_id(rs.getInt("review_id"));
                reviewVO.setUser_id(rs.getInt("user_id"));
                reviewVO.setStore_id(rs.getInt("store_id"));
                reviewVO.setReview_point(rs.getInt("review_point"));
                reviewVO.setReview_text(rs.getString("review_text"));
                reviewVO.setReview_store_response(rs.getString("review_store_response"));
                reviewVO.setReview_time(rs.getDate("review_time"));
                list.add(reviewVO);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final String GET_ONE_STMT = "SELECT review_id,user_id,store_id,review_point,review_text,review_store_response,review_time FROM Review where user_id = 1";

    @Override
    public List<ReviewVO> findByPrimaryKey() {
        List<ReviewVO> list = new ArrayList<ReviewVO>();
        ReviewVO reviewVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = dataSource.getConnection();
            pstmt = con.prepareStatement(GET_ONE_STMT);
//            pstmt.setInt(1, user_id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                reviewVO = new ReviewVO();
                reviewVO.setReview_id(rs.getInt("review_id"));
                reviewVO.setUser_id(rs.getInt("user_id"));
                reviewVO.setStore_id(rs.getInt("store_id"));
                reviewVO.setReview_point(rs.getInt("review_point"));
                reviewVO.setReview_text(rs.getString("review_text"));
                reviewVO.setReview_store_response(rs.getString("review_store_response"));
                reviewVO.setReview_time(rs.getDate("review_time"));
                list.add(reviewVO);
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

//	review_id,user_id,store_id,review_point,review_text,review_store_response,review_time
    private static final String INSERT_STMT = "INSERT INTO Review (user_id,store_id,review_point,review_text,review_store_response) VALUES (?, ?, ?, ?,?)";
    private static final String GET_ALL_STMT = "SELECT review_id,user_id,store_id,review_point,review_text,review_store_response,review_time FROM Review order by review_id";
    private static final String DELETE = "DELETE FROM Review where review_id = ?";

    private static final String GET_BY_ID = "SELECT * FROM REVIEW WHERE review_id = ?;";

    public ReviewVO getByReviewId() {
			   
                try (Connection connection = dataSource.getConnection();
                        PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
                        ResultSet rs = statement.executeQuery();)
                {   ReviewVO reviewVO = new ReviewVO();
                    while (rs.next()) {                        
                        reviewVO.setReview_id(rs.getInt("review_id"));
                        reviewVO.setUser_id(rs.getInt("user_id"));
                        reviewVO.setStore_id(rs.getInt("store_id"));
                        reviewVO.setReview_point(rs.getInt("review_point"));
                        reviewVO.setReview_text(rs.getString("review_text"));
                        reviewVO.setReview_store_response(rs.getString("review_store_response"));
                        reviewVO.setReview_time(rs.getDate("review_time"));  
                }   
                    return reviewVO;       
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

    @Override
    public void insert(ReviewVO reviewVO) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {

            con = dataSource.getConnection();
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setInt(1, reviewVO.getUser_id());
            pstmt.setInt(2, reviewVO.getStore_id());
            pstmt.setInt(3, reviewVO.getReview_point());
            pstmt.setString(4, reviewVO.getReview_text());
            pstmt.setString(5, "店家尚未回覆");
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

    private static final String UPDATE = "UPDATE Review set user_id=?, store_id=?, review_point=?, review_text=? where review_id = ?";

    @Override
    public void update(ReviewVO reviewVO) {

        Connection con = null;
        PreparedStatement pstmt = null;
        try {

            con = dataSource.getConnection();
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setInt(1, reviewVO.getUser_id());
            pstmt.setInt(2, reviewVO.getStore_id());
            pstmt.setInt(3, reviewVO.getReview_point());
            pstmt.setString(4, reviewVO.getReview_text());
            pstmt.setInt(5, reviewVO.getReview_id());

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

    @Override
    public void delete(Integer review_id) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            con = dataSource.getConnection();
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, review_id);

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

    @Override
    public List<ReviewVO> getAll() {
        List<ReviewVO> list = new ArrayList<ReviewVO>();
        ReviewVO ReviewVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = dataSource.getConnection();
            pstmt = con.prepareStatement(GET_ALL_STMT);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                ReviewVO = new ReviewVO();
                ReviewVO.setReview_id(rs.getInt("review_id"));
                ReviewVO.setUser_id(rs.getInt("user_id"));
                ReviewVO.setStore_id(rs.getInt("store_id"));
                ReviewVO.setReview_point(rs.getInt("review_point"));
                ReviewVO.setReview_text(rs.getString("review_text"));
                ReviewVO.setReview_store_response(rs.getString("review_store_response"));
                ReviewVO.setReview_time(rs.getDate("review_time"));
                list.add(ReviewVO); // Store the row in the list
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

//			private static final String GET_ONE = 
//		            "SELECT review_id,user_id,store_id,review_point,review_text,review_store_response,review_time FROM Review where user_id = ?";
    private static final String GET_ONE_SELECT = "SELECT review_id,user_id,store_id,review_point,review_text,review_store_response,review_time FROM Review where review_id = ?";

    @Override
    public ReviewVO findReviewid(Integer review_id) {
        ReviewVO reviewVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = dataSource.getConnection();
            pstmt = con.prepareStatement(GET_ONE_SELECT);

            pstmt.setInt(1, review_id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                // empVo 也稱為 Domain objects
                reviewVO = new ReviewVO();
                reviewVO.setReview_id(rs.getInt("review_id"));
                reviewVO.setUser_id(rs.getInt("user_id"));
                reviewVO.setStore_id(rs.getInt("store_id"));
                reviewVO.setReview_point(rs.getInt("review_point"));
                reviewVO.setReview_text(rs.getString("review_text"));
                reviewVO.setReview_store_response(rs.getString("review_store_response"));
                reviewVO.setReview_time(rs.getDate("review_time"));
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

        return reviewVO;
    }

}
