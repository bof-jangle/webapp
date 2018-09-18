package xyz.jangle.model;

import java.util.Date;

public class DUser {
	
	private Long usrId;
	private String usrName;
	private String usrCode;
	private String usrPassword;
	private int usrStatus;
	private Date createTime;
	private Date updateTime;
	private String extends1;
	private String extends2;
	public Long getUsrId() {
		return usrId;
	}
	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getUsrCode() {
		return usrCode;
	}
	public void setUsrCode(String usrCode) {
		this.usrCode = usrCode;
	}
	public String getUsrPassword() {
		return usrPassword;
	}
	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}
	
	public int getUsrStatus() {
		return usrStatus;
	}
	public void setUsrStatus(int usrStatus) {
		this.usrStatus = usrStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getExtends1() {
		return extends1;
	}
	public void setExtends1(String extends1) {
		this.extends1 = extends1;
	}
	public String getExtends2() {
		return extends2;
	}
	public void setExtends2(String extends2) {
		this.extends2 = extends2;
	}
	
	

}
