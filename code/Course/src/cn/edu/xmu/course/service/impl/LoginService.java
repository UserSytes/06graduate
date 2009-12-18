package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.TeacherDAO;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.ILoginService;

public class LoginService implements ILoginService {

	private TeacherDAO teacherDAO;

	public Teacher login(String account, String password) {
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

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

}