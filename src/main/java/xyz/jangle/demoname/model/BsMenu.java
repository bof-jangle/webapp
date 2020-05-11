package xyz.jangle.demoname.model;

/**
 * 菜单表 Model
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public class BsMenu extends BaseModel {
	
	public static final String tableName = "bs_menu";

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
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 上级菜单ID
	 */
	private Long menuParentId;
	/**
	 * 上级菜单名称
	 */
	private String menuParentName;
	/**
	 * 菜单链接
	 */
	private String menuUrl;
	
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
	public String getMenuName(){
		return menuName;
	}
	public void setMenuName(String menuName){
		this.menuName = menuName;
	}
	public Long getMenuParentId(){
		return menuParentId;
	}
	public void setMenuParentId(Long menuParentId){
		this.menuParentId = menuParentId;
	}
	public String getMenuParentName(){
		return menuParentName;
	}
	public void setMenuParentName(String menuParentName){
		this.menuParentName = menuParentName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	
	
}