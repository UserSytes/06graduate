package cn.edu.xmu.course.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.School;

/**
 * A data access object (DAO) providing persistence and search support for
 * School entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.School
 * @author MyEclipse Persistence Tools
 */

public class SchoolDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(SchoolDAO.class);
	// property constants
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public boolean save(School transientInstance) {
		log.debug("saving School instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
			return true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			//throw re;
			return false;
		}
	}

	public boolean delete(School persistentInstance) {
		log.debug("deleting School instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
			return true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			//throw re;
			return false;
		}
	}

	public School findById(java.lang.Integer id) {
		log.debug("getting School instance with id: " + id);
		try {
			School instance = (School) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.School", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(School instance) {
		log.debug("finding School instance by example");
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
		log.debug("finding School instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from School as model where model."
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

	public List findAll() {
		log.debug("finding all School instances");
		try {
			String queryString = "from School";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public School merge(School detachedInstance) {
		log.debug("merging School instance");
		try {
			School result = (School) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(School instance) {
		log.debug("attaching dirty School instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(School instance) {
		log.debug("attaching clean School instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SchoolDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SchoolDAO) ctx.getBean("SchoolDAO");
	}
}