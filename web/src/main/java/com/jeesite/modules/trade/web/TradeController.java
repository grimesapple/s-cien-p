package com.jeesite.modules.trade.web;

import com.alibaba.fastjson.JSONValidator;
import com.jeesite.common.codec.EncodeUtils;
import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.trade.entity.Trade;
import com.jeesite.modules.trade.service.TradeService;
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
 * 国民经济行业Controller
 * @author rye
 * @version 2022-11-19
 */
@Controller
@RequestMapping(value = "${adminPath}/trade/trade")
public class TradeController extends BaseController {

	@Autowired
	private TradeService tradeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Trade get(String id, boolean isNewRecord) {
		return tradeService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("trade:trade:view")
	@RequestMapping(value = {"list", ""})
	public String list(Trade trade, Model model) {
		model.addAttribute("trade", trade);
		return "modules/trade/tradeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("trade:trade:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Trade> listData(Trade trade, HttpServletRequest request, HttpServletResponse response) {
		trade.setPage(new Page<>(request, response));
		Page<Trade> page = tradeService.findPage(trade);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("trade:trade:view")
	@RequestMapping(value = "form")
	public String form(Trade trade, Model model) {
		model.addAttribute("trade", trade);
		return "modules/trade/tradeForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("trade:trade:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Trade trade) {
		tradeService.save(trade);
		return renderResult(Global.TRUE, text("保存国民经济行业成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("trade:trade:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Trade trade) {
		tradeService.delete(trade);
		return renderResult(Global.TRUE, text("删除国民经济行业成功！"));
	}
	
	/**
	 * 列表选择对话框
	 */
	@RequiresPermissions("trade:trade:view")
	@RequestMapping(value = "tradeSelect")
	public String tradeSelect(Trade trade, String selectData, Model model) {
		String selectDataJson = EncodeUtils.decodeUrl(selectData);
		if (selectDataJson != null && JSONValidator.from(selectDataJson).validate()){
			model.addAttribute("selectData", selectDataJson);
		}
		model.addAttribute("trade", trade);
		return "modules/trade/tradeSelect";
	}
	
}