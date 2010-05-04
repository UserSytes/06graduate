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
 * 查找课程
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
	 * 通过院系查找
	 * 
	 * @return
	 */

	public String findCourseByDepartment() {
		Department dept = departmentService.getDepartmentById(Integer
				.parseInt(departmentId));
		setCourseList(searchCourseService.findCourseByDepartment(dept));
		if (getCourseList().size() == 0) {
			addActionError("未找到该课程，请返回重新搜索！");
			return ERROR;
		} else
			return "courses";
	}

	/**
	 * 通过名称查找
	 * 
	 * @return
	 */
	public String findCourseByName() {
		courseList = searchCourseService.findCourseByName(courseName);
		System.out.println("查找课程" + courseName);
		if (courseList.size() == 0) {
			addActionError("未找到该课程，请返回重新搜索！");
			return ERROR;
		} else
			return "courses";
	}

	/**
	 * 根据课程名称或者教师姓名的关键字查找
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
			addActionMessage("一共找到 0 门相关课程！");
		} else
			addActionMessage("一共找到 " + courseList.size() + " 门相关课程！");
		return SUCCESS;
	}

	public String superSearchCourse() {

		if (departmentId.equals("-1")) {
			if (courseName.equals(""))
				// 按教师姓名搜索
				courseList = searchCourseService
						.findCourseByTeacher(teacherName);
			else {
				if (teacherName.equals(""))
					// 按课程名称搜索
					courseList = searchCourseService
							.findCourseByName(courseName);
				else
					// 按课程名和教师名搜索
					courseList = searchCourseService
							.findCourseByNameAndTeacher(courseName, teacherName);
			}
		} else {
			Department dept = departmentService.getDepartmentById(Integer
					.parseInt(departmentId));
			if (courseName.equals("")) {
				if (teacherName.equals("")) // 按系搜索
					courseList = searchCourseService
							.findCourseByDepartment(dept);
				else
					// 按教师和系搜索
					courseList = searchCourseService
							.findCourseByDepartmentAndTeacher(teacherName, dept);
			} else {
				if (teacherName.equals("")) // 按课程名称和系搜索
					courseList = searchCourseService
							.findCourseByNameAndDepartment(courseName, dept);
				else
					// 按课程名、系、教师搜索
					courseList = searchCourseService
							.findCourseByNameAndDepartmentAndTeacher(
									courseName, dept, teacherName);
			}
		}

		if (courseList == null) {
			addActionMessage("一共找到 0 门相关课程！");
		} else
			addActionMessage("一共找到 " + courseList.size() + " 门相关课程！");
		return SUCCESS;
	}

	/**
	 * 通过教师查找
	 * 
	 * @return
	 */
	public String findCourseByTeacher() {
		courseList = searchCourseService.findCourseByTeacher(teacherName);
		if (courseList.size() == 0) {
			addActionError("未找到该课程，请返回重新搜索！");
			return ERROR;
		} else
			return "courses";
	}

	/**
	 * 进入课程
	 * 
	 * @return
	 */
	public String enterCourse() {
		course = searchCourseService.findCourseById(courseId);
		if (course == null) {
			addActionError("未找到该课程！");
			return ERROR;
		} else if (course.getVisible() == 1) {
			if (null == super.getEvaluation() && null == super.getStudent()) {
				addActionError("对不起，该课程目前仅对学生、同行和专家开放。已有帐号请先登录！");
				return ERROR;
			}
		} else if (course.getVisible() == 2) {
			if (null == super.getEvaluation()) {
				addActionError("对不起，该课程目前仅对同行和专家开放。己有帐户请先登录 ！");
				return ERROR;
			}
		} else if (course.getVisible() == 3) {
			Evaluation eva = super.getEvaluation();
			if (eva == null || eva.getSort() == 0) {
				addActionError("对不起，该课程目前仅对专家开放。己有帐户请先登录 ！");
				return ERROR;
			}
		} else if (course.getVisible() == 4) {
			if (super.getTeacher() == null
					|| super.getTeacher() != course.getTeacher()) {
				addActionError("对不起，该课程目前不对用户开放!");
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
	 * 查找最新三天课程
	 * 
	 * @return
	 */
	public String lastThreeDaysCourse() {
		courseList = searchCourseService.findCourseByDate(3);
		imageNum = 1;
		if (courseList == null) {
			addActionMessage("最近三天未发布新课程！");
		} else
			addActionMessage("最近三天一共发布 " + courseList.size() + " 门课程！");
		return SUCCESS;
	}

	/**
	 * 查找最新一周课程
	 * 
	 * @return
	 */
	public String lastWeekCourse() {
		courseList = searchCourseService.findCourseByDate(7);
		imageNum = 2;
		if (courseList == null) {
			addActionMessage("最近一周未发布新课程！");
		} else
			addActionMessage("最近一周一共发布 " + courseList.size() + " 门课程！");
		return SUCCESS;
	}

	/**
	 * 查找最近一个月课程
	 * 
	 * @return
	 */
	public String lastMonthCourse() {
		courseList = searchCourseService.findCourseByDate(30);
		imageNum = 3;
		if (courseList == null) {
			addActionMessage("最近一个月未发布新课程！");
		} else
			addActionMessage("最近一个月一共发布 " + courseList.size() + " 门课程！");
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
