package com.fastero.service.impl;

import com.fastero.common.Regex;
import com.fastero.common.Result;
import com.fastero.dao.impl.UserDAOIm;
import com.fastero.service.intf.UserService;
import com.fastero.vo.UserVO;

public class UserServiceIm implements UserService {

	private UserDAOIm DAO;
	// RESTFUL
	private Result R;

	public UserServiceIm() {
		DAO = new UserDAOIm();
		R = new Result();
	}

	@Override
	public Result getAll() {
		try {
			return R.success(DAO.getAll());
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result getById(Integer id) {
		try {
			return R.success(DAO.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	public Result register(UserVO vo) {

		String account = vo.getUserAccount();
		String password = vo.getUserPassword();
		String name = vo.getUserName();
		String phone = vo.getUserPhone();
		
		try {
			// 1.檢查帳號
			if(account == null || "".equals(account)) return R.fail("帳號不可為空！");
				// 	1-1. 檢查帳號是否存在
				if (DAO.getByAccount(account) != null) return R.fail("帳號已存在！");
				// 	1-2. 檢查帳號是否為email
				if (!Regex.emailCheck(account)) return R.fail("email格式錯誤！");
			// 2.檢查密碼
			if(password == null || "".equals(password)) return R.fail("密碼不可為空！");
				// 	2-1. 檢查密碼格式
				if (!Regex.passwordCheck(password)) return R.fail("密碼格式錯誤！");
			// 3. 檢查姓名
			if(name == null || "".equals(name)) return R.fail("姓名不可為空！");
				// 	3-1. 檢查姓名格式
				if(!Regex.nameCheck(name)) return R.fail("姓名格式錯誤！");
			// 4. 檢查電話
			if(phone == null || "".equals(phone)) return R.fail("電話不可為空！");
				// 	4-1 檢查電話格式
				if(!Regex.phoneCheck(phone)) return R.fail("電話格式錯誤！");
			
			//檢查完畢無問題，將資料寫DB
			
			return R.success(DAO.insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	public Result login(String account, String password) {

		try {
			// 檢查是否有該帳號
			if (DAO.getByAccount(account) != null) {
				// 檢查密碼是否相符
				if (password.equals(DAO.getByAccount(account).getUserPassword())) {
					return R.success(DAO.getByAccount(account));
				}
			}
			return R.fail("帳號或密碼錯誤");
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}

	}

	@Override
	public Result update(UserVO vo) {
		try {
			// 若傳進來的vo沒有password，要呼叫updateNoPassword方法
			if(vo.getUserPassword() == null) {
				return R.success(DAO.updateNoPassword(vo));
			}else {
				return R.success(DAO.update(vo));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}
}
