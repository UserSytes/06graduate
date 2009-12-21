package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.TeacherDAO;
import cn.edu.xmu.course.dao.UserInfoDAO;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.ITeacherInfoService;

public class TeacherInfoService implements ITeacherInfoService {

	private TeacherDAO teacherDAO;
	private UserInfoDAO userInfoDAO;

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.ITeacherInfoService#getTeacher(java.lang.String)
	 */
	public Teacher getTeacher(String userName) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = teacherDAO.findByTeacherNo(userName);
		System.out.println("the old password is"
				+ teachers.get(0).getPassword());
		if (teachers.size() == 0)
			return null;
		else
			return teachers.get(0);
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.ITeacherInfoService#changePassword(cn.edu.xmu.course.pojo.Teacher)
	 */
	public boolean changePassword(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			Teacher t = teacherDAO.merge(teacher);
			if (t == null)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.ITeacherInfoService#addTeacher(cn.edu.xmu.course.pojo.Teacher)
	 */
	public boolean addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDAO.save(teacher);
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.ITeacherInfoService#updateTeacher(cn.edu.xmu.course.pojo.Teacher, cn.edu.xmu.course.pojo.UserInfo)
	 */
	public boolean updateTeacher(Teacher teacher, UserInfo userInfo) {
		// TODO Auto-generated method stub
		try {
			Teacher t = teacherDAO.merge(teacher);
			UserInfo u = userInfoDAO.merge(userInfo);
			if (t == null || u ==null)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

}
