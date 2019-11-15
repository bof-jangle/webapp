package xyz.jangle.utils;

import java.util.HashMap;
import java.util.Map;

import xyz.jangle.demoname.model.BsUser2;

/** 
 * 用于缓存登陆的用户信息
* @author jangle E-mail: jangle@jangle.xyz
* @version 2018年9月28日 下午3:18:15 
* 类说明 
*/
public class UserCacheMap2 {
	
	public static String codePrev = "JG_CODE_";
	
	private static Map<String, BsUser2> map = new HashMap<String, BsUser2>();
	
	public static BsUser2 get(String idOrPassword) {
		return map.get(idOrPassword);
	}
	
	public static BsUser2 put(String key, BsUser2 value) {
		return map.put(key, value);
	}
	
	public static BsUser2 remove(String key) {
		return map.remove(key);
	}

}
