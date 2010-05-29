package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.ICoursewareService;

/**
 * 负责课程教案的类
 * 
 * @author 何申密
 * @author 许子彦
 * 
 */
public class CoursewareAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1786518150476463775L;
	private List<Chapter> chapterList; // 章节列表
	private Chapter chapter; // 章节
	private Integer chapterId; // 章节ID

	private List<Courseware> coursewareList; // 课件列表
	private Courseware courseware; // 课件
	private Integer coursewareId; // 课件ID

	private File upload; // 附件
	private String uploadContentType; // 文件类型
	private String uploadFileName; // 文件名称

	private IChapterService chapterService; // 负责章节的接口
	private ICoursewareService coursewareService; // 负责课件的接口

	/**
	 * 根据章节查找课件
	 * 
	 * @return
	 */
	public String getCoursewareListByChapter() {
		Course course = super.getCourse();
		chapterList = chapterService.getAllChapter(super.getCourse());
		if (chapterId == null || chapterId == -1)
			coursewareList = coursewareService.getAllCoursewares(course);
		else {
			chapter = chapterService.getChapterById(chapterId);
			coursewareList = coursewareService.getCoursewaresByChapter(chapter);
		}
		return SUCCESS;
	}

	/**
	 * 查找所有课件
	 * 
	 * @return
	 */
	public String getAllCourseware() {
		Course course = super.getCourse();
		coursewareList = coursewareService.getAllCoursewares(course);
		return SUCCESS;
	}

	/**
	 * 下载课件
	 * 
	 * @return
	 */
	public String downloadCourseware() {
		Chapter currentChapter = chapterService.getChapterById(chapterId);
		coursewareList = coursewareService
				.getCoursewaresByChapter(currentChapter);
		if (getCoursewareList() == null) {
			System.out.println("本章节无课件！");
			addActionError("本章节无课件！");
			return ERROR;
		} else
			return "courseware";
	}

	/**
	 * 添加课件
	 * 
	 * @return
	 */
	public String addCourseware() {	
		String fileLink = super.getPreFileNameByTeacher(super.getCourse()) + uploadFileName;
		courseware.setFilename(uploadFileName);
		courseware.setFileLink(fileLink);
		chapter = chapterService.getChapterById(chapterId);
		if (coursewareService.addCourseware(courseware, chapter, upload))
			return SUCCESS;
		else {
			addActionError("添加课件失败，请重新添加！");
			return ERROR;
		}
	}

	/**
	 * 跳转到编辑课件
	 * 
	 * @return
	 */
	public String goEditCourseware() {
		courseware = coursewareService.getCoursewareById(coursewareId);
		chapterList = chapterService.getAllChapter(super.getCourse());
		chapterId = courseware.getChapter().getId();
		return SUCCESS;
	}

	/**
	 * 跳转到增加课件
	 * 
	 * @return
	 */
	public String goAddCourseware() {
		chapterList = chapterService.getAllChapter(super.getCourse());
		return SUCCESS;
	}

	/**
	 * 更新课件
	 * 
	 * @return
	 */
	public String updateCourseware() {	
		String fileLink = super.getPreFileNameByTeacher(super.getCourse()) + uploadFileName;
		courseware.setFilename(uploadFileName);
		courseware.setFileLink(fileLink);
		chapter = chapterService.getChapterById(chapterId);
		if (coursewareService.updateCourseware(courseware, chapter, upload))
			return SUCCESS;
		else {
			addActionError("更新课件失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 删除课件
	 * 
	 * @return
	 */
	public String deleteCourseware() {
		Courseware delCourseware = coursewareService
				.getCoursewareById(coursewareId);
		if (coursewareService.deleteCourseware(delCourseware))
			return SUCCESS;
		else {
			addActionError("删除课件失败，请重新操作！");
			return ERROR;
		}
	}

	public List<Chapter> getChapterList() {
		return chapterList;
	}

	public void setChapterList(List<Chapter> chapterList) {
		this.chapterList = chapterList;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	public List<Courseware> getCoursewareList() {
		return coursewareList;
	}

	public void setCoursewareList(List<Courseware> coursewareList) {
		this.coursewareList = coursewareList;
	}

	public Courseware getCourseware() {
		return courseware;
	}

	public void setCourseware(Courseware courseware) {
		this.courseware = courseware;
	}

	public Integer getCoursewareId() {
		return coursewareId;
	}

	public void setCoursewareId(Integer coursewareId) {
		this.coursewareId = coursewareId;
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

	public IChapterService getChapterService() {
		return chapterService;
	}

	public void setChapterService(IChapterService chapterService) {
		this.chapterService = chapterService;
	}

	public ICoursewareService getCoursewareService() {
		return coursewareService;
	}

	public void setCoursewareService(ICoursewareService coursewareService) {
		this.coursewareService = coursewareService;
	}
	
	
}
