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
}