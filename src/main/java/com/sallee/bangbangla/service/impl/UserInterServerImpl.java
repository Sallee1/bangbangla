package com.sallee.bangbangla.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sallee.bangbangla.mapper.ChatMapper;
import com.sallee.bangbangla.mapper.ItemHistoryMapper;
import com.sallee.bangbangla.mapper.ReportMapper;
import com.sallee.bangbangla.mapper.UserMapper;
import com.sallee.bangbangla.pojo.DAO.ChatDAO;
import com.sallee.bangbangla.pojo.DAO.ItemHistoryDAO;
import com.sallee.bangbangla.pojo.DAO.ReportDAO;
import com.sallee.bangbangla.pojo.DTO.ChatDTO;
import com.sallee.bangbangla.pojo.DTO.CommitDTO;
import com.sallee.bangbangla.pojo.DTO.ReportDTO;
import com.sallee.bangbangla.pojo.Enum;
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
	public ItemHistoryMapper itemHistoryMapper;

	@Override
	public boolean addChat(ChatDTO chatDTO) {

		ChatDAO addChat = new ChatDAO();
		addChat.setData(chatDTO.getData());
		addChat.setReceiverId(chatDTO.getReceiverId());
		addChat.setSenderId(chatDTO.getSenderId());
		addChat.setType(Enum.ChatType.valueOf(chatDTO.getType()).ordinal());

		int addRow = chatMapper.insert(addChat);

		return addRow>=1?true:false;
	}

	@Override
	public boolean addReport(ReportDTO reportDTO) {

		ReportDAO reportDAO = new ReportDAO();
		reportDAO.setBeReportId(reportDTO.getBeReportId());
		reportDAO.setReportId(reportDTO.getReportId());
		reportDAO.setItemId(reportDTO.getItemId());
		reportDAO.setResult(reportDTO.getResult());

		int addRow = reportMapper.insert(reportDAO);

		return addRow>=1?true:false;
	}

	@Override
	public boolean addCommit(CommitDTO commitDTO) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("id",commitDTO.getItemId());

		ItemHistoryDAO itemHistoryDAO = itemHistoryMapper.selectOne(queryWrapper);

		if(itemHistoryDAO==null){
			throw new RuntimeException("没有查到Id");
		}
		else{
			ItemHistoryDAO addCom = new ItemHistoryDAO();
			addCom.setCommit(commitDTO.getText());
			addCom.setCredit(commitDTO.getCredit());
			return true;
		}

	}
}
