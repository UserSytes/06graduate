package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.commons.MD5;
import cn.edu.xmu.course.dao.StudentDAO;
import cn.edu.xmu.course.dao.UserInfoDAO;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IStudentInfoService;

/**
 * ѧ����Ϣ����
 * @author ֣����
 *
 */
public class StudentInfoService implements IStudentInfoService {

	private StudentDAO studentDAO;
	private UserInfoDAO userInfoDAO;
	private MD5 md5 = new MD5();

	/*
	 * �޸�ѧ��ͷ��(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#addStudentPhoto(cn.edu.xmu.course.pojo.UserInfo, java.io.File, java.lang.String)
	 */
	public boolean addStudentPhoto(UserInfo userInfo, File photo,String oldPhoto) {
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + userInfo.getPhoto();
		File file = new File(fileName);			
		try {
			userInfoDAO.merge(userInfo);
			if(!oldPhoto.equals("photo/defaultPhoto.jpg"))
				FileOperation.delete(new File(path + "/" + oldPhoto));
			if (FileOperation.copy(photo, file))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ���ѧ��(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#addStudent(cn.edu.xmu.course.pojo.Student, cn.edu.xmu.course.pojo.UserInfo)
	 */
	public boolean addStudent(Student student, UserInfo userInfo) {
		// TODO Auto-generated method stub
		student.setPassword(getMd5().getMD5ofStr(student.getPassword()));
		userInfo.setPhoto("photo/defaultPhoto.jpg");
		try {
			studentDAO.save(student);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/*
	 * ɾ��ѧ��(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#deleteStudent(cn.edu.xmu.course.pojo.Student)
	 */
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			userInfoDAO.delete(student.getUserInfo());
			studentDAO.delete(student);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ����ɾ��ѧ��(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#deleteMoreStudent(cn.edu.xmu.course.pojo.Grade, cn.edu.xmu.course.pojo.Department)
	 */
	public int deleteMoreStudent(Grade grade, Department department) {
		List<Student> studentList = studentDAO.findByDepartmentAndGrade(
				department, grade);
		int i = 0;
		for (Student s : studentList) {
			try {
				userInfoDAO.delete(s.getUserInfo());
				studentDAO.delete(s);
				i++;
			} catch (Exception e) {
				break;
			}
		}
		return i;
	}

	/*
	 * �����꼶����ѧ��(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#findByGrade(cn.edu.xmu.course.pojo.Grade)
	 */
	public List<Student> findByGrade(Grade grade) {
		// TODO Auto-generated method stub
		return studentDAO.findByProperty("grade", grade);
	}

	/*
	 * ����id����ѧ��(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#findById(int)
	 */
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return studentDAO.findById(id);
	}

	/*
	 * ����ѧԺ����ѧ��(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#findBySchool(cn.edu.xmu.course.pojo.School)
	 */
	public List findBySchool(School school) {
		// TODO Auto-generated method stub
		return studentDAO.findBySchool(school);
	}

	/*
	 * ����ѧ�Ų���ѧ��(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#findByStudentNo(java.lang.String)
	 */
	public Student findByStudentNo(String studentNo) {
		// TODO Auto-generated method stub
		List<Student> students = studentDAO.findByStudentNo(studentNo);
		if (students.size() == 0) {
			return null;
		} else {
			return students.get(0);
		}
	}

	/*
	 * ����ѧԺ��ѧ�Ų���ѧ����Ϣ(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#findByStudentNoFuzzy(java.lang.String, cn.edu.xmu.course.pojo.School)
	 */
	public List findByStudentNoFuzzy(String studentNo, School school) {
		// TODO Auto-generated method stub
		List<Student> students = studentDAO.findByStudentNoFuzzy(studentNo,
				school);
		System.out.println("���Բ���ѧ��2��" + students.size());
		return students;

	}

	/*
	 * �޸�����(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#updatePassword(cn.edu.xmu.course.pojo.Student)
	 */
	public boolean updatePassword(Student student) {
		try {
			studentDAO.merge(student);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ����ѧ����Ϣ(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#updateStudent(cn.edu.xmu.course.pojo.Student, cn.edu.xmu.course.pojo.UserInfo)
	 */
	public boolean updateStudent(Student student, UserInfo userInfo) {
		// TODO Auto-generated method stub
		try {
			student.setUserInfo(userInfo);
			Student s = studentDAO.merge(student);
			UserInfo u = userInfoDAO.merge(userInfo);
			if (s == null || u == null)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ����ϵ����ѧ��(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#findByDepartment(cn.edu.xmu.course.pojo.Department)
	 */
	public List<Student> findByDepartment(Department department) {
		return studentDAO.findByDepartment(department);
	}

	/*
	 * ����ϵ���꼶����ѧ��(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#findByDepartmentAndGrade(cn.edu.xmu.course.pojo.Department, cn.edu.xmu.course.pojo.Grade)
	 */
	public List<Student> findByDepartmentAndGrade(Department department,
			Grade grade) {
		return studentDAO.findByDepartmentAndGrade(department, grade);
	}
	
	/*
	 * ����ϵ����ѧ����Ϣ(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#getStuNameAndNumber(cn.edu.xmu.course.pojo.Department)
	 */
	public List getStuNameAndNumber(Department department) {
		// TODO Auto-generated method stub
		return studentDAO.findStuNameAndNumberByDepartment(department);
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	/*
	 * ����ѧ�Ų����û���Ϣ(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#findUserInfoByStudentNo(java.lang.String)
	 */
	public UserInfo findUserInfoByStudentNo(String studentNo) {
		// TODO Auto-generated method stub
		List<Student> students = studentDAO.findByStudentNo(studentNo);
		if (students.size() == 0) {
			return null;
		} else {
			return students.get(0).getUserInfo();
		}
	}

	/*
	 * �������ѧ��(non-Javadoc)(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#addMoreStudent(cn.edu.xmu.course.pojo.Grade, cn.edu.xmu.course.pojo.Department, java.io.File)
	 */
	public String addMoreStudent(Grade grade,
			Department department, File file) {
		// TODO Auto-generated method stub
		Workbook book = null;
		try {
			book = Workbook.getWorkbook(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "�������ѧ��ʧ�ܣ��޷����ѧ���������²�����";
		}
		int rows = 0;
		Sheet sh = null;
		sh = book.getSheet(0);
		rows = sh.getRows();
		for (int j = 1; j < rows; j++) {
			Cell cellStuNo = sh.getCell(0, j);
			String content = cellStuNo.getContents();
			String stuNo = content.substring(0, content.length() - 1);
			if (isNumeric(stuNo)) {
				if (studentDAO.findByStudentNo(stuNo).size() != 0) {
					return "ѧ��Ϊ" + stuNo + "��ѧ���Ѿ����ڣ������²�����";
				}
			} else {
				return "�������ѧ��ʧ�ܣ�����ѧ��ѧ�������Ƿ���ȷ��";
			}
		}
		for (int j = 1; j < rows; j++) {
			Cell cellStuNo = sh.getCell(0, j);
			String content = cellStuNo.getContents();
			String stuNo = content.substring(0, content.length() - 1);
			Student stu = new Student();
			stu.setGrade(grade);
			stu.setStudentNo(stuNo);
			stu.setPassword(stuNo);
			UserInfo userInfo = new UserInfo();
			userInfo.setDepartment(department);
			userInfo.setName(sh.getCell(1, j).getContents());
			userInfo.setPhoto("photo/defaultPhoto.jpg");
			stu.setUserInfo(userInfo);
			studentDAO.save(stu);
		}
		return "�������ѧ���ɹ����ܼ����" + --rows + "��ѧ����";
	}

	/**
	 * �ж��ַ��Ƿ�Ϊ��������
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/*
	 * �����û���Ϣ����ѧ��(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IStudentInfoService#findByUserInfo(cn.edu.xmu.course.pojo.UserInfo)
	 */
	public Student findByUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		List<Student> students = studentDAO.findByUserInfo(userInfo);
		if (students.size() == 0) {
			return null;
		} else {
			return students.get(0);
		}
	}

	public void setMd5(MD5 md5) {
		this.md5 = md5;
	}

	public MD5 getMd5() {
		return md5;
	}

	

}
