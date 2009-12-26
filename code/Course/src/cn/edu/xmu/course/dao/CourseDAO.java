package cn.edu.xmu.course.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.Course;
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
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List findByRefuseReason(Object refuseReason) {
		return findByProperty(REFUSE_REASON, refuseReason);
	}
	public List findByTeacherId(Object teacherId) {
		return findByProperty("teacher.id", teacherId);
	}
	
	public List findByDepartment(Object department) {
		return findByProperty("department", department);
	}
	public List findByTeacher(String teacherName)
	{
		return findByProperty("teacher.userInfo.name", teacherName);
	}
	
	public List findByTeacherAndType(Integer teacherId, int status) {
		log.debug("finding Course instance with property: teacher,status" +
				", value: " + teacherId+" and "+status);
		try {
			String queryString = "from Course as model where model.teacher.id="
					+ teacherId + "and model.status= "+status;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	
	public List findApplicationBySchool(School school) {
		log.debug("finding Course instance with status = 0 and department.school, value: " + school);
		try {
			String queryString = "from Course as model where model.status = 0 and model.department.school = ?";
			return getHibernateTemplate().find(queryString, school);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findBySchool(School school) {
		log.debug("finding Course instance with status = 1 and department.school, value: " + school);
		try {
			String queryString = "from Course as model where model.status = 1 and model.department.school = ?";
			return getHibernateTemplate().find(queryString, school);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findNotPassBySchool(School school) {
		log.debug("finding Course instance with status = 2 and department.school, value: " + school);
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