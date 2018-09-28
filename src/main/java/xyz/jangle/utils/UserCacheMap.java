package xyz.jangle.utils;

import java.util.HashMap;
import java.util.Map;

import xyz.jangle.model.DUser;

/** 
 * 用于缓存登陆的用户信息
* @author jangle E-mail: jangle@jangle.xyz
* @version 2018年9月28日 下午3:18:15 
* 类说明 
*/
public class UserCacheMap {
	
	private static Map<String, DUser> map = new HashMap<String, DUser>();
	
	public static DUser get(String idOrPassword) {
		return map.get(idOrPassword);
	}
	
	public static DUser put(String key, DUser value) {
		return map.put(key, value);
	}
	
	public static DUser remove(String key) {
		return map.remove(key);
	}

}
