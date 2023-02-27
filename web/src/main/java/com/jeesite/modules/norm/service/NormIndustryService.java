package com.jeesite.modules.norm.service;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.norm.dao.NormIndustryDao;
import com.jeesite.modules.norm.entity.NormIndustry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 标准行业表(GB/T 4754-2017)Service
 * @author rye
 * @version 2022-12-05
 */
@Service
public class NormIndustryService extends CrudService<NormIndustryDao, NormIndustry> {
	
	/**
	 * 获取单条数据
	 * @param normIndustry
	 * @return
	 */
	@Override
	public NormIndustry get(NormIndustry normIndustry) {
		return super.get(normIndustry);
	}
	
	/**
	 * 查询分页数据
	 * @param normIndustry 查询条件
	 * @param normIndustry.page 分页对象
	 * @return
	 */
	@Override
	public Page<NormIndustry> findPage(NormIndustry normIndustry) {
		return super.findPage(normIndustry);
	}
	
	/**
	 * 查询列表数据
	 * @param normIndustry
	 * @return
	 */
	@Override
	public List<NormIndustry> findList(NormIndustry normIndustry) {
		return super.findList(normIndustry);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param normIndustry
	 */
	@Override
	@Transactional
	public void save(NormIndustry normIndustry) {
		super.save(normIndustry);
	}
	
	/**
	 * 更新状态
	 * @param normIndustry
	 */
	@Override
	@Transactional
	public void updateStatus(NormIndustry normIndustry) {
		super.updateStatus(normIndustry);
	}
	
	/**
	 * 删除数据
	 * @param normIndustry
	 */
	@Override
	@Transactional
	public void delete(NormIndustry normIndustry) {
		super.delete(normIndustry);
	}
	
}