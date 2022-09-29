package com.fastero.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fastero.common.Result;
import com.fastero.dao.impl.OrderMasterDAOIm;
import com.fastero.service.intf.OrderMasterService;
import com.fastero.vo.OrderMasterVO;
import com.fastero.vo.UserVO;

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
	
	public Result getAllForStore(Integer id) {
		try {
			return R.success(DAO.getByStoreId(id));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}
	public Result getAllForUser(Integer id) {
		try {
			return R.success(DAO.getByUserId(id));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}
	
	public Result getByIdForUser(Integer orderId, Integer userId) {
		try {
			List<OrderMasterVO> list = new ArrayList<OrderMasterVO>();
			for (OrderMasterVO vo : DAO.getById(orderId)) {
				if(vo.getUserId() == userId) {
					list.add(vo);
				}
			}
			return R.success(list);
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}
	
	public Result getByIdForStore(Integer orderId, Integer storeId) {
		try {
			List<OrderMasterVO> list = new ArrayList<OrderMasterVO>();
			for (OrderMasterVO vo : DAO.getById(orderId)) {
				if(vo.getUserId() == storeId) {
					list.add(vo);
				}
			}
			return R.success(list);
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

}
