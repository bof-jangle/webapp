package xyz.jangle.utils;

/**
 * 作为service层的结果返回对象（超类）
 * 
 * @author dell
 *
 * @param <T>
 */
public class ResultModel<T> {
	/** model */
	private T model;
	/** 返回信息编码 */
	private String code = CodeMessageEnum.success.getCode();
	/** 返回信息 */
	private String message;

	public ResultModel() {

	}

	public ResultModel(CodeMessageEnum cmEnum) {
		this.code = cmEnum.getCode();
		this.message = cmEnum.getMessage();
	}

	public ResultModel(T model) {
		this.model = model;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
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

	/**
	 * 将枚举对象作为参数，直接赋值给code和message
	 * 
	 * @param cmEnum
	 */
	public void setCodeMessage(CodeMessageEnum cmEnum) {
		this.code = cmEnum.getCode();
		this.message = cmEnum.getMessage();
	}

}
