package com.sallee.bangbangla.service;
import com.sallee.bangbangla.pojo.DAO.BanDAO;
import com.sallee.bangbangla.pojo.DTO.BanUserDTO;
import com.sallee.bangbangla.pojo.DTO.LoginDTO;
import com.sallee.bangbangla.pojo.VO.AdminReportVO;
import com.sallee.bangbangla.pojo.VO.AdminUserVO;
import com.sallee.bangbangla.pojo.VO.AdminOrderVO;

import java.util.List;

public interface AdminServer {

  /**
   * 管理员账户登陆
   *
   * @param loginDTO
   * @return 是否成功
   */
  public Integer login(LoginDTO loginDTO);

  /**
   * 查看指定物品id的订单详细信息
   * @param itemId
   * @return 管理员视图显示的订单
   */
  public AdminOrderVO selectItemsWithId(Integer itemId);

  /**
   * 查看所有订单
   * @return 管理员视图显示的所有订单
   */
  public List<AdminOrderVO> selectAllOrder();

  /**
   * 移除物品
   * @param itemId
   * @return 是否移除成功
   */
  public boolean removeItem(Integer itemId);

  /**
   * 查看指定Id的用户的详细信息
   * @param userId
   * @return 管理员视图显示的用户
   */
  public AdminUserVO selectUserWithId(Integer userId);

  /**
   * 查看所有用户的详细信息
   * @return 管理员视图显示的所有用户
   */
  public List<AdminUserVO> selectAllUser();

  /**
   * 按id封禁用户
   * @param banUserDTO
   * @return 是否成功
   */

  public boolean banId(BanUserDTO banUserDTO);

  /**
   * 查看所有举报列表
   * @return 管理员视图显示的举报列表
   */
  public List<AdminReportVO> selectAllReport();

  /**
   * 移除举报（已受理）
   * @param reportId
   * @return 是否成功
   */
  public boolean removeReport(Integer reportId);

  /**
   * 显示所有被封禁的用户
   * @return 被封禁的用户列表
   */
  public List<BanDAO> selectAllBan();
}
