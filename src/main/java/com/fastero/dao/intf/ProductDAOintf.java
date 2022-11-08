package com.fastero.dao.intf;

import java.util.List;

import com.fastero.model.ProductVO;


public interface ProductDAOintf {
	public void insert(ProductVO productVO);
    public void update(ProductVO productVO);
    public void delete(Integer productId);
    public ProductVO findByPrimaryKey(Integer productId);
    public List<ProductVO> getAll();
    public List<ProductVO> getBystoreId();

}
