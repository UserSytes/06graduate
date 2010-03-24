package cn.edu.xmu.course.web.action;

import cn.edu.xmu.course.service.ILoginService;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;
/**
 * ���ฺ�� �û��ĵ�¼���˳�����Ȩ�޷���
 * @author ֣����
 *
 */
public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3613304347937871262L;

	private ILoginService loginService;

	private String userName;
	private String password;
	private int flag;
	private Student student;
	private Teacher teacher;
	private UserInfo userInfo;

	/**
	 * ��ʦ��¼
	 * @return
	 */
	public String login() {
		Teacher teacher = loginService.teacherLogin(userName, password);
		if (null == teacher)
			return ERROR;
		else {
			super.getSession().put(TEACHER, teacher);
			return SUCCESS;
		}
	}

	/**
	 * ����Ա��¼
	 * @return
	 */
	public String adminLogin() {
		if (flag == 0) {
			Administrator admin = loginService.adminLogin(userName, password);
			if (null == admin){
				addActionError("�ʺŻ���������������µ�¼��");
				return ERROR;
			}
			else {
				super.getSession().put(ADMIN, admin);
				return "admin";
			}
		} else if(flag == 1){
			SuperAdmin superAdmin = loginService.superAdminLogin(userName,
					password);
			if (null == superAdmin){
				addActionError("�ʺŻ���������������µ�¼��");
				return ERROR;
			}
			else {
				super.getSession().put(SUPERADMIN, superAdmin);
				return "superAdmin";
			}
		}
	
		else
			return ERROR;
	}

	/**
	 * ��ת�ĸ�����ҳ����ʦ��ѧ����
	 * @return
	 */
	public String myPage(){
		student = (Student) super.getSession().get(STUDENT);
		teacher = (Teacher) super.getSession().get(TEACHER);
		if(student == null && teacher == null){
			addActionMessage("����δ��¼�����ȵ�¼��");
			return ERROR;
		}else if(student != null){
			userInfo = student.getUserInfo();
			return "student";
		}else if(teacher != null){
			userInfo = teacher.getUserInfo();
			return "teacher";
		}else{
			addActionMessage("����δ��¼�����ȵ�¼��");
			return ERROR;
		}
		
	}
	
	/**
	 * ��ʦ��ѧ���˳�ϵͳ
	 */
	public String logout(){
		student = (Student) super.getSession().get(STUDENT);
		teacher = (Teacher) super.getSession().get(TEACHER);

		if(student != null){
			super.getSession().remove(STUDENT);
			super.getSession().remove("user");
		}else if(teacher != null){
			super.getSession().remove(TEACHER);
			super.getSession().remove("user");
		}
		return SUCCESS;
	}
	
	/**
	 * ѧԺ����Ա�˳�ϵͳ
	 * @return
	 */
	public String adminLogout(){
		super.getSession().remove(ADMIN);
		return SUCCESS;
	}
	
	/**
	 * У����Ա�˳�ϵͳ
	 * @return
	 */
	public String superAdminLogout(){
		super.getSession().remove(SUPERADMIN);
		return SUCCESS;
	}
	
	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
