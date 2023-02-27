package com.jeesite.modules.norm.web;

import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.norm.entity.NormIndustry;
import com.jeesite.modules.norm.service.NormIndustryService;
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
import java.util.List;
import java.util.Map;

/**
 * 标准行业表(GB/T 4754-2017)Controller
 * @author rye
 * @version 2022-12-05
 */
@Controller
@RequestMapping(value = "${adminPath}/norm/normIndustry")
public class NormIndustryController extends BaseController {

	@Autowired
	private NormIndustryService normIndustryService;

	/**
	 * 获取区域树结构数据
	 * @param excludeCode 排除的Code
	 * @param isShowCode 是否显示编码（true or 1：显示在左侧；2：显示在右侧；false or null：不显示）
	 * @return
	 */
	@RequestMapping(value = "treeData")
	@ResponseBody
	public List<Map<String, Object>> treeData(String excludeCode, String isShowCode, String parentCode) {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		List<NormIndustry> list = null;
		if (StringUtils.isNotBlank(parentCode)){
			NormIndustry where = new NormIndustry();
			where.setParentCode(parentCode);
			list = normIndustryService.findList(where);
		}else{
			NormIndustry where = new NormIndustry();
			where.setHasChild(1);
			where.setParentCode("0");
			list = normIndustryService.findList(where);
		}
		for (int i=0; i<list.size(); i++){
			NormIndustry e = list.get(i);

			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", e.getId());
			map.put("pId", e.getParentCode());
			map.put("name", e.getName());
			map.put("isParent",e.hashCode()==1?true:false);
			mapList.add(map);
		}
		return mapList;
	}

	/**
	 * 获取数据
	 */
	@ModelAttribute
	public NormIndustry get(String id, boolean isNewRecord) {
		return normIndustryService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("norm:normIndustry:view")
	@RequestMapping(value = {"list", ""})
	public String list(NormIndustry normIndustry, Model model) {
		model.addAttribute("normIndustry", normIndustry);
		return "modules/norm/normIndustryList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("norm:normIndustry:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<NormIndustry> listData(NormIndustry normIndustry, HttpServletRequest request, HttpServletResponse response) {
		normIndustry.setPage(new Page<>(request, response));
		Page<NormIndustry> page = normIndustryService.findPage(normIndustry);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("norm:normIndustry:view")
	@RequestMapping(value = "form")
	public String form(NormIndustry normIndustry, Model model) {
		model.addAttribute("normIndustry", normIndustry);
		return "modules/norm/normIndustryForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("norm:normIndustry:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated NormIndustry normIndustry) {
		normIndustryService.save(normIndustry);
		return renderResult(Global.TRUE, text("保存标准行业表(GB/T 4754-2017)成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("norm:normIndustry:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(NormIndustry normIndustry) {
		normIndustryService.delete(normIndustry);
		return renderResult(Global.TRUE, text("删除标准行业表(GB/T 4754-2017)成功！"));
	}
	
}