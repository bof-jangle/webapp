package xyz.jangle.utils;

/**
 * CME = CodeMessageEnum
 * 
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2018年9月18日 下午2:28:28 类说明
 */
public enum CME {
	ATTACHMENT_FILE_NOT_FOUND("30001","未获取到附件"),
	USER_APPLY_IP_UNSUPPORT("20002","网络信息获取异常"),
	USER_APPLY_IP_REPEAT("20001","当前网络地址已存在申请用户且未审批"),
	BSUSER2_JGCODE_REPEAT("10007","用户名已存在"),
	UNFIND_IDS_TO_DELETE("10006","待批量删除的ids结果集为空"),
	UNLOGIN("10005", "未登录或会话已过期"), LOGIN_FAILED("10004", "登陆异常，用户名或密码错误"), EXCEPTION("10003", "操作异常"),
	ERROR("10002", "操作失败"), SUCCESS("10001", "操作成功");

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
