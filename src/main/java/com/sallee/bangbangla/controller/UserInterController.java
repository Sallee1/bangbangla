package com.sallee.bangbangla.controller;


import com.sallee.bangbangla.pojo.DTO.ChatDTO;
import com.sallee.bangbangla.pojo.DTO.CommitDTO;
import com.sallee.bangbangla.pojo.DTO.ReportDTO;
import com.sallee.bangbangla.pojo.ServerResult;
import com.sallee.bangbangla.service.UserInterServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserInterController {
	@Autowired
	public UserInterServer userInterServer;

	@RequestMapping("/inter/addChat")
	public ServerResult addChat(ChatDTO chatDTO) {

		return null;
	}
	@RequestMapping("/inter/addReport")
	public ServerResult addReport(ReportDTO reportDTO) {

		return null;
	}

	@RequestMapping("/inter/addCommit")
	public ServerResult addCommit(CommitDTO commitDTO) {

		return null;
	}
}
