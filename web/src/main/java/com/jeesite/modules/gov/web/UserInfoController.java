package com.jeesite.modules.gov.web;

import com.alibaba.fastjson.JSONValidator;
import com.jeesite.common.codec.EncodeUtils;
import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.gov.entity.UserInfo;
import com.jeesite.modules.gov.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户信息表Controller
 * @author rye
 * @version 2022-12-06
 */
@Controller
@RequestMapping(value = "${adminPath}/gov/userInfo")
public class UserInfoController extends BaseController {

	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public UserInfo get(String id, boolean isNewRecord) {
		return userInfoService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("gov:userInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(UserInfo userInfo, Model model) {
		model.addAttribute("userInfo", userInfo);
		return "modules/gov/userInfoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("gov:userInfo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<UserInfo> listData(UserInfo userInfo, HttpServletRequest request, HttpServletResponse response) {
		userInfo.setPage(new Page<>(request, response));
		Page<UserInfo> page = userInfoService.findPage(userInfo);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("gov:userInfo:view")
	@RequestMapping(value = "form")
	public String form(UserInfo userInfo, Model model) {
		model.addAttribute("userInfo", userInfo);
		return "modules/gov/userInfoForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("gov:userInfo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated UserInfo userInfo) {
		userInfoService.save(userInfo);
		return renderResult(Global.TRUE, text("保存用户信息表成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("gov:userInfo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(UserInfo userInfo) {
		userInfoService.delete(userInfo);
		return renderResult(Global.TRUE, text("删除用户信息表成功！"));
	}
	
	/**
	 * 列表选择对话框
	 */
	@RequiresPermissions("gov:userInfo:view")
	@RequestMapping(value = "userInfoSelect")
	public String userInfoSelect(UserInfo userInfo, String selectData, Model model) {
		String selectDataJson = EncodeUtils.decodeUrl(selectData);
		if (selectDataJson != null && JSONValidator.from(selectDataJson).validate()){
			model.addAttribute("selectData", selectDataJson);
		}
		model.addAttribute("userInfo", userInfo);
		return "modules/gov/userInfoSelect";
	}
	
}