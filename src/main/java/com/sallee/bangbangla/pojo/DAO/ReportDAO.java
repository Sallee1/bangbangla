package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("report_list")
public class ReportDAO {
	@TableId(type = IdType.AUTO)
	Integer id;
	Integer reportId;
	Integer beReportId;
	Integer itemId;
	Date reportTime;
	String result;

	public ReportDAO(){}

	public ReportDAO(Integer id, Integer reportId, Integer beReportId, Integer itemId, Date reportTime, String result) {
		this.id = id;
		this.reportId = reportId;
		this.beReportId = beReportId;
		this.itemId = itemId;
		this.reportTime = reportTime;
		this.result = result;
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
}
