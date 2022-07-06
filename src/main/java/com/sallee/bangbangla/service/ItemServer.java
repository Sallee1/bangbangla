package com.sallee.bangbangla.service;

import com.sallee.bangbangla.pojo.DTO.ItemEditDTO;
import com.sallee.bangbangla.pojo.DTO.UserBriefInfoDTO;
import com.sallee.bangbangla.pojo.VO.ItemDetailVO;
import com.sallee.bangbangla.pojo.VO.ItemVO;
import com.sallee.bangbangla.pojo.DTO.CreateItemDTO;

import java.util.List;

public interface ItemServer {
  /**
   * 查看所有（在同一个学校）的需求
   * @param userBriefInfoDTO
   * @return 需求列表
   */
  public List<ItemVO> selectAllItems(UserBriefInfoDTO userBriefInfoDTO);

  /**
   * 模糊匹配（在同一个学校）需求列表
   * @param key
   * @return 需求列表
   */
  public List<ItemVO> selectItemsWithKey(UserBriefInfoDTO userBriefInfoDTO,String key);

  /**
   * 显示某个需求的详细信息
   * @param itemId
   * @return 需求详细信息
   */
  public ItemDetailVO showItemDetail(Integer itemId);

  /**
   * 发起一个需求
   * @param createItemDTO
   * @return 是否成功
   */
  public boolean addItem(CreateItemDTO createItemDTO);

  /**
   * 编辑需求
   * @param itemEditDTO
   * @return 是否成功
   */
  public boolean editItem(ItemEditDTO itemEditDTO);

  /**
   * 增加浏览人数
   * @param itemId
   * @return 是否成功
   */
  public boolean addView(Integer itemId);
}
