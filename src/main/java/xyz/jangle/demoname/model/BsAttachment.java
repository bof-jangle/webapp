package xyz.jangle.demoname.model;

import java.io.File;

/**
 * 附件上传存放管理 Model
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public class BsAttachment extends BaseModel {
	
	public static final String tableName = "bs_attachment";

	/**
	 * 主键UUID
	 */
	private String uuid;
	/**
	 * 文件表id
	 */
	private Long attId;
	/**
	 * 状态 0、未启用  1、启用
	 */
	private Integer status;
	/**
	 * 创建人的uuid
	 */
	private String attCreateUuid;
	/**
	 * 文件名
	 */
	private String attName;
	/**
	 * 文件类型，扩展名
	 */
	private String attExt;
	/**
	 * 相对路径 年/月/ID/文件
	 */
	private String attPath;
	/**
	 * 绝对路径
	 */
	private String attAbspath;
	/**
	 * 协议
	 */
	private String attProtocol;
	/**
	 * 内容，备用
	 */
	private String attContext;
	/**
	 * 附件所属业务表名
	 */
	private String attSourceType;
	/**
	 * 附件所属业务表主键id
	 */
	private Long attSourceId;
	/**
	 * 业务源的UUID
	 */
	private String attSourceUuid;
	/**
	 * 附件类型
	 */
	private String attFileType;
	/**
	 * 扩展字段1
	 */
	private Integer attExtends1;
	/**
	 * 扩展字段2 
	 */
	private String attExtends2;
	/**
	 * 扩展字段3
	 */
	private java.util.Date attExtends3;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 更新时间
	 */
	private java.util.Date updateTime;
	/**
	 * 描述
	 */
	private String dmDesc;
	
	private File[] JAttFile;
	
	private String JAttFileFileName;
	
	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public Long getAttId(){
		return attId;
	}
	public void setAttId(Long attId){
		this.attId = attId;
	}
	public Integer getStatus(){
		return status;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public String getAttCreateUuid(){
		return attCreateUuid;
	}
	public void setAttCreateUuid(String attCreateUuid){
		this.attCreateUuid = attCreateUuid;
	}
	public String getAttName(){
		return attName;
	}
	public void setAttName(String attName){
		this.attName = attName;
	}
	public String getAttExt(){
		return attExt;
	}
	public void setAttExt(String attExt){
		this.attExt = attExt;
	}
	public String getAttPath(){
		return attPath;
	}
	public void setAttPath(String attPath){
		this.attPath = attPath;
	}
	public String getAttAbspath(){
		return attAbspath;
	}
	public void setAttAbspath(String attAbspath){
		this.attAbspath = attAbspath;
	}
	public String getAttProtocol(){
		return attProtocol;
	}
	public void setAttProtocol(String attProtocol){
		this.attProtocol = attProtocol;
	}
	public String getAttContext(){
		return attContext;
	}
	public void setAttContext(String attContext){
		this.attContext = attContext;
	}
	public String getAttSourceType(){
		return attSourceType;
	}
	public void setAttSourceType(String attSourceType){
		this.attSourceType = attSourceType;
	}
	public Long getAttSourceId(){
		return attSourceId;
	}
	public void setAttSourceId(Long attSourceId){
		this.attSourceId = attSourceId;
	}
	public String getAttSourceUuid(){
		return attSourceUuid;
	}
	public void setAttSourceUuid(String attSourceUuid){
		this.attSourceUuid = attSourceUuid;
	}
	public String getAttFileType(){
		return attFileType;
	}
	public void setAttFileType(String attFileType){
		this.attFileType = attFileType;
	}
	public Integer getAttExtends1(){
		return attExtends1;
	}
	public void setAttExtends1(Integer attExtends1){
		this.attExtends1 = attExtends1;
	}
	public String getAttExtends2(){
		return attExtends2;
	}
	public void setAttExtends2(String attExtends2){
		this.attExtends2 = attExtends2;
	}
	public java.util.Date getAttExtends3(){
		return attExtends3;
	}
	public void setAttExtends3(java.util.Date attExtends3){
		this.attExtends3 = attExtends3;
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
	public File[] getJAttFile() {
		return JAttFile;
	}
	public void setJAttFile(File[] jAttFile) {
		JAttFile = jAttFile;
	}
	public String getJAttFileFileName() {
		return JAttFileFileName;
	}
	public void setJAttFileFileName(String jAttFileFileName) {
		JAttFileFileName = jAttFileFileName;
	}
	
	
	
	
}