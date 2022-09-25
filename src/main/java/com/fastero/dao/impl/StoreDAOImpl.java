package com.fastero.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.fastero.dao.intf.StoreDAO;
import com.fastero.vo.StoreVO;
//
public class StoreDAOImpl implements StoreDAO {
//	private DataSource dataSource;
//	public StoreDAOImpl() throws NamingException {
//		dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/FASTERO");
//	}
	@Override
	public List<StoreVO> selectAll(){
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement pstt = conn.prepareStatement("SELECT * FROM FASTERO.Store");
				ResultSet rSet = pstt.executeQuery()
		){
//			store_id, store_name, store_address, store_longitude, store_latitude, store_phone, 
//			store_email, store_admin_account, store_admin_password, store_admin_phone, 
//			store_admin_address, store_preview_img, store_introduction, store_open_status, 
//			store_account_status, store_admin_name, store_admin_id, store_build_time, 
//			store_update_time, store_comment_number, store_total_star, store_business_time
			List<StoreVO> list = new ArrayList<>();
			while (rSet.next()) {
				StoreVO storeVO = new StoreVO();
				storeVO.setStoreId(rSet.getInt("store_id"));
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
				storeVO.setStoreImg(rSet.getBlob("store_preview_img"));
				storeVO.setStoreIntroduction(rSet.getNString("store_introduction"));
				storeVO.setStoreOpenStatus(rSet.getByte("store_open_status"));
				storeVO.setStoreAccountStatus(rSet.getInt("store_account_status"));
				storeVO.setStoreAdminName(rSet.getNString("store_admin_name"));
				storeVO.setstoreAdminId(rSet.getNString("store_admin_id"));
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
	public Integer insert(StoreVO vo) {
//		store_id, store_name, store_address, store_longitude, store_latitude, store_phone, 
//		store_email, store_admin_account, store_admin_password, store_admin_phone, 
//		store_admin_address, store_preview_img, store_introduction, store_open_status, 
//		store_account_status, store_admin_name, store_admin_id, store_build_time, 
//		store_update_time, store_comment_number, store_total_star, store_business_time
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = conn.prepareStatement("insert into `store` (store_admin_account, store_admin_password, "
														   + "store_admin_name, store_admin_id, store_admin_phone, store_admin_address, "
														   + "store_name, store_address, store_phone, store_email, store_introduction) "
														   + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		){
			
			ps.setString(1, vo.getStoreAdminAccount());
			ps.setString(2, vo.getStoreAdminPassword());
			ps.setString(3, vo.getStoreAdminName());
			ps.setString(4, vo.getstoreAdminId());
			ps.setString(5, vo.getStoreAdminPhone());
			ps.setString(6, vo.getStoreAdminAddress());
			ps.setString(7, vo.getStoreName());
			ps.setString(8, vo.getStoreAddress());
			ps.setString(9, vo.getStorePhone());
			ps.setString(10, vo.getStoreEmail());
			ps.setString(11, vo.getStoreIntroduction());

			ps.executeUpdate();
			return 1;
			
		}catch (Exception e) {
			e.printStackTrace();
			return -1; 
		}
	}
}
