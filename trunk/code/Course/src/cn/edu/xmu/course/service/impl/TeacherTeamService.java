package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.TeacherTeamDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.TeacherTeam;
import cn.edu.xmu.course.service.ITeacherTeamService;

public class TeacherTeamService implements ITeacherTeamService {
	private TeacherTeamDAO teacherTeamDAO;
	public boolean addTeacher(TeacherTeam teacherTeam, Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteTeacher(TeacherTeam teacherTeam) {
		// TODO Auto-generated method stub
		return false;
	}

	public List getTeacherTeam(int courseId) {
		return teacherTeamDAO.findByCourse(courseId);
		
	}

	public boolean updateTeacher(TeacherTeam teacherTeam) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setTeacherTeamDAO(TeacherTeamDAO teacherTeamDAO) {
		this.teacherTeamDAO = teacherTeamDAO;
	}

	public TeacherTeamDAO getTeacherTeamDAO() {
		return teacherTeamDAO;
	}

}
