package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Achievement;
import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.pojo.Exercise;
import cn.edu.xmu.course.pojo.Experiment;
import cn.edu.xmu.course.pojo.TeacherTeam;
import cn.edu.xmu.course.service.IAchievementService;
import cn.edu.xmu.course.service.IApplicationFormService;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.ICourseInfoService;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.ICoursewareService;
import cn.edu.xmu.course.service.IExerciseService;
import cn.edu.xmu.course.service.IExperimentService;
import cn.edu.xmu.course.service.ITeacherTeamService;

public class ViewDetailAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationForm applicationForm;
	private CourseInfo courseInfo;
	private Course course;
	private Achievement achievement;
	private List<TeacherTeam> teacherTeamList;
	private List<Chapter> chapterList;
	private List<Courseware> coursewareList;
	private List<Experiment> experimentList;
	private List<Exercise> exerciseList;
	private int courseId;
	private int chapterId;
	private int flag;
	private int sort;
	private IApplicationFormService applicationFormService;
	private ICourseInfoService courseInfoService;
	private ITeacherTeamService teacherTeamService;
	private IAchievementService achievementService;
	private IChapterService chapterService;
	private ICoursewareService coursewareService;
	private IExperimentService experimentService;
	private IExerciseService exerciseService;
	private ICourseService courseService;
	public ApplicationForm getApplicationForm() {
		return applicationForm;
	}

	public void setApplicationForm(ApplicationForm applicationForm) {
		this.applicationForm = applicationForm;
	}

	

	public IApplicationFormService getApplicationFormService() {
		return applicationFormService;
	}

	public void setApplicationFormService(
			IApplicationFormService applicationFormService) {
		this.applicationFormService = applicationFormService;
	}
	/**
	 * 查找申请表格
	 * @return
	 */
	public String findApplicationForm(){
		applicationForm=applicationFormService.getApplicationForm(courseId);
		if (getApplicationForm() == null) {
			addActionError("申报表格信息不存在！");
			return ERROR;
		} else
			return "applicationForm";
	}
	/**
	 * 查找课程简介
	 * @return
	 */
	public String findCourseInfo(){
		courseInfo=courseInfoService.getCourseInfo(courseId, sort);
		System.out.println("\naction"+courseInfo.getTitle());
		if (getCourseInfo() == null) {
			addActionError("课程信息不存在！");
			return ERROR;
		} else
			return "courseInfo";
	}
	/**
	 * 查找师资队伍
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findTeacherTeam(){
		teacherTeamList=teacherTeamService.getTeacherTeamList(courseId);
		if (getTeacherTeamList() == null) {
			addActionError("教师队伍不存在！");
			return ERROR;
		} else
			return "teachers";
	}
	/**
	 * 查找成果展示
	 * @return
	 */
	public String findAchievement(){
		achievement=achievementService.getAchievement(courseId);
		if (getAchievement() == null) {
			addActionError("教学成果信息不存在！");
			return ERROR;
		} else
			return "achievement";
	}
	/**
	 * 查找章节
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findChapter(){
		chapterList=chapterService.getAllChapter(courseId);
		if (getChapterList() == null) {
			addActionError("课程章节信息不存在！");
			return ERROR;
		} else
			{if(getFlag()==1)
				return "coursewares";
			else if(getFlag()==2)
				return "experiments";
			else
				return "exercises";
			}
	}
	@SuppressWarnings("unchecked")
	public String downloadCourseware(){
		Chapter currentChapter=chapterService.getChapter(chapterId);
		coursewareList=coursewareService.getCoursewaresByChapter(currentChapter);
		if(getCoursewareList()==null)
			{addActionError("本章节无课件！");
			return ERROR;}
		else
			return "courseware";
	}
	@SuppressWarnings("unchecked")
	public String downloadExperiment(){
		Chapter currentChapter=chapterService.getChapter(chapterId);
		experimentList=experimentService.getExperimentsByChapter(currentChapter);
		if(getExperimentList()==null)
		{	
			addActionError("本章节无实验指导！");
			return ERROR;
			}
		else
			return "experiment";
	}
	@SuppressWarnings("unchecked")
	public String downloadExercise(){
		Chapter currentChapter=chapterService.getChapter(chapterId);
		exerciseList=exerciseService.getExercisesByChapter(currentChapter);
		if(getExerciseList()==null)
			{addActionError("本章节无习题，请自觉复习！");
			return ERROR;
			
			}
		else
			return "exercise";
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

	public void setCourseInfoService(ICourseInfoService courseInfoService) {
		this.courseInfoService = courseInfoService;
	}

	public ICourseInfoService getCourseInfoService() {
		return courseInfoService;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	public CourseInfo getCourseInfo() {
		return courseInfo;
	}

	public void setTeacherTeamService(ITeacherTeamService teacherTeamService) {
		this.teacherTeamService = teacherTeamService;
	}

	public ITeacherTeamService getTeacherTeamService() {
		return teacherTeamService;
	}

	public void setTeacherTeamList(List<TeacherTeam> teacherTeamList) {
		this.teacherTeamList = teacherTeamList;
	}

	public List<TeacherTeam> getTeacherTeamList() {
		return teacherTeamList;
	}

	public void setAchievementService(IAchievementService achievementService) {
		this.achievementService = achievementService;
	}

	public IAchievementService getAchievementService() {
		return achievementService;
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Achievement getAchievement() {
		return achievement;
	}

	public void setChapterService(IChapterService chapterService) {
		this.chapterService = chapterService;
	}

	public IChapterService getChapterService() {
		return chapterService;
	}

	public void setCoursewareService(ICoursewareService coursewareService) {
		this.coursewareService = coursewareService;
	}

	public ICoursewareService getCoursewareService() {
		return coursewareService;
	}

	public void setChapterList(List<Chapter> chapterList) {
		this.chapterList = chapterList;
	}

	public List<Chapter> getChapterList() {
		return chapterList;
	}

	public void setCoursewareList(List<Courseware> coursewareList) {
		this.coursewareList = coursewareList;
	}

	public List<Courseware> getCoursewareList() {
		return coursewareList;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getFlag() {
		return flag;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public int getChapterId() {
		return chapterId;
	}

	public void setExperimentList(List<Experiment> experimentList) {
		this.experimentList = experimentList;
	}

	public List<Experiment> getExperimentList() {
		return experimentList;
	}

	public void setExperimentService(IExperimentService experimentService) {
		this.experimentService = experimentService;
	}

	public IExperimentService getExperimentService() {
		return experimentService;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getSort() {
		return sort;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setExerciseList(List<Exercise> exerciseList) {
		this.exerciseList = exerciseList;
	}

	public List<Exercise> getExerciseList() {
		return exerciseList;
	}

	public void setExerciseService(IExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}

	public IExerciseService getExerciseService() {
		return exerciseService;
	}


}
