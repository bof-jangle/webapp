package xyz.jangle.demoname.model;

import java.util.Map;

/**
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2020年11月12日 下午8:30:36
 * 
 */
public abstract class BaseModelQuery {

	private Map<String, String> query;

	public Map<String, String> getQuery() {
		return query;
	}

	public void setQuery(Map<String, String> query) {
		this.query = query;
	}

}
