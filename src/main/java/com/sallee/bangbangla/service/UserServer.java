package com.sallee.bangbangla.service;


import com.sallee.bangbangla.pojo.DTO.*;
import com.sallee.bangbangla.pojo.VO.UserInfoVO;

public interface UserServer {
  /**
   * 登录账号
   * @param loginDTO
   * @return 账号识别信息（cookie）
   */
  public UserBriefInfoDTO login(LoginDTO loginDTO);

  /**
   * 注册账号
   * @param register
   * @return 账号识别信息（cookie)
   */
  public UserBriefInfoDTO register(RegisterDTO register);

  /**
   * 显示指定用户详细资料
   * @param userId
   * @return 用户的详细资料
   */
  public UserInfoVO getInfo(Integer userId);

  /**
   * 修改用户的资料
   * @param editInfoDTO
   * @return 是否修改成功
   */
  public boolean editInfo(EditInfoDTO editInfoDTO);

  /**
   * 利用验证码重设密码
   * @param resetPasswordDTO
   * @return 是否重设成功
   */
  public boolean resetPassword(ResetPasswordDTO resetPasswordDTO);

  /**
   * 利用原密码修改密码
   * @param updataPasswordDTO
   * @return 是否修改成功
   */
  public boolean updatePassword(UpdatePasswordDTO updataPasswordDTO);
}
