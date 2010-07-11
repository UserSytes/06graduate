package cn.edu.xmu.course.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import cn.edu.xmu.course.commons.CourseEvaluate;
import cn.edu.xmu.course.commons.MD5;
import cn.edu.xmu.course.dao.EvaluationDAO;
import cn.edu.xmu.course.dao.StudentCourseDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.service.IEvaluateService;

/**
 * �������۵���
 * 
 * @author �Ժ���
 * @author ������
 * 
 */
public class EvaluateService implements IEvaluateService {

	private StudentCourseDAO studentCourseDAO;
	private EvaluationDAO evaluationDAO;


	/*
	 * ����ѧ������(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#updateStudentCourse(cn.edu
	 * .xmu.course.pojo.StudentCourse)
	 */
	public boolean updateStudentCourse(StudentCourse studentCourse) {
		try {
			getStudentCourseDAO().merge(studentCourse);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ����ѧ��ID����ѧ������(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#findStudentCourseByStudentId
	 * (java.lang.Integer)
	 */
	public StudentCourse findStudentCourseByStudentId(Integer id) {
		return getStudentCourseDAO().findById(id);
	}

	/*
	 * ���ݿγ̺�ѧ������ѧ������(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#findByStudentAndCourse(cn.
	 * edu.xmu.course.pojo.Course, cn.edu.xmu.course.pojo.Student)
	 */
	public List<StudentCourse> findByStudentAndCourse(Course course,
			Student student) {
		return getStudentCourseDAO().findByStudentAndCourse(course,
				student);
	}

	/*
	 * ����ר�Һ���ʦ������(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#updateEvaluation(cn.edu.xmu
	 * .course.pojo.Evaluation)
	 */
	public boolean updateEvaluation(Evaluation evaluation) {
		try {
			getEvaluationDAO().merge(evaluation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ����ID����ר�Һ���ʦ������(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#findById(java.lang.Integer)
	 */
	public Evaluation findById(Integer id) {
		return getEvaluationDAO().findById(id);
	}

	/*
	 * ����ר�һ�����ʦ�����۽��(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#getEvaluationCalculateResult
	 * (int, int)
	 */
	public Object[] getEvaluationCalculateResult(int courseId, int sort,int status) {
		List result = getEvaluationDAO().findCountAndScoreAvg(courseId, sort ,status);
		ListIterator iterator = result.listIterator();
		Object[] rows = (Object[]) iterator.next();
		return rows;
	}

	/*
	 * ���ݿγ��б��ȡ������Ϣ(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#getEvaluateByCourseList(java
	 * .util.List)
	 */
	public List<CourseEvaluate> getEvaluateByCourseList(List<Course> courseList) {
		List<CourseEvaluate> courseEvaluateList = new ArrayList<CourseEvaluate>();
		for (Course course : courseList) {
			CourseEvaluate courseEvaluate = new CourseEvaluate();
			courseEvaluate.setCourseName(course.getName());
			courseEvaluate.setTeacherName(course.getTeacher().getUserInfo()
					.getName());
			Object[] expertEvaluationResult = this
					.getEvaluationCalculateResult(course.getId(), 0 ,1);
			Object[] teacherEvaluationResult = this
					.getEvaluationCalculateResult(course.getId(), 1 ,1);
			Object[] scResult = this.getStudentCourseCalculateResult(course
					.getId());
			courseEvaluate.setStuCount(scResult[0]);
			courseEvaluate.setExpertCount(expertEvaluationResult[0]);
			courseEvaluate.setTeacherCount(teacherEvaluationResult[0]);

			if (scResult[1] != null)
				courseEvaluate.setStuAvgScore(scResult[1]);
			if (expertEvaluationResult[1] != null)
				courseEvaluate.setExpertAvgScore(expertEvaluationResult[1]);
			if (teacherEvaluationResult[1] != null)
				courseEvaluate.setTeacherAvgScore(teacherEvaluationResult[1]);
			courseEvaluateList.add(courseEvaluate);
		}
		return courseEvaluateList;
	}

	/*
	 * ��ѯѧ���Կγ̵�ƽ������(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#getStudentCourseCalculateResult
	 * (int)
	 */
	public Object[] getStudentCourseCalculateResult(int courseId) {
		List result = getStudentCourseDAO().findCountAndScoreAvg(courseId);
		ListIterator iterator = result.listIterator();
		Object[] rows = (Object[]) iterator.next();
		return rows;
	}

	/*
	 * ���ݿγ̣��û����ͷ������ר�һ�����ʦ������(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#findByCourseAndUsernameAndSort
	 * (cn.edu.xmu.course.pojo.Course, java.lang.String, int)
	 */
	public List<Evaluation> findByCourseAndUsernameAndSort(Course course,
			String username, int sort) {
		return getEvaluationDAO().findByCourseAndUsernameAndSort(course, username,
				sort);

	}

	/*
	 * ���ݿγ̺ͷ������ר�һ�����ʦ������(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#findByCourseAndSort(cn.edu
	 * .xmu.course.pojo.Course, int)
	 */
	public List<Evaluation> findByCourseAndSort(Course course, int sort) {
		return getEvaluationDAO().findByCourseAndSort(course, sort);

	}

	/*
	 * ���ݿγ̣������״̬ר�һ�����ʦ������(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#findByCourseAndSortAndStatus
	 * (cn.edu.xmu.course.pojo.Course, int, int)
	 */
	public List<Evaluation> findByCourseAndSortAndStatus(Course course,
			int sort, int status) {
		return getEvaluationDAO().findByCourseAndSortAndStatus(course, sort, status);

	}

	/*
	 * ����ר������(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#addEvaluation(cn.edu.xmu.course
	 * .pojo.Evaluation, cn.edu.xmu.course.pojo.Course)
	 */
	public boolean addEvaluation(Evaluation evaluation, Course course) {		
		// TODO Auto-generated method stub
		MD5 md5 = new MD5();
		evaluation.setPassword(md5.getMD5ofStr(evaluation.getPassword()));
		evaluation.setCourse(course);
		evaluation.setStatus(0);

		try {
			getEvaluationDAO().save(evaluation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ɾ���γ�����
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#deleteEvaluation(cn.edu.xmu
	 * .course.pojo.Evaluation)
	 */
	public boolean deleteEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		try {
			getEvaluationDAO().delete(evaluation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/*
	 * ��dwr��ѯ���û����Ƿ��Ѿ�����(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IEvaluateService#getEvaluationByUsername(java.lang.String)
	 */
	public Evaluation getEvaluationByUsername(String username){
		List<Evaluation> el = getEvaluationDAO().findByUsername(username);
		if(el.size()==0)
			return null;
		else return el.get(0);
	}
	

	public void setStudentCourseDAO(StudentCourseDAO studentCourseDAO) {
		this.studentCourseDAO = studentCourseDAO;
	}

	public StudentCourseDAO getStudentCourseDAO() {
		return studentCourseDAO;
	}

	public void setEvaluationDAO(EvaluationDAO evaluationDAO) {
		this.evaluationDAO = evaluationDAO;
	}

	public EvaluationDAO getEvaluationDAO() {
		return evaluationDAO;
	}


}
