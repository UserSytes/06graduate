package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.TeacherTeamDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.TeacherTeam;
import cn.edu.xmu.course.service.ITeacherTeamService;

public class TeacherTeamService implements ITeacherTeamService {
	private TeacherTeamDAO teacherTeamDAO;

	public boolean addTeacherTeam(TeacherTeam teacherTeam, Course course) {
		// TODO Auto-generated method stub
		teacherTeam.setCourse(course);
		try {
			teacherTeamDAO.save(teacherTeam);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public TeacherTeam getTeacherTeam(int teacherTeamId) {
		// TODO Auto-generated method stub
		return teacherTeamDAO.findById(teacherTeamId);
	}

	public boolean deleteTeacherTeam(TeacherTeam teacherTeam) {
		// TODO Auto-generated method stub
		try {
			teacherTeamDAO.delete(teacherTeam);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List getTeacherTeamList(int courseId) {
		return teacherTeamDAO.findByCourse(courseId);

	}

	public boolean updateTeacherTeam(TeacherTeam teacherTeam) {
		// TODO Auto-generated method stub
		try {
			teacherTeamDAO.merge(teacherTeam);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setTeacherTeamDAO(TeacherTeamDAO teacherTeamDAO) {
		this.teacherTeamDAO = teacherTeamDAO;
	}

	public TeacherTeamDAO getTeacherTeamDAO() {
		return teacherTeamDAO;
	}

}
