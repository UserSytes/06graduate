package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.ICoursewareService;

/**
 * ����γ̰̽�����
 * 
 * @author ������
 * @author ������
 * 
 */
public class CoursewareAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1786518150476463775L;
	private List<Chapter> chapterList; // �½��б�
	private Chapter chapter; // �½�
	private Integer chapterId; // �½�ID

	private List<Courseware> coursewareList; // �μ��б�
	private Courseware courseware; // �μ�
	private Integer coursewareId; // �μ�ID

	private File upload; // ����
	private String uploadContentType; // �ļ�����
	private String uploadFileName; // �ļ�����

	private IChapterService chapterService; // �����½ڵĽӿ�
	private ICoursewareService coursewareService; // ����μ��Ľӿ�

	/**
	 * �����½ڲ��ҿμ�
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
	 * �������пμ�
	 * 
	 * @return
	 */
	public String getAllCourseware() {
		Course course = super.getCourse();
		coursewareList = coursewareService.getAllCoursewares(course);
		return SUCCESS;
	}

	/**
	 * ���ؿμ�
	 * 
	 * @return
	 */
	public String downloadCourseware() {
		Chapter currentChapter = chapterService.getChapterById(chapterId);
		coursewareList = coursewareService
				.getCoursewaresByChapter(currentChapter);
		if (getCoursewareList() == null) {
			System.out.println("���½��޿μ���");
			addActionError("���½��޿μ���");
			return ERROR;
		} else
			return "courseware";
	}

	/**
	 * ��ӿμ�
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
			addActionError("��ӿμ�ʧ�ܣ���������ӣ�");
			return ERROR;
		}
	}

	/**
	 * ��ת���༭�μ�
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
	 * ��ת�����ӿμ�
	 * 
	 * @return
	 */
	public String goAddCourseware() {
		chapterList = chapterService.getAllChapter(super.getCourse());
		return SUCCESS;
	}

	/**
	 * ���¿μ�
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
			addActionError("���¿μ�ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ɾ���μ�
	 * 
	 * @return
	 */
	public String deleteCourseware() {
		Courseware delCourseware = coursewareService
				.getCoursewareById(coursewareId);
		if (coursewareService.deleteCourseware(delCourseware))
			return SUCCESS;
		else {
			addActionError("ɾ���μ�ʧ�ܣ������²�����");
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
