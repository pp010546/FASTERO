package com.fastero.service.impl;

import com.fastero.common.Result;
import com.fastero.dao.impl.OrderMasterDAOIm;
<<<<<<< HEAD
import com.fastero.service.intf.OrderMasterServiceIn;

public class OrderMasterServiceIm implements OrderMasterServiceIn {

	OrderMasterDAOIm DAO;
	Result R;

=======
import com.fastero.service.intf.OrderMasterService;

public class OrderMasterServiceIm implements OrderMasterService{

	private OrderMasterDAOIm DAO;
	private Result R;
	
>>>>>>> Philip
	public OrderMasterServiceIm() {
		DAO = new OrderMasterDAOIm();
		R = new Result();
	}
<<<<<<< HEAD

	@Override
	public Result getAll() {
		try {
			return R.success(DAO.getAll());
		} catch (Exception e) {
=======
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
>>>>>>> Philip
			return R.fail(e.toString());
		}
	}

}
