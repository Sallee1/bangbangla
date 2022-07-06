package com.sallee.bangbangla.service.impl;

import com.sallee.bangbangla.mapper.ChatMapper;
import com.sallee.bangbangla.mapper.OrderHistoryMapper;
import com.sallee.bangbangla.mapper.ReportMapper;
import com.sallee.bangbangla.mapper.UserMapper;
import com.sallee.bangbangla.pojo.DTO.ChatDTO;
import com.sallee.bangbangla.pojo.DTO.CommitDTO;
import com.sallee.bangbangla.pojo.DTO.ReportDTO;
import com.sallee.bangbangla.service.UserInterServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInterServerImpl implements UserInterServer {
	@Autowired
	public UserMapper userMapper;
	@Autowired
	public ChatMapper chatMapper;
	@Autowired
	public ReportMapper reportMapper;
	@Autowired
	public OrderHistoryMapper orderHistoryMapper;

	@Override
	public boolean addChat(ChatDTO chatDTO) {
		return false;
	}

	@Override
	public boolean addReport(ReportDTO reportDTO) {
		return false;
	}

	@Override
	public boolean addCommit(CommitDTO commitDTO) {
		return false;
	}
}
