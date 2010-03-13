package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Collection;
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
	 * 通过学号查找学生
	 * @param studentNo
	 * @return
	 */
	public Student findStudentByStudentNo(String studentNo);
	
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
	
	/**
	 * 批量添加学生课程关系
	 * @param course
	 * @param studentFile
	 * @return
	 */
	public String addMoreStudentCourse(Course course, File studentFile);
	
	/**
	 * 根据学生查找课程
	 * @param student
	 * @return
	 */
	public List<StudentCourse> findByStudent(Student student);
	
	/**
	 * 根据学生查找收藏课程
	 * @param student
	 * @return
	 */
	public List<Collection> findCollectionByStudent(Student student);
	
	/**
	 * 删除某门课程收藏
	 * @param student
	 * @param course
	 * @return
	 */
	public boolean deleteCollection(Student student, Course course);
	
	/**
	 * 查找某学生帐号是否可以加入某课程
	 * @param course
	 * @param studentNo
	 * @return
	 */
	public boolean checkStudent(Course course, Student student);
}
