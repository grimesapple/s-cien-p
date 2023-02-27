package com.jeesite.modules.norm.entity;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 标准行业表(GB/T 4754-2017)Entity
 * @author rye
 * @version 2022-12-05
 */
@Table(name="norm_industry", alias="a", label="标准行业表(GB/T 4754-2017)信息", columns={
		@Column(name="id", attrName="id", label="自增数据ID", isPK=true),
		@Column(name="code", attrName="code", label="行业编号"),
		@Column(name="name", attrName="name", label="行业名称", queryType=QueryType.LIKE),
		@Column(name="parent_code", attrName="parentCode", label="父行业编号"),
		@Column(name="has_child", attrName="hasChild", label="是否有子节点", comment="是否有子节点：1是，0否"),
	}, orderBy="a.id DESC"
)
public class NormIndustry extends DataEntity<NormIndustry> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// 行业编号
	private String name;		// 行业名称
	private String parentCode;
	private Integer hasChild;		// 是否有子节点：1是，0否

	public NormIndustry() {
		this(null);
	}
	
	public NormIndustry(String id){
		super(id);
	}
	
	@NotBlank(message="行业编号不能为空")
	@Size(min=0, max=8, message="行业编号长度不能超过 8 个字符")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@NotBlank(message="行业名称不能为空")
	@Size(min=0, max=64, message="行业名称长度不能超过 64 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull(message="是否有子节点不能为空")
	public Integer getHasChild() {
		return hasChild;
	}

	public void setHasChild(Integer hasChild) {
		this.hasChild = hasChild;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}


//	@Override
//	public void setParent(NormIndustry parent) {
//		this.parent = parent;
//	}
//
//	@Override
//	public NormIndustry getParent() {
//		return parent;
//	}
}