package com.jeesite.modules.trade.entity;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

import javax.validation.constraints.Size;

/**
 * 国民经济行业Entity
 * @author rye
 * @version 2022-11-19
 */
@Table(name="trade", alias="a", label="国民经济行业信息", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="main_code", attrName="mainCode", label="code"),
		@Column(name="category_name", attrName="categoryName", label="门类名称", queryType=QueryType.LIKE),
		@Column(name="category_code", attrName="categoryCode", label="门类代码"),
		@Column(name="major_class_name", attrName="majorClassName", label="大类名称", queryType=QueryType.LIKE),
		@Column(name="major_class_code", attrName="majorClassCode", label="大类代码"),
		@Column(name="middle_class_name", attrName="middleClassName", label="中类名称", queryType=QueryType.LIKE),
		@Column(name="middle_class_code", attrName="middleClassCode", label="中类代码"),
		@Column(name="subclass_name", attrName="subclassName", label="小类名称", queryType=QueryType.LIKE),
		@Column(name="subclass_code", attrName="subclassCode", label="小类代码"),
	}, orderBy="a.id DESC"
)
public class Trade extends DataEntity<Trade> {
	
	private static final long serialVersionUID = 1L;
	private String mainCode;		// code
	private String categoryName;		// 门类名称
	private String categoryCode;		// 门类代码
	private String majorClassName;		// 大类名称
	private String majorClassCode;		// 大类代码
	private String middleClassName;		// 中类名称
	private String middleClassCode;		// 中类代码
	private String subclassName;		// 小类名称
	private String subclassCode;		// 小类代码

	public Trade() {
		this(null);
	}
	
	public Trade(String id){
		super(id);
	}
	
	@Size(min=0, max=255, message="code长度不能超过 255 个字符")
	public String getMainCode() {
		return mainCode;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}
	
	@Size(min=0, max=255, message="门类名称长度不能超过 255 个字符")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Size(min=0, max=10, message="门类代码长度不能超过 10 个字符")
	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	@Size(min=0, max=255, message="大类名称长度不能超过 255 个字符")
	public String getMajorClassName() {
		return majorClassName;
	}

	public void setMajorClassName(String majorClassName) {
		this.majorClassName = majorClassName;
	}
	
	@Size(min=0, max=10, message="大类代码长度不能超过 10 个字符")
	public String getMajorClassCode() {
		return majorClassCode;
	}

	public void setMajorClassCode(String majorClassCode) {
		this.majorClassCode = majorClassCode;
	}
	
	@Size(min=0, max=255, message="中类名称长度不能超过 255 个字符")
	public String getMiddleClassName() {
		return middleClassName;
	}

	public void setMiddleClassName(String middleClassName) {
		this.middleClassName = middleClassName;
	}
	
	@Size(min=0, max=10, message="中类代码长度不能超过 10 个字符")
	public String getMiddleClassCode() {
		return middleClassCode;
	}

	public void setMiddleClassCode(String middleClassCode) {
		this.middleClassCode = middleClassCode;
	}
	
	@Size(min=0, max=255, message="小类名称长度不能超过 255 个字符")
	public String getSubclassName() {
		return subclassName;
	}

	public void setSubclassName(String subclassName) {
		this.subclassName = subclassName;
	}
	
	@Size(min=0, max=10, message="小类代码长度不能超过 10 个字符")
	public String getSubclassCode() {
		return subclassCode;
	}

	public void setSubclassCode(String subclassCode) {
		this.subclassCode = subclassCode;
	}
	
}