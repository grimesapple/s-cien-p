package com.jeesite.modules.trade.service;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.trade.dao.TradeDao;
import com.jeesite.modules.trade.entity.Trade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 国民经济行业Service
 * @author rye
 * @version 2022-11-19
 */
@Service
public class TradeService extends CrudService<TradeDao, Trade> {
	
	/**
	 * 获取单条数据
	 * @param trade
	 * @return
	 */
	@Override
	public Trade get(Trade trade) {
		return super.get(trade);
	}
	
	/**
	 * 查询分页数据
	 * @param trade 查询条件
	 * @param trade.page 分页对象
	 * @return
	 */
	@Override
	public Page<Trade> findPage(Trade trade) {
		return super.findPage(trade);
	}
	
	/**
	 * 查询列表数据
	 * @param trade
	 * @return
	 */
	@Override
	public List<Trade> findList(Trade trade) {
		return super.findList(trade);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param trade
	 */
	@Override
	@Transactional
	public void save(Trade trade) {
		super.save(trade);
	}
	
	/**
	 * 更新状态
	 * @param trade
	 */
	@Override
	@Transactional
	public void updateStatus(Trade trade) {
		super.updateStatus(trade);
	}
	
	/**
	 * 删除数据
	 * @param trade
	 */
	@Override
	@Transactional
	public void delete(Trade trade) {
		super.delete(trade);
	}
	
}