package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import cn.edu.xmu.course.dao.CollectionDAO;
import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.dao.StudentCourseDAO;
import cn.edu.xmu.course.dao.StudentDAO;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Collection;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IStudentCourseService;

/**
 * 此类负责管理学生课程关系
 * 
 * @author 郑冰凌
 * 
 */
public class StudentCourseService implements IStudentCourseService {

	private StudentCourseDAO studentCourseDAO;
	private CollectionDAO collectionDAO;
	private StudentDAO studentDAO;

	/*
	 * 验证课程中是否存在指定学生(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IStudentCourseService#checkStudent(cn.edu.xmu
	 * .course.pojo.Course, cn.edu.xmu.course.pojo.Student)
	 */
	public boolean checkStudent(Course course, Student student) {
		List<StudentCourse> studentCourses = studentCourseDAO
				.findByStudentAndCourse(course, student);
		if (studentCourses.size() == 0) {
			return true;// 该学生未加入该课程，可执行加入
		} else
			return false;// 该生已经加入该课程
	}

	public Collection findCollectionByStu(Student student, Course course) {
		// TODO Auto-generated method stub
		List<Collection> c = collectionDAO.findByStudentAndCourse(course,
				student);
		if (c.size() != 0) return c.get(0);
		else 
			return null;
	}
	/*
	 * 学生添加收藏课程 (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IStudentCourseService#addCollection(cn.edu.
	 * xmu.course.pojo.Student, cn.edu.xmu.course.pojo.Course)
	 */
	public boolean addCollection(Student student, Course course) {
		// TODO Auto-generated method stub
		Collection col = new Collection();
		col.setCourse(course);
		col.setStudent(student);
		try {
			collectionDAO.save(col);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 删除学生收藏的课程(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IStudentCourseService#deleteCollection(cn.edu
	 * .xmu.course.pojo.Student, cn.edu.xmu.course.pojo.Course)
	 */
	public boolean deleteCollection(Student student, Course course) {
		List<Collection> c = collectionDAO.findByStudentAndCourse(course,
				student);
		if (c.size() != 0) {
			collectionDAO.delete(c.get(0));
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 查找某学生的收藏课程(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IStudentCourseService#findCollectionByStudent
	 * (cn.edu.xmu.course.pojo.Student)
	 */
	public List<Collection> findCollectionByStudent(Student student) {
		return collectionDAO.findByProperty("student", student);
	}

	/*
	 * 根据课程查找学生(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IStudentCourseService#findByCourse(cn.edu.xmu
	 * .course.pojo.Course)
	 */
	public List<StudentCourse> findByCourse(Course course) {
		// TODO Auto-generated method stub
		return studentCourseDAO.findByProperty("course", course);
	}

	/*
	 * 根据id查找学生(non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.IStudentCourseService#findStudentById(int)
	 */
	public Student findStudentById(int id) {
		return studentDAO.findById(id);
	}

	/*
	 * 根据学号查找学生(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IStudentCourseService#findStudentByStudentNo
	 * (java.lang.String)
	 */
	public Student findStudentByStudentNo(String studentNo) {
		return (Student) studentDAO.findByStudentNo(studentNo).get(0);
	}

	/*
	 * 删除某课程的某个学生(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IStudentCourseService#delete(cn.edu.xmu.course
	 * .pojo.Course, cn.edu.xmu.course.pojo.Student)
	 */
	public boolean delete(Course course, Student student) {
		StudentCourse sc = (StudentCourse) studentCourseDAO
				.findByStudentAndCourse(course, student).get(0);
		if (sc != null) {
			try {
				studentCourseDAO.delete(sc);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/*
	 * 批量删除课程中的学生(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IStudentCourseService#deleteMoreSudentCourse
	 * (cn.edu.xmu.course.pojo.Course, java.lang.String, java.lang.String)
	 */
	public boolean deleteMoreSudentCourse(Course course, String departmentId,
			String gradeId) {
		List<StudentCourse> scList = studentCourseDAO
				.fingByCourseAndDepartmentAndGrade(course, departmentId,
						gradeId);
		if (scList.size() == 0) {
			return true;
		}
		for (StudentCourse sc : scList) {
			try {
				studentCourseDAO.delete(sc);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	/*
	 * 添加学生到课程中(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IStudentCourseService#addStudentCourse(cn.edu
	 * .xmu.course.pojo.StudentCourse)
	 */
	public boolean addStudentCourse(StudentCourse studentCourse) {
		try {
			studentCourseDAO.save(studentCourse);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 批量添加学生到课程中(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IStudentCourseService#addMoreStudentCourse(
	 * cn.edu.xmu.course.pojo.Course, java.io.File)
	 */
	public String addMoreStudentCourse(Course course, File file) {
		Workbook book = null;
		List<Student> students;
		try {
			book = Workbook.getWorkbook(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "批量添加学生到失败，无法添加学生，请重新操作！";
		}
		int rows = 0;
		Sheet sh = null;
		sh = book.getSheet(0);
		rows = sh.getRows();
		for (int j = 1; j < rows; j++) {
			Cell cellStuNo = sh.getCell(0, j);
			String content = cellStuNo.getContents();
			String stuNo = content.substring(0, content.length() - 1);
			if (isNumeric(stuNo)) {
				students = studentDAO.findByStudentNo(stuNo);
				if (students.size() == 0) {
					return "学号为" + stuNo + "的学生不存在，请重新操作！";
				}
				if (!this.checkStudent(course, students.get(0))) {
					return "学号为" + stuNo + "的学生已经加入该课程，请重新操作！";
				}
			} else {
				return "批量添加学生失败，请检查学生学号类型是否正确！";
			}
		}
		for (int j = 1; j < rows; j++) {
			Cell cellStuNo = sh.getCell(0, j);
			String content = cellStuNo.getContents();
			String stuNo = content.substring(0, content.length() - 1);
			students = studentDAO.findByStudentNo(stuNo);
			if (students.size() == 0) {
				return "学号为" + stuNo + "的学生不存在，请重新操作！";
			}
			// Student stu = new Student();
			StudentCourse sc = new StudentCourse();
			sc.setCourse(course);
			sc.setStudent(students.get(0));
			sc.setStatus(0);
			studentCourseDAO.save(sc);
		}
		return "批量添加学生到课程成功，总计添加" + --rows + "个学生！";
	}

	/**
	 * 判断字符是否为数字类型
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 更新学生课程信息
	 * @param studentCourse
	 * @return
	 */
	public boolean updateStudentCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		try {
			studentCourseDAO.merge(studentCourse);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 根据学生查找课程(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IStudentCourseService#findByStudent(cn.edu.
	 * xmu.course.pojo.Student)
	 */
	public List<StudentCourse> findByStudent(Student student) {
		return studentCourseDAO.findByProperty("student", student);
	}
	
	public List<StudentCourse> findByStudentAndCourse(Course course,
			Student student) {
		return getStudentCourseDAO().findByStudentAndCourse(course,
				student);
	}

	public StudentCourseDAO getStudentCourseDAO() {
		return studentCourseDAO;
	}

	public void setStudentCourseDAO(StudentCourseDAO studentCourseDAO) {
		this.studentCourseDAO = studentCourseDAO;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public CollectionDAO getCollectionDAO() {
		return collectionDAO;
	}

	public void setCollectionDAO(CollectionDAO collectionDAO) {
		this.collectionDAO = collectionDAO;
	}

}
