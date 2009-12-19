package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * 课程参考书
 * @author Administrator
 *
 */
public interface ICourseBookService {

	/**
	 * 查找所有课程参考书
	 * @param teacherCourse
	 * @return
	 */
	public List getAllbooks(TeacherCourse teacherCourse);
	
	/**
	 * 查找课程参考书
	 * @param id
	 * @return
	 */
	public Book getbookById(Integer id);
	
	/**
	 * 添加课程参考书
	 * @param book
	 * @param teacherCourse
	 * @return
	 */
	public boolean addbook(Book book, TeacherCourse teacherCourse);
	
	/**
	 * 更新课程参考书
	 * @param book
	 * @return
	 */
	public boolean updatebook(Book book);
	
	/**
	 * 删除课程参考书
	 * @param book
	 * @return
	 */
	public boolean deletebook(Book CourseBook);
}
