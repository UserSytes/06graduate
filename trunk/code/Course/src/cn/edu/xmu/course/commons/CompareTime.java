package cn.edu.xmu.course.commons;

import java.util.Comparator;

import cn.edu.xmu.course.pojo.Message;
/**
 * 该辅助类用于排序留言的时间
 * @author Rossi
 *
 */
public class CompareTime implements Comparator <Object>{
	/**
	 * 反向排序，留言时间较新的在前
	 */
	public int compare(Object arg0, Object arg1) {
		Message m1=(Message)arg0;
		Message m2=(Message)arg1;
		int flag=m2.getTime().compareTo(m1.getTime());   
		return flag; 
	}
	
}
