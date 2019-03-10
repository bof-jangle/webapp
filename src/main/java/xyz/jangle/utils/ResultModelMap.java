package xyz.jangle.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2018年9月18日 下午2:13:50 类说明
 */
public class ResultModelMap<T> extends ResultModelList<T> {

	private Map<String, Object> map;

	public ResultModelMap() {
		super();
	}

	public ResultModelMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public ResultModelMap(CME cmEnum){
		this();
		this.setCodeMessage(cmEnum);
	}

	public Map<String, Object> getMap() {
		if (map == null) {
			return new HashMap<String, Object>();
		}
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
