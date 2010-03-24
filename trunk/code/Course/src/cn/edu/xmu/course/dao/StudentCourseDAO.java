package cn.edu.xmu.course.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;

/**
 * A data access object (DAO) providing persistence and search support for
 * StudentCourse entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.StudentCourse
 * @author MyEclipse Persistence Tools
 */

public class StudentCourseDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(StudentCourseDAO.class);
	// property constants
	public static final String STATUS = "status";
	public static final String SCORE = "score";

	protected void initDao() {
		// do nothing
	}

	public void save(StudentCourse transientInstance) {
		log.debug("saving StudentCourse instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StudentCourse persistentInstance) {
		log.debug("deleting StudentCourse instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudentCourse findById(java.lang.Integer id) {
		log.debug("getting StudentCourse instance with id: " + id);
		try {
			StudentCourse instance = (StudentCourse) getHibernateTemplate()
					.get("cn.edu.xmu.course.pojo.StudentCourse", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StudentCourse instance) {
		log.debug("finding StudentCourse instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findCountAndScoreAvg(int courseId) {
		log.debug("finding Evaluation instance with property: course"
				+ ", value: " + courseId);
		try {
			String queryString = "select count(*),avg(score) from StudentCourse as model where model.course.id"
					+"= "+courseId;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List fingByCourseAndDepartmentAndGrade(Course course, String departmentId, String gradeId){
		try {
			String queryString = "from StudentCourse as model where model.course = ? and model.student.grade.id = "
					+ gradeId + " and model.student.userInfo.department.id = "+ departmentId;
			return getHibernateTemplate().find(queryString, course);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding StudentCourse instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StudentCourse as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * 根据学生、课程查找
	 * @param course
	 * @param student
	 * @return
	 */
	public List findByStudentAndCourse(Course course, Student student) {
		try {
			String queryString = "from StudentCourse as model where model.course.id ="
					+ course.getId() + " and model.student= ?";
			return getHibernateTemplate().find(queryString, student);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
    public List findByCourse(int courseId){
		
		return findByProperty("course.id", courseId);
		
	}
	
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}
	
	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}


	public List findAll() {
		log.debug("finding all StudentCourse instances");
		try {
			String queryString = "from StudentCourse";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StudentCourse merge(StudentCourse detachedInstance) {
		log.debug("merging StudentCourse instance");
		try {
			StudentCourse result = (StudentCourse) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StudentCourse instance) {
		log.debug("attaching dirty StudentCourse instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudentCourse instance) {
		log.debug("attaching clean StudentCourse instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StudentCourseDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (StudentCourseDAO) ctx.getBean("StudentCourseDAO");
	}
}