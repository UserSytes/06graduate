package cn.edu.xmu.course.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.Administrator;

/**
 * A data access object (DAO) providing persistence and search support for
 * Administrator entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.Administrator
 * @author MyEclipse Persistence Tools
 */

public class AdministratorDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(AdministratorDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String ACCOUNT = "account";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	public static final String MOBILE = "mobile";

	protected void initDao() {
		// do nothing
	}

	public boolean save(Administrator transientInstance) {
		log.debug("saving Administrator instance");
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

	public boolean delete(Administrator persistentInstance) {
		log.debug("deleting Administrator instance");
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

	public Administrator findById(java.lang.Integer id) {
		log.debug("getting Administrator instance with id: " + id);
		try {
			Administrator instance = (Administrator) getHibernateTemplate()
					.get("cn.edu.xmu.course.pojo.Administrator", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Administrator instance) {
		log.debug("finding Administrator instance by example");
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
		log.debug("finding Administrator instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Administrator as model where model."
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

	public List findByAccount(Object account) {
		return findByProperty(ACCOUNT, account);
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
		log.debug("finding all Administrator instances");
		try {
			String queryString = "from Administrator";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Administrator merge(Administrator detachedInstance) {
		log.debug("merging Administrator instance");
		try {
			Administrator result = (Administrator) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Administrator instance) {
		log.debug("attaching dirty Administrator instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Administrator instance) {
		log.debug("attaching clean Administrator instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdministratorDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdministratorDAO) ctx.getBean("AdministratorDAO");
	}
}