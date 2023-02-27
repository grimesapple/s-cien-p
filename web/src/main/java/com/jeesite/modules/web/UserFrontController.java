package com.jeesite.modules.web;

import com.jeesite.common.config.Global;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.g.entity.Gclient;
import com.jeesite.modules.g.entity.Gtechnology;
import com.jeesite.modules.g.service.GclientService;
import com.jeesite.modules.g.service.GtechnologyService;
import com.jeesite.modules.gov.entity.UserInfo;
import com.jeesite.modules.gov.service.UserInfoService;
import com.jeesite.modules.test.entity.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户信息表Controller
 * @author rye
 * @version 2022-11-19
 */
@Controller
@RequestMapping(value = "${adminPath}/front/userInfo")
public class UserFrontController extends BaseController {

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private GclientService gclientService;
	@Autowired
	private GtechnologyService gtechnologyService;


	/**
	 * 客户注册
	 */
	@RequestMapping(value = "userRegister")
	public String form(UserInfo userInfo, Model model) {
		model.addAttribute("userInfo", userInfo);
		return "modules/front/userInfoForm1";
	}

	/**
	 * 客户填报
	 */
	@RequestMapping(value = "clientMake")
	public String userMake(Gclient gclient, Model model) {
		model.addAttribute("gclient", gclient);
		return "modules/front/gclientForm";
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(TestData testData, Model model) {
		model.addAttribute("testData", testData);
		return "modules/front/gclientForm";
	}

	/**
	 * 客户填报-月报
	 */
	@RequestMapping(value = "clientMonthMake")
	public String clientMonthMake(Gclient gclient, Model model) {
		model.addAttribute("gclient", gclient);
		return "modules/front/gclientMonthForm";
	}

	/**
	 * 客户填报-季报
	 */
	@RequestMapping(value = "clientQuarterMake")
	public String clientQuarterMake(Gclient gclient, Model model) {
		model.addAttribute("gclient", gclient);
		return "modules/front/gclientQuarterForm";
	}

	/**
	 * 客户填报-年报
	 */
	@RequestMapping(value = "clientYearMake")
	public String clientYearMake(Gclient gclient, Model model) {
		model.addAttribute("gclient", gclient);
		return "modules/front/gclientYearForm";
	}

	/**
	 * 科技局填报
	 */
	@RequestMapping(value = "technologyMake")
	public String technologyMake(Gtechnology gtechnology, Model model) {
		model.addAttribute("gtechnology", gtechnology);
		return "modules/front/gtechnologyForm";
	}

	/**
	 * 用户信息保存
	 */
	@PostMapping(value = "register")
	@ResponseBody
	public String saveUserInfo(@Validated UserInfo userInfo) {
		userInfoService.save(userInfo);
		return renderResult(Global.TRUE, text("保存用户信息表成功！"));
	}

	/**
	 * 客户填报保存
	 */
	@PostMapping(value = "saveClient")
	@ResponseBody
	public String saveClient(@Validated Gclient gclient) {
		if (gclient.getMonth() != null) {
			gclientService.update(gclient);
		}
		gclientService.save(gclient);
		return renderResult(Global.TRUE, text("保存客户填报成功！"));
	}

	/**
	 * 科技局填报保存
	 * @param gtechnology
	 * @return
	 */
	@PostMapping(value = "saveTechnology")
	@ResponseBody
	public String saveTechnology(@Validated Gtechnology gtechnology) {
		gtechnologyService.save(gtechnology);
		return renderResult(Global.TRUE, text("保存科技局填报成功！"));
	}
}