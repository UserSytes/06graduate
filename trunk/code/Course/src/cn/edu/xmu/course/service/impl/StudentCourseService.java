package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import cn.edu.xmu.course.dao.CollectionDAO;
import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.dao.StudentCourseDAO;
import cn.edu.xmu.course.dao.StudentDAO;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Collection;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IStudentCourseService;
/**
 * 
 * @author Sky
 *
 */
public class StudentCourseService implements IStudentCourseService {

	private StudentCourseDAO studentCourseDAO;
	private CollectionDAO collectionDAO;
	private StudentDAO studentDAO;
	
	public boolean checkStudent(Course course, Student student){
		List<StudentCourse> studentCourses = studentCourseDAO.findByStudentAndCourse(course, student);
		if(studentCourses.size()==0){
			return true;//��ѧ��δ����ÿγ̣���ִ�м���
		}else
			return false;//�����Ѿ�����ÿγ�
	}
	
	public boolean deleteCollection(Student student, Course course){
		Collection c = (Collection) collectionDAO.findByStudentAndCourse(course, student).get(0);
		if(c != null){
			try{
				collectionDAO.delete(c);
				return true;
			}catch(Exception e){
				return false;
			}
		}else{
			return false;
		}
	}
	
	public List<Collection> findCollectionByStudent(Student student){
		return collectionDAO.findByProperty("student", student);
	}
	
	public List<StudentCourse> findByCourse(Course course) {
		// TODO Auto-generated method stub
		return studentCourseDAO.findByProperty("course", course);
	}
	
	public Student findStudentById(int id){
		return studentDAO.findById(id);
	}
	
	public Student findStudentByStudentNo(String studentNo){
		return (Student) studentDAO.findByStudentNo(studentNo).get(0);
	}
	
	public boolean delete(Course course, Student student){
		StudentCourse sc = (StudentCourse) studentCourseDAO.findByStudentAndCourse(course, student).get(0);
		if(sc != null){
			try{
				studentCourseDAO.delete(sc);
				return true;
			}catch(Exception e){
				return false;
			}
		}else{
			return false;
		}
	}
	
	public boolean deleteMoreSudentCourse(Course course, String departmentId, String gradeId){
		List<StudentCourse> scList = studentCourseDAO.fingByCourseAndDepartmentAndGrade(course, departmentId, gradeId);
		if(scList.size()==0){
			return true;
		}
		for(StudentCourse sc: scList){
			try{
				studentCourseDAO.delete(sc);
			}catch(Exception e){
				return false;
			}
		}
		return true;
	}

	public boolean addStudentCourse(StudentCourse studentCourse){
		try{
			studentCourseDAO.save(studentCourse);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public String addMoreStudentCourse(Course course, File file){
		Workbook book = null;
		List<Student> students ;
		try {
			book = Workbook.getWorkbook(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "�������ѧ����ʧ�ܣ��޷����ѧ���������²�����";
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
				students = studentDAO.findByStudentNo(stuNo);
				if(students.size()==0){
					return "ѧ��Ϊ" + stuNo + "��ѧ�������ڣ������²�����";
				}
				if (!this.checkStudent( course, students.get(0))) {
					return "ѧ��Ϊ" + stuNo + "��ѧ���Ѿ�����ÿγ̣������²�����";
				}
			} else {
				return "�������ѧ��ʧ�ܣ�����ѧ��ѧ�������Ƿ���ȷ��";
			}
		}
		for (int j = 1; j < rows; j++) {
			Cell cellStuNo = sh.getCell(0, j);
			String content = cellStuNo.getContents();
			String stuNo = content.substring(0, content.length() - 1);
			students = studentDAO.findByStudentNo(stuNo);
			if(students.size()==0){
				return "ѧ��Ϊ" + stuNo + "��ѧ�������ڣ������²�����";
			}
			//Student stu = new Student();
			StudentCourse sc = new StudentCourse();
			sc.setCourse(course);
			sc.setStudent(students.get(0));
			sc.setStatus(0);
			studentCourseDAO.save(sc);
		}
		return "�������ѧ�����γ̳ɹ����ܼ����" + --rows + "��ѧ����";
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
	
	public boolean updateStudentCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		try{
			studentCourseDAO.merge(studentCourse);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public List<StudentCourse> findByStudent(Student student){
		return studentCourseDAO.findByProperty("student", student);
	}
	
	public StudentCourseDAO getStudentCourseDAO() {
		return studentCourseDAO;
	}

	public void setStudentCourseDAO(StudentCourseDAO studentCourseDAO) {
		this.studentCourseDAO = studentCourseDAO;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public CollectionDAO getCollectionDAO() {
		return collectionDAO;
	}

	public void setCollectionDAO(CollectionDAO collectionDAO) {
		this.collectionDAO = collectionDAO;
	}

}
