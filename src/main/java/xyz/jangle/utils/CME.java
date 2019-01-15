package xyz.jangle.utils;

/**
 * CME = CodeMessageEnum
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2018年9月18日 下午2:28:28 类说明
 */
public enum CME {
	
	unlogin("10005","未登录或回话已过期"),
	loginFailed("10004","登陆异常，用户名或密码错误"),
	exception("10003","操作异常"),
	error("10002","操作失败"),
	success("10001","操作成功");

	private String code;

	private String message;

	private CME(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
