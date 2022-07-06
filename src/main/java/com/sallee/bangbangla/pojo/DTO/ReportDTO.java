package com.sallee.bangbangla.pojo.DTO;


public class ReportDTO {
	Integer reportId;
	Integer beReportId;
	Integer itemId;
	Long reportTime;
	String result;
	String state;

	public ReportDTO() {}

	public ReportDTO(Integer reportId, Integer beReportId, Integer itemId, Long reportTime, String result, String state) {
		this.reportId = reportId;
		this.beReportId = beReportId;
		this.itemId = itemId;
		this.reportTime = reportTime;
		this.result = result;
		this.state = state;
	}

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public Integer getBeReportId() {
		return beReportId;
	}

	public void setBeReportId(Integer beReportId) {
		this.beReportId = beReportId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Long getReportTime() {
		return reportTime;
	}

	public void setReportTime(Long reportTime) {
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
