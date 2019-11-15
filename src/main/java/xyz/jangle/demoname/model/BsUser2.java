package xyz.jangle.demoname.model;

/**
 * 用户表V2 Model
 * 
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public class BsUser2 extends BaseModel {

	public static final String tableName = "bs_user2";

	/**
	 * 主键UUID
	 */
	private String uuid;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 更新时间
	 */
	private java.util.Date updateTime;
	/**
	 * 状态 0、未启用 1、启用
	 */
	private Integer status;
	/**
	 * 描述
	 */
	private String dmDesc;
	/**
	 * 描述2
	 */
	private String dmDesc2;
	/**
	 * 用户中文名称
	 */
	private String jgName;
	/**
	 * 英文账号
	 */
	private String jgCode;
	/**
	 * 密码
	 */
	private String jgPassword;
	/**
	 * 申请人IP
	 */
	private String jgApplyIp;
	/**
	 * 申请理由
	 */
	private String jgApplyReason;
	// IP 和城市
	private String ip, city;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
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

	public String getDmDesc2() {
		return dmDesc2;
	}

	public void setDmDesc2(String dmDesc2) {
		this.dmDesc2 = dmDesc2;
	}

	public String getJgName() {
		return jgName;
	}

	public void setJgName(String jgName) {
		this.jgName = jgName;
	}

	public String getJgCode() {
		return jgCode;
	}

	public void setJgCode(String jgCode) {
		this.jgCode = jgCode;
	}

	public String getJgPassword() {
		return jgPassword;
	}

	public void setJgPassword(String jgPassword) {
		this.jgPassword = jgPassword;
	}

	public String getJgApplyIp() {
		return jgApplyIp;
	}

	public void setJgApplyIp(String jgApplyIp) {
		this.jgApplyIp = jgApplyIp;
	}

	public String getJgApplyReason() {
		return jgApplyReason;
	}

	public void setJgApplyReason(String jgApplyReason) {
		this.jgApplyReason = jgApplyReason;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}