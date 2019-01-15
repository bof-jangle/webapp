package xyz.jangle.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回结果的List对象
 * 
 * @author jangle
 *
 * @param <T>
 */
public class ResultModelList<T> extends ResultModel<T> {

	private List<T> list;

	public ResultModelList() {
		super();
		this.list = new ArrayList<T>();
	}

	public ResultModelList(String code, String msg) {
		this();
		this.setCode(code);
		this.setMessage(msg);
	}

	public ResultModelList(CME cmEnum) {
		this();
		this.setCodeMessage(cmEnum);
	}

	public ResultModelList(List<T> list) {
		this.list = list;
	}

	public List<T> getList() {
		if (list == null) {
			return new ArrayList<T>();
		}
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
