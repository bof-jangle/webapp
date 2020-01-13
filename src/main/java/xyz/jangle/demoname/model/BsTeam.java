package xyz.jangle.demoname.model;

/**
 * 队伍管理 Model
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public class BsTeam extends BaseModel {
	
	public static final String tableName = "bs_team";

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
	 * 上级节点ID
	 */
	private Long jgParentId;
	/**
	 * 上级节点名称
	 */
	private String jgParentName;
	/**
	 * 队伍名称
	 */
	private String jgName;
	/**
	 * 队伍类型
	 */
	private String jgTeamType;
	/**
	 * 排序
	 */
	private Integer jgOrder;
	/**
	 * 描述
	 */
	private String dmDesc;
	/**
	 * 描述2
	 */
	private String dmDesc2;
	
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
	public Long getJgParentId(){
		return jgParentId;
	}
	public void setJgParentId(Long jgParentId){
		this.jgParentId = jgParentId;
	}
	public String getJgParentName(){
		return jgParentName;
	}
	public void setJgParentName(String jgParentName){
		this.jgParentName = jgParentName;
	}
	public String getJgName(){
		return jgName;
	}
	public void setJgName(String jgName){
		this.jgName = jgName;
	}
	public String getJgTeamType(){
		return jgTeamType;
	}
	public void setJgTeamType(String jgTeamType){
		this.jgTeamType = jgTeamType;
	}
	public Integer getJgOrder(){
		return jgOrder;
	}
	public void setJgOrder(Integer jgOrder){
		this.jgOrder = jgOrder;
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
	
	
}