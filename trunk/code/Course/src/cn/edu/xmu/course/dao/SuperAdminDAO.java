package cn.edu.xmu.course.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.SuperAdmin;

/**
 * A data access object (DAO) providing persistence and search support for
 * SuperAdmin entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.SuperAdmin
 * @author MyEclipse Persistence Tools
 */

public class SuperAdminDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(SuperAdminDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String ACCOUNT = "account";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	public static final String MOBILE = "mobile";

	protected void initDao() {
		// do nothing
	}

	public void save(SuperAdmin transientInstance) {
		log.debug("saving SuperAdmin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SuperAdmin persistentInstance) {
		log.debug("deleting SuperAdmin instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SuperAdmin findById(java.lang.Integer id) {
		log.debug("getting SuperAdmin instance with id: " + id);
		try {
			SuperAdmin instance = (SuperAdmin) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.SuperAdmin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SuperAdmin instance) {
		log.debug("finding SuperAdmin instance by example");
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
		log.debug("finding SuperAdmin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SuperAdmin as model where model."
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

	/**
	 * 根据帐号获取校管理员
	 * @param account
	 * @return
	 */
	public SuperAdmin findByAccount(String account) {
		List<SuperAdmin> superAdmins = findByProperty(ACCOUNT, account);
		if (superAdmins.size() == 0) {
			return null;
		} else
			return superAdmins.get(0);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List findAll() {
		log.debug("finding all SuperAdmin instances");
		try {
			String queryString = "from SuperAdmin";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SuperAdmin merge(SuperAdmin detachedInstance) {
		log.debug("merging SuperAdmin instance");
		try {
			SuperAdmin result = (SuperAdmin) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SuperAdmin instance) {
		log.debug("attaching dirty SuperAdmin instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SuperAdmin instance) {
		log.debug("attaching clean SuperAdmin instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SuperAdminDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SuperAdminDAO) ctx.getBean("SuperAdminDAO");
	}
}