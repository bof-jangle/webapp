package xyz.jangle.demoname.model;

import java.util.Date;
/**
 * 用户申请 Model
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public class ZdUserApply extends BaseModel {
	
	public static final String tableName = "zd_user_apply";

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
	 * 状态 0、未启用  1、启用
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
	 * 昵称
	 */
	private String zdUserName;
	/**
	 * 用户名
	 */
	private String zdUserCode;
	/**
	 * 密码
	 */
	private String zdUserPassword;
	/**
	 * 申请理由
	 */
	private String zdUserApplyReason;
	/**
	 * 申请人IP地址
	 */
	private String zdUserApplyIp;
	
	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public java.util.Date getCreateTime(){
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	public java.util.Date getUpdateTime(){
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	public Integer getStatus(){
		return status;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public String getDmDesc(){
		return dmDesc;
	}
	public void setDmDesc(String dmDesc){
		this.dmDesc = dmDesc;
	}
	public String getDmDesc2(){
		return dmDesc2;
	}
	public void setDmDesc2(String dmDesc2){
		this.dmDesc2 = dmDesc2;
	}
	public String getZdUserName(){
		return zdUserName;
	}
	public void setZdUserName(String zdUserName){
		this.zdUserName = zdUserName;
	}
	public String getZdUserCode(){
		return zdUserCode;
	}
	public void setZdUserCode(String zdUserCode){
		this.zdUserCode = zdUserCode;
	}
	public String getZdUserPassword(){
		return zdUserPassword;
	}
	public void setZdUserPassword(String zdUserPassword){
		this.zdUserPassword = zdUserPassword;
	}
	public String getZdUserApplyReason(){
		return zdUserApplyReason;
	}
	public void setZdUserApplyReason(String zdUserApplyReason){
		this.zdUserApplyReason = zdUserApplyReason;
	}
	public String getZdUserApplyIp(){
		return zdUserApplyIp;
	}
	public void setZdUserApplyIp(String zdUserApplyIp){
		this.zdUserApplyIp = zdUserApplyIp;
	}
	
	
}