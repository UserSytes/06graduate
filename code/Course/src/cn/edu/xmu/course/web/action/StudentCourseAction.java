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
 * �������Ա����ʦ����γ�ѧ������
 * @author ������
 * @author ֣����
 * 
 */
public class StudentCourseAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4565394952959955957L;
	private int courseId;	//�γ�id
	private String departmentId;	//ϵ��id
	private Course course;	//�γ�
	
	private ISchoolService schoolService;	//�������Ժϵ���꼶�Ľӿ�
	private IStudentCourseService studentCourseService;	//����ѧ���γ���Ϣ�Ľӿ�
	private ICourseService courseService;	//����γ̵Ľӿ�
	
	
	private Student student;	//ѧ��
	private int studentId;	//ѧ��id
	private String studentNo;	//ѧ��ѧ�š��ʺ�
	private String gradeId;	//ѧ���꼶id
	
	private List<Student> studentList;	//ѧ���б�
	private List<Grade> gradeList;	//ѧ���꼶�б�
	private List<Department> departmentList;	//ϵ�б�
	private List<Course> courseList;	//�γ��б�
	
	private File studentFile;	//ѧ���ʺ��ļ�

	/**
	 * ��ȡĳ�γ̵�����ѧ��
	 * 
	 * @return
	 */
	public String getStudentByCourse() {
		course = courseService.getCourseById(courseId);
		System.out.println("the courseId is"+courseId);
		List<StudentCourse> scList = studentCourseService.findByCourse(course);
		if (scList.size() == 0) {
			addActionError("�˿γ���δ���ѧ����");
			return ERROR;
		}
		studentList = new ArrayList<Student>();
		for (StudentCourse sc : scList) {
			studentList.add(sc.getStudent());
		}
		return SUCCESS;
	}

	/**
	 * ɾ��course��ĳλѧ����ϵ
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
			addActionError("ɾ��ѧ��ʧ�ܣ������²�����");
			return ERROR;}
	}

	/**
	 * ��ת������ɾ��ѧ���γ�
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
	 * ����ɾ��ѧ���γ�
	 * @return
	 */
	public String deleteMoreStudent(){
		course = courseService.getCourseById(course.getId());
		boolean result = studentCourseService.deleteMoreSudentCourse(course, departmentId, gradeId);
		if(result){
			addActionMessage("�ɹ���"+course.getName()+"�γ���ɾ��ѡ��ѧ����");
		}else{
			addActionError("��"+course.getName()+"�γ���ɾ��ѧ��ʧ�ܣ�������ɾ����");
		}
		return SUCCESS;
	}
	
	/**
	 * Ϊcourse���ѧ��
	 * 
	 * @return
	 */
	public String addStudentCourse() {
		StudentCourse studentCourse = new StudentCourse();
		course = courseService.getCourseById(course.getId());
		student = studentCourseService.findStudentByStudentNo(studentNo);
		boolean check = studentCourseService.checkStudent(course, student);
		if (!check) {
			addActionError("ѧ��"+student.getUserInfo().getName()+"("+studentNo+") �Ѿ�����ÿγ̣������ظ����롣");
			return SUCCESS;
		}
		studentCourse.setCourse(course);
		studentCourse.setStudent(student);
		studentCourse.setStatus(0);
		boolean result = studentCourseService.addStudentCourse(studentCourse);
		if (result) {
			addActionError("���ѧ���ɹ���");
			return SUCCESS;
		} else{
			addActionError("���ѧ��ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * Ϊcourse�������ѧ��
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
	 * �����ҵĿγ�
	 * 
	 * @return
	 */
	public String findMyCourses() {
		student = (Student) super.getSession().get(STUDENT);
		List<StudentCourse> studentCourses = new ArrayList<StudentCourse>();
		studentCourses = studentCourseService.findByStudent(student);
		if (studentCourses.size() == 0) {
			addActionError("�����޿γ̣�");
			return SUCCESS;
		}
		courseList = new ArrayList<Course>();
		for (StudentCourse sc : studentCourses) {
			courseList.add(sc.getCourse());
		}
		return SUCCESS;
	}

	/**
	 * �����ҵ��ղؿγ�
	 * 
	 * @return
	 */
	public String findMyCollection() {
		student = (Student) super.getSession().get(STUDENT);
		List<Collection> collections = new ArrayList<Collection>();
		collections = studentCourseService.findCollectionByStudent(student);
		if (collections.size() == 0) {
			addActionError("����δ�ղ��κογ̣�");
			return SUCCESS;
		}
		courseList = new ArrayList<Course>();
		for (Collection c : collections) {
			courseList.add(c.getCourse());
		}
		return SUCCESS;
	}

	/**
	 * ɾ���ղؿγ�
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
	 * ����ղؿγ�
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
				addActionMessage("��ϲ�����ղ�"+course.getName()+"�γ̳ɹ�!");
			}
			else{
				addActionError("�ղ�"+course.getName()+"�γ�ʧ�ܣ������²���!");
				return ERROR;
			}
		}
		else{
			addActionError("���Ѿ��ղع���"+course.getName()+"���ſγ̡�");
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
