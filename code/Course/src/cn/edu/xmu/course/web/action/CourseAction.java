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
import cn.edu.xmu.course.service.ISuperAdminService;
import cn.edu.xmu.course.service.ITeacherInfoService;

/**
 * 负责管理员、教师管理课程的类
 * @author 何申密
 * @author 郑冰凌
 * 
 */
public class CourseAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1435933948873647769L;
	private String departmentId;	//系的id
	private int courseId;	//课程id
	private Department department;	//系
	private Teacher teacher;	//教师
	private Course course;	//课程
	private List<Course> myCoursesList;	//我（教师）的课程列表
	private int type = 3;	//课程状态标识，3:通过审核的课程
	private String style; //课程风格颜色 

	private ISuperAdminService superAdminService;	//负责管理校方管理员的接口
	private ITeacherInfoService teacherInfoService;	//管理教师信息的接口
	private IStudentCourseService studentCourseService;	//管理学生课程信息的接口
	private ICourseService courseService;	//管理课程的接口
	private IDepartmentService departmentService;	//管理系的接口

	private List<Course> applicationCourseList;	//申报课程列表
	private List<Student> studentList;	//学生列表
	private Student student;	//学生
	private int studentId;	//学生id
	private String studentNo;	//学生学号、帐号
	private String refuseReason;	//审核课程退回时填写的理由
	private String gradeId;	//学生年级id
	private List<Grade> gradeList;	//学生年级列表
	private List<Department> departmentList;	//系列表

	private File studentFile;	//学生帐号文件
	private String studentFileContentType;	//学生帐号文件类型
	private String studentFileName;	//学生帐号文件名
		

	/**
	 * 申报课程
	 * @return
	 */
	public String addNewCourse() {
		Department dept = departmentService.getDepartmentById(Integer
				.parseInt(departmentId));		
		if (getCourseService().addCourse(course, dept, super.getTeacher())) {
			addActionMessage("申报课程成功！");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 获取某教师的课程
	 * @return
	 */
	public String findMyCoursesList() {		
		myCoursesList = courseService.findCoursesByTeacher(super.getTeacher().getId(), type);
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
		myCoursesList = courseService.findCoursesByTeacher(super.getTeacher().getId(), type);
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
		} else{
			addActionError("删除课程失败,请重新操作！");
			return ERROR;}
	}
	
	/**
	 * 设置课程风格
	 * @return
	 */
	public String setCourseStyle(){
		Course course = courseService.getCourseById(courseId);
		int length = style.length();
		course.setStyle(style.substring(0,length-1));
		String str = style.substring(length-1);
		if(str.equals("t"))
			course.setHeader("header.jsp");
		else if(str.equals("d"))
			course.setHeader("header_dock.jsp");
		else course.setHeader("header_sand.jsp");
		if(courseService.updateCourse(course)){
			addActionMessage("设置风格成功！");
			return SUCCESS;
		}
		else {
			addActionError("设置课程风格失败，请重新操作！");
			return ERROR;
		}
	}
	
	/**
	 * 跳转到设置课程风格页面
	 * @return
	 */
	public String goSetCourseStyle(){
		Course course = courseService.getCourseById(courseId);
		if(course.getStatus()==2){
			addActionError("您的课程暂未通过审核，目前无法设置课程风格！");
			return ERROR;
		}
		return SUCCESS;
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
		System.out.println("the courseId is"+courseId);
		List<StudentCourse> scList = studentCourseService.findByCourse(course);
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
	 * 跳转到批量删除学生课程
	 * @return
	 */
	public String goDeleteMoreStudentCourse(){
		course = courseService.getCourseById(course.getId());
		Administrator admin = (Administrator) super.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		gradeList = superAdminService.findAllGrade();
		departmentList = superAdminService.findDepartmentBySchool(school);
		return SUCCESS;
	}
	
	/**
	 * 批量删除学生课程
	 * @return
	 */
	public String deleteMoreStudent(){
		course = courseService.getCourseById(course.getId());
		boolean result = studentCourseService.deleteMoreSudentCourse(course, departmentId, gradeId);
		if(result){
			addActionMessage("成功从"+course.getName()+"课程中删除选定学生！");
		}else{
			addActionError("从"+course.getName()+"课程中删除学生失败，请重新删除！");
		}
		return SUCCESS;
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
	
	/**
	 * 查看课程详细信息
	 * @return
	 */
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

	/**
	 * 保存当前课程
	 * @return
	 */
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

	public ISuperAdminService getSuperAdminService() {
		return superAdminService;
	}

	public void setSuperAdminService(ISuperAdminService superAdminService) {
		this.superAdminService = superAdminService;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public List<Grade> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<Grade> gradeList) {
		this.gradeList = gradeList;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getStyle() {
		return style;
	}

}
