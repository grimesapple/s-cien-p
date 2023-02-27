package com.jeesite.modules.gov.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 用户信息表Entity
 * @author rye
 * @version 2022-12-06
 */
@Table(name="g_user_info", alias="a", label="用户信息表信息", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="company", attrName="company", label="单位名称"),
		@Column(name="username", attrName="username", label="税号", comment="税号（登录账号）"),
		@Column(name="linkman", attrName="linkman", label="联系人"),
		@Column(name="phone", attrName="phone", label="手机号码"),
		@Column(name="industry", attrName="industry", label="行业code"),
		@Column(name="registered_capital", attrName="registeredCapital", label="注册资本"),
		@Column(name="file", attrName="file", label="上传营业执照复印件"),
		@Column(name="set_up_datetime", attrName="setUpDatetime", label="企业成立日期", isUpdateForce=true),
		@Column(name="address", attrName="address", label="企业地址"),
		@Column(name="create_time", attrName="createTime", label="创建时间", isUpdateForce=true),
		@Column(name="update_time", attrName="updateTime", label="更新时间", isUpdateForce=true),
	}, orderBy="a.id DESC"
)
public class UserInfo extends DataEntity<UserInfo> {
	
	private static final long serialVersionUID = 1L;
	private String company;		// 单位名称
	private String username;		// 税号（登录账号）
	private String linkman;		// 联系人
	private String phone;		// 手机号码
	private String industry;		// 行业code
	private String registeredCapital;		// 注册资本
	private String file;		// 上传营业执照复印件
	private Date setUpDatetime;		// 企业成立日期
	private String address;		// 企业地址
	private Date createTime;		// 创建时间
	private Date updateTime;		// 更新时间

	public UserInfo() {
		this(null);
	}
	
	public UserInfo(String id){
		super(id);
	}
	
	@Size(min=0, max=64, message="单位名称长度不能超过 64 个字符")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	@Size(min=0, max=64, message="税号长度不能超过 64 个字符")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Size(min=0, max=64, message="联系人长度不能超过 64 个字符")
	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	
	@Size(min=0, max=255, message="手机号码长度不能超过 255 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Size(min=0, max=255, message="行业code长度不能超过 255 个字符")
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	@Size(min=0, max=255, message="注册资本长度不能超过 255 个字符")
	public String getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}
	
	@Size(min=0, max=255, message="上传营业执照复印件长度不能超过 255 个字符")
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSetUpDatetime() {
		return setUpDatetime;
	}

	public void setSetUpDatetime(Date setUpDatetime) {
		this.setUpDatetime = setUpDatetime;
	}
	
	@Size(min=0, max=255, message="企业地址长度不能超过 255 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}