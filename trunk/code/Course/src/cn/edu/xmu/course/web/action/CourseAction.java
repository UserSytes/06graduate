package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xmu.course.pojo.*;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.IDepartmentService;
import cn.edu.xmu.course.service.IStudentCourseService;
import cn.edu.xmu.course.service.IStudentInfoService;
import cn.edu.xmu.course.service.ITeacherInfoService;

/**
 * 
 * @author 何申密
 * @author 郑冰凌
 * 
 */
public class CourseAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1435933948873647769L;
	private String departmentId;
	private int courseId;
	private Department department;
	private Teacher teacher;
	private Course course;
	private List<Course> myCoursesList;
	private int type = 3;

	private ITeacherInfoService teacherInfoService;
	private IStudentCourseService studentCourseService;
	private ICourseService courseService;
	private IDepartmentService departmentService;

	private List<Course> applicationCourseList;
	private List<Student> studentList;
	private Student student;
	private int studentId;
	private String studentNo;
	private String refuseReason;

	private File studentFile;
	private String studentFileContentType;
	private String studentFileName;
	
	private final String userName = "123";

	/**
	 * 申报课程
	 * 
	 * @return
	 */
	public String addNewCourse() {
		Department dept = departmentService.getDepartmentById(Integer
				.parseInt(departmentId));
		Teacher tea = teacherInfoService.getTeacher(userName);
		if (getCourseService().addCourse(course, dept, tea)) {
			addActionMessage("申报课程成功！");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 获取某教师的课程
	 * 
	 * @return
	 */
	public String findMyCoursesList() {
		Teacher tea = teacherInfoService.getTeacher(userName);
		myCoursesList = courseService.findCoursesByTeacher(tea.getId(), type);
		System.out.println(type);
		return SUCCESS;
	}
	
	/**
	 * 查看课程详细信息
	 * @return
	 */
	public String goEidtCourse(){
		course = courseService.getCourseById(courseId);
		return SUCCESS;
	}
	
	/**
	 * 更新课程
	 * @return
	 */
	public String updateCourseVisible(){
		int visible = course.getVisible();
		course=courseService.getCourseById(course.getId());
		course.setVisible(visible);
		if(courseService.updateCourse(course))
			return SUCCESS;
		else return ERROR;
	}

	/**
	 * 获取某教师的课程
	 * 
	 * @return
	 */
	public String findMyCoursesListInLeft() {
		Teacher tea = teacherInfoService.getTeacher(userName);
		myCoursesList = courseService.findCoursesByTeacher(tea.getId(), type);
		if (myCoursesList.size() == 0) {
			return null;
		} else
			return SUCCESS;
	}

	/**
	 * 删除课程
	 * 
	 * @return
	 */
	public String deleteCourse() {
		Course deleteCourse = courseService.getCourseById(courseId);
		if (courseService.deleteCourse(deleteCourse)) {
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 获取申请课程列表
	 * 
	 * @return
	 */
	public String findApplicationCourse() {
		Administrator admin = (Administrator) super.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findApplicationCourse(school);
		if (applicationCourseList.size() == 0) {
			addActionError("暂无新申报课程！");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * 获取某课程的所有学生
	 * 
	 * @return
	 */
	public String getStudentByCourse() {
		course = courseService.getCourseById(courseId);
		List<StudentCourse> scList = new ArrayList<StudentCourse>();
		scList = studentCourseService.findByCourse(course);
		if (scList.size() == 0) {
			addActionError("此课程暂未添加学生！");
			return ERROR;
		}
		studentList = new ArrayList<Student>();
		for (StudentCourse sc : scList) {
			studentList.add(sc.getStudent());
		}
		return SUCCESS;
	}
	
//	public String searchStudentByCourse(){
//		course = courseService.getCourseById(course.getId());
//		List<StudentCourse> scList = new ArrayList<StudentCourse>();
//		scList = studentCourseService.findByCourse(course);
//		studentList = new ArrayList<Student>();
//		for (StudentCourse sc : scList) {
//			student = sc.getStudent();
//			if(student.getStudentNo().)
//			studentList.add(student);
//		}
//	}

	/**
	 * 删除course的某位学生关系
	 * 
	 * @return
	 */
	public String deleteStudent() {
		student = studentCourseService.findStudentById(studentId);
		course = courseService.getCourseById(courseId);
		boolean result = studentCourseService.delete(course, student);
		if (result) {
			return SUCCESS;
		} else{
			addActionError("删除学生失败，请重新操作！");
			return ERROR;}
	}

	/**
	 * 为course添加学生
	 * 
	 * @return
	 */
	public String addStudentCourse() {
		StudentCourse studentCourse = new StudentCourse();
		course = courseService.getCourseById(course.getId());
		student = studentCourseService.findStudentByStudentNo(studentNo);
		boolean check = studentCourseService.checkStudent(course, student);
		if (!check) {
			addActionError("学生"+student.getUserInfo().getName()+"("+studentNo+") 已经加入该课程！不能重复加入。");
			return SUCCESS;
		}
		studentCourse.setCourse(course);
		studentCourse.setStudent(student);
		studentCourse.setStatus(0);
		boolean result = studentCourseService.addStudentCourse(studentCourse);
		if (result) {
			addActionError("添加学生成功！");
			return SUCCESS;
		} else{
			addActionError("添加学生失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 为course批量添加学生
	 * 
	 * @return
	 */
	public String addMoreStudentCourse() {
		course = courseService.getCourseById(course.getId());
		String result = studentCourseService.addMoreStudentCourse(course, studentFile);
		addActionError(result);
		return SUCCESS;
	}
	
	public String courseDetail() {
		course = courseService.getCourseById(courseId);
		if (course == null) {
			addActionError("该课程不存在，请重新操作！");
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * 审核课程通过
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
			addActionError(course.getName() + "课程通过审核！");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 审核课程未通过
	 * 
	 * @return
	 */
	public String courseNoPass() {
		course = courseService.getCourseById(course.getId());
		course.setStatus(2);
		course.setRefuseReason(refuseReason);
		boolean result = courseService.updateCourse(course);
		if (result) {
			addActionError(course.getName() + "课程审核后退回！");
			// this.findApplicationCourse();
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 获取学院课程列表
	 * 
	 * @return
	 */
	public String findCourse() {
		Administrator admin = (Administrator) super.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findBySchool(school);
		if (applicationCourseList.size() == 0) {
			addActionError("暂无课程！");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * 获取学院退回课程列表
	 * 
	 * @return
	 */
	public String findNoPassCourse() {
		Administrator admin = (Administrator) super.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findNoPassCourse(school);
		if (applicationCourseList.size() == 0) {
			addActionError("暂无退回课程！");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	public String saveCurrentCourse() {
		Course currentCourse = courseService.getCourseById(courseId);
		if (currentCourse.getStatus() == 1) {
			super.getSession().put(COURSE, currentCourse);
			return SUCCESS;
		}
		else{
			addActionError("该课程未通过审核，请联系教学秘书做相关处理！");
			return ERROR;
		}
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public IDepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setTeacherInfoService(ITeacherInfoService teacherInfoService) {
		this.teacherInfoService = teacherInfoService;
	}

	public ITeacherInfoService getTeacherInfoService() {
		return teacherInfoService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setMyCoursesList(List<Course> myCoursesList) {
		this.myCoursesList = myCoursesList;
	}

	public List<Course> getMyCoursesList() {
		return myCoursesList;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public List<Course> getApplicationCourseList() {
		return applicationCourseList;
	}

	public void setApplicationCourseList(List<Course> applicationCourseList) {
		this.applicationCourseList = applicationCourseList;
	}

	public int getCourseId() {
		return courseId;
	}

	public String getUserName() {
		return userName;
	}

	public String getRefuseReason() {
		return refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

	public IStudentCourseService getStudentCourseService() {
		return studentCourseService;
	}

	public void setStudentCourseService(
			IStudentCourseService studentCourseService) {
		this.studentCourseService = studentCourseService;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public File getStudentFile() {
		return studentFile;
	}

	public void setStudentFile(File studentFile) {
		this.studentFile = studentFile;
	}

	public String getStudentFileContentType() {
		return studentFileContentType;
	}

	public void setStudentFileContentType(String studentFileContentType) {
		this.studentFileContentType = studentFileContentType;
	}

	public String getStudentFileName() {
		return studentFileName;
	}

	public void setStudentFileName(String studentFileName) {
		this.studentFileName = studentFileName;
	}

}
