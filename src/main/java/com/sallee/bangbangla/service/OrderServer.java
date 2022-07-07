package com.sallee.bangbangla.service;


import com.sallee.bangbangla.pojo.DTO.UserItemRelateDTO;
import com.sallee.bangbangla.pojo.VO.UserCreditVO;

import java.util.List;

public interface OrderServer {
  /**
   * 为订单添加一个意愿者
   * @param userItemRelateDTO
   * @return 是否添加成功
   */
  public boolean addWant(UserItemRelateDTO userItemRelateDTO);

  /**
   * 显示某个订单所有的意愿者
   * @param itemId
   * @return 意愿者的信用列表
   */
  public List<UserCreditVO> selectAllBuyer(Integer itemId);

  /**
   * 选择一个意愿者
   * @param userItemRelateDTO
   * @return 被选中意愿者的ID
   */
  public Integer chooseBuyer(UserItemRelateDTO userItemRelateDTO);

  /**
   * 支付某个订单的钱款
   * @param orderId
   * @return 是否支付成功
   */
  public boolean pay(Integer orderId);

  /**
   * 完成订单
   * @param orderId
   * @return 是否成功完成
   */
  public boolean finishOrder(Integer orderId);

  /**
   * 将订单移动到历史记录
   * @param orderId
   * @return 是否移动成功
   */
  public boolean moveToHistory(Integer orderId);
}
