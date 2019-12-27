package xyz.jangle.demoname.model;

/**
 * 角色管理 Model
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public class BsRole extends BaseModel {
	
	public static final String tableName = "bs_role";

	/**
	 * UUID
	 */
	private String uuid;
	/**
	 * 角色名称
	 */
	private String rolName;
	/**
	 * 角色编码
	 */
	private String rolCode;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 更新时间
	 */
	private java.util.Date updateTime;
	/**
	 * 拓展字段1
	 */
	private String dmDesc;
	/**
	 * 拓展字段2
	 */
	private String dmDesc2;
	
	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getRolName(){
		return rolName;
	}
	public void setRolName(String rolName){
		this.rolName = rolName;
	}
	public String getRolCode(){
		return rolCode;
	}
	public void setRolCode(String rolCode){
		this.rolCode = rolCode;
	}
	public Integer getStatus(){
		return status;
	}
	public void setStatus(Integer status){
		this.status = status;
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