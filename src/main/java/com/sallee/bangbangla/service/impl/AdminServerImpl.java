package com.sallee.bangbangla.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sallee.bangbangla.mapper.*;
import com.sallee.bangbangla.pojo.DAO.*;
import com.sallee.bangbangla.pojo.DTO.BanUserDTO;
import com.sallee.bangbangla.pojo.DTO.LoginDTO;
import com.sallee.bangbangla.pojo.Enum;
import com.sallee.bangbangla.pojo.VO.AdminOrderVO;
import com.sallee.bangbangla.pojo.VO.AdminReportVO;
import com.sallee.bangbangla.pojo.VO.AdminUserVO;
import com.sallee.bangbangla.service.AdminServer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class AdminServerImpl implements AdminServer {
	@Autowired
	public UserMapper userMapper;
	@Autowired
	public ItemMapper itemMapper;
	@Autowired
	public OrderMapper orderMapper;
	@Autowired
	public OrderHistoryMapper orderHistoryMapper;
	@Autowired
	public AdminMapper adminMapper;
	@Autowired
	public BanMapper banMapper;
	@Autowired
	public ReportMapper reportMapper;
	@Autowired
	public UserItemRelateMapper userItemRelateMapper;
	@Autowired
	public UserItemRelateMapper itemHistoryMapper;

	@Override
	public Integer login(LoginDTO loginDTO) {
		//从数据库查询管理员是否存在
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("user_name",loginDTO.getUserName());
		AdminDAO admin = adminMapper.selectOne(queryWrapper);
		if(admin == null)throw new RuntimeException("ADMIN_NOT_EXIST");

		if(admin.getPassword().equals(StaticTool.getSHA256(loginDTO.getPassword()+admin.getSalt())))
			return  admin.getId();
		throw new RuntimeException("ADMIN_PASSWORD_ERROR");
	}

	@Override
	public AdminOrderVO selectItemsWithId(Integer itemId) {
		boolean isOld = false;
		//从订单列表查询
		QueryWrapper itemQueryWrapper = new QueryWrapper();
		itemQueryWrapper.eq("id",itemId);
		ItemDAO item = itemMapper.selectOne(itemQueryWrapper);

		//如果找不到，从历史订单找
		ItemHistoryDAO hisItem = null;
		if(item == null)
		{
			QueryWrapper hisItemQueryWrapper = new QueryWrapper();
			hisItemQueryWrapper.eq("id",itemId);

			hisItem = orderHistoryMapper.selectOne(hisItemQueryWrapper);
			if(hisItem == null) throw new RuntimeException("ITEM_NOT_EXIST");
			isOld = true;
		}

		//装载
		AdminOrderVO adminOrderVO;
		if(isOld) adminOrderVO = new AdminOrderVO(hisItem);
		else adminOrderVO = new AdminOrderVO(item,orderMapper);
		return adminOrderVO;
	}

	@Override
	public List<AdminOrderVO> selectAllOrder() {
		//查询所有的订单表和历史订单表
		List<ItemDAO> items = itemMapper.selectList(null);
		List<ItemHistoryDAO> itemHistoryDAOS = orderHistoryMapper.selectList(null);
		//复制到AdminOrderVO
		List<AdminOrderVO> adminOrderVOList = new ArrayList<>();
		for (ItemDAO item : items)
			adminOrderVOList.add(new AdminOrderVO(item, orderMapper));
		for (ItemHistoryDAO hisItems : itemHistoryDAOS)
			adminOrderVOList.add(new AdminOrderVO(hisItems));

		return adminOrderVOList;
	}

	@Override
	public boolean removeItem(Integer itemId) {
		boolean isOld = false;
		//从订单列表查询
		QueryWrapper itemQueryWrapper = new QueryWrapper();
		itemQueryWrapper.eq("id",itemId);
		ItemDAO item = itemMapper.selectOne(itemQueryWrapper);

		//如果找不到，从历史订单找
		ItemHistoryDAO hisItem;
		QueryWrapper hisItemQueryWrapper = null;
		if(item == null)
		{
			hisItemQueryWrapper = new QueryWrapper();
			hisItemQueryWrapper.eq("id",itemId);

			hisItem = orderHistoryMapper.selectOne(hisItemQueryWrapper);
			if(hisItem == null) throw new RuntimeException("ITEM_NOT_EXIST");
			isOld = true;
		}

		//移除对应的订单
		if(isOld)
		{
			orderHistoryMapper.delete(hisItemQueryWrapper);
			QueryWrapper userItemHisQueryWrapper = new QueryWrapper();
			userItemHisQueryWrapper.eq("item_id",itemId);
			itemHistoryMapper.delete(userItemHisQueryWrapper);
		}
		else
		{
			itemMapper.delete(itemQueryWrapper);
			QueryWrapper orderQueryWrapper = new QueryWrapper();
			orderQueryWrapper.eq("item_id",itemId);
			userItemRelateMapper.delete(orderQueryWrapper);
			orderMapper.delete(orderQueryWrapper);
		}
		return true;
	}

	@Override
	public AdminUserVO selectUserWithId(Integer userId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("id",userId);
		UserDAO userDAO = userMapper.selectOne(queryWrapper);
		if(userDAO == null) throw new RuntimeException("USER_NOT_EXIST");
		return new AdminUserVO(userDAO);
	}

	@Override
	public List<AdminUserVO> selectAllUser() {
		List<UserDAO> userDAOList = userMapper.selectList(null);

		List<AdminUserVO> adminUserVOList = new ArrayList<>();
		for(UserDAO user:userDAOList)
			adminUserVOList.add(new AdminUserVO(user));

		return adminUserVOList;
	}

	@Override
	public boolean banId(BanUserDTO banUserDTO) {
		//检测用户是否存在
		QueryWrapper userQueryWrapper = new QueryWrapper();
		userQueryWrapper.eq("id",banUserDTO.getBanId());
		UserDAO user = userMapper.selectOne(userQueryWrapper);
		if(user == null) throw new RuntimeException("USER_NOT_EXIST");

		//检测封神榜里有没有用户
		QueryWrapper banQueryWrapper = new QueryWrapper();
		banQueryWrapper.eq("ban_id",banUserDTO.getBanId());
		BanDAO banDAO = banMapper.selectOne(banQueryWrapper);
		if(banDAO != null) throw new RuntimeException("USER_ALREADY_BAN");

		//填写解封日期
		//利用Calendar计算日期
		Calendar today = Calendar.getInstance();
		Calendar unbanDay = (Calendar)today.clone();
		unbanDay.add(Calendar.DATE,banUserDTO.getDayLen());
		user.setUnBanTime(unbanDay.getTime());

		//写入封神榜
		banDAO = new BanDAO();
		BeanUtils.copyProperties(banUserDTO,banDAO);
		banDAO.setBanType(Enum.BanType.USER.ordinal());
		banDAO.setStartTime(today.getTime());
		banDAO.setEndTime(unbanDay.getTime());

		//写入数据库
		banMapper.insert(banDAO);
		userMapper.update(user,userQueryWrapper);
		return true;
	}

	@Override
	public List<AdminReportVO> selectAllReport() {
		List<ReportDAO> reportDAO = reportMapper.selectList(null);

		List<AdminReportVO> adminReportVOList = new ArrayList<>();
		for(ReportDAO report:reportDAO)
			adminReportVOList.add(new AdminReportVO(report));
		return adminReportVOList;
	}

	@Override
	public boolean removeReport(Integer reportId) {
		QueryWrapper reportQueryWrapper = new QueryWrapper();
		reportQueryWrapper.eq("id",reportId);
		ReportDAO report = reportMapper.selectOne(reportQueryWrapper);
		if(report == null)throw new RuntimeException("REPORT_NOT_EXIST");

		reportMapper.delete(reportQueryWrapper);
		return true;
	}

	@Override
	public List<BanDAO> selectAllBan() {
		return banMapper.selectList(null);
	}
}
