package xyz.jangle.demoname.model;

import java.util.Date;

public class BsDemo extends BaseModel {
	/**
	 * 主键ID
	 *
	 * @mbg.generated
	 */
	private Long id;

	/**
	 * 主键UUID
	 *
	 * @mbg.generated
	 */
	private String uuid;

	/**
	 * 创建时间
	 *
	 * @mbg.generated
	 */
	private Date createTime;

	/**
	 * 更新时间
	 *
	 * @mbg.generated
	 */
	private Date updateTime;

	/**
	 * 状态 0、未启用 1、启用
	 *
	 * @mbg.generated
	 */
	private Integer status;
	
	private String extends1;
	
	private String extends2;
	
	private Date extends3;
	
	private Date extends4;
	
	private Integer extends5;
	
	private Long extends6;

	/**
	 * 描述
	 *
	 * @mbg.generated
	 */
	private String dmDesc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDmDesc() {
		return dmDesc;
	}

	public void setDmDesc(String dmDesc) {
		this.dmDesc = dmDesc;
	}

	public String getExtends1() {
		return extends1;
	}

	public void setExtends1(String extends1) {
		this.extends1 = extends1;
	}

	public String getExtends2() {
		return extends2;
	}

	public void setExtends2(String extends2) {
		this.extends2 = extends2;
	}

	public Date getExtends3() {
		return extends3;
	}

	public void setExtends3(Date extends3) {
		this.extends3 = extends3;
	}

	public Date getExtends4() {
		return extends4;
	}

	public void setExtends4(Date extends4) {
		this.extends4 = extends4;
	}

	public Integer getExtends5() {
		return extends5;
	}

	public void setExtends5(Integer extends5) {
		this.extends5 = extends5;
	}

	public Long getExtends6() {
		return extends6;
	}

	public void setExtends6(Long extends6) {
		this.extends6 = extends6;
	}
	
	
}