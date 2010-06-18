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
 * 负责管理员、教师管理课程的类
 * 
 * @author 何申密
 * @author 郑冰凌
 * 
 */
@SuppressWarnings("unchecked")
public class CourseAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1435933948873647769L;
	private String departmentId; // 系的id
	private int courseId; // 课程id
	private Course course; // 课程
	private List<Course> myCoursesList; // 我（教师）的课程列表
	private int type = 3; // 课程状态标识，3:所有课程
	private String style; // 课程风格颜色

	private ICourseService courseService; // 管理课程的接口
	private IDepartmentService departmentService; // 管理系的接口

	private List<Course> applicationCourseList; // 申报课程列表
	private String refuseReason; // 审核课程退回时填写的理由
	
	private Popedom popedom;
	
	/**
	 * 跳转到申报课程
	 * 
	 * @return
	 */
	public String goAddNewCourse() {
			return SUCCESS;
	}
	
	/**
	 * 申报课程
	 * 
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
	
	
	
	public String updateCoursePopedom(){
		if (courseService.updatePopedom(popedom)) {
			addActionMessage("修改课程内容浏览权限成功！");
			return SUCCESS;
		}
		else{
			addActionMessage("修改课程内容浏览权限失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 获取某教师的课程
	 * 
	 * @return
	 */
	public String findMyCoursesList() {
		setMyCoursesList(courseService.findCoursesByTeacher(super.getTeacher()
				.getId(), type));
		return SUCCESS;
	}
	
	/**
	 * 获取某教师的课程
	 * 
	 * @return
	 */
	public String goSetCoursePopedom() {
		course =courseService.getCourseById(courseId);
		if(course !=null){
			popedom = course.getPopedom();
			return SUCCESS;
		}else{
			addActionMessage("该课程不存在！");
			return ERROR;
		}
		
	}

	/**
	 * 查看课程详细信息
	 * 
	 * @return
	 */
	public String goEidtCourse() {
		course = courseService.getCourseById(courseId);
		return SUCCESS;
	}

	/**
	 * 更新课程
	 * 
	 * @return
	 */
	public String updateCourseVisible() {
		// 0:所有用户,1:学生、同行和专家,2:同行和专家,3:仅专家,4:仅自己
		int visible = course.getVisible();
		course = courseService.getCourseById(course.getId());
		course.setVisible(visible);
		if (courseService.updateCourse(course))
			return SUCCESS;
		else
			return ERROR;
	}

	/**
	 * 获取某教师的课程
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
	 * 删除课程
	 * 
	 * @return
	 */
	public String deleteCourse() {
		Course deleteCourse = courseService.getCourseById(courseId);
		if (courseService.deleteCourse(deleteCourse)) {
			return SUCCESS;
		} else {
			addActionError("删除课程失败,请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 设置课程风格
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
			addActionMessage("设置风格成功！");
			return SUCCESS;
		} else {
			addActionError("设置课程风格失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 跳转到设置课程风格页面
	 * 
	 * @return
	 */
	public String goSetCourseStyle() {
		Course course = courseService.getCourseById(courseId);
		if (course.getStatus() == 2) {
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
		Administrator admin = super.getAdmin();
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
	 * 查看课程详细信息
	 * 
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
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
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
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
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
	 * 
	 * @return
	 */
	public String saveCurrentCourse() {
		Course currentCourse = courseService.getCourseById(courseId);
		if (currentCourse.getStatus() == 1) {
			super.getSession().put(COURSE, currentCourse);
			return SUCCESS;
		} else {
			addActionError("该课程未通过审核，请联系教学秘书做相关处理！");
			return ERROR;
		}
	}
	
	/**
	 * 教师跳转到发布新贴
	 * @return
	 */
	public String goAddNewTopicByTea(){
		setMyCoursesList(courseService.findCoursesByTeacher(super.getTeacher()
				.getId(), 1));
		if (getMyCoursesList().size() < 0) {
			addActionError("你还未添加任何课程，不能添加留言！");
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
