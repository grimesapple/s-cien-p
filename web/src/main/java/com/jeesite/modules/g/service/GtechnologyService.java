package com.jeesite.modules.g.service;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.g.dao.GtechnologyDao;
import com.jeesite.modules.g.entity.Gtechnology;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * g_technologyService
 * @author rye
 * @version 2022-12-04
 */
@Service
public class GtechnologyService extends CrudService<GtechnologyDao, Gtechnology> {
	
	/**
	 * 获取单条数据
	 * @param gtechnology
	 * @return
	 */
	@Override
	public Gtechnology get(Gtechnology gtechnology) {
		return super.get(gtechnology);
	}
	
	/**
	 * 查询分页数据
	 * @param gtechnology 查询条件
	 * @param gtechnology.page 分页对象
	 * @return
	 */
	@Override
	public Page<Gtechnology> findPage(Gtechnology gtechnology) {
		return super.findPage(gtechnology);
	}
	
	/**
	 * 查询列表数据
	 * @param gtechnology
	 * @return
	 */
	@Override
	public List<Gtechnology> findList(Gtechnology gtechnology) {
		return super.findList(gtechnology);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param gtechnology
	 */
	@Override
	@Transactional
	public void save(Gtechnology gtechnology) {
		super.save(gtechnology);
	}
	
	/**
	 * 更新状态
	 * @param gtechnology
	 */
	@Override
	@Transactional
	public void updateStatus(Gtechnology gtechnology) {
		super.updateStatus(gtechnology);
	}
	
	/**
	 * 删除数据
	 * @param gtechnology
	 */
	@Override
	@Transactional
	public void delete(Gtechnology gtechnology) {
		super.delete(gtechnology);
	}
	
}