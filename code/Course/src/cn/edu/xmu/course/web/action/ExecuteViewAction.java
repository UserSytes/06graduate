package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.IDepartmentService;
import cn.edu.xmu.course.service.ISchoolService;
import cn.edu.xmu.course.service.ISearchCourseService;

/**
 * ���ҿγ̺�ִ�в鿴��������
 * @author ������
 * @author ������
 * 
 */
public class ExecuteViewAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Department department; // ϵ
	private String departmentId; // ϵID
	private String courseName; // �γ�����
	private int courseId; // �γ�ID
	private List<Course> courseList; // �γ��б�
	private Course course; // �γ�
	private String teacherName; // ��ʦ����

	private ICourseService courseService; // ����γ̵Ľӿ�
	private ISearchCourseService searchCourseService; // ���������γ̵Ľӿ�
	private IDepartmentService departmentService; // ����ϵ�Ľӿ�
	private ISchoolService schoolService; // ����ѧԺ�Ľӿ�
	private int flag; // ��������
	private String keyword; // �����ؼ���
	private int imageNum = 1; // ͼƬ��ʾ

	private String schoolName; // ѧԺ����
	private String deptName; // ϵ����

	/**
	 * ����ѧԺ���ֲ��ҿγ̣�ѧԺ���õ��ķ���
	 * 
	 * @return
	 */
	public String findCourseListBySchoolName() {
		System.out.println("the schoolName is " + schoolName);
		School school = schoolService.findSchoolByName(schoolName);
		if (school == null) {
			addActionMessage("��ѧԺ�����ڣ������²�����");
		} else {
			courseList = courseService.findBySchool(school);
			if (courseList == null) {
				addActionMessage("һ���ҵ� 0 ����ؿγ̣�");
			} else
				addActionMessage("һ���ҵ� " + courseList.size() + " ����ؿγ̣�");
		}
		return SUCCESS;
	}

	/**
	 * ����ϵ�����ֲ��ҿγ̣�ѧԺ���õ��ķ���
	 * 
	 * @return
	 */
	public String findCourseListByDeptName() {
		Department dept = departmentService.getDepartmentByName(deptName);
		if (dept == null) {
			addActionMessage("��ϵ�𲻴��ڣ������²�����");
		} else {
			courseList = searchCourseService.findCourseByDepartment(dept);
			if (courseList == null) {
				addActionMessage("һ���ҵ� 0 ����ؿγ̣�");
			} else
				addActionMessage("һ���ҵ� " + courseList.size() + " ����ؿγ̣�");
		}
		return SUCCESS;
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
	@SuppressWarnings("unchecked")
	public String enterCourse() {
		this.courseId = courseId;
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

	public void setschoolService(ISchoolService schoolService) {
		this.schoolService = schoolService;
	}

	public ISchoolService getschoolService() {
		return schoolService;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
