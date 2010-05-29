package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.TeacherTeamDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.TeacherTeam;
import cn.edu.xmu.course.service.ITeacherTeamService;

/**
 * 教师队伍
 * 
 * @author 何申密
 * @author 许子彦
 * 
 */
public class TeacherTeamService implements ITeacherTeamService {
	private TeacherTeamDAO teacherTeamDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherTeamService#addTeacherTeam(cn.edu.xmu
	 * .course.pojo.TeacherTeam, cn.edu.xmu.course.pojo.Course)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.ITeacherTeamService#getTeacherTeam(int)
	 */
	public TeacherTeam getTeacherTeam(int teacherTeamId) {
		// TODO Auto-generated method stub
		return teacherTeamDAO.findById(teacherTeamId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherTeamService#deleteTeacherTeam(cn.edu
	 * .xmu.course.pojo.TeacherTeam)
	 */
	public boolean deleteTeacherTeam(TeacherTeam teacherTeam) {
		// TODO Auto-generated method stub
		try {
			teacherTeamDAO.delete(teacherTeam);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherTeamService#getTeacherTeamList(int)
	 */
	public List<TeacherTeam> getTeacherTeamList(int courseId) {
		return teacherTeamDAO.findByCourse(courseId);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITeacherTeamService#updateTeacherTeam(cn.edu
	 * .xmu.course.pojo.TeacherTeam)
	 */
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
