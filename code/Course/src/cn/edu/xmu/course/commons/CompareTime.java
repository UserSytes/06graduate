package cn.edu.xmu.course.commons;

import java.util.Comparator;

import cn.edu.xmu.course.pojo.Message;
/**
 * �ø����������������Ե�ʱ��
 * @author Rossi
 *
 */
public class CompareTime implements Comparator <Object>{
	/**
	 * ������������ʱ����µ���ǰ
	 */
	public int compare(Object arg0, Object arg1) {
		Message m1=(Message)arg0;
		Message m2=(Message)arg1;
		int flag=m2.getTime().compareTo(m1.getTime());   
		return flag; 
	}
	
}
