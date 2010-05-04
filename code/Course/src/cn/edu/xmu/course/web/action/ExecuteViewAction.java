package cn.edu.xmu.course.web.action;

import java.util.List;

import org.apache.struts2.config.Namespace;

import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.IApplicationFormService;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.IDepartmentService;
import cn.edu.xmu.course.service.ISearchCourseService;

/**
 * ���ҿγ�
 * 
 * @author
 * 
 */
public class ExecuteViewAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Department department;
	private String departmentId;
	private String courseName;
	private int courseId;
	private List<Course> courseList;
	private Course course;
	private String teacherName;

	private ICourseService courseService;
	private ISearchCourseService searchCourseService;
	private IDepartmentService departmentService;
	private int flag;
	private String keyword;
	private int imageNum = 1;

	/**
	 * ͨ��Ժϵ����
	 * 
	 * @return
	 */

	public String findCourseByDepartment() {
		Department dept = departmentService.getDepartmentById(Integer
				.parseInt(departmentId));
		setCourseList(searchCourseService.findCourseByDepartment(dept));
		if (getCourseList().size() == 0) {
			addActionError("δ�ҵ��ÿγ̣��뷵������������");
			return ERROR;
		} else
			return "courses";
	}

	/**
	 * ͨ�����Ʋ���
	 * 
	 * @return
	 */
	public String findCourseByName() {
		courseList = searchCourseService.findCourseByName(courseName);
		System.out.println("���ҿγ�" + courseName);
		if (courseList.size() == 0) {
			addActionError("δ�ҵ��ÿγ̣��뷵������������");
			return ERROR;
		} else
			return "courses";
	}

	/**
	 * ���ݿγ����ƻ��߽�ʦ�����Ĺؼ��ֲ���
	 * 
	 * @return
	 */
	public String searchCourseByKeyword() {
		if (flag == 0) {
			courseList = searchCourseService.findCourseByName(keyword);
		} else {
			courseList = searchCourseService.findCourseByTeacher(keyword);
		}
		if (courseList == null) {
			addActionMessage("һ���ҵ� 0 ����ؿγ̣�");
		} else
			addActionMessage("һ���ҵ� " + courseList.size() + " ����ؿγ̣�");
		return SUCCESS;
	}

	public String superSearchCourse() {

		if (departmentId.equals("-1")) {
			if (courseName.equals(""))
				// ����ʦ��������
				courseList = searchCourseService
						.findCourseByTeacher(teacherName);
			else {
				if (teacherName.equals(""))
					// ���γ���������
					courseList = searchCourseService
							.findCourseByName(courseName);
				else
					// ���γ����ͽ�ʦ������
					courseList = searchCourseService
							.findCourseByNameAndTeacher(courseName, teacherName);
			}
		} else {
			Department dept = departmentService.getDepartmentById(Integer
					.parseInt(departmentId));
			if (courseName.equals("")) {
				if (teacherName.equals("")) // ��ϵ����
					courseList = searchCourseService
							.findCourseByDepartment(dept);
				else
					// ����ʦ��ϵ����
					courseList = searchCourseService
							.findCourseByDepartmentAndTeacher(teacherName, dept);
			} else {
				if (teacherName.equals("")) // ���γ����ƺ�ϵ����
					courseList = searchCourseService
							.findCourseByNameAndDepartment(courseName, dept);
				else
					// ���γ�����ϵ����ʦ����
					courseList = searchCourseService
							.findCourseByNameAndDepartmentAndTeacher(
									courseName, dept, teacherName);
			}
		}

		if (courseList == null) {
			addActionMessage("һ���ҵ� 0 ����ؿγ̣�");
		} else
			addActionMessage("һ���ҵ� " + courseList.size() + " ����ؿγ̣�");
		return SUCCESS;
	}

	/**
	 * ͨ����ʦ����
	 * 
	 * @return
	 */
	public String findCourseByTeacher() {
		courseList = searchCourseService.findCourseByTeacher(teacherName);
		if (courseList.size() == 0) {
			addActionError("δ�ҵ��ÿγ̣��뷵������������");
			return ERROR;
		} else
			return "courses";
	}

	/**
	 * ����γ�
	 * 
	 * @return
	 */
	public String enterCourse() {
		course = searchCourseService.findCourseById(courseId);
		if (course == null) {
			addActionError("δ�ҵ��ÿγ̣�");
			return ERROR;
		} else if (course.getVisible() == 1) {
			if (null == super.getEvaluation() && null == super.getStudent()) {
				addActionError("�Բ��𣬸ÿγ�Ŀǰ����ѧ����ͬ�к�ר�ҿ��š������ʺ����ȵ�¼��");
				return ERROR;
			}
		} else if (course.getVisible() == 2) {
			if (null == super.getEvaluation()) {
				addActionError("�Բ��𣬸ÿγ�Ŀǰ����ͬ�к�ר�ҿ��š������ʻ����ȵ�¼ ��");
				return ERROR;
			}
		} else if (course.getVisible() == 3) {
			Evaluation eva = super.getEvaluation();
			if (eva == null || eva.getSort() == 0) {
				addActionError("�Բ��𣬸ÿγ�Ŀǰ����ר�ҿ��š������ʻ����ȵ�¼ ��");
				return ERROR;
			}
		} else if (course.getVisible() == 4) {
			if (super.getTeacher() == null
					|| super.getTeacher() != course.getTeacher()) {
				addActionError("�Բ��𣬸ÿγ�Ŀǰ�����û�����!");
				return ERROR;
			}
		}
		course.setCount(course.getCount() + 1);
		courseService.updateCourse(course);
		super.getSession().put(COURSE, course);
		super.getSession().put("style", course.getStyle());
		super.getSession().put("header", course.getHeader());
		if (course.getHeader().equals("header_sand.jsp")) {
			super.getSession().put("sort", "sorttype");
			super.getSession().put("filtercon", "allcon");
		}
		return "course";
	}
	
	

	/**
	 * ������������γ�
	 * 
	 * @return
	 */
	public String lastThreeDaysCourse() {
		courseList = searchCourseService.findCourseByDate(3);
		imageNum = 1;
		if (courseList == null) {
			addActionMessage("�������δ�����¿γ̣�");
		} else
			addActionMessage("�������һ������ " + courseList.size() + " �ſγ̣�");
		return SUCCESS;
	}

	/**
	 * ��������һ�ܿγ�
	 * 
	 * @return
	 */
	public String lastWeekCourse() {
		courseList = searchCourseService.findCourseByDate(7);
		imageNum = 2;
		if (courseList == null) {
			addActionMessage("���һ��δ�����¿γ̣�");
		} else
			addActionMessage("���һ��һ������ " + courseList.size() + " �ſγ̣�");
		return SUCCESS;
	}

	/**
	 * �������һ���¿γ�
	 * 
	 * @return
	 */
	public String lastMonthCourse() {
		courseList = searchCourseService.findCourseByDate(30);
		imageNum = 3;
		if (courseList == null) {
			addActionMessage("���һ����δ�����¿γ̣�");
		} else
			addActionMessage("���һ����һ������ " + courseList.size() + " �ſγ̣�");
		return SUCCESS;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public ISearchCourseService getSearchCourseService() {
		return searchCourseService;
	}

	public void setSearchCourseService(ISearchCourseService searchCourseService) {
		this.searchCourseService = searchCourseService;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public IDepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getFlag() {
		return flag;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setImageNum(int imageNum) {
		this.imageNum = imageNum;
	}

	public int getImageNum() {
		return imageNum;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

}
