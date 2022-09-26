package com.fastero.service.impl;

import java.util.List;

import com.fastero.dao.intf.ProductDAOintf;
import com.fastero.model.ProductVO;

public class ProductService {
	private ProductDAOintf dao;

	public ProductVO addProduct(Integer storeId, String productName, String productIntroduction,
			Integer productPrice, Integer productSatus, java.sql.Date productWaitTime)
			{

		ProductVO productVO = new ProductVO();

		productVO.setStore_id(storeId);
		productVO.setProduct_name(productName);
		productVO.setProduct_introduction(productIntroduction);
		productVO.setProduct_price(productPrice);
		productVO.setProduct_satus(productSatus);
		productVO.setProduct_wait_time(productWaitTime);
		dao.insert(productVO);

		return productVO;
	}

	public ProductVO updateProduct(Integer productId, String productName,
			String productIntroduction, Integer productPrice, Integer productSatus, java.sql.Date productWaitTime)
			{
		ProductVO productVO = new ProductVO();

		productVO.setProduct_id(productId);
		productVO.setProduct_name(productName);
		productVO.setProduct_introduction(productIntroduction);
		productVO.setProduct_price(productPrice);
		productVO.setProduct_satus(productSatus);
		productVO.setProduct_wait_time(productWaitTime);
		dao.insert(productVO);

		return productVO;
		
	}
	public void deleteProduct(Integer productId) {
		dao.delete(productId);
	
	}

	public ProductVO getOneProduct(Integer storeId) {
		return dao.findByPrimaryKey(storeId);
	}
	public List<ProductVO> getAll(){
		return dao.getAll();
	}
}
