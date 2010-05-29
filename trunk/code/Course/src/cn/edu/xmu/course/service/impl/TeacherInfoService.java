package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.commons.MD5;
import cn.edu.xmu.course.dao.TeacherDAO;
import cn.edu.xmu.course.dao.UserInfoDAO;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.ITeacherInfoService;

/**
 * ��ʦ��Ϣ����
 * 
 * @author ������
 * @author ֣����
 */
public class TeacherInfoService implements ITeacherInfoService {

	private TeacherDAO teacherDAO;
	private UserInfoDAO userInfoDAO;

	/*
	 * ���ݵ�¼�ʺŻ�ȡ��ʦ(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#getTeacher(java.lang.String
	 * )
	 */
	public Teacher getTeacher(String userName) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = teacherDAO.findByTeacherNo(userName);
		if (teachers.size() == 0)
			return null;
		else
			return teachers.get(0);
	}

	/*
	 * �޸�����(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#changePassword(cn.edu.xmu
	 * .course.pojo.Teacher)
	 */
	public boolean updatePassword(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			teacherDAO.merge(teacher);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ��ӽ�ʦ(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#addTeacher(cn.edu.xmu.course
	 * .pojo.Teacher)
	 */
	public boolean addTeacher(Teacher teacher, UserInfo userInfo) {
		// TODO Auto-generated method stub
		MD5 md5 = new MD5();
		teacher.setPassword(md5.getMD5ofStr(teacher.getPassword()));
		String photo = "photo/defaultPhoto.jpg";
		userInfo.setPhoto(photo);
		try {
			userInfoDAO.save(userInfo);
			teacherDAO.save(teacher);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ���½�ʦ(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#updateTeacher(cn.edu.xmu
	 * .course.pojo.Teacher, cn.edu.xmu.course.pojo.UserInfo)
	 */
	public boolean updateTeacher(Teacher teacher, UserInfo userInfo) {
		// TODO Auto-generated method stub
		try {
			teacher.setUserInfo(userInfo);
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

	/*
	 * ɾ����ʦ��Ϣ(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#deleteTeacher(cn.edu.xmu
	 * .course.pojo.Teacher)
	 */
	public boolean deleteTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + teacher.getTeacherNo()
				+ teacher.getUserInfo().getName();
		try {
			if (!FileOperation.delFolder(fileName))
				return false;
			userInfoDAO.delete(teacher.getUserInfo());
			teacherDAO.delete(teacher);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ����id���ҽ�ʦ(non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.ITeacherInfoService#findTeacherById(int)
	 */
	public Teacher findTeacherById(int id) {
		// TODO Auto-generated method stub
		return teacherDAO.findById(id);
	}

	/*
	 * ����ѧԺ���ҽ�ʦ(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#findTeachersBySchool(cn
	 * .edu.xmu.course.pojo.School)
	 */
	public List<Teacher> findTeachersBySchool(School school) {
		return teacherDAO.findBySchool(school);

	}

	/*
	 * ���ݽ�ʦ�ʺŲ��ҽ�ʦ(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#findTeacherByTeacherNo(
	 * java.lang.String)
	 */
	public Teacher findTeacherByTeacherNo(String teacherNo) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = teacherDAO.findByTeacherNo(teacherNo);
		if (teachers.size() == 0) {
			return null;
		} else {
			return teachers.get(0);
		}
	}

	/*
	 * �����û���Ϣ���ҽ�ʦ(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#findTeacherByUserInfo(cn
	 * .edu.xmu.course.pojo.UserInfo)
	 */
	public Teacher findTeacherByUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = teacherDAO.findByUserInfo(userInfo);
		if (teachers.size() == 0) {
			return null;
		} else {
			return teachers.get(0);
		}
	}

	/*
	 * �޸�ͷ��(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#addTeacherPhoto(cn.edu.
	 * xmu.course.pojo.UserInfo, java.io.File, java.lang.String)
	 */
	public boolean addTeacherPhoto(UserInfo userInfo, File photo,
			String fileLink) {
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
			if (FileOperation.copy(photo, file)) {
				userInfoDAO.merge(userInfo);
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ����ѧԺ���ҽ�ʦ������Ϣ(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherInfoService#getTeaNameAndNumber(cn.
	 * edu.xmu.course.pojo.School)
	 */
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
