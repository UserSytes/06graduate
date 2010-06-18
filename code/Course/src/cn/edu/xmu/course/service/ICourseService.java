package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Popedom;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Teacher;
/**
 * 负责管理课程的接口
 * @author 郑冰凌
 * @author 何申密
 *
 */
public interface ICourseService {

	/**
	 * 添加新的课程
	 * @param course
	 * @param department
	 * @return
	 */
	public boolean addCourse(Course course, Department department,Teacher teacher);
	
	/**
	 * 根据课程Id查找课程
	 * @param courseId
	 * @return
	 */
	public Course getCourseById(Integer courseId);
	
	/**
	 * 根据教师查找课程
	 * @param teacherId
	 * @return
	 */
	public List<Course> findCoursesByTeacher(Integer teacherId,int type);
	
	/**
	 * 删除课程
	 * @param course
	 * @return
	 */
	public boolean deleteCourse(Course course);

	/**
	 * 根据级别查找课程
	 * @param time
	 * @return
	 */
	public List<Course> findCourseListLevel(String level);

	/**
	 * 根据级别查找课程
	 * @param time
	 * @return
	 */
	public List<Course> findCourseListByLevel(String level);
	/**
	 * 更新课程
	 * @param course
	 * @return
	 */
	public boolean updateCourse(Course course);
	
	/**
	 * 查找学院审核未通过的课程
	 * @param school
	 * @return
	 */
	public List<Course> findNoPassCourse(School school);
	
	/**
	 * 查找学院等待审核的课程
	 * @param school
	 * @return
	 */
	public List<Course> findApplicationCourse(School school);
	
	/**
	 * 查找本院已通过审核的课程
	 * @param school
	 * @return
	 */
	public List<Course> findBySchool(School school);
	
	/**
	 * 更新课程部分内容权限
	 * @param popedom
	 * @return
	 */
	public boolean updatePopedom(Popedom popedom);
	

}
