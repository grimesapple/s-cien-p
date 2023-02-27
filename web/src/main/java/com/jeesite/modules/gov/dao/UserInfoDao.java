package com.jeesite.modules.gov.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.gov.entity.UserInfo;

/**
 * 用户信息表DAO接口
 * @author rye
 * @version 2022-12-06
 */
@MyBatisDao
public interface UserInfoDao extends CrudDao<UserInfo> {
	
}