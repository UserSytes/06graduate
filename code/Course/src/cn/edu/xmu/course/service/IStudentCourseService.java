package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;

/**
 * 负责 学生课程关系的业务 的接口
 * @author 郑冰凌
 *
 */
public interface IStudentCourseService {

	/**
	 * 通过课程查找学生课程表
	 * @param course
	 * @return
	 */
	public List<StudentCourse> findByCourse(Course course);
	
	/**
	 * 根据id查找学生
	 * @param id
	 * @return
	 */
	public Student findStudentById(int id);
	
	/**
	 * 根据课程、学生删除 StudentCourse
	 * @param course
	 * @param student
	 * @return
	 */
	public boolean delete(Course course, Student student);
	
	/**
	 * 添加学生课程关系
	 * @param studentCourse
	 * @return
	 */
	public boolean addStudentCourse(StudentCourse studentCourse);
}
