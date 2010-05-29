package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.TeacherTeam;
import cn.edu.xmu.course.service.ITeacherTeamService;
/**
 * 负责教师队伍的类
 * @author 何申密
 * @author 许子彦
 *
 */
public class TeacherTeamAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3296127131655857810L;
	private List<TeacherTeam> teacherTeamList; // 师资队伍列表
	private TeacherTeam teacherTeam; // 师资队伍
	private Integer teacherTeamId; // 师资队伍ID

	private ITeacherTeamService teacherTeamService; // 负责师资队伍的接口

	/**
	 * 根据课程查找师资队伍
	 * 
	 * @return
	 */
	public String getTeacherTeamListByCourse() {
		Course course = super.getCourse();
		teacherTeamList = teacherTeamService.getTeacherTeamList(course.getId());
		return SUCCESS;
	}

	/**
	 * 查找师资队伍
	 * 
	 * @return
	 */
	public String findTeacherTeam() {
		Course course = super.getCourse();
		teacherTeamList = teacherTeamService.getTeacherTeamList(course.getId());
		if (getTeacherTeamList() == null) {
			addActionError("教师队伍信息不存在！");
			return ERROR;
		} else
			return "teachers";
	}

	/**
	 * 添加师资队伍
	 * 
	 * @return
	 */
	public String addTeacherTeam() {
		Course course = super.getCourse();
		if (teacherTeamService.addTeacherTeam(teacherTeam, course))
			return SUCCESS;
		else {
			addActionError("添加教师队伍失败,请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 跳转到编辑师资队伍
	 * 
	 * @return
	 */
	public String goEidtTeacherTeam() {
		teacherTeam = teacherTeamService.getTeacherTeam(teacherTeamId);
		return SUCCESS;
	}

	/**
	 * 更新师资队伍
	 * 
	 * @return
	 */
	public String updateTeacherTeam() {
		if (teacherTeamService.updateTeacherTeam(teacherTeam))
			return SUCCESS;
		else {
			addActionError("更新教师队伍失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 删除师资队伍
	 * 
	 * @return
	 */
	public String deleteTeacherTeam() {
		teacherTeam = teacherTeamService.getTeacherTeam(teacherTeamId);
		if (teacherTeamService.deleteTeacherTeam(teacherTeam))
			return SUCCESS;
		else {
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
