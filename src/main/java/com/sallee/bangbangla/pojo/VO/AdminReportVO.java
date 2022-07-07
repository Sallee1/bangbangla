package com.sallee.bangbangla.pojo.VO;


import java.util.Date;

public class AdminReportVO {
	Integer id;
	Integer reportId;
	String reportUserName;
	Integer beReportId;
	String beReportUserName;
	Integer itemId;
	Integer itemTitle;
	Date reportTime;
	String result;
	String state;

	public AdminReportVO() {}

	public AdminReportVO(Integer id, Integer reportId, String reportUserName, Integer beReportId,
											 String beReportUserName, Integer itemId, Integer itemTitle, Date reportTime, String result,
											 String state) {
		this.id = id;
		this.reportId = reportId;
		this.reportUserName = reportUserName;
		this.beReportId = beReportId;
		this.beReportUserName = beReportUserName;
		this.itemId = itemId;
		this.itemTitle = itemTitle;
		this.reportTime = reportTime;
		this.result = result;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public String getReportUserName() {
		return reportUserName;
	}

	public void setReportUserName(String reportUserName) {
		this.reportUserName = reportUserName;
	}

	public Integer getBeReportId() {
		return beReportId;
	}

	public void setBeReportId(Integer beReportId) {
		this.beReportId = beReportId;
	}

	public String getBeReportUserName() {
		return beReportUserName;
	}

	public void setBeReportUserName(String beReportUserName) {
		this.beReportUserName = beReportUserName;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(Integer itemTitle) {
		this.itemTitle = itemTitle;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
