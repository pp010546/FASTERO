package com.fastero.dao.intf;

import java.util.List;

import com.fastero.model.StoreSheetVO;
import com.fastero.model.StoreVO;
//
public interface StoreDAO {

	List<StoreVO> selectAll();
	
	public void insert(StoreVO storeVO);
	
	public void update(StoreVO storeVO);
	
	StoreVO selectBystoreId(Integer storeId);
	
	List<StoreVO> selectShortStoreList();
	
	List<StoreVO> selecList();
	
	List<StoreVO> newStoreList();
	
	
}