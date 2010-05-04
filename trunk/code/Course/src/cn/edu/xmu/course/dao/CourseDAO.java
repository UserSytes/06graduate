package cn.edu.xmu.course.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.School;

/**
 * A data access object (DAO) providing persistence and search support for
 * Course entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.Course
 * @author MyEclipse Persistence Tools
 */

public class CourseDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CourseDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String REMARK = "remark";
	public static final String STATUS = "status";
	public static final String LEVEL = "level";
	public static final String REFUSE_REASON = "refuseReason";
	public static final String COUNT = "count";
	public static final String VISIBLE = "visible";

	protected void initDao() {
		// do nothing
	}

	public void save(Course transientInstance) {
		log.debug("saving Course instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Course persistentInstance) {
		log.debug("deleting Course instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Course findById(java.lang.Integer id) {
		log.debug("getting Course instance with id: " + id);
		try {
			Course instance = (Course) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.Course", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Course instance) {
		log.debug("finding Course instance by example");
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

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Course instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Course as model where model."
					+ propertyName + "= ? and model.status = 1";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * 根据名称模糊查找课程
	 * @author 郑冰凌
	 * @param key
	 * @return
	 */
	public List findByName(Object key) {
		try {
			String queryString = "from Course as model where model.name like '%"
					+ key + "%' and model.status = 1";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/**
	 * 根据级别查找课程
	 * @param level
	 * @return
	 */
	public List findByLevel(String level) {
		if (level.equals("country")) {
			return findByProperty(LEVEL, "国家级");
		} else if (level.equals("province")) {
			return findByProperty(LEVEL, "省级");
		} else if (level.equals("school")) {
			return findByProperty(LEVEL, "校级");
		} else {
			return null;
		}

	}

	public List findByRefuseReason(Object refuseReason) {
		return findByProperty(REFUSE_REASON, refuseReason);
	}

	public List findByCount(Object count) {
		return findByProperty(COUNT, count);
	}

	public List findByVisible(Object visible) {
		return findByProperty(VISIBLE, visible);
	}

	public List findByTeacherId(Object teacherId) {
		return findByProperty("teacher.id", teacherId);
	}

	public List findByDepartment(Object department) {
		return findByProperty("department", department);
	}

	/**
	 * 根据教师名称模糊查找课程
	 * @param teacherName
	 * @return
	 */
	public List findByTeacher(String teacherName) {
		try {
			String queryString = "from Course as model where model.teacher.userInfo.name like '%"
					+ teacherName + "%' and model.status = 1";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * 根据课程名称和教师名称模糊查找课程
	 * @param courseName
	 * @param teacherName
	 * @return
	 */
	public List<Course> findCourseByNameAndTeacher(String courseName,
			String teacherName) {
		try {
			String queryString = "from Course as model where model.name like '%"
					+ courseName
					+ "%' and model.teacher.userInfo.name like '%"
					+ teacherName + "%' and model.status = 1";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * 根据部门和教师名称模糊查找课程
	 * @param teacherName
	 * @param department
	 * @return
	 */
	public List<Course> findCourseByDepartmentAndTeacher(String teacherName,
			Department department){
		try {
			String queryString = "from Course as model where model.department = ?"
					+ " and model.teacher.userInfo.name like '%"
					+ teacherName + "%' and model.status = 1";
			return getHibernateTemplate().find(queryString, department);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * 根据名称和部门查找课程
	 * @param courseName
	 * @param department
	 * @return
	 */
	public List<Course> findCourseByNameAndDepartment(String courseName,
			Department department){
		try {
			String queryString = "from Course as model where model.department = ?"
					+ " and model.name like '%"
					+ courseName + "%' and model.status = 1";
			return getHibernateTemplate().find(queryString, department);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * 根据教师姓名、课程名称、系模糊查找课程
	 * @param courseName
	 * @param department
	 * @param teacherName
	 * @return
	 */
	public List<Course> findCourseByNameAndDepartmentAndTeacher(
			String courseName, Department department, String teacherName){
		try {
			String queryString = "from Course as model where model.department = ?"
					+ " and model.name like '%"
					+ courseName + "%'"
					+ " and model.teacher.userInfo.name like '%"
					+ teacherName + "%' and model.status = 1";
			return getHibernateTemplate().find(queryString, department);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/**
	 * 根据时间查找课程
	 * @param date
	 * @return
	 */
	public List findCourseByDate(String date){
		try {
			String queryString = "from Course as model where model.status = 1 and model.time >"+date;
			Query queryObject = getSession().createQuery(queryString);
	  		queryObject.setFirstResult(0); 
	  		queryObject.setMaxResults(10); 
	  		return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * 根据教师和课程状态查找课程
	 * @param teacherId
	 * @param status
	 * @return
	 */
	public List findByTeacherAndType(Integer teacherId, int status) {
		log.debug("finding Course instance with property: teacher,status"
				+ ", value: " + teacherId + " and " + status);
		try {
			String queryString = "from Course as model where model.teacher.id="
					+ teacherId + "and model.status= " + status;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * 根据学院查找未审核的课程
	 * @param school
	 * @return
	 */
	public List findApplicationBySchool(School school) {
		log
				.debug("finding Course instance with status = 0 and department.school, value: "
						+ school);
		try {
			String queryString = "from Course as model where model.status = 0 and model.department.school = ?";
			return getHibernateTemplate().find(queryString, school);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * 根据学院查找通过审核的课程
	 * @param school
	 * @return
	 */
	public List findBySchool(School school) {
		log
				.debug("finding Course instance with status = 1 and department.school, value: "
						+ school);
		try {
			String queryString = "from Course as model where model.status = 1 and model.department.school = ?";
			return getHibernateTemplate().find(queryString, school);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * 通过学院查找未通过审核的课程
	 * @param school
	 * @return
	 */
	public List findNotPassBySchool(School school) {
		log
				.debug("finding Course instance with status = 2 and department.school, value: "
						+ school);
		try {
			String queryString = "from Course as model where model.status = 2 and model.department.school = ?";
			return getHibernateTemplate().find(queryString, school);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Course instances");
		try {
			String queryString = "from Course";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Course merge(Course detachedInstance) {
		log.debug("merging Course instance");
		try {
			Course result = (Course) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Course instance) {
		log.debug("attaching dirty Course instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Course instance) {
		log.debug("attaching clean Course instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CourseDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CourseDAO) ctx.getBean("CourseDAO");
	}
}