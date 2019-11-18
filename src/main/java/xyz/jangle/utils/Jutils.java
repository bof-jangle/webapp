package xyz.jangle.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2019年1月21日 下午5:52:48 类说明
 */
public class Jutils {
	/**
	 * 参数大于0
	 * 
	 * @param arg
	 * @return
	 */
	public static boolean isGreatThan0(Long arg) {
		return (arg != null && arg > 0);
	}

	/**
	 * 参数大于0
	 * 
	 * @param arg
	 * @return
	 */
	public static boolean isGreatThan0(Integer arg) {
		return (arg != null && arg > 0);
	}

	/**
	 * 参数不为空
	 * 
	 * @param arg
	 * @return
	 */
	public static boolean isNotEmpty(String arg) {
		return (arg != null && !arg.equals(""));
	}

	/**
	 * 参数为空
	 * 
	 * @param arg
	 * @return
	 */
	public static boolean isEmpty(String arg) {
		return !Jutils.isNotEmpty(arg);
	}
	
	/**
	 * 获取HashMap<String,Object>的对象
	 * @return
	 */
	public static Map<String, Object> getHashMapSO(){
		return new HashMap<String, Object>();
	}
	
	/**
	 * 获取新的UUID
	 * @return
	 */
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
