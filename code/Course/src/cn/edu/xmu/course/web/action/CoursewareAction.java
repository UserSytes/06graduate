package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.ICoursewareService;

public class CoursewareAction extends BaseAction {

	private List<Chapter> chapterList;
	private Chapter chapter;
	private Integer chapterId;

	private List<Courseware> coursewareList;
	private Courseware courseware;
	private Integer coursewareId;

	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	private IChapterService chapterService;
	private ICoursewareService coursewareService;

	public String getCoursewareListByChapter() {
		Course course = super.getCourse();
		chapterList = chapterService.getAllChapter(super.getCourse());
		if(chapterId ==null ||chapterId== -1)
			coursewareList = coursewareService.getAllCoursewares(course);
		else{
			chapter=chapterService.getChapter(chapterId);
			coursewareList = coursewareService.getCoursewaresByChapter(chapter);
		}
		return SUCCESS;
	}
	public String getAllCourseware(){
		Course course = super.getCourse();
		coursewareList = coursewareService.getAllCoursewares(course);
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String downloadCourseware(){
		Chapter currentChapter=chapterService.getChapter(chapterId);
		coursewareList=coursewareService.getCoursewaresByChapter(currentChapter);
		if(getCoursewareList()==null)
			{
			System.out.println("本章节无课件！");
			addActionError("本章节无课件！");
			return ERROR;
			}
		else
			return "courseware";
	}
	public String addCourseware() {
		if(upload.length()>=new Long(10485760L)){
			addActionError("上传课件大小不能超过10M,请重新上传！");
			return ERROR;
		}
		String fileLink = super.getPreFileNameByTeacher() + uploadFileName;
		courseware.setFilename(uploadFileName);
		courseware.setFileLink(fileLink);
		chapter = chapterService.getChapterById(chapterId);
		System.out.println("the  path1 is "+upload.getPath());
		if (coursewareService.addCourseware(courseware, chapter, upload))
			return SUCCESS;
		else {
			addActionError("添加课件失败，请重新添加！");
			return ERROR;
		}
	}

	public String goEditCourseware() {
		courseware = coursewareService.getCoursewareById(coursewareId);
		chapterList = chapterService.getAllChapter(super.getCourse());
		chapterId = courseware.getChapter().getId();
		return SUCCESS;
	}

	public String goAddCourseware() {
		chapterList = chapterService.getAllChapter(super.getCourse());
		return SUCCESS;
	}

	public String updateCourseware() {
		if(upload.length()>=new Long(10485760L)){
			addActionError("上传课件大小不能超过10M,请重新上传！");
			return ERROR;
		}
		String fileLink = super.getPreFileNameByTeacher() + uploadFileName;
		courseware.setFilename(uploadFileName);
		courseware.setFileLink(fileLink);
		chapter = chapterService.getChapterById(chapterId);
		if (coursewareService.updateCourseware(courseware, chapter,upload))
			return SUCCESS;
		else {
			addActionError("更新课件失败，请重新操作！");
			return ERROR;
		}
	}

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

	public void setCoursewareId(Integer coursewareId) {
		this.coursewareId = coursewareId;
	}

	public Integer getCoursewareId() {
		return coursewareId;
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

}
