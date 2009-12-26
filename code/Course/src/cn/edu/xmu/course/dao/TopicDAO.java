package cn.edu.xmu.course.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.Topic;

/**
 * A data access object (DAO) providing persistence and search support for Topic
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.Topic
 * @author MyEclipse Persistence Tools
 */

public class TopicDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TopicDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String AUTHOR_NAME = "authorName";
	public static final String LAST_ANSWER = "lastAnswer";
	public static final String COUNT_PERSON = "countPerson";

	protected void initDao() {
		// do nothing
	}

	public void save(Topic transientInstance) {
		log.debug("saving Topic instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Topic persistentInstance) {
		log.debug("deleting Topic instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Topic findById(java.lang.Integer id) {
		log.debug("getting Topic instance with id: " + id);
		try {
			Topic instance = (Topic) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.Topic", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Topic instance) {
		log.debug("finding Topic instance by example");
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
		log.debug("finding Topic instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Topic as model where model."
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

	public List findByAuthorName(Object authorName) {
		return findByProperty(AUTHOR_NAME, authorName);
	}

	public List findByLastAnswer(Object lastAnswer) {
		return findByProperty(LAST_ANSWER, lastAnswer);
	}

	public List findByCountPerson(Object countPerson) {
		return findByProperty(COUNT_PERSON, countPerson);
	}

	public List findAll() {
		log.debug("finding all Topic instances");
		try {
			String queryString = "from Topic";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Topic merge(Topic detachedInstance) {
		log.debug("merging Topic instance");
		try {
			Topic result = (Topic) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Topic instance) {
		log.debug("attaching dirty Topic instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Topic instance) {
		log.debug("attaching clean Topic instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TopicDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TopicDAO) ctx.getBean("TopicDAO");
	}
}