package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.service.ICourseInfoService;
/**
 * ����γ���Ϣ����
 * @author ������
 * @author ������
 *
 */
public class CourseInfoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8520468160026179099L;
	private CourseInfo courseInfo; // �γ���Ϣ
	private ApplicationForm applicationForm; // �걨���
	private List<CourseInfo> courseInfoList; // �γ���Ϣ�б�
	private Integer courseInfoId; // �γ���ϢID
	private Integer sort = 1; // �γ���Ϣ���

	private File upload; // ����
	private String uploadContentType; // �ļ�����
	private String uploadFileName; // �ļ�����

	private ICourseInfoService courseInfoService; // ����γ���Ϣ�Ľӿ�

	/**
	 * ��ӿγ���Ϣ
	 * 
	 * @return
	 */
	public String addNewCourseInfo() {
		Course currentCourse = super.getCourse();
		courseInfo.setSort(1);
		if (null == courseInfo.getId()) {
			if (courseInfoService.addCoureseInfo(courseInfo, currentCourse)) {
				addActionError("��ӿγ̼��ɹ���");
				return SUCCESS;
			} else {
				addActionError("��ӿγ̼��ʧ�ܣ���������ӣ�");
				return ERROR;
			}

		} else {
			if (courseInfoService.updateCourseInfo(courseInfo)) {
				addActionError("���¿γ̼��ɹ���");
				return SUCCESS;
			} else
				addActionError("���¿γ̼��ʧ�ܣ������²�����");
			return ERROR;

		}
	}

	/**
	 * ��ӽ�ѧ���
	 * 
	 * @return
	 */
	public String addNewCourseOutline() {
		Course currentCourse = super.getCourse();
		courseInfo.setSort(2);
		if (null == courseInfo.getId()) {
			if (courseInfoService.addCoureseInfo(courseInfo, currentCourse)) {
				addActionError("��ӽ�ѧ��ٳɹ���");
				return SUCCESS;
			} else {
				addActionError("��ӽ�ѧ���ʧ�ܣ���������ӣ�");
				return ERROR;
			}

		} else {
			if (courseInfoService.updateCourseInfo(courseInfo)) {
				addActionError("���½�ѧ��ٳɹ���");
				return SUCCESS;
			} else
				addActionError("���½�ѧ���ʧ�ܣ������²�����");
			return ERROR;

		}
	}

	/**
	 * ɾ���γ���Ϣ
	 * 
	 * @return
	 */
	public String deleteCourseInfo() {
		CourseInfo delCourseInfo = courseInfoService
				.getCourseInfoById(courseInfoId);
		if (courseInfoService.deleteCourseInfo(delCourseInfo))
			return SUCCESS;
		else {
			addActionError("ɾ���γ���Ϣʧ�ܣ������²�����");
			return ERROR;
		}

	}

	/**
	 * �༭�γ���Ϣ
	 * 
	 * @return
	 */
	public String updateCourseInfo() {

		if (courseInfoId == null)
			courseInfo = new CourseInfo();
		else {
			courseInfo = courseInfoService.getCourseInfoById(courseInfoId);
		}
		return SUCCESS;
	}

	/**
	 * ��ȡ��ǰ�γ���Ϣ
	 * 
	 * @return
	 */
	public String findCourseInfo() {
		Course currentCourse = super.getCourse();
		courseInfo = courseInfoService.getCourseInfo(currentCourse.getId(), 1);
		if (null == courseInfo) {
			courseInfo = new CourseInfo();
			courseInfo.setContent("�����κ����ݣ�");
		}
		return SUCCESS;
	}

	/**
	 * ���ҽ�ѧ���
	 * 
	 * @return
	 */
	public String findCourseOutline() {
		Course currentCourse = super.getCourse();
		courseInfo = courseInfoService.getCourseInfo(currentCourse.getId(), 2);
		if (null == courseInfo) {
			courseInfo = new CourseInfo();
			courseInfo.setContent("�����κ����ݣ�");
		}
		return SUCCESS;
	}

	/**
	 * �γ�ҳ���ȡ��ǰ�γ���Ϣ
	 * 
	 * @return
	 */
	public String findCourseInfo2() {
		Course currentCourse = super.getCourse();
		courseInfo = courseInfoService.getCourseInfo(currentCourse.getId(),
				sort);
		if (null == courseInfo) {
			courseInfo = new CourseInfo();
			courseInfo.setContent("�����κ����ݣ�");
		}
		if (sort == 1)
			return "courseinfo1";
		else
			return "courseinfo2";
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	public CourseInfo getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfoService(ICourseInfoService courseInfoService) {
		this.courseInfoService = courseInfoService;
	}

	public ICourseInfoService getCourseInfoService() {
		return courseInfoService;
	}

	public void setApplicationForm(ApplicationForm applicationForm) {
		this.applicationForm = applicationForm;
	}

	public ApplicationForm getApplicationForm() {
		return applicationForm;
	}

	public void setCourseInfoList(List<CourseInfo> courseInfoList) {
		this.courseInfoList = courseInfoList;
	}

	public List<CourseInfo> getCourseInfoList() {
		return courseInfoList;
	}

	public void setCourseInfoId(Integer courseInfoId) {
		this.courseInfoId = courseInfoId;
	}

	public Integer getCourseInfoId() {
		return courseInfoId;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return sort;
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
