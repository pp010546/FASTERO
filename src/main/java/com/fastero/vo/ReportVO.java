package com.fastero.vo;

import java.time.LocalDateTime;

public class ReportVO {
	
	private Integer reportId;
	private Integer userId;
	private Integer storeId;
	private LocalDateTime reportTime;
	private String reportText;
	private Boolean reportStatus;

	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
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
	public LocalDateTime getReportTime() {
		return reportTime;
	}
	public void setReportTime(LocalDateTime reportTime) {
		this.reportTime = reportTime;
	}
	public String getReportText() {
		return reportText;
	}
	public void setReportText(String reportText) {
		this.reportText = reportText;
	}
	public Boolean getReportStatus() {
		return reportStatus;
	}
	public void setReportStatus(Boolean reportStatus) {
		this.reportStatus = reportStatus;
	}
		
	
	

}
