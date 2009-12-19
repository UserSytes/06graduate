package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * �γ̲ο���
 * @author Administrator
 *
 */
public interface ICourseBookService {

	/**
	 * �������пγ̲ο���
	 * @param teacherCourse
	 * @return
	 */
	public List getAllbooks(TeacherCourse teacherCourse);
	
	/**
	 * ���ҿγ̲ο���
	 * @param id
	 * @return
	 */
	public Book getbookById(Integer id);
	
	/**
	 * ��ӿγ̲ο���
	 * @param book
	 * @param teacherCourse
	 * @return
	 */
	public boolean addbook(Book book, TeacherCourse teacherCourse);
	
	/**
	 * ���¿γ̲ο���
	 * @param book
	 * @return
	 */
	public boolean updatebook(Book book);
	
	/**
	 * ɾ���γ̲ο���
	 * @param book
	 * @return
	 */
	public boolean deletebook(Book CourseBook);
}
