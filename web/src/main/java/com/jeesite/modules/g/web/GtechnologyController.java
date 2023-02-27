package com.jeesite.modules.g.web;

import com.alibaba.fastjson.JSONValidator;
import com.jeesite.common.codec.EncodeUtils;
import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.g.entity.Gtechnology;
import com.jeesite.modules.g.service.GtechnologyService;
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
 * g_technologyController
 * @author rye
 * @version 2022-12-04
 */
@Controller
@RequestMapping(value = "${adminPath}/g/gtechnology")
public class GtechnologyController extends BaseController {

	@Autowired
	private GtechnologyService gtechnologyService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Gtechnology get(String id, boolean isNewRecord) {
		return gtechnologyService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("g:gtechnology:view")
	@RequestMapping(value = {"list", ""})
	public String list(Gtechnology gtechnology, Model model) {
		model.addAttribute("gtechnology", gtechnology);
		return "modules/g/gtechnologyList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("g:gtechnology:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Gtechnology> listData(Gtechnology gtechnology, HttpServletRequest request, HttpServletResponse response) {
		gtechnology.setPage(new Page<>(request, response));
		Page<Gtechnology> page = gtechnologyService.findPage(gtechnology);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("g:gtechnology:view")
	@RequestMapping(value = "form")
	public String form(Gtechnology gtechnology, Model model) {
		model.addAttribute("gtechnology", gtechnology);
		return "modules/g/gtechnologyForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("g:gtechnology:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Gtechnology gtechnology) {
		gtechnologyService.save(gtechnology);
		return renderResult(Global.TRUE, text("保存g_technology成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("g:gtechnology:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Gtechnology gtechnology) {
		gtechnologyService.delete(gtechnology);
		return renderResult(Global.TRUE, text("删除g_technology成功！"));
	}
	
	/**
	 * 列表选择对话框
	 */
	@RequiresPermissions("g:gtechnology:view")
	@RequestMapping(value = "gtechnologySelect")
	public String gtechnologySelect(Gtechnology gtechnology, String selectData, Model model) {
		String selectDataJson = EncodeUtils.decodeUrl(selectData);
		if (selectDataJson != null && JSONValidator.from(selectDataJson).validate()){
			model.addAttribute("selectData", selectDataJson);
		}
		model.addAttribute("gtechnology", gtechnology);
		return "modules/g/gtechnologySelect";
	}
	
}