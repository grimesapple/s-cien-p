package com.jeesite.modules.g.entity;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;

import javax.validation.constraints.Size;

/**
 * g_clientEntity
 * @author rye
 * @version 2022-12-04
 */
@Table(name="g_client", alias="a", label="g_client信息", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="month", attrName="month", label="月报"),
		@Column(name="quarter", attrName="quarter", label="季报"),
		@Column(name="year", attrName="year", label="年报"),
		@Column(name="free", attrName="free", label="自由报"),
	}, orderBy="a.id DESC"
)
public class Gclient extends DataEntity<Gclient> {
	
	private static final long serialVersionUID = 1L;
	private String month;		// 月报
	private String quarter;		// 季报
	private String year;		// 年报
	private String free;		// 自由报

	public Gclient() {
		this(null);
	}
	
	public Gclient(String id){
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
	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	
	@Size(min=0, max=255, message="年报长度不能超过 255 个字符")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	@Size(min=0, max=255, message="自由报长度不能超过 255 个字符")
	public String getFree() {
		return free;
	}

	public void setFree(String free) {
		this.free = free;
	}
	
}