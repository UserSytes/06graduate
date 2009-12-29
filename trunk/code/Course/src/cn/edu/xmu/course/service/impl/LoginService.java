package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.AdministratorDAO;
import cn.edu.xmu.course.dao.StudentDAO;
import cn.edu.xmu.course.dao.SuperAdminDAO;
import cn.edu.xmu.course.dao.TeacherDAO;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.ILoginService;

/**
 * �����½
 * @author ������
 * @author ֣����
 *
 */
public class LoginService implements ILoginService {

	private TeacherDAO teacherDAO;
	private StudentDAO studentDAO;
	private AdministratorDAO administratorDAO;
	private SuperAdminDAO superAdminDAO;

	public Teacher teacherLogin(String account, String password) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = teacherDAO.findByTeacherNo(account);
		if (0 == teachers.size())
			return null;
		Teacher t = teachers.get(0);
		if (password.equals(t.getPassword()))
			return t;
		else
			return null;
	}

	public Administrator adminLogin(String account, String password) {
		// TODO Auto-generated method stub
		List<Administrator> admins = administratorDAO.findByAccount(account);
		if (0 == admins.size())
			return null;
		Administrator a = admins.get(0);
		if (password.equals(a.getPassword()))
			return a;
		else
			return null;
	}
	
	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public AdministratorDAO getAdministratorDAO() {
		return administratorDAO;
	}

	public void setAdministratorDAO(AdministratorDAO administratorDAO) {
		this.administratorDAO = administratorDAO;
	}

	public SuperAdminDAO getSuperAdminDAO() {
		return superAdminDAO;
	}

	public void setSuperAdminDAO(SuperAdminDAO superAdminDAO) {
		this.superAdminDAO = superAdminDAO;
	}

	public Student studentLogin(String userName, String password) {
		// TODO Auto-generated method stub
		List<Student> students = studentDAO.findByStudentNo(userName);
		if (0 == students.size())
			return null;
		Student st = students.get(0);
		if (password.equals(st.getPassword()))
			return st;
		else
			return null;
	}

	public SuperAdmin superAdminLogin(String account, String password) {
		// TODO Auto-generated method stub
		List<SuperAdmin> superAdmins = superAdminDAO.findByAccount(account);
		if (0 == superAdmins.size())
			return null;
		SuperAdmin a = superAdmins.get(0);
		if (password.equals(a.getPassword()))
			return a;
		else
			return null;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

}
