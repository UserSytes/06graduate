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
 * 查找课程和执行查看操作的类
 * @author 许子彦
 * @author 何申密
 * 
 */
public class ExecuteViewAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Department department; // 系
	private String departmentId; // 系ID
	private String courseName; // 课程名称
	private int courseId; // 课程ID
	private List<Course> courseList; // 课程列表
	private Course course; // 课程
	private String teacherName; // 教师名称

	private ICourseService courseService; // 负责课程的接口
	private ISearchCourseService searchCourseService; // 负责搜索课程的接口
	private IDepartmentService departmentService; // 负责系的接口
	private ISchoolService schoolService; // 负责学院的接口
	private int flag; // 搜索类型
	private String keyword; // 搜索关键字
	private int imageNum = 1; // 图片标示

	private String schoolName; // 学院名字
	private String deptName; // 系名字

	/**
	 * 根据学院名字查找课程，学院树用到的方法
	 * 
	 * @return
	 */
	public String findCourseListBySchoolName() {
		System.out.println("the schoolName is " + schoolName);
		School school = schoolService.findSchoolByName(schoolName);
		if (school == null) {
			addActionMessage("该学院不存在，请重新操作！");
		} else {
			courseList = courseService.findBySchool(school);
			if (courseList == null) {
				addActionMessage("一共找到 0 门相关课程！");
			} else
				addActionMessage("一共找到 " + courseList.size() + " 门相关课程！");
		}
		return SUCCESS;
	}

	/**
	 * 根据系别名字查找课程，学院树用到的方法
	 * 
	 * @return
	 */
	public String findCourseListByDeptName() {
		Department dept = departmentService.getDepartmentByName(deptName);
		if (dept == null) {
			addActionMessage("该系别不存在，请重新操作！");
		} else {
			courseList = searchCourseService.findCourseByDepartment(dept);
			if (courseList == null) {
				addActionMessage("一共找到 0 门相关课程！");
			} else
				addActionMessage("一共找到 " + courseList.size() + " 门相关课程！");
		}
		return SUCCESS;
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
	@SuppressWarnings("unchecked")
	public String enterCourse() {
		this.courseId = courseId;
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
