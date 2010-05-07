package cn.edu.xmu.course.commons;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ����ʵ���й����ڵļӼ����任����
 * 
 * @author ֣����
 * @author ����
 * @version Version 2.00
 */
public class CalculateDate {

	Calendar calendar;
	static SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");

	private static CalculateDate instance = new CalculateDate();
	
	private CalculateDate() {

	}

	/**
	 * ��ȡ��ĳ�����ϼ���days�����������
	 * 
	 * @param now
	 *            ����
	 * @param days
	 *            Ҫ�ӵ�����
	 * @return Calendar ��Ӻ������
	 */
	public static Calendar addDate(Calendar now, int days) {
		Calendar calendar = Calendar.getInstance();
		int day = now.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day + days); // ��ǰʱ���days��
		return calendar;// ����days��������
	}

	public static Calendar addMonth(Calendar now, int months) {
		now.add(Calendar.MONTH, months); // ��ǰʱ���days��
		return now;// ����days��������
	}

	/**
	 * �������
	 * 
	 * @param dateStart
	 *            ����1
	 * @param dateEnd
	 *            ����2
	 * @return ��������������
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
	 * Date����ת����String����
	 * 
	 * @param date
	 *            Ҫת����date������
	 * @return һ��String���͵�ʱ��
	 */
	public static String dateToString(Calendar date) {
		return form.format(date.getTime());
	}

	/**
	 * String���͵�ʱ��ת����Calendar����
	 * 
	 * @param d
	 *            Ҫת����String���͵�����
	 * @return һ��Calendar���͵�����
	 */
	public static Calendar getCalendar(String d) {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(d.substring(0, 4)), Integer.parseInt(d
				.substring(4, 6)) - 1, Integer.parseInt(d.substring(6, 8)));
		return c;
	}

	/**
	 * ������ת���� oracle �� to_date('xxx','xxx') ��ʽ *
	 * 
	 * @param d
	 *            ����
	 * @param format
	 *            ���ڸ�ʽ������ "yyyy-MM-dd HH:mm"
	 * @param hqlFormat
	 *            oracle�����ڸ�ʽ�����磺"yyyy-mm-dd hh24:mi"
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
	 * ������ת����ָ����ʽ���ַ���
	 * 
	 * @param d
	 *            ����
	 * @param formatStr
	 *            �ַ�����ʽ
	 * @return
	 */
	private static String dateFormat(Date d, String formatStr) {
		return (new java.text.SimpleDateFormat(formatStr).format(d));
	}

	public static CalculateDate getInstance() {
		return instance;
	}
}
