package com.fastero.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.fastero.dao.intf.StoreDAO;
import com.fastero.model.StoreVO;

//
public class StoreDAOImpl implements StoreDAO {
    private DataSource dataSource;

    public StoreDAOImpl() throws NamingException {
        dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/FASTERO");
    }
//    private static DataSource dataSource;
//    static {
//        try {
//            Context ctx = new InitialContext();
//
//            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/FASTERO");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    @Override
    public List<StoreVO> selectAll() {
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstt = conn.prepareStatement("SELECT * FROM FASTERO.Store");
                ResultSet rSet = pstt.executeQuery()) {
            List<StoreVO> list = new ArrayList<>();
            while (rSet.next()) {
                StoreVO storeVO = new StoreVO();
                storeVO.setStoreID(rSet.getInt("store_id"));
                storeVO.setStoreName(rSet.getString("store_name"));
                storeVO.setStoreAddress(rSet.getNString("store_address"));
                storeVO.setLongitude(rSet.getNString("store_longitude"));
                storeVO.setLatitude(rSet.getString("store_latitude"));
                storeVO.setStorePhone(rSet.getNString("store_phone"));
                storeVO.setStoreEmail(rSet.getNString("store_email"));
                storeVO.setStoreAdminAccount(rSet.getNString("store_admin_account"));
                storeVO.setStoreAdminPassword(rSet.getNString("store_admin_password"));
                storeVO.setStoreAdminPhone(rSet.getNString("store_admin_phone"));
                storeVO.setStoreAdminAddress(rSet.getNString("store_admin_address"));
                try {
                    storeVO.setStoreImg(Base64.getDecoder().decode(rSet.getBytes("store_preview_img")));
                } catch (Exception e) {
                    storeVO.setStoreImg(null);
                }
                storeVO.setStoreIntroduction(rSet.getNString("store_introduction"));
                storeVO.setStoreOpenStatus(rSet.getByte("store_open_status"));
                storeVO.setStoreAccountStatus(rSet.getInt("store_account_status"));
                storeVO.setStoreAdminName(rSet.getNString("store_admin_name"));
                storeVO.setStoreAdminID(rSet.getNString("store_admin_id"));
                storeVO.setStoreBuildTime(rSet.getDate("store_build_time"));
                storeVO.setStoreUpdteTime(rSet.getDate("store_update_time"));
                storeVO.setStoreCommentNumber(rSet.getInt("store_comment_number"));
                storeVO.setStoreTotalStar(rSet.getInt("store_total_star"));
                storeVO.setStoreBusinessTime(rSet.getString("store_business_time"));
                list.add(storeVO);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insert(StoreVO storeVO) {

    }

    @Override
    public void update(StoreVO storeVO) {

    }

    @Override
    public StoreVO selectBystoreId(Integer storeId) {
        final String sql = "SELECT store_name, store_preview_img FROM Store where store_id = ?";
        try (Connection conn = dataSource.getConnection(); 
                PreparedStatement ptst = conn.prepareStatement(sql);) 
            {
                ptst.setInt(1, storeId);
                try (ResultSet rs = ptst.executeQuery()) {
                    if (rs.next()) {
                    StoreVO storeVO = new StoreVO();
                    storeVO.setStoreName(rs.getString("store_name"));
                    storeVO.setStoreImg(rs.getBytes("store_preview_img"));
//                    try {
//                        storeVO.setStoreImg(Base64.getDecoder().decode(rs.getBytes("store_preview_img")));
//                    } catch (Exception e) {
//                        storeVO.setStoreImg(null);
//                    }
                    return storeVO;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<StoreVO> selectShortStoreList() {
        String sqlString = "SELECT store_name, store_preview_img, store_introduction, store_business_time FROM Store WHERE store_id = 1;";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstt = conn.prepareStatement(sqlString);
                ResultSet rSet = pstt.executeQuery()) {
            
            List<StoreVO> list = new ArrayList<>();

            while (rSet.next()) {
                StoreVO storeVO = new StoreVO();
                storeVO.setStoreName(rSet.getString("store_name"));
                try {
                    storeVO.setSimgString(Base64.getEncoder().encodeToString(rSet.getBytes("store_preview_img")));
                } catch (Exception e) {
                    storeVO.setSimgString(null);
                }
//                storeVO.setStoreImg(rSet.getBytes("store_preview_img"));
//                try {
//                    storeVO.setStoreImg(Base64.getDecoder().decode(rSet.getBytes("store_preview_img")));
//                } catch (Exception e) {
//                    storeVO.setStoreImg(null);
//                }
                storeVO.setStoreIntroduction(rSet.getString("store_introduction"));
                storeVO.setStoreBusinessTime(rSet.getString("store_business_time"));
                list.add(storeVO);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<StoreVO> selecList() {
        String sql = "SELECT store_id, store_name, store_preview_img, store_introduction, store_business_time, store_type FROM Store;";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery();

        ) {
            List<StoreVO> list = new ArrayList<>();
            while (rSet.next()) {
                StoreVO storeVO = new StoreVO();
                storeVO.setStoreID(rSet.getInt("store_id"));
                storeVO.setStoreName(rSet.getString("store_name"));
                try {
                    storeVO.setSimgString(Base64.getEncoder().encodeToString(rSet.getBytes("store_preview_img")));
                } catch (Exception e) {
                    storeVO.setSimgString(null);
                }               
                storeVO.setStoreIntroduction(rSet.getNString("store_introduction"));                
                storeVO.setStoreBusinessTime(rSet.getNString("store_business_time"));
                storeVO.setStoreType(rSet.getString("store_type"));
                list.add(storeVO);             
            }
            return list;
        } catch (Exception e) {

        }
        return null;
    }
    @Override
    public List<StoreVO> newStoreList() {
       String sql = "SELECT store_id, store_name, store_preview_img, store_introduction, store_business_time, store_type FROM Store order by store_total_star;";
       try (Connection connection = dataSource.getConnection();
               PreparedStatement statement = connection.prepareStatement(sql);
               ResultSet rSet = statement.executeQuery();

       ) {
           List<StoreVO> list = new ArrayList<>();
           while (rSet.next()) {
               StoreVO storeVO = new StoreVO();
               storeVO.setStoreID(rSet.getInt("store_id"));
               storeVO.setStoreName(rSet.getString("store_name"));
               try {
                   storeVO.setSimgString(Base64.getEncoder().encodeToString(rSet.getBytes("store_preview_img")));
               } catch (Exception e) {
                   storeVO.setSimgString(null);
               }               
               storeVO.setStoreIntroduction(rSet.getNString("store_introduction"));                
               storeVO.setStoreBusinessTime(rSet.getNString("store_business_time"));
               storeVO.setStoreType(rSet.getString("store_type"));
               list.add(storeVO);             
           }
           return list;
       } catch (Exception e) {

       }
       return null;
    }

}
