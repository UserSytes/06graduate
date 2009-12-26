package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.*;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.IDepartmentService;
import cn.edu.xmu.course.service.ITeacherInfoService;
/**
 * 
 * @author 何申密
 * @author 郑冰凌
 *
 */
public class CourserAction extends BaseAction {

	private String departmentId;
	private int courseId;
	private Department department;
	private Teacher teacher;
	private Course course;
	private List<Course> myCoursesList;
	private int type=2;

	private ITeacherInfoService teacherInfoService;
	private ICourseService courseService;
	private IDepartmentService departmentService;
	
	private List<Course> applicationCourseList;

	private final String userName = "123";

	/**
	 * 申报课程
	 * @return
	 */
	public String addNewCourse() {
		Department dept = departmentService.getDepartmentById(Integer
				.parseInt(departmentId));
		Teacher tea = teacherInfoService.getTeacher(userName);
		if (getCourseService().addCourse(course, dept,tea)){
			addActionMessage("申报课程成功！"); 
			return SUCCESS;
		}
		else
			return ERROR;
	}
	
	/**
	 * 获取某教师的课程
	 * @return
	 */
	public String findMyCoursesList(){
		Teacher tea = teacherInfoService.getTeacher(userName); 
		myCoursesList = courseService.findCoursesByTeacher(tea.getId(), type);
		if(myCoursesList.size()==0){
			addActionError("暂无任何课程！");
			return ERROR;
		}
		else 
			return SUCCESS;
	}
	
	/**
	 * 删除课程
	 * @return
	 */
	public String deleteCourse(){
		Course deleteCourse = courseService.getCourseById(courseId);
		if(courseService.deleteCourse(deleteCourse)){
			return SUCCESS;
		}
		else 
			return ERROR;
	}
	
	/**
	 * 获取申请课程列表
	 * @return
	 */
	public String findApplicationCourse(){
		Administrator admin = (Administrator) ActionSession.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findApplicationCourse(school);
		if(applicationCourseList.size()==0){
			addActionError("暂无新申报课程！");
			return ERROR;
		}else{
			return SUCCESS;
		}
	}

	/**
	 * 审核课程通过
	 * @return
	 */
	public String coursePass(){
		course = courseService.getCourseById(courseId);
		course.setStatus(1);
		boolean result = courseService.updateCourse(course);
		if(result){
			this.findApplicationCourse();
			return SUCCESS;
		}else
			return ERROR;
	}
	
	/**
	 * 审核课程未通过
	 * @return
	 */
	public String courseNoPass(){
		course = courseService.getCourseById(courseId);
		course.setStatus(2);
		boolean result = courseService.updateCourse(course);
		if(result){
			this.findApplicationCourse();
			return SUCCESS;
		}else
			return ERROR;
	}
	
	/**
	 * 获取学院课程列表
	 * @return
	 */
	public String findCourse(){
		Administrator admin = (Administrator) ActionSession.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findBySchool(school);
		if(applicationCourseList.size()==0){
			addActionError("暂无课程！");
			return ERROR;
		}else{
			return SUCCESS;
		}
	}
	
	/**
	 * 获取学院退回课程列表
	 * @return
	 */
	public String findNoPassCourse(){
		Administrator admin = (Administrator) ActionSession.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findNoPassCourse(school);
		if(applicationCourseList.size()==0){
			addActionError("暂无退回课程！");
			return ERROR;
		}else{
			return SUCCESS;
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


}
