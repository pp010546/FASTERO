package com.fastero.service.impl;

import java.util.List;

import javax.naming.NamingException;

import com.fastero.common.Regex;
import com.fastero.common.Result;
import com.fastero.dao.impl.StoreDAOImpl;
import com.fastero.dao.impl.UserDAOIm;
import com.fastero.dao.intf.StoreDAO;
import com.fastero.vo.StoreVO;
import com.fastero.service.intf.StoreService;

//
public class StoreServiceImpl implements StoreService {
	private StoreDAOImpl DAO;

	// RESTFUL
	private Result R;

	public StoreServiceImpl() {

		DAO = new StoreDAOImpl();
		R = new Result();
	}

	@Override
	public List<StoreVO> findAllStores() {

		return DAO.selectAll();
	}

	@Override
	public Result register(StoreVO vo) {

		try {
			String account = vo.getStoreAdminAccount();
			String password = vo.getStoreAdminPassword();
			String adminName = vo.getStoreAdminName();
			String adminId = vo.getstoreAdminId();
			String adminPhone = vo.getStoreAdminPhone();
			String adminAddress = vo.getStoreAdminAddress();
			String storeName = vo.getStoreName();
			String storeAddress = vo.getStoreAddress();
			String storePhone = vo.getStorePhone();
			String storeEmail = vo.getStoreEmail();
			
			//1. 檢查帳號
			if(account == null || "".equals(account)) return R.fail("帳號不得為空！");
				//1-1. 檢查帳號是否存在
				if(DAO.getByAccount(account) != null) return R.fail("帳號已存在！");
				// 	1-2. 檢查帳號是否為email
				if (!Regex.emailCheck(account)) return R.fail("email格式錯誤！");
				
			//2. 檢查密碼
			if(password == null || "".equals(password)) return R.fail("密碼不得為空！");
				//2-1. 檢查密碼格式
				if (!Regex.passwordCheck(password)) return R.fail("密碼格式錯誤！");
				
			//3. 檢查負責人姓名
			if(adminName == null || "".equals(adminName)) return R.fail("負責人姓名不得為空！");
				// 	3-1. 檢查姓名格式
				if(!Regex.nameCheck(adminName)) return R.fail("姓名格式錯誤！");
				
			//4. 檢查負責人身分證字號
			if(adminId == null || "".equals(adminId)) return R.fail("負責人身分證號不得為空！");
				//4-1. 檢查是否重複
				if(DAO.getByAdminId(adminId)) return R.fail("負責人身分證號已被使用！");
				//4-2. 檢查身分證字號格式
				if(!Regex.idcheck(adminId)) return R.fail("身分證字號格式錯誤！");
			
			//5. 檢查負責人電話
			if(adminPhone == null || "".equals(adminPhone)) return R.fail("負責人電話不得為空！");
				//5-1. 檢查電話格式
				if(!Regex.phoneCheck(adminPhone)) return R.fail("電話格式錯誤！");
				
			//6. 檢查負責人地址
			if(adminAddress == null || "".equals(adminAddress)) return R.fail("負責人地址不得為空！");
			
			//7. 檢查店家名稱
			if(storeName == null || "".equals(storeName)) return R.fail("店家名稱不得為空！");
			
			//8. 檢查店家地址
			if(storeAddress == null || "".equals(storeAddress)) return R.fail("店家地址不得為空！");
			
			//9. 檢查店家電話
			if(storePhone == null || "".equals(storePhone)) return R.fail("店家電話不得為空！");
			
			//10. 檢查店家信箱
			if(storeEmail == null || "".equals(storeEmail)) return R.fail("店家信箱不得為空！");
				//10-1. 檢查帳號是否為email
				if (!Regex.emailCheck(account)) return R.fail("email格式錯誤！");
			
			//資料無誤，輸入進DB
			return R.success(DAO.insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result login(String account, String password) {
		try {
			// 檢查是否有該帳號
			if (DAO.getByAccount(account) != null) {
				// 檢查密碼是否相符
				if (password.equals(DAO.getByAccount(account).getStoreAdminPassword())) {
					return R.success(DAO.getByAccount(account));
				}else {
					System.out.println("密碼錯誤");
				}
			}else {
				System.out.println("無帳號");
			}
			return R.fail("帳號或密碼錯誤");
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

}
