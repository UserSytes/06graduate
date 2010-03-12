package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import cn.edu.xmu.course.dao.StudentDAO;
import cn.edu.xmu.course.dao.UserInfoDAO;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IStudentInfoService;

public class StudentInfoService implements IStudentInfoService {

	private StudentDAO studentDAO;
	private UserInfoDAO userInfoDAO;

	public boolean addStudent(Student student, UserInfo userInfo) {
		// TODO Auto-generated method stub
		try {
			studentDAO.save(student);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean batchAddStudents(List<Student> studentList,
			List<UserInfo> userInfoList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			userInfoDAO.delete(student.getUserInfo());
			studentDAO.delete(student);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Student> findByGrade(Grade grade) {
		// TODO Auto-generated method stub
		return studentDAO.findByProperty("grade", grade);
	}

	public Student findById(int id) {
		// TODO Auto-generated method stub
		return studentDAO.findById(id);
	}

	public List findBySchool(School school) {
		// TODO Auto-generated method stub
		return studentDAO.findBySchool(school);
	}

	public Student findByStudentNo(String studentNo) {
		// TODO Auto-generated method stub
		List<Student> students = studentDAO.findByStudentNo(studentNo);
		if (students.size() == 0) {
			return null;
		} else {
			return students.get(0);
		}
	}
	
	public boolean updatePassword(Student student){
		try {
			studentDAO.merge(student);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean updateStudent(Student student, UserInfo userInfo) {
		// TODO Auto-generated method stub
		try {
			userInfoDAO.merge(userInfo);
			studentDAO.merge(student);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Student> findByDepartment(Department department) {
		return studentDAO.findByDepartment(department);
	}

	public List<Student> findByDepartmentAndGrade(Department department,
			Grade grade) {
		return studentDAO.findByDepartmentAndGrade(department, grade);
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	public UserInfo findUserInfoByStudentNo(String studentNo) {
		// TODO Auto-generated method stub
		List<Student> students = studentDAO.findByStudentNo(studentNo);
		if (students.size() == 0) {
			return null;
		} else {
			return students.get(0).getUserInfo();
		}
	}

	public String addMoreStudent(Student student, Grade grade,
			Department department, File file) {
		// TODO Auto-generated method stub
		Workbook book = null;
		try {
			book = Workbook.getWorkbook(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "批量添加学生失败，无法添加学生，请重新操作！";
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
				if (studentDAO.findByStudentNo(stuNo).size() != 0) {
					return "学号为" + stuNo + "的学生已经存在，请重新操作！";
				}
			} else {
				return "批量添加学生失败，请检查学生学号类型是否正确！";
			}
		}
		for (int j = 1; j < rows; j++) {
			Cell cellStuNo = sh.getCell(0, j);
			String content = cellStuNo.getContents();
			String stuNo = content.substring(0, content.length() - 1);
			Student stu = new Student();
			stu.setGrade(grade);
			stu.setStudentNo(stuNo);
			stu.setPassword(stuNo);
			UserInfo userInfo = new UserInfo();
			userInfo.setDepartment(department);
			userInfo.setName(sh.getCell(1, j).getContents());
			stu.setUserInfo(userInfo);
			studentDAO.save(stu);
		}
		return "批量添加学生成功，总计添加" + --rows + "个学生！";
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

}
