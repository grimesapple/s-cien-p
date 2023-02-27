package com.jeesite.modules.g.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.g.entity.Gtechnology;

/**
 * g_technologyDAO接口
 * @author rye
 * @version 2022-12-04
 */
@MyBatisDao
public interface GtechnologyDao extends CrudDao<Gtechnology> {
	
}