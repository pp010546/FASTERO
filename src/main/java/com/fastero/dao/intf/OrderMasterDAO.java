package com.fastero.dao.intf;

import java.util.List;

import com.fastero.vo.OrderMasterVO;

public interface OrderMasterDAO {

	List<OrderMasterVO> getAll() throws Exception;
	List<OrderMasterVO> getById(Integer id) throws Exception;
}
