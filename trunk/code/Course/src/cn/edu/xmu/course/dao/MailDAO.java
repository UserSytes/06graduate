package cn.edu.xmu.course.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.Mail;
import cn.edu.xmu.course.pojo.UserInfo;

/**
 * A data access object (DAO) providing persistence and search support for Mail
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.Mail
 * @author MyEclipse Persistence Tools
 */

public class MailDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(MailDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String STATUS = "status";
	public static final String SENDER = "sender";
	public static final String RECEIVER = "receiver";

	protected void initDao() {
		// do nothing
	}

	public void save(Mail transientInstance) {
		log.debug("saving Mail instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Mail persistentInstance) {
		log.debug("deleting Mail instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mail findById(java.lang.Integer id) {
		log.debug("getting Mail instance with id: " + id);
		try {
			Mail instance = (Mail) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.Mail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Mail instance) {
		log.debug("finding Mail instance by example");
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
		log.debug("finding Mail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Mail as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByReceiver(Object receiver) {
		log.debug("finding Mail instance with property: sender, value: " + receiver);
		try {
			String queryString = "from Mail as model where model.sort = 1 and model.receiver"
					+ "= ?";
			return getHibernateTemplate().find(queryString, receiver);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findBySender(UserInfo sender, int status) {
		log.debug("finding Mail instance with property: sender, value: " + sender);
		try {
			String queryString = "from Mail as model where model.sort = 2 and model.status ="+status+" and model.sender"
					+ "= ?";
			return getHibernateTemplate().find(queryString, sender);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Mail instances");
		try {
			String queryString = "from Mail";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Mail merge(Mail detachedInstance) {
		log.debug("merging Mail instance");
		try {
			Mail result = (Mail) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Mail instance) {
		log.debug("attaching dirty Mail instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mail instance) {
		log.debug("attaching clean Mail instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MailDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MailDAO) ctx.getBean("MailDAO");
	}
}