package com.fastero.model;

import java.sql.Date;

public class ProductVO {
	private Integer productId;
	private Integer storeId;
	private String productName;
	private String productIntroduction;
	private Integer productPrice;
	private Integer productSatus;
	private String productImg;
	private Date productWaitTime;
	private Date productBuildTime;
	private Date productUpdateTime;
	
	
	public Integer getProduct_id() {
		return productId;
	}
	public void setProduct_id(Integer productId) {
		this.productId = productId;
	}
	public Integer getStore_id() {
		return storeId;
	}
	public void setStore_id(Integer storeId) {
		this.storeId = storeId;
	}
	public String getProduct_name() {
		return productName;
	}
	public void setProduct_name(String productName) {
		this.productName = productName;
	}
	public String getProduct_introduction() {
		return productIntroduction;
	}
	public void setProduct_introduction(String productIntroduction) {
		this.productIntroduction = productIntroduction;
	}
	public Integer getProduct_satus() {
		return productSatus;
	}
	public void setProduct_satus(Integer productSatus) {
		this.productSatus = productSatus;
	}
	public Integer getProduct_price() {
		return productPrice;
	}
	public void setProduct_price(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public Date getProduct_wait_time() {
		return productWaitTime;
	}
	public void setProduct_wait_time(Date productWaitTime) {
		this.productWaitTime = productWaitTime;
	}
	public Date getProduct_build_time() {
		return productBuildTime;
	}
	public void setProduct_build_time(Date productBuildTime) {
		this.productBuildTime = productBuildTime;
	}
	public Date getProduct_update_time() {
		return productUpdateTime;
	}
	public void setProduct_update_time(Date productUpdateTime) {
		this.productUpdateTime = productUpdateTime;
	}
    public String getProductImg() {
        return productImg;
    }
    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }
}
