package com.wxc.mongodb.util;

import java.util.List;
import java.util.Map;

/**
 * 判断是否为空的工具类
 * @author Administrator
 *
 */
public class EmptyUtil {
	/**
	 * 私有构造
	 */
	private EmptyUtil() {
		
	}
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str==null||str==""||str.trim()==""||str.length()<=0;
	}
	/**
	 * 判断map是否为空
	 * @param list
	 * @return
	 */
	public static <T> boolean isEmpty(List<T> list) {
		return list==null||list.isEmpty();
	}
	/**
	 * 判断数组是否为空
	 * @param array
	 * @return
	 */
	public static <T> boolean isEmpty(T[] array) {
		return array==null||array.length==0;
	}
	/**
	 * 判断字符串是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	/**
	 * 判断List是否不为空
	 * @param list
	 * @return
	 */
	public static <T> boolean isNotEmpty(List<T> list) {
		return !isEmpty(list);
	}
	/**
	 * 判断Map是否不为空
	 * @param map
	 * @return
	 */
	public static <K,V> boolean isNotEmpty(Map<K,V> map) {
		return !isNotEmpty(map);
	}
	/**
	 * 判断数组是否不为空
	 * @param array
	 * @return
	 */
	public static <T> boolean isNotEmpty(T[] array) {
		return !isEmpty(array);
	}
	
}
