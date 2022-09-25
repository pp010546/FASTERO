package com.fastero.service.impl;

import java.util.List;

import javax.naming.NamingException;

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
			return R.success(DAO.insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result login(String account, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
