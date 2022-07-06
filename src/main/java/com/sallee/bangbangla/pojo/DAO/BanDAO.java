package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("ban_list")
public class BanDAO {
	Integer id;
	Integer banId;
	Integer banType;
	String result;
	Integer opId;
	Long startTime;
	Long endTime;

	public BanDAO() {}

	public BanDAO(Integer id, Integer banId, Integer banType, String result, Integer opId, Long startTime, Long endTime) {
		this.id = id;
		this.banId = banId;
		this.banType = banType;
		this.result = result;
		this.opId = opId;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBanId() {
		return banId;
	}

	public void setBanId(Integer banId) {
		this.banId = banId;
	}

	public Integer getBanType() {
		return banType;
	}

	public void setBanType(Integer banType) {
		this.banType = banType;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getOpId() {
		return opId;
	}

	public void setOpId(Integer opId) {
		this.opId = opId;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
}
