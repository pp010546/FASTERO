package com.fastero.service.intf;

import java.util.List;

import com.fastero.common.Result;
import com.fastero.vo.StoreVO;
//
public interface StoreService {
	List<StoreVO> findAllStores();
	
	public Result register(StoreVO vo);
	
	public Result login(String account, String password);

}
