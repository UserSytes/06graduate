package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Popedom;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.IDepartmentService;

/**
 * �������Ա����ʦ����γ̵���
 * 
 * @author ������
 * @author ֣����
 * 
 */
@SuppressWarnings("unchecked")
public class CourseAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1435933948873647769L;
	private String departmentId; // ϵ��id
	private int courseId; // �γ�id
	private Course course; // �γ�
	private List<Course> myCoursesList; // �ң���ʦ���Ŀγ��б�
	private int type = 3; // �γ�״̬��ʶ��3:���пγ�
	private String style; // �γ̷����ɫ

	private ICourseService courseService; // ����γ̵Ľӿ�
	private IDepartmentService departmentService; // ����ϵ�Ľӿ�

	private List<Course> applicationCourseList; // �걨�γ��б�
	private String refuseReason; // ��˿γ��˻�ʱ��д������
	
	private Popedom popedom;
	
	/**
	 * ��ת���걨�γ�
	 * 
	 * @return
	 */
	public String goAddNewCourse() {
			return SUCCESS;
	}
	
	/**
	 * �걨�γ�
	 * 
	 * @return
	 */
	public String addNewCourse() {
		Department dept = departmentService.getDepartmentById(Integer
				.parseInt(departmentId));
		if (getCourseService().addCourse(course, dept, super.getTeacher())) {
			addActionMessage("�걨�γ̳ɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}
	
	
	
	public String updateCoursePopedom(){
		if (courseService.updatePopedom(popedom)) {
			addActionMessage("�޸Ŀγ��������Ȩ�޳ɹ���");
			return SUCCESS;
		}
		else{
			addActionMessage("�޸Ŀγ��������Ȩ��ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ��ȡĳ��ʦ�Ŀγ�
	 * 
	 * @return
	 */
	public String findMyCoursesList() {
		setMyCoursesList(courseService.findCoursesByTeacher(super.getTeacher()
				.getId(), type));
		return SUCCESS;
	}
	
	/**
	 * ��ȡĳ��ʦ�Ŀγ�
	 * 
	 * @return
	 */
	public String goSetCoursePopedom() {
		course =courseService.getCourseById(courseId);
		if(course !=null){
			popedom = course.getPopedom();
			return SUCCESS;
		}else{
			addActionMessage("�ÿγ̲����ڣ�");
			return ERROR;
		}
		
	}

	/**
	 * �鿴�γ���ϸ��Ϣ
	 * 
	 * @return
	 */
	public String goEidtCourse() {
		course = courseService.getCourseById(courseId);
		return SUCCESS;
	}

	/**
	 * ���¿γ�
	 * 
	 * @return
	 */
	public String updateCourseVisible() {
		// 0:�����û�,1:ѧ����ͬ�к�ר��,2:ͬ�к�ר��,3:��ר��,4:���Լ�
		int visible = course.getVisible();
		course = courseService.getCourseById(course.getId());
		course.setVisible(visible);
		if (courseService.updateCourse(course))
			return SUCCESS;
		else
			return ERROR;
	}

	/**
	 * ��ȡĳ��ʦ�Ŀγ�
	 * 
	 * @return
	 */
	public String findMyCoursesListInLeft() {
		setMyCoursesList(courseService.findCoursesByTeacher(super.getTeacher()
				.getId(), type));
		if (getMyCoursesList().size() == 0) {
			return null;
		} else
			return SUCCESS;
	}

	/**
	 * ɾ���γ�
	 * 
	 * @return
	 */
	public String deleteCourse() {
		Course deleteCourse = courseService.getCourseById(courseId);
		if (courseService.deleteCourse(deleteCourse)) {
			return SUCCESS;
		} else {
			addActionError("ɾ���γ�ʧ��,�����²�����");
			return ERROR;
		}
	}

	/**
	 * ���ÿγ̷��
	 * 
	 * @return
	 */
	public String setCourseStyle() {
		Course course = courseService.getCourseById(courseId);
		int length = style.length();
		course.setStyle(style.substring(0, length - 1));
		String str = style.substring(length - 1);
		if (str.equals("t"))
			course.setHeader("header.jsp");
		else if (str.equals("d"))
			course.setHeader("header_dock.jsp");
		else
			course.setHeader("header_sand.jsp");
		if (courseService.updateCourse(course)) {
			addActionMessage("���÷��ɹ���");
			return SUCCESS;
		} else {
			addActionError("���ÿγ̷��ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ��ת�����ÿγ̷��ҳ��
	 * 
	 * @return
	 */
	public String goSetCourseStyle() {
		Course course = courseService.getCourseById(courseId);
		if (course.getStatus() == 2) {
			addActionError("���Ŀγ���δͨ����ˣ�Ŀǰ�޷����ÿγ̷��");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * ��ȡ����γ��б�
	 * 
	 * @return
	 */
	public String findApplicationCourse() {
		Administrator admin = super.getAdmin();
		School school = admin.getSchool();
		applicationCourseList = courseService.findApplicationCourse(school);
		if (applicationCourseList.size() == 0) {
			addActionError("�������걨�γ̣�");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * �鿴�γ���ϸ��Ϣ
	 * 
	 * @return
	 */
	public String courseDetail() {
		course = courseService.getCourseById(courseId);
		if (course == null) {
			addActionError("�ÿγ̲����ڣ������²�����");
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * ��˿γ�ͨ��
	 * 
	 * @return
	 */
	public String coursePass() {
		course = courseService.getCourseById(course.getId());
		course.setStatus(1);
		course.setRefuseReason(refuseReason);
		boolean result = courseService.updateCourse(course);
		if (result) {
			this.findCourse();
			addActionError(course.getName() + "�γ�ͨ����ˣ�");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��˿γ�δͨ��
	 * 
	 * @return
	 */
	public String courseNoPass() {
		course = courseService.getCourseById(course.getId());
		course.setStatus(2);
		course.setRefuseReason(refuseReason);
		boolean result = courseService.updateCourse(course);
		if (result) {
			addActionError(course.getName() + "�γ���˺��˻أ�");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ȡѧԺ�γ��б�
	 * 
	 * @return
	 */
	public String findCourse() {
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findBySchool(school);
		if (applicationCourseList.size() == 0) {
			addActionError("���޿γ̣�");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * ��ȡѧԺ�˻ؿγ��б�
	 * 
	 * @return
	 */
	public String findNoPassCourse() {
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findNoPassCourse(school);
		if (applicationCourseList.size() == 0) {
			addActionError("�����˻ؿγ̣�");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * ���浱ǰ�γ�
	 * 
	 * @return
	 */
	public String saveCurrentCourse() {
		Course currentCourse = courseService.getCourseById(courseId);
		if (currentCourse.getStatus() == 1) {
			super.getSession().put(COURSE, currentCourse);
			return SUCCESS;
		} else {
			addActionError("�ÿγ�δͨ����ˣ�����ϵ��ѧ��������ش���");
			return ERROR;
		}
	}
	
	/**
	 * ��ʦ��ת����������
	 * @return
	 */
	public String goAddNewTopicByTea(){
		setMyCoursesList(courseService.findCoursesByTeacher(super.getTeacher()
				.getId(), 1));
		if (getMyCoursesList().size() < 0) {
			addActionError("�㻹δ����κογ̣�����������ԣ�");
			return ERROR;
		} else
			return SUCCESS;		
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public IDepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String getRefuseReason() {
		return refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

	public void setMyCoursesList(List<Course> myCoursesList) {
		this.myCoursesList = myCoursesList;
	}

	public List<Course> getMyCoursesList() {
		return myCoursesList;
	}

	public List<Course> getApplicationCourseList() {
		return applicationCourseList;
	}

	public void setApplicationCourseList(List<Course> applicationCourseList) {
		this.applicationCourseList = applicationCourseList;
	}

	public void setPopedom(Popedom popedom) {
		this.popedom = popedom;
	}

	public Popedom getPopedom() {
		return popedom;
	}
}
