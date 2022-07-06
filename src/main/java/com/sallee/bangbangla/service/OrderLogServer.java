package com.sallee.bangbangla.service;


import com.sallee.bangbangla.pojo.DTO.UserItemRelateDTO;
import com.sallee.bangbangla.pojo.VO.OrderLogDetailVO;
import com.sallee.bangbangla.pojo.VO.OrderLogVO;

import java.util.List;

public interface OrderLogServer {
  /**
   * 显示所有由自己发布的需求记录
   * @param userId
   * @return 需求记录列表
   */
  public List<OrderLogVO> showOrderFrom(Integer userId);

  /**
   * 显示所有由自己接手的需求
   * @param userId
   * @return 需求记录列表
   */
  public List<OrderLogVO> showOrderTo(Integer userId);

  /**
   * 显示某个需求记录的细节
   * @param userItemRelateDTO
   * @return 需求记录详情
   */
  public OrderLogDetailVO showOrderDetail(UserItemRelateDTO userItemRelateDTO);
}
