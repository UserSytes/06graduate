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
 * �������Ա����ʦ����γ̵���
 * @author ������
 * @author ֣����
 * 
 */
public class CourseAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1435933948873647769L;
	private String departmentId;	//ϵ��id
	private int courseId;	//�γ�id
	private Department department;	//ϵ
	private Teacher teacher;	//��ʦ
	private Course course;	//�γ�
	private List<Course> myCoursesList;	//�ң���ʦ���Ŀγ��б�
	private int type = 3;	//�γ�״̬��ʶ��3:ͨ����˵Ŀγ�
	private String style; //�γ̷����ɫ 

	private ISuperAdminService superAdminService;	//�������У������Ա�Ľӿ�
	private ITeacherInfoService teacherInfoService;	//�����ʦ��Ϣ�Ľӿ�
	private IStudentCourseService studentCourseService;	//����ѧ���γ���Ϣ�Ľӿ�
	private ICourseService courseService;	//����γ̵Ľӿ�
	private IDepartmentService departmentService;	//����ϵ�Ľӿ�

	private List<Course> applicationCourseList;	//�걨�γ��б�
	private List<Student> studentList;	//ѧ���б�
	private Student student;	//ѧ��
	private int studentId;	//ѧ��id
	private String studentNo;	//ѧ��ѧ�š��ʺ�
	private String refuseReason;	//��˿γ��˻�ʱ��д������
	private String gradeId;	//ѧ���꼶id
	private List<Grade> gradeList;	//ѧ���꼶�б�
	private List<Department> departmentList;	//ϵ�б�

	private File studentFile;	//ѧ���ʺ��ļ�
	private String studentFileContentType;	//ѧ���ʺ��ļ�����
	private String studentFileName;	//ѧ���ʺ��ļ���
		

	/**
	 * �걨�γ�
	 * @return
	 */
	public String addNewCourse() {
		Department dept = departmentService.getDepartmentById(Integer
				.parseInt(departmentId));		
		if (getCourseService().addCourse(course, dept, super.getTeacher())) {
			addActionMessage("�걨�γ̳ɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ȡĳ��ʦ�Ŀγ�
	 * @return
	 */
	public String findMyCoursesList() {		
		myCoursesList = courseService.findCoursesByTeacher(super.getTeacher().getId(), type);
		return SUCCESS;
	}
	
	/**
	 * �鿴�γ���ϸ��Ϣ
	 * @return
	 */
	public String goEidtCourse(){
		course = courseService.getCourseById(courseId);
		return SUCCESS;
	}
	
	/**
	 * ���¿γ�
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
	 * ��ȡĳ��ʦ�Ŀγ�
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
	 * ɾ���γ�
	 * 
	 * @return
	 */
	public String deleteCourse() {
		Course deleteCourse = courseService.getCourseById(courseId);
		if (courseService.deleteCourse(deleteCourse)) {
			return SUCCESS;
		} else{
			addActionError("ɾ���γ�ʧ��,�����²�����");
			return ERROR;}
	}
	
	/**
	 * ���ÿγ̷��
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
			addActionMessage("���÷��ɹ���");
			return SUCCESS;
		}
		else {
			addActionError("���ÿγ̷��ʧ�ܣ������²�����");
			return ERROR;
		}
	}
	
	/**
	 * ��ת�����ÿγ̷��ҳ��
	 * @return
	 */
	public String goSetCourseStyle(){
		Course course = courseService.getCourseById(courseId);
		if(course.getStatus()==2){
			addActionError("���Ŀγ���δͨ����ˣ�Ŀǰ�޷����ÿγ̷��");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * ��ȡ����γ��б�
	 * 
	 * @return
	 */
	public String findApplicationCourse() {
		Administrator admin = (Administrator) super.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findApplicationCourse(school);
		if (applicationCourseList.size() == 0) {
			addActionError("�������걨�γ̣�");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

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
	 * �鿴�γ���ϸ��Ϣ
	 * @return
	 */
	public String courseDetail() {
		course = courseService.getCourseById(courseId);
		if (course == null) {
			addActionError("�ÿγ̲����ڣ������²�����");
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * ��˿γ�ͨ��
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
			addActionError(course.getName() + "�γ�ͨ����ˣ�");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��˿γ�δͨ��
	 * 
	 * @return
	 */
	public String courseNoPass() {
		course = courseService.getCourseById(course.getId());
		course.setStatus(2);
		course.setRefuseReason(refuseReason);
		boolean result = courseService.updateCourse(course);
		if (result) {
			addActionError(course.getName() + "�γ���˺��˻أ�");
			// this.findApplicationCourse();
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ȡѧԺ�γ��б�
	 * 
	 * @return
	 */
	public String findCourse() {
		Administrator admin = (Administrator) super.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findBySchool(school);
		if (applicationCourseList.size() == 0) {
			addActionError("���޿γ̣�");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * ��ȡѧԺ�˻ؿγ��б�
	 * 
	 * @return
	 */
	public String findNoPassCourse() {
		Administrator admin = (Administrator) super.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findNoPassCourse(school);
		if (applicationCourseList.size() == 0) {
			addActionError("�����˻ؿγ̣�");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * ���浱ǰ�γ�
	 * @return
	 */
	public String saveCurrentCourse() {
		Course currentCourse = courseService.getCourseById(courseId);
		if (currentCourse.getStatus() == 1) {
			super.getSession().put(COURSE, currentCourse);
			return SUCCESS;
		}
		else{
			addActionError("�ÿγ�δͨ����ˣ�����ϵ��ѧ��������ش���");
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
