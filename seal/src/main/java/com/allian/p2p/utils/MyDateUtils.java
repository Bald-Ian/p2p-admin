package com.allian.p2p.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具处理类
 * 
 * @author yanglijun
 *
 */
public class MyDateUtils {

	public final static String FORMAT_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	
	public final static String FORMAT_YYYYMMDD_CN = "yyyy年MM月dd日";
	
	/**
	 * 获取当前日期的格式化信息
	 * 
	 * @return
	 */
	public static String getCurrentDateByFormat () {
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSSSSS);
		return format.format(new Date());
	}
	
	/**
	 * 获取当前日期的格式化信息
	 * 
	 * @return
	 */
	public static String getCurrentDateByFormatCN (Date date) {
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_YYYYMMDD_CN);
		return format.format(date);
	}
}
