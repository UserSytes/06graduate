package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.TeacherTeam;
import cn.edu.xmu.course.service.ITeacherTeamService;
/**
 * �����ʦ�������
 * @author ������
 * @author ������
 *
 */
public class TeacherTeamAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3296127131655857810L;
	private List<TeacherTeam> teacherTeamList; // ʦ�ʶ����б�
	private TeacherTeam teacherTeam; // ʦ�ʶ���
	private Integer teacherTeamId; // ʦ�ʶ���ID

	private ITeacherTeamService teacherTeamService; // ����ʦ�ʶ���Ľӿ�

	/**
	 * ���ݿγ̲���ʦ�ʶ���
	 * 
	 * @return
	 */
	public String getTeacherTeamListByCourse() {
		Course course = super.getCourse();
		teacherTeamList = teacherTeamService.getTeacherTeamList(course.getId());
		return SUCCESS;
	}

	/**
	 * ����ʦ�ʶ���
	 * 
	 * @return
	 */
	public String findTeacherTeam() {
		Course course = super.getCourse();
		teacherTeamList = teacherTeamService.getTeacherTeamList(course.getId());
		if (getTeacherTeamList() == null) {
			addActionError("��ʦ������Ϣ�����ڣ�");
			return ERROR;
		} else
			return "teachers";
	}

	/**
	 * ���ʦ�ʶ���
	 * 
	 * @return
	 */
	public String addTeacherTeam() {
		Course course = super.getCourse();
		if (teacherTeamService.addTeacherTeam(teacherTeam, course))
			return SUCCESS;
		else {
			addActionError("��ӽ�ʦ����ʧ��,�����²�����");
			return ERROR;
		}
	}

	/**
	 * ��ת���༭ʦ�ʶ���
	 * 
	 * @return
	 */
	public String goEidtTeacherTeam() {
		teacherTeam = teacherTeamService.getTeacherTeam(teacherTeamId);
		return SUCCESS;
	}

	/**
	 * ����ʦ�ʶ���
	 * 
	 * @return
	 */
	public String updateTeacherTeam() {
		if (teacherTeamService.updateTeacherTeam(teacherTeam))
			return SUCCESS;
		else {
			addActionError("���½�ʦ����ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ɾ��ʦ�ʶ���
	 * 
	 * @return
	 */
	public String deleteTeacherTeam() {
		teacherTeam = teacherTeamService.getTeacherTeam(teacherTeamId);
		if (teacherTeamService.deleteTeacherTeam(teacherTeam))
			return SUCCESS;
		else {
			addActionError("ɾ����ʦ����ʧ�ܣ������²�����");
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
