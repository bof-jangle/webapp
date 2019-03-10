package xyz.jangle.utils;

import java.util.HashMap;
import java.util.Map;

import xyz.jangle.demoname.model.BsUser;

/** 
 * 用于缓存登陆的用户信息
* @author jangle E-mail: jangle@jangle.xyz
* @version 2018年9月28日 下午3:18:15 
* 类说明 
*/
public class UserCacheMap {
	
	private static Map<String, BsUser> map = new HashMap<String, BsUser>();
	
	public static BsUser get(String idOrPassword) {
		return map.get(idOrPassword);
	}
	
	public static BsUser put(String key, BsUser value) {
		return map.put(key, value);
	}
	
	public static BsUser remove(String key) {
		return map.remove(key);
	}

}
