package xyz.jangle.demoname.model;

/**
 * 访客统计 Model
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public class BsVisitCount extends BaseModel {
	
	public static final String tableName = "bs_visit_count";

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
	 * IP
	 */
	private String dmDesc;
	/**
	 * 城市
	 */
	private String dmDesc2;
	/**
	 * 访问次数
	 */
	private String visitCount;
	
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
	public String getVisitCount(){
		return visitCount;
	}
	public void setVisitCount(String visitCount){
		this.visitCount = visitCount;
	}
	
	
}