package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("report_list")
public class ReportDAO {
	Integer id;
	Integer reportId;
	Integer beReportId;
	Integer itemId;
	Date reportTime;
	String result;
	Integer state;

	public ReportDAO(){}

	public ReportDAO(Integer id, Integer reportId, Integer beReportId, Integer itemId, Date reportTime, String result, Integer state) {
		this.id = id;
		this.reportId = reportId;
		this.beReportId = beReportId;
		this.itemId = itemId;
		this.reportTime = reportTime;
		this.result = result;
		this.state = state;
	}

}
