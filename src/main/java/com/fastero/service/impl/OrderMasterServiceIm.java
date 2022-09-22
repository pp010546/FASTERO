package com.fastero.service.impl;

import com.fastero.common.Result;
import com.fastero.dao.impl.OrderMasterDAOIm;
import com.fastero.service.intf.OrderMasterService;

public class OrderMasterServiceIm implements OrderMasterService{

	private OrderMasterDAOIm DAO;
	private Result R;
	
	public OrderMasterServiceIm() {
		DAO = new OrderMasterDAOIm();
		R = new Result();
	}
	@Override
	public Result getAll(){
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

}
