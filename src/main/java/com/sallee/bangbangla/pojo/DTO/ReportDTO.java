package com.sallee.bangbangla.pojo.DTO;


import java.util.Date;

public class ReportDTO {
	Integer reportId;
	Integer beReportId;
	Integer itemId;
	String result;

	public ReportDTO() {}

	public ReportDTO(Integer reportId, Integer beReportId, Integer itemId, Date reportTime, String result) {
		this.reportId = reportId;
		this.beReportId = beReportId;
		this.itemId = itemId;

		this.result = result;
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


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
