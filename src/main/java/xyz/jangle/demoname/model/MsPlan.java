package xyz.jangle.demoname.model;

/**
 * 面试安排 Model
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.12020-06-08 11:34:37
 */
public class MsPlan extends BaseModel {
	
	public static final String tableName = "ms_plan";

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
	 * 公司
	 */
	private String company;
	/**
	 * 职务
	 */
	private String work;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 联系信息
	 */
	private String tellInfo;
	/**
	 * 优势
	 */
	private String goodness;
	/**
	 * 我的安排
	 */
	private String myPlan;
	/**
	 * 备注
	 */
	private String remark;
	
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
	public String getCompany(){
		return company;
	}
	public void setCompany(String company){
		this.company = company;
	}
	public String getWork(){
		return work;
	}
	public void setWork(String work){
		this.work = work;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getTellInfo(){
		return tellInfo;
	}
	public void setTellInfo(String tellInfo){
		this.tellInfo = tellInfo;
	}
	public String getGoodness(){
		return goodness;
	}
	public void setGoodness(String goodness){
		this.goodness = goodness;
	}
	public String getMyPlan(){
		return myPlan;
	}
	public void setMyPlan(String myPlan){
		this.myPlan = myPlan;
	}
	public String getRemark(){
		return remark;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	
}