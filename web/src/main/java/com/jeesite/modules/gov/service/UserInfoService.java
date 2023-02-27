package com.jeesite.modules.gov.service;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.gov.dao.UserInfoDao;
import com.jeesite.modules.gov.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户信息表Service
 * @author rye
 * @version 2022-12-06
 */
@Service
public class UserInfoService extends CrudService<UserInfoDao, UserInfo> {
	
	/**
	 * 获取单条数据
	 * @param userInfo
	 * @return
	 */
	@Override
	public UserInfo get(UserInfo userInfo) {
		return super.get(userInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param userInfo 查询条件
	 * @param userInfo.page 分页对象
	 * @return
	 */
	@Override
	public Page<UserInfo> findPage(UserInfo userInfo) {
		return super.findPage(userInfo);
	}
	
	/**
	 * 查询列表数据
	 * @param userInfo
	 * @return
	 */
	@Override
	public List<UserInfo> findList(UserInfo userInfo) {
		return super.findList(userInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param userInfo
	 */
	@Override
	@Transactional
	public void save(UserInfo userInfo) {
		super.save(userInfo);
	}
	
	/**
	 * 更新状态
	 * @param userInfo
	 */
	@Override
	@Transactional
	public void updateStatus(UserInfo userInfo) {
		super.updateStatus(userInfo);
	}
	
	/**
	 * 删除数据
	 * @param userInfo
	 */
	@Override
	@Transactional
	public void delete(UserInfo userInfo) {
		super.delete(userInfo);
	}
	
}