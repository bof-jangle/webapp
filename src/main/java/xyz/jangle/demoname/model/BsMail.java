package xyz.jangle.demoname.model;

/**
 * 邮件发送记录表 Model
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public class BsMail extends BaseModel {
	
	public static final String tableName = "bs_mail";
	/** 密码邮件类型 */
	public static final Integer typePassword = 1;
	/** 手动录入类型 */
	public static final Integer typeManual = 2;
	/** 管理员提醒类型 */
	public static final Integer typeManage = 3;
	/** 访问录入类型 */
	public static final Integer typeAccess = 4;

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
	 * 状态 0、待发送  1、发送成功 2、发送失败
	 */
	private Integer status;
	/**
	 * 邮箱收件人
	 */
	private String toEmail;
	/**
	 * 邮件标题
	 */
	private String mailSubject;
	/**
	 * 邮件内容
	 */
	private String mailContent;
	/**
	 * 邮件类型：1、密码邮件 2、手动录入
	 */
	private Integer mailType;
	/**
	 * 发送结果（失败原因）
	 */
	private String mailResult;
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
	public String getToEmail(){
		return toEmail;
	}
	public void setToEmail(String toEmail){
		this.toEmail = toEmail;
	}
	public String getMailSubject(){
		return mailSubject;
	}
	public void setMailSubject(String mailSubject){
		this.mailSubject = mailSubject;
	}
	public String getMailContent(){
		return mailContent;
	}
	public void setMailContent(String mailContent){
		this.mailContent = mailContent;
	}
	public Integer getMailType(){
		return mailType;
	}
	public void setMailType(Integer mailType){
		this.mailType = mailType;
	}
	public String getMailResult(){
		return mailResult;
	}
	public void setMailResult(String mailResult){
		this.mailResult = mailResult;
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