package xyz.jangle.demoname.model;

/**
 * 战队留言板 Model
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public class ZdLyb extends BaseModel {
	
	public static final String tableName = "zd_lyb";

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
	 * 留言正文
	 */
	private String zdContent;
	/**
	 * zd_lyr_uuid
	 */
	private String zdLyrUuid;
	/**
	 * zd_lyr
	 */
	private String zdLyr;
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
	public String getZdContent(){
		return zdContent;
	}
	public void setZdContent(String zdContent){
		this.zdContent = zdContent;
	}
	public String getZdLyrUuid(){
		return zdLyrUuid;
	}
	public void setZdLyrUuid(String zdLyrUuid){
		this.zdLyrUuid = zdLyrUuid;
	}
	public String getZdLyr(){
		return zdLyr;
	}
	public void setZdLyr(String zdLyr){
		this.zdLyr = zdLyr;
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