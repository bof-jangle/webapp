package xyz.jangle.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.swing.text.DateFormatter;

import xyz.jangle.demoname.model.BsUser2;
import xyz.jangle.demoname.service.BsUser2Service;

/**
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2019年1月21日 下午5:52:48 类说明
 */
public class Jutils {

	private static Map<String, ThreadLocal<DateFormatter>> dateLocalMap = new HashMap<>();
	
	// 线程安全的日期格式化
//	private final static ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));

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

	public static boolean isEmpty(List<?> list) {
		return list == null || list.isEmpty();
	}

	/**
	 * 获取HashMap<String,Object>的对象
	 * 
	 * @return
	 */
	public static Map<String, Object> getHashMapSO() {
		return new HashMap<String, Object>();
	}

	/**
	 * 获取新的UUID
	 * 
	 * @return
	 */
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 	日期格式转换
	 * 	每种type类型一个ThreadLocal。
	 * 	每个线程对应与该ThreadLocal中的独立实例（详见threadLocal.get()方法）
	 * @param date 日期
	 * @param type 字符串类型（例：yyyy年MM月dd日 HH:mm:ss.SSS ）
	 * @return
	 */
	public static String datetimeFormatter(Date date, String type) {
		if (date == null || type == null) {
			return "";
		}
		ThreadLocal<DateFormatter> threadLocal = dateLocalMap.get(type);
		if (threadLocal == null) {
			threadLocal = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat(type)));
			dateLocalMap.put(type, threadLocal);
		}
		return threadLocal.get().getFormat().format(date);
	}
	
	/**
	 * Date time parser
	 * @param source
	 * @return
	 */
	public static Date datetimeParser(String source) {
        return dateParser(source, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * Date parse
	 * @param source
	 * @return
	 */
	public static Date dateParser(String source,String type) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(type);
		dateFormat.setLenient(false);
		try {
			return dateFormat.parse(source);
		} catch (ParseException e) {
//			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 日期格式转换
	 * 
	 * @param date
	 * @return
	 */
	public static String datetimeFormatter(Date date) {
		return datetimeFormatter(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 *   获取当前用户的UUID
	 * @param bsUser2Service
	 * @return
	 */
	public static String getUserUuid(BsUser2Service bsUser2Service) {
		ResultModel<BsUser2> currentLoggedIn = bsUser2Service.currentLoggedIn();
		if(currentLoggedIn == null || currentLoggedIn.getCode().equals(CME.UNLOGIN.getCode())) {
			return null;
		} else {
			return currentLoggedIn.getModel().getUuid();
		}
	}

}
