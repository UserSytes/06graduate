package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.commons.MD5;
import cn.edu.xmu.course.dao.AdministratorDAO;
import cn.edu.xmu.course.dao.EvaluationDAO;
import cn.edu.xmu.course.dao.StudentDAO;
import cn.edu.xmu.course.dao.SuperAdminDAO;
import cn.edu.xmu.course.dao.TeacherDAO;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.ILoginService;

/**
 * 负责登陆的类
 * @author 何申密
 * @author 郑冰凌
 *
 */
public class LoginService implements ILoginService {

	private TeacherDAO teacherDAO;
	private StudentDAO studentDAO;
	private AdministratorDAO administratorDAO;
	private SuperAdminDAO superAdminDAO;
	private EvaluationDAO evaluationDAO;
	private MD5 md5 = new MD5();
	
	/*
	 * 教师登录(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ILoginService#teacherLogin(java.lang.String, java.lang.String)
	 */
	public Teacher teacherLogin(String account, String password) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = teacherDAO.findByTeacherNo(account);
		if (0 == teachers.size())
			return null;
		Teacher t = teachers.get(0);
		if (t.getPassword().equals(md5.getMD5ofStr(password)))
			return t;
		else
			return null;
	}

	/*
	 * 管理员登录(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ILoginService#adminLogin(java.lang.String, java.lang.String)
	 */
	public Administrator adminLogin(String account, String password) {
		// TODO Auto-generated method stub
		List<Administrator> admins = administratorDAO.findByAccount(account);
		if (0 == admins.size())
			return null;
		Administrator a = admins.get(0);		
		if (md5.getMD5ofStr(password).equals(a.getPassword()))
			return a;
		else
			return null;
	}
	
	/*
	 * 学生登录(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ILoginService#studentLogin(java.lang.String, java.lang.String)
	 */
	public Student studentLogin(String userName, String password) {
		// TODO Auto-generated method stub
		List<Student> students = studentDAO.findByStudentNo(userName);
		if (0 == students.size())
			return null;
		Student st = students.get(0);
		if (md5.getMD5ofStr(password).equals(st.getPassword()))
			return st;
		else
			return null;
	}

	/*
	 * 校方管理员登录(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ILoginService#superAdminLogin(java.lang.String, java.lang.String)
	 */
	public SuperAdmin superAdminLogin(String account, String password) {
		// TODO Auto-generated method stub
		SuperAdmin a = superAdminDAO.findByAccount(account);
		if (a == null)
			return null;
		if (md5.getMD5ofStr(password).equals(a.getPassword()))
			return a;
		else
			return null;
	}

	/*
	 * 专家登录(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ILoginService#expertLogin(java.lang.String, java.lang.String, int)
	 */
	public Evaluation expertLogin(String username, String password,int flag) {
		// TODO Auto-generated method stub
		List<Evaluation> evaluations = evaluationDAO.findByUsername(username);
		if (0 == evaluations.size())
			return null;
		Evaluation a = evaluations.get(0);
		if (md5.getMD5ofStr(password).equals(a.getPassword())&&a.getSort()==flag)
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

	public EvaluationDAO getEvaluationDAO() {
		return evaluationDAO;
	}

	public void setEvaluationDAO(EvaluationDAO evaluationDAO) {
		this.evaluationDAO = evaluationDAO;
	}

	public void setMd5(MD5 md5) {
		this.md5 = md5;
	}

	public MD5 getMd5() {
		return md5;
	}

	
}
