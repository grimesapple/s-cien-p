package com.jeesite.modules.g.entity;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;

import javax.validation.constraints.Size;

/**
 * g_technologyEntity
 * @author rye
 * @version 2022-12-04
 */
@Table(name="g_technology", alias="a", label="g_technology信息", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="month", attrName="month", label="月报"),
		@Column(name="quartrly", attrName="quartrly", label="季报"),
		@Column(name="annual", attrName="annual", label="年报"),
	}, orderBy="a.id DESC"
)
public class Gtechnology extends DataEntity<Gtechnology> {
	
	private static final long serialVersionUID = 1L;
	private String month;		// 月报
	private String quartrly;		// 季报
	private String annual;		// 年报

	public Gtechnology() {
		this(null);
	}
	
	public Gtechnology(String id){
		super(id);
	}
	
	@Size(min=0, max=255, message="月报长度不能超过 255 个字符")
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	@Size(min=0, max=255, message="季报长度不能超过 255 个字符")
	public String getQuartrly() {
		return quartrly;
	}

	public void setQuartrly(String quartrly) {
		this.quartrly = quartrly;
	}
	
	@Size(min=0, max=255, message="年报长度不能超过 255 个字符")
	public String getAnnual() {
		return annual;
	}

	public void setAnnual(String annual) {
		this.annual = annual;
	}
	
}