package com.novel.web.boss.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {
	 
	 /**
	  * 日期减几年
	  */
	 public static String dateMinusYear(String str) throws Exception {
	 
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	  Date dt = sdf.parse(str);
	  Calendar rightNow = Calendar.getInstance();
	  rightNow.setTime(dt);
	  rightNow.add(Calendar.YEAR, -1);// 日期减1年
	  Date dt1 = rightNow.getTime();
	  String reStr = sdf.format(dt1);
	  return reStr;
	 }
	 
	 /**
	  * 日期加几年
	  */
	 public static String dateAddYear(String str) throws Exception {
	 
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	  Date dt = sdf.parse(str);
	  Calendar rightNow = Calendar.getInstance();
	  rightNow.setTime(dt);
	  rightNow.add(Calendar.YEAR, 1);// 日期加1年
	  Date dt1 = rightNow.getTime();
	  String reStr = sdf.format(dt1);
	  return reStr;
	 }
	 
	 /**
	  * 日期减几月
	  */
	 public static String dateMinusMonth(String str) throws Exception {
	 
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	  Date dt = sdf.parse(str);//将字符串生成Date
	  Calendar rightNow = Calendar.getInstance();
	  rightNow.setTime(dt);//使用给定的 Date 设置此 Calendar 的时间。 
	  rightNow.add(Calendar.MONTH, -1);// 日期减1个月
	  Date dt1 = rightNow.getTime();//返回一个表示此 Calendar 时间值的 Date 对象。
	  String reStr = sdf.format(dt1);//将给定的 Date 格式化为日期/时间字符串，并将结果添加到给定的 StringBuffer。
	  return reStr;
	 }
	 
	 /**
	  * 日期加几月
	  */
	 public static String dateAddMonth(String str) throws Exception {
	 
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	  Date dt = sdf.parse(str);
	  Calendar rightNow = Calendar.getInstance();
	  rightNow.setTime(dt);
	  rightNow.add(Calendar.MONTH, 1);// 日期加3个月
	  // rightNow.add(Calendar.DAY_OF_YEAR,10);//日期加10天
	  Date dt1 = rightNow.getTime();
	  String reStr = sdf.format(dt1);
	  return reStr;
	 }
	 
	 
	 /**
	  * 日期加几天
	  */
	 public static Date dateAddDay(Date dt,int days) throws Exception {
	 
	  Calendar rightNow = Calendar.getInstance();
	  rightNow.setTime(dt);
	  rightNow.add(Calendar.DAY_OF_MONTH, days);// 日期加days天
	  Date dt1 = rightNow.getTime();
	  return dt1;
	 }
	 
	 /**
	  * 获取当前年月的第一个月的str
	  * @param str
	  *   201505
	  * @return 201501
	  * @throws Exception
	  */
	 public static String dateOneMonth(String str) {
	 
	  str = str.substring(0, str.length() - 2);
	  str = str + "01";
	  return str;
	 }
	 
	 /**
	  * 算出所选月份距离一月份有几个月。
	  * @param str 201509
	  * @return 9
	  */
	 public static int dateDistanceMonth(String str) {
	 
	  int i = Integer.parseInt(str);
	  int j = Integer.parseInt(DateFormat.dateOneMonth(str));
	  System.out.println(i - j);
	  return i - j + 1;
	 }
	 
	 /**
	  * 获取两个时间的时间差，精确到毫秒
	  * @param str
	  * @return
	  */
	 public static String TimeDifference(long start, long end) {
	 
	  long between = end - start;
	  long day = between / (24 * 60 * 60 * 1000);
	  long hour = (between / (60 * 60 * 1000) - day * 24);
	  long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
	  long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
	  long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
	    - min * 60 * 1000 - s * 1000);
	  String timeDifference = day + "天" + hour + "小时" + min + "分" + s + "秒" + ms
	    + "毫秒";
	  return timeDifference;
	 }
	}
