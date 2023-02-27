package com.jeesite.modules.norm.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.norm.entity.NormIndustry;

/**
 * 标准行业表(GB/T 4754-2017)DAO接口
 * @author rye
 * @version 2022-12-05
 */
@MyBatisDao
public interface NormIndustryDao extends CrudDao<NormIndustry> {
	
}