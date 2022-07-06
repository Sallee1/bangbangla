package com.sallee.bangbangla.service;


import com.sallee.bangbangla.pojo.DTO.ChatDTO;
import com.sallee.bangbangla.pojo.DTO.CommitDTO;
import com.sallee.bangbangla.pojo.DTO.ReportDTO;

public interface UserInterServer {
  /**
   * 添加一个聊天
   * @param chatDTO
   * @return 是否添加成功
   */
  public boolean addChat(ChatDTO chatDTO);

  /**
   * 发起一个举报
   * @param reportDTO
   * @return 是否举报成功
   */
  public boolean addReport(ReportDTO reportDTO);

  /**
   * 添加一条评论
   * @param commitDTO
   * @return 是否评论成功
   */
  public boolean addCommit(CommitDTO commitDTO);
}
