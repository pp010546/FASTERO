package com.fastero.service.impl;

import java.util.List;

import javax.naming.NamingException;

import com.fastero.controller.Base64Adapter;
import com.fastero.dao.impl.StoreDAOImpl;
import com.fastero.dao.intf.StoreDAO;
import com.fastero.model.StoreVO;
import com.fastero.service.intf.StoreService;
//
public class StoreServiceImpl implements StoreService{
	private StoreDAO dao;
	private Base64Adapter base64;
	
	public StoreServiceImpl() {
		try {
            dao = new StoreDAOImpl();
            base64 = new Base64Adapter();
        } catch (NamingException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public List<StoreVO> findAllStores() {
		
		return dao.selectAll();
	}

	@Override
	public StoreVO getBystoreId(Integer storeId) {
		try {
//		    return dao.selectBystoreId(storeId);
		    StoreVO vo = dao.selectBystoreId(storeId);
		    vo.setSimgString(base64.Encoder(vo.getStoreImg()));
		    vo.setStoreImg(null);
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StoreVO> getShortStoreList() {	
		try {		    		    
			return dao.selectShortStoreList();
//			List<StoreVO> list = dao.selectShortStoreList();
//			for (int i = 0; i < list.size(); i++) {
//			    list.get(i).setSimgString(base64.Encoder(list.get(i).getStoreImg()));
//			    list.get(i).setStoreImg(null);
//			}
//			((StoreVO) list).setSimgString(base64.Encoder(((StoreVO) list).getStoreImg()));
//			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}

    @Override
    public List<StoreVO> selectList() {
        try {
            return dao.selecList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<StoreVO> newStoreList() {
        try {
            return dao.newStoreList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateStatus(StoreVO vo) {
        // TODO Auto-generated method stub
        
    }
	
	

}
