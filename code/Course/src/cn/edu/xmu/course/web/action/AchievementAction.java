package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.pojo.Achievement;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.service.IAchievementService;
/**
 * �����ѧ�ɹ�����
 * @author ������
 * @author ������
 *
 */
public class AchievementAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 390526433485524738L;
	private List<Achievement> achievementList; // �ɹ��б�
	private Achievement achievement; // �ɹ�
	private Integer achievementId; // �ɹ�ID
	private Course course; // �γ�
	private int courseId; // �γ�ID
	private File upload; // ����
	private String uploadContentType; // �ļ�����
	private String uploadFileName; // �ļ�����

	private IAchievementService achievementService; // �����ѧ�ɹ��Ľӿ�

	/**
	 * ���ݿγ̲��ҳɹ�
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getAchievementListByCourse() {
		course = super.getCourse();
		achievementList = achievementService.getAllAchievements(super
				.getCourse());
		return SUCCESS;
	}

	/**
	 * ���ӿγ̳ɹ�
	 * 
	 * @return
	 */
	public String addAchievement() {
		String fileLink = super.getPreFileNameByTeacher(super.getCourse()) + uploadFileName;
		achievement.setFileName(uploadFileName);
		achievement.setFileLink(fileLink);
		if (achievementService.addAchievement(super.getCourse(), achievement,
				upload))
			return SUCCESS;
		else {
			addActionError("��ӽ�ѧ�ɹ�ʧ�ܣ���������ӣ�");
			return ERROR;
		}
	}

	/**
	 * ��ת���༭�ɹ�
	 * 
	 * @return
	 */
	public String goEditAchievement() {
		achievement = achievementService.getAchievementById(achievementId);
		return SUCCESS;
	}

	/**
	 * ���³ɹ�
	 * 
	 * @return
	 */
	public String updateAchievement() {
		String fileLink = super.getPreFileNameByTeacher(super.getCourse()) + uploadFileName;
		achievement.setFileName(uploadFileName);
		achievement.setFileLink(fileLink);
		if (achievementService.updateAchievement(achievement, upload))
			return SUCCESS;
		else {
			addActionError("���½�ѧ�ɹ�ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ɾ���ɹ�
	 * 
	 * @return
	 */
	public String deleteAchievement() {
		Achievement delAchievement = achievementService
				.getAchievementById(achievementId);
		if (achievementService.deleteAchievement(delAchievement))
			return SUCCESS;
		else {
			addActionError("ɾ����ѧ�ɹ�ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ����ID���ҳɹ�
	 * 
	 * @return
	 */
	public String getAchievementById() {
		course = super.getCourse();
		achievement = achievementService.getAchievementById(achievementId);
		if (achievement == null)
			return ERROR;
		else {
			return SUCCESS;
		}
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<Achievement> getAchievementList() {
		return achievementList;
	}

	public void setAchievementList(List<Achievement> achievementList) {
		this.achievementList = achievementList;
	}

	public Achievement getAchievement() {
		return achievement;
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Integer getAchievementId() {
		return achievementId;
	}

	public void setAchievementId(Integer achievementId) {
		this.achievementId = achievementId;
	}

	public IAchievementService getAchievementService() {
		return achievementService;
	}

	public void setAchievementService(IAchievementService achievementService) {
		this.achievementService = achievementService;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

}
