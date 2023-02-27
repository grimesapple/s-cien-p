package com.jeesite.modules.trade.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.trade.entity.Trade;

/**
 * 国民经济行业DAO接口
 * @author rye
 * @version 2022-11-19
 */
@MyBatisDao
public interface TradeDao extends CrudDao<Trade> {
	
}