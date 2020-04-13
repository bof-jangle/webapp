package xyz.jangle.demoname.model;

/**
 * 执行记录表 Model
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public class BsExcuteHistory extends BaseModel {
	
	public static final String tableName = "bs_excute_history";

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
	 * 执行方法
	 */
	private String excuteMethod;
	/**
	 * 执行人账户
	 */
	private String excuterCode;
	
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
	public String getExcuteMethod(){
		return excuteMethod;
	}
	public void setExcuteMethod(String excuteMethod){
		this.excuteMethod = excuteMethod;
	}
	public String getExcuterCode(){
		return excuterCode;
	}
	public void setExcuterCode(String excuterCode){
		this.excuterCode = excuterCode;
	}
	
	
}