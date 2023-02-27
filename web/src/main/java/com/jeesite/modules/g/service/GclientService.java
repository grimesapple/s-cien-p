package com.jeesite.modules.g.service;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.g.dao.GclientDao;
import com.jeesite.modules.g.entity.Gclient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * g_clientService
 * @author rye
 * @version 2022-12-04
 */
@Service
public class GclientService extends CrudService<GclientDao, Gclient> {
	
	/**
	 * 获取单条数据
	 * @param gclient
	 * @return
	 */
	@Override
	public Gclient get(Gclient gclient) {
		return super.get(gclient);
	}
	
	/**
	 * 查询分页数据
	 * @param gclient 查询条件
	 * @param gclient.page 分页对象
	 * @return
	 */
	@Override
	public Page<Gclient> findPage(Gclient gclient) {
		return super.findPage(gclient);
	}
	
	/**
	 * 查询列表数据
	 * @param gclient
	 * @return
	 */
	@Override
	public List<Gclient> findList(Gclient gclient) {
		return super.findList(gclient);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param gclient
	 */
	@Override
	@Transactional
	public void save(Gclient gclient) {
		super.save(gclient);
	}
	
	/**
	 * 更新状态
	 * @param gclient
	 */
	@Override
	@Transactional
	public void updateStatus(Gclient gclient) {
		super.updateStatus(gclient);
	}
	
	/**
	 * 删除数据
	 * @param gclient
	 */
	@Override
	@Transactional
	public void delete(Gclient gclient) {
		super.delete(gclient);
	}
	
}