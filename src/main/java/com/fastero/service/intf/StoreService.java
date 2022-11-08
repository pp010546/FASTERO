package com.fastero.service.intf;

import java.util.List;

import com.fastero.model.StoreVO;

//
public interface StoreService {
    List<StoreVO> findAllStores();

    StoreVO getBystoreId(Integer storeId);

    List<StoreVO> getShortStoreList();

    List<StoreVO> selectList();
    
    List<StoreVO> newStoreList();

    void updateStatus(StoreVO vo);
}
