package xyz.jangle.demoname.model;


/**
 * 资产管理 Model
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public class JgAssets extends BaseModel {
	
	public static final String tableName = "jg_assets";

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
	 * 资产名称
	 */
	private String jgAssetsName;
	/**
	 * 存放位置
	 */
	private String jgAssetsPosition;
	/**
	 * 价值
	 */
	private String jgAssetsCost;
	/**
	 * 来源
	 */
	private String jgAssetsSource;
	/**
	 * 获取时间
	 */
	private java.util.Date jgAssetsGetTime;
	/**
	 * 创建人UUID
	 */
	private String createUuid;
	
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
	public String getJgAssetsName(){
		return jgAssetsName;
	}
	public void setJgAssetsName(String jgAssetsName){
		this.jgAssetsName = jgAssetsName;
	}
	public String getJgAssetsPosition(){
		return jgAssetsPosition;
	}
	public void setJgAssetsPosition(String jgAssetsPosition){
		this.jgAssetsPosition = jgAssetsPosition;
	}
	public String getJgAssetsCost(){
		return jgAssetsCost;
	}
	public void setJgAssetsCost(String jgAssetsCost){
		this.jgAssetsCost = jgAssetsCost;
	}
	public String getJgAssetsSource(){
		return jgAssetsSource;
	}
	public void setJgAssetsSource(String jgAssetsSource){
		this.jgAssetsSource = jgAssetsSource;
	}
	public java.util.Date getJgAssetsGetTime(){
		return jgAssetsGetTime;
	}
	public void setJgAssetsGetTime(java.util.Date jgAssetsGetTime){
		this.jgAssetsGetTime = jgAssetsGetTime;
	}
	public String getCreateUuid(){
		return createUuid;
	}
	public void setCreateUuid(String createUuid){
		this.createUuid = createUuid;
	}
	
	
}