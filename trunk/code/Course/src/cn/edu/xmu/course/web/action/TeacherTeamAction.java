package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.TeacherTeam;
import cn.edu.xmu.course.service.ITeacherTeamService;

public class TeacherTeamAction extends BaseAction{

	private List<TeacherTeam> teacherTeamList;
	private TeacherTeam teacherTeam;
	private Integer teacherTeamId;
	
	private ITeacherTeamService teacherTeamService;

	public String getTeacherTeamListByCourse(){
		Course course = super.getCourse();
		teacherTeamList = teacherTeamService.getTeacherTeamList(course.getId());
		return SUCCESS;
	}
	/**
	 * 查找师资队伍
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findTeacherTeam(){
		Course course = super.getCourse();
		teacherTeamList=teacherTeamService.getTeacherTeamList(course.getId());
		if (getTeacherTeamList() == null) {
			addActionError("教师队伍信息不存在！");
			return ERROR;
		} else
			return "teachers";
	}
	public String addTeacherTeam(){
		Course course=super.getCourse();
		if(teacherTeamService.addTeacherTeam(teacherTeam, course))
			return SUCCESS;
		else{
			addActionError("添加教师队伍失败,请重新操作！");
			return ERROR;
		}
	}
	
	public String goEidtTeacherTeam(){
		teacherTeam = teacherTeamService.getTeacherTeam(teacherTeamId);
		return SUCCESS;
	}
	
	public String updateTeacherTeam(){
		if(teacherTeamService.updateTeacherTeam(teacherTeam))
			return SUCCESS;
		else {
			addActionError("更新教师队伍失败，请重新操作！");
			return ERROR;
		}
	}
	
	public String deleteTeacherTeam(){
		teacherTeam = teacherTeamService.getTeacherTeam(teacherTeamId);
		if(teacherTeamService.deleteTeacherTeam(teacherTeam))
			return SUCCESS;
		else{
			addActionError("删除教师队伍失败，请重新操作！");
			return ERROR;
		}
	}
	
	public List<TeacherTeam> getTeacherTeamList() {
		return teacherTeamList;
	}

	public void setTeacherTeamList(List<TeacherTeam> teacherTeamList) {
		this.teacherTeamList = teacherTeamList;
	}

	public TeacherTeam getTeacherTeam() {
		return teacherTeam;
	}

	public void setTeacherTeam(TeacherTeam teacherTeam) {
		this.teacherTeam = teacherTeam;
	}

	public ITeacherTeamService getTeacherTeamService() {
		return teacherTeamService;
	}

	public void setTeacherTeamService(ITeacherTeamService teacherTeamService) {
		this.teacherTeamService = teacherTeamService;
	}

	public void setTeacherTeamId(Integer teacherTeamId) {
		this.teacherTeamId = teacherTeamId;
	}

	public Integer getTeacherTeamId() {
		return teacherTeamId;
	}
	
	
}
