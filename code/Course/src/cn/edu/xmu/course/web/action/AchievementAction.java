package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.pojo.Achievement;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.service.IAchievementService;
/**
 * 负责教学成果的类
 * @author 何申密
 * @author 许子彦
 *
 */
public class AchievementAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 390526433485524738L;
	private List<Achievement> achievementList; // 成果列表
	private Achievement achievement; // 成果
	private Integer achievementId; // 成果ID
	private Course course; // 课程
	private int courseId; // 课程ID
	private File upload; // 附件
	private String uploadContentType; // 文件类型
	private String uploadFileName; // 文件名称

	private IAchievementService achievementService; // 负责教学成果的接口

	/**
	 * 根据课程查找成果
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
	 * 增加课程成果
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
			addActionError("添加教学成果失败，请重新添加！");
			return ERROR;
		}
	}

	/**
	 * 跳转到编辑成果
	 * 
	 * @return
	 */
	public String goEditAchievement() {
		achievement = achievementService.getAchievementById(achievementId);
		return SUCCESS;
	}

	/**
	 * 更新成果
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
			addActionError("更新教学成果失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 删除成果
	 * 
	 * @return
	 */
	public String deleteAchievement() {
		Achievement delAchievement = achievementService
				.getAchievementById(achievementId);
		if (achievementService.deleteAchievement(delAchievement))
			return SUCCESS;
		else {
			addActionError("删除教学成果失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 根据ID查找成果
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
