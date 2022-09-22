package com.fastero.vo;

import java.time.LocalDateTime;

public class OrderMasterVO {
	
	//order_id, user_id, store_id, order_status, order_amount, order_time, update_time, order_remark
	
	private Integer orderId;
	private Integer userId;
	private Integer storeId;
	private Byte orderStatus;
	private Integer orderAmount;
	private LocalDateTime orderTime;
	private LocalDateTime updateTime;
	private String orderRemark;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Byte getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	

}
