package cn.edu.xmu.course.commons;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 该类实现有关日期的加减及变换运算
 * 
 * @author 郑冰凌
 * @author 尹琳
 * @version Version 2.00
 */
public class CalculateDate {

	Calendar calendar;
	static SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");

	private static CalculateDate instance = new CalculateDate();
	
	private CalculateDate() {

	}

	/**
	 * 获取在某日期上加上days天数后的日期
	 * 
	 * @param now
	 *            日期
	 * @param days
	 *            要加的天数
	 * @return Calendar 相加后的日期
	 */
	public static Calendar addDate(Calendar now, int days) {
		Calendar calendar = Calendar.getInstance();
		int day = now.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day + days); // 当前时间加days天
		return calendar;// 返回days天后的日期
	}

	public static Calendar addMonth(Calendar now, int months) {
		now.add(Calendar.MONTH, months); // 当前时间加days天
		return now;// 返回days天后的日期
	}

	/**
	 * 日期相减
	 * 
	 * @param dateStart
	 *            日期1
	 * @param dateEnd
	 *            日期2
	 * @return 日期相减后的天数
	 */
	public int minusDate(Calendar dateStart, Calendar dateEnd) {
		int days = 0;

		Date d1 = dateStart.getTime();
		Date d2 = dateEnd.getTime();
		long diff = Math.abs(d2.getTime() - d1.getTime());
		days = (int) (diff / (1000 * 60 * 60 * 24));
		return days;
	}

	/**
	 * Date类型转换成String类型
	 * 
	 * @param date
	 *            要转换的date型日期
	 * @return 一个String类型的时间
	 */
	public static String dateToString(Calendar date) {
		return form.format(date.getTime());
	}

	/**
	 * String类型的时间转换成Calendar类型
	 * 
	 * @param d
	 *            要转换的String类型的日期
	 * @return 一个Calendar类型的日期
	 */
	public static Calendar getCalendar(String d) {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(d.substring(0, 4)), Integer.parseInt(d
				.substring(4, 6)) - 1, Integer.parseInt(d.substring(6, 8)));
		return c;
	}

	/**
	 * 将日期转化成 oracle 的 to_date('xxx','xxx') 格式 *
	 * 
	 * @param d
	 *            日期
	 * @param format
	 *            日期格式，例如 "yyyy-MM-dd HH:mm"
	 * @param hqlFormat
	 *            oracle的日期格式，例如："yyyy-mm-dd hh24:mi"
	 * @return
	 */
	public static String toDate(Date d) {
		StringBuffer bf = new StringBuffer();
		bf.append("'");
		bf.append(dateFormat(d, "yyyy-MM-dd HH:mm"));
		bf.append("'");
		return bf.toString();
	}

	/**
	 * 将日期转化成指定格式的字符串
	 * 
	 * @param d
	 *            日期
	 * @param formatStr
	 *            字符串格式
	 * @return
	 */
	private static String dateFormat(Date d, String formatStr) {
		return (new java.text.SimpleDateFormat(formatStr).format(d));
	}

	public static CalculateDate getInstance() {
		return instance;
	}
}
