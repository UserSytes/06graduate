package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Collection;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.IStudentCourseService;
import cn.edu.xmu.course.service.ISchoolService;
/**
 * 负责管理员、教师管理课程学生的类
 * @author 何申密
 * @author 郑冰凌
 * 
 */
public class StudentCourseAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4565394952959955957L;
	private int courseId;	//课程id
	private String departmentId;	//系的id
	private Course course;	//课程
	
	private ISchoolService schoolService;	//负责管理院系、年级的接口
	private IStudentCourseService studentCourseService;	//管理学生课程信息的接口
	private ICourseService courseService;	//管理课程的接口
	
	
	private Student student;	//学生
	private int studentId;	//学生id
	private String studentNo;	//学生学号、帐号
	private String gradeId;	//学生年级id
	
	private List<Student> studentList;	//学生列表
	private List<Grade> gradeList;	//学生年级列表
	private List<Department> departmentList;	//系列表
	private List<Course> courseList;	//课程列表
	
	private File studentFile;	//学生帐号文件

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
	@SuppressWarnings("unchecked")
	public String goDeleteMoreStudentCourse(){
		course = courseService.getCourseById(course.getId());
		Administrator admin = (Administrator) super.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		gradeList = schoolService.findAllGrade();
		departmentList = schoolService.findDepartmentBySchool(school);
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
	 * 查找我的课程
	 * 
	 * @return
	 */
	public String findMyCourses() {
		student = (Student) super.getSession().get(STUDENT);
		List<StudentCourse> studentCourses = new ArrayList<StudentCourse>();
		studentCourses = studentCourseService.findByStudent(student);
		if (studentCourses.size() == 0) {
			addActionError("您暂无课程！");
			return SUCCESS;
		}
		courseList = new ArrayList<Course>();
		for (StudentCourse sc : studentCourses) {
			courseList.add(sc.getCourse());
		}
		return SUCCESS;
	}

	/**
	 * 查找我的收藏课程
	 * 
	 * @return
	 */
	public String findMyCollection() {
		student = (Student) super.getSession().get(STUDENT);
		List<Collection> collections = new ArrayList<Collection>();
		collections = studentCourseService.findCollectionByStudent(student);
		if (collections.size() == 0) {
			addActionError("您暂未收藏任何课程！");
			return SUCCESS;
		}
		courseList = new ArrayList<Course>();
		for (Collection c : collections) {
			courseList.add(c.getCourse());
		}
		return SUCCESS;
	}

	/**
	 * 删除收藏课程
	 * 
	 * @return
	 */
	public String deleteCollection() {
		student = (Student) super.getSession().get(STUDENT);
		course = courseService.getCourseById(courseId);
		boolean result = studentCourseService.deleteCollection(student, course);
		if (result) {
			this.findMyCollection();
			return SUCCESS;
		} else
			return ERROR;

	}
	
	/**
	 * 添加收藏课程
	 * @return
	 */
	public String addCollection(){
		student = super.getStudent();
		if(student == null)
			return "collogin";
		course = super.getCourse();
		Collection col =studentCourseService.findCollectionByStu(student, course);
		if(col == null){
			if(studentCourseService.addCollection(student, course)){
				addActionMessage("恭喜您，收藏"+course.getName()+"课程成功!");
			}
			else{
				addActionError("收藏"+course.getName()+"课程失败，请重新操作!");
				return ERROR;
			}
		}
		else{
			addActionError("您已经收藏过了"+course.getName()+"这门课程。");
		}
		return SUCCESS;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public ISchoolService getschoolService() {
		return schoolService;
	}

	public void setschoolService(ISchoolService schoolService) {
		this.schoolService = schoolService;
	}

	public IStudentCourseService getStudentCourseService() {
		return studentCourseService;
	}

	public void setStudentCourseService(IStudentCourseService studentCourseService) {
		this.studentCourseService = studentCourseService;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
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

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
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

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public File getStudentFile() {
		return studentFile;
	}

	public void setStudentFile(File studentFile) {
		this.studentFile = studentFile;
	}

	
	
}
