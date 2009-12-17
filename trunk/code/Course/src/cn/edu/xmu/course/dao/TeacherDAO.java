package cn.edu.xmu.course.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.Teacher;

/**
 * A data access object (DAO) providing persistence and search support for
 * Teacher entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.Teacher
 * @author MyEclipse Persistence Tools
 */

public class TeacherDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TeacherDAO.class);
	// property constants
	public static final String TEACHER_NO = "teacherNo";
	public static final String PASSWORD = "password";

	protected void initDao() {
		// do nothing
	}

	public void save(Teacher transientInstance) {
		log.debug("saving Teacher instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Teacher persistentInstance) {
		log.debug("deleting Teacher instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Teacher findById(java.lang.Integer id) {
		log.debug("getting Teacher instance with id: " + id);
		try {
			Teacher instance = (Teacher) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.Teacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Teacher instance) {
		log.debug("finding Teacher instance by example");
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
		log.debug("finding Teacher instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Teacher as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTeacherNo(Object teacherNo) {
		return findByProperty(TEACHER_NO, teacherNo);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findAll() {
		log.debug("finding all Teacher instances");
		try {
			String queryString = "from Teacher";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Teacher merge(Teacher detachedInstance) {
		log.debug("merging Teacher instance");
		try {
			Teacher result = (Teacher) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Teacher instance) {
		log.debug("attaching dirty Teacher instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Teacher instance) {
		log.debug("attaching clean Teacher instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TeacherDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TeacherDAO) ctx.getBean("TeacherDAO");
	}
}