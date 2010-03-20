package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.pojo.Achievement;
import cn.edu.xmu.course.pojo.Book;
import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseMovie;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.pojo.Examination;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.IAchievementService;
import cn.edu.xmu.course.service.IBookService;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.ICourseMovieService;
import cn.edu.xmu.course.service.ICoursewareService;
import cn.edu.xmu.course.service.IExaminationService;

public class AchievementAction extends BaseAction {

	private List<Achievement> achievementList;
	private Achievement achievement;
	private Integer achievementId;
	private Course course;
	private int courseId;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	private IAchievementService achievementService;

	public String getAchievementListByCourse() {
		System.out.println(super.getCourse());
		achievementList = achievementService.getAllAchievements(super.getCourse());
		return SUCCESS;
	}
	
//	/**
//	 * 查找成果展示
//	 * @return
//	 */
//	public String findAchievement(){
//		course=super.getCourse();
//		achievementList=achievementService.getAllAchievements(course);
//		if (getAchievementList() == null) {
//			addActionError("教学成果信息不存在！");
//			return ERROR;
//		} else
//			return "achievement";
//	}
	public String addAchievement() {
		String fileLink = super.getTeacher().getUserInfo().getName() + "/"
		+ new Date().getTime()+"_"+super.getCourse().getName() + "_" + uploadFileName;
		achievement.setFileName(uploadFileName);
		achievement.setFileLink(fileLink);
		if (achievementService.addAchievement( super.getCourse(),achievement, upload))
			return SUCCESS;
		else {
			addActionError("添加教学成果失败，请重新添加！");
			return ERROR;
		}
	}

	public String goEditAchievement() {
		achievement = achievementService.getAchievementById(achievementId);		
		return SUCCESS;
	}

	public String updateAchievement() {
		String fileLink = super.getPreFileNameByTeacher() + uploadFileName;
		achievement.setFileName(uploadFileName);
		achievement.setFileLink(fileLink);
		if (achievementService.updateAchievement(achievement,upload))
			return SUCCESS;
		else {
			addActionError("更新教学成果失败，请重新操作！");
			return ERROR;
		}
	}

	public String deleteAchievement() {
		Achievement delAchievement = achievementService.getAchievementById(achievementId);
		if (achievementService.deleteAchievement(delAchievement))
			return SUCCESS;
		else {
			addActionError("删除教学成果失败，请重新操作！");
			return ERROR;
		}
	}

	public String getAchievementById(){
		achievement = achievementService.getAchievementById(achievementId);
		if (achievement==null)
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
