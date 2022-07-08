package com.sallee.bangbangla.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sallee.bangbangla.pojo.DAO.ItemHistoryDAO;
import com.sallee.bangbangla.pojo.DAO.OrderHistoryDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderHistoryMapper extends BaseMapper<ItemHistoryDAO> {
}
