package com.anquan.jy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日期格式化转换类
 * @author zhaotj
 *
 */
public class TimeFormatUtil {
	
	public static String getTime(String time) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdf.parse(time);
		return sdf.format(date);
	}
	
	/**
	 * 输入日期对象返回yyyy-MM-dd HH:mm:ss 格式化字符串时间
	 * @param date
	 * @return String
	 */
	public static String getTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	/**
	 * 获取当前时间 字符串格式yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getcurrentTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
	/**
	 * 格式化输入日期，返回yyyy-MM-dd格式字符串日期
	 * @param date
	 * @return
	 */
	public static String getDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	/**
	 * 传入日期
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static String getDate(String time) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=sdf.parse(time);
		return sdf.format(date);
	}
	/**
	 * 获取当前日期字符串格式为：yyyy-MM-dd
	 * @return
	 */
	public static String getcurrentDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
}
