package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.service.IApplicationFormService;
import cn.edu.xmu.course.service.ICourseInfoService;

public class CourseInfoAction extends BaseAction {

	private CourseInfo courseInfo;
	private ApplicationForm applicationForm;
	private List<CourseInfo> courseInfoList;
	private Integer courseInfoId;
	private Integer sort = 1;

	private ICourseInfoService courseInfoService;
	private IApplicationFormService applicationFormService;

	/**
	 * ��ӿγ���Ϣ
	 * @return
	 */
	public String addNewCourseInfo() {
		Course currentCourse = super.getCourse();
		if (null == courseInfoService.getCourseInfo(currentCourse.getId(), courseInfo.getSort())) {
			if (courseInfoService.addCoureseInfo(courseInfo, currentCourse))
				return SUCCESS;
			else {
				addActionError("��ӿγ���Ϣʧ�ܣ����������");
				return ERROR;
			}

		} else {
			if (courseInfo.getSort() == 1)
				addActionError("�γ̼���Ѿ����ڣ��޷���ӣ����ԭ�����ݽ��б༭��");
			else if (courseInfo.getSort() == 2)
				addActionError("��ѧ����Ѿ����ڣ��޷���ӣ����ԭ�����ݽ��б༭��");
			return ERROR;

		}
	}
	
	/**
	 * ɾ���γ���Ϣ
	 * @return
	 */
	public String deleteCourseInfo(){
		if(courseInfoId == null){
			if(sort == 1)
				addActionError("�γ̼�������κ���Ϣ���޷�ɾ����");
			else if(sort == 2)
				addActionError("��ѧ��������κ���Ϣ���޷�ɾ����");
			return ERROR;
		}

		else{
			CourseInfo delCourseInfo = courseInfoService.getCourseInfoById(courseInfoId);
			if(courseInfoService.deleteCourseInfo(delCourseInfo))
				return SUCCESS;
			else{
				addActionError("ɾ���γ���Ϣʧ�ܣ������²�����");
				return ERROR;
			}
		}
	}
	
	/**
	 * ��ȡ�ÿγ���ϸ��Ϣ
	 * @return
	 */
	public String getCourseInfoDetail(){
		courseInfo = courseInfoService.getCourseInfoById(courseInfoId);
		return SUCCESS;
	}

	/**
	 * ��ȡ��ǰ�γ�
	 * 
	 * @return
	 */
	public String getCurrentCourse() {
		Course course = super.getCourse();
		if (null == applicationFormService.getApplicationForm(course.getId())) {
			applicationForm = new ApplicationForm();
		} else
			applicationForm = applicationFormService.getApplicationForm(course
					.getId());
		System.out.println(applicationForm.getSort());
		return SUCCESS;
	}

	/**
	 * ��ȡ��ǰ�γ���Ϣ
	 * 
	 * @return
	 */
	public String findCourseInfo() {
		Course currentCourse = super.getCourse();
		courseInfo=courseInfoService.getCourseInfo(currentCourse.getId(), sort);
		if (null == courseInfo) {
			courseInfo = new CourseInfo();
			courseInfo.setContent("�����κ����ݣ�");
		}
		return SUCCESS;
	}

	public String addApplicationForm() {
		Course course = super.getCourse();
		if (applicationForm.getId() == null) {
			if (applicationFormService.addApplicationForm(applicationForm,
					course)) {
				addActionMessage("��ӿγ��걨���ɹ�!");
				return SUCCESS;
			} else
				return ERROR;
		} else {
			if (applicationFormService.updateApplicationForm(applicationForm)) {
				addActionMessage("���Ŀγ��걨���ɹ�!");
				return SUCCESS;
			} else
				return ERROR;
		}

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

	public void setApplicationFormService(
			IApplicationFormService applicationFormService) {
		this.applicationFormService = applicationFormService;
	}

	public IApplicationFormService getApplicationFormService() {
		return applicationFormService;
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
}
