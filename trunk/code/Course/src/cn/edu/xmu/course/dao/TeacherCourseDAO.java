package cn.edu.xmu.course.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.TeacherCourse;

/**
 * A data access object (DAO) providing persistence and search support for
 * TeacherCourse entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.TeacherCourse
 * @author MyEclipse Persistence Tools
 */

public class TeacherCourseDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TeacherCourseDAO.class);
	// property constants
	public static final String STATUS = "status";
	public static final String REMARK = "remark";

	protected void initDao() {
		// do nothing
	}

	public void save(TeacherCourse transientInstance) {
		log.debug("saving TeacherCourse instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TeacherCourse persistentInstance) {
		log.debug("deleting TeacherCourse instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeacherCourse findById(java.lang.Integer id) {
		log.debug("getting TeacherCourse instance with id: " + id);
		try {
			TeacherCourse instance = (TeacherCourse) getHibernateTemplate()
					.get("cn.edu.xmu.course.pojo.TeacherCourse", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TeacherCourse instance) {
		log.debug("finding TeacherCourse instance by example");
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
		log.debug("finding TeacherCourse instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TeacherCourse as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all TeacherCourse instances");
		try {
			String queryString = "from TeacherCourse";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TeacherCourse merge(TeacherCourse detachedInstance) {
		log.debug("merging TeacherCourse instance");
		try {
			TeacherCourse result = (TeacherCourse) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeacherCourse instance) {
		log.debug("attaching dirty TeacherCourse instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeacherCourse instance) {
		log.debug("attaching clean TeacherCourse instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TeacherCourseDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TeacherCourseDAO) ctx.getBean("TeacherCourseDAO");
	}
}