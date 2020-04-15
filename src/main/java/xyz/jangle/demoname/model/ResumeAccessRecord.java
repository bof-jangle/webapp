package xyz.jangle.demoname.model;

/**
 * 简历访问记录 Model
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public class ResumeAccessRecord extends BaseModel {
	
	public static final String tableName = "resume_access_record";

	/**
	 * 主键UUID
	 */
	private String uuid;
	/**
	 * 创建时间（web访问时间）
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
	 * ip
	 */
	private String dmDesc;
	/**
	 * 城市
	 */
	private String dmDesc2;
	/**
	 * 简历URI
	 */
	private String resumeUri;
	
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
	public String getResumeUri(){
		return resumeUri;
	}
	public void setResumeUri(String resumeUri){
		this.resumeUri = resumeUri;
	}
	
	
}