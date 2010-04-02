package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.TeacherDAO;
import cn.edu.xmu.course.dao.UserInfoDAO;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.ITeacherInfoService;

public class TeacherInfoService implements ITeacherInfoService {

	private TeacherDAO teacherDAO;
	private UserInfoDAO userInfoDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#getTeacher(java.lang.String
	 * )
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
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#changePassword(cn.edu.xmu
	 * .course.pojo.Teacher)
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
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#addTeacher(cn.edu.xmu.course
	 * .pojo.Teacher)
	 */
	public boolean addTeacher(Teacher teacher, UserInfo userInfo) {
		// TODO Auto-generated method stub
		try {
			userInfoDAO.save(userInfo);
			teacherDAO.save(teacher);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#updateTeacher(cn.edu.xmu
	 * .course.pojo.Teacher, cn.edu.xmu.course.pojo.UserInfo)
	 */
	public boolean updateTeacher(Teacher teacher, UserInfo userInfo) {
		// TODO Auto-generated method stub
		try {
			UserInfo u = userInfoDAO.merge(userInfo);
			Teacher t = teacherDAO.merge(teacher);
			if (t == null || u == null)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			userInfoDAO.delete(teacher.getUserInfo());
			teacherDAO.delete(teacher);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Teacher findTeacherById(int id) {
		// TODO Auto-generated method stub
		return teacherDAO.findById(id);
	}

	public List findTeachersBySchool(School school) {
		return teacherDAO.findBySchool(school);

	}

	public Teacher findTeacherByTeacherNo(String teacherNo) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = teacherDAO.findByTeacherNo(teacherNo);
		if (teachers.size() == 0) {
			return null;
		} else {
			return teachers.get(0);
		}
	}

	public Teacher findTeacherByUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = teacherDAO.findByUserInfo(userInfo);
		if (teachers.size() == 0) {
			return null;
		} else {
			return teachers.get(0);
		}
	}

	public boolean addTeacherPhoto(UserInfo userInfo, File photo, String fileLink) {
		// TODO Auto-generated method stub
		String oldPhoto = userInfo.getPhoto();
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");		
		String fileName = path + "/" + fileLink;
		File file = new File(fileName);
		userInfo.setPhoto(fileLink);		
		try {
			
			if (!oldPhoto.equals("photo/defaultPhoto.jpg"))
				FileOperation.delete(new File(path + "/" + oldPhoto));
			if (FileOperation.copy(photo, file)){	
				userInfoDAO.merge(userInfo);
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public List getTeaNameAndNumber(School school) {
		// TODO Auto-generated method stub
		return teacherDAO.findTeaNameAndNumberBySchool(school);
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
