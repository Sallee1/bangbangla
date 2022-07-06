package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("report_list")
public class ReportDAO {
	Integer id;
	Integer reportId;
	Integer beReportId;
	Integer itemId;
	Long reportTime;
	String result;
	Integer state;

	public ReportDAO(){}

	public ReportDAO(Integer id, Integer reportId, Integer beReportId, Integer itemId, Long reportTime, String result, Integer state) {
		this.id = id;
		this.reportId = reportId;
		this.beReportId = beReportId;
		this.itemId = itemId;
		this.reportTime = reportTime;
		this.result = result;
		this.state = state;
	}

}
