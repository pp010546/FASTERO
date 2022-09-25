package com.fastero.vo;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
//
public class StoreVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer storeId;
	private String storeName;
	private String storeAddress;
	private String longitude;
	private String latitude;
	private String storePhone;
	private String storeEmail;
	private String storeAdminAccount;
	private String storeAdminPassword;
	private String storeAdminPhone;
	private String storeAdminAddress;
	private Blob storeImg;
	private String storeIntroduction;
	private Byte storeOpenStatus;
	private Integer storeAccountStatus;
	private String storeAdminName;
	private String storeAdminId;
	private Date storeBuildTime;
	private Date storeUpdteTime;
	private Integer storeCommentNumber;
	private Integer storeTotalStar;
	private String storeBusinessTime;
	
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getStorePhone() {
		return storePhone;
	}
	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
	public String getStoreEmail() {
		return storeEmail;
	}
	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}
	public String getStoreAdminAccount() {
		return storeAdminAccount;
	}
	public void setStoreAdminAccount(String storeAdminAccount) {
		this.storeAdminAccount = storeAdminAccount;
	}
	public String getStoreAdminPassword() {
		return storeAdminPassword;
	}
	public void setStoreAdminPassword(String storeAdminPassword) {
		this.storeAdminPassword = storeAdminPassword;
	}
	public String getStoreAdminPhone() {
		return storeAdminPhone;
	}
	public void setStoreAdminPhone(String storeAdminPhone) {
		this.storeAdminPhone = storeAdminPhone;
	}
	public String getStoreAdminAddress() {
		return storeAdminAddress;
	}
	public void setStoreAdminAddress(String storeAdminAddress) {
		this.storeAdminAddress = storeAdminAddress;
	}
	public Blob getStoreImg() {
		return storeImg;
	}
	public void setStoreImg(Blob storeImg) {
		this.storeImg = storeImg;
	}
	public String getStoreIntroduction() {
		return storeIntroduction;
	}
	public void setStoreIntroduction(String storeIntroduction) {
		this.storeIntroduction = storeIntroduction;
	}
	public Byte getStoreOpenStatus() {
		return storeOpenStatus;
	}
	public void setStoreOpenStatus(Byte storeOpenStatus) {
		this.storeOpenStatus = storeOpenStatus;
	}
	public Integer getStoreAccountStatus() {
		return storeAccountStatus;
	}
	public void setStoreAccountStatus(Integer storeAccountStatus) {
		this.storeAccountStatus = storeAccountStatus;
	}
	public String getStoreAdminName() {
		return storeAdminName;
	}
	public void setStoreAdminName(String storeAdminName) {
		this.storeAdminName = storeAdminName;
	}
	public String getstoreAdminId() {
		return storeAdminId;
	}
	public void setstoreAdminId(String storeAdminId) {
		this.storeAdminId = storeAdminId;
	}
	public Date getStoreBuildTime() {
		return storeBuildTime;
	}
	public void setStoreBuildTime(Date storeBuildTime) {
		this.storeBuildTime = storeBuildTime;
	}
	public Date getStoreUpdteTime() {
		return storeUpdteTime;
	}
	public void setStoreUpdteTime(Date storeUpdteTime) {
		this.storeUpdteTime = storeUpdteTime;
	}
	public Integer getStoreCommentNumber() {
		return storeCommentNumber;
	}
	public void setStoreCommentNumber(Integer storeCommentNumber) {
		this.storeCommentNumber = storeCommentNumber;
	}
	public Integer getStoreTotalStar() {
		return storeTotalStar;
	}
	public void setStoreTotalStar(Integer storeTotalStar) {
		this.storeTotalStar = storeTotalStar;
	}
	public String getStoreBusinessTime() {
		return storeBusinessTime;
	}
	public void setStoreBusinessTime(String storeBusinessTime) {
		this.storeBusinessTime = storeBusinessTime;
	}
	


}
