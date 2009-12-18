package cn.edu.xmu.course.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.Chapter;

/**
 * A data access object (DAO) providing persistence and search support for
 * Chapter entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.Chapter
 * @author MyEclipse Persistence Tools
 */

public class ChapterDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ChapterDAO.class);
	// property constants
	public static final String NUMBER = "number";
	public static final String NAME = "name";
	public static final String REMARK = "remark";

	protected void initDao() {
		// do nothing
	}

	public void save(Chapter transientInstance) {
		log.debug("saving Chapter instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Chapter persistentInstance) {
		log.debug("deleting Chapter instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Chapter findById(java.lang.Integer id) {
		log.debug("getting Chapter instance with id: " + id);
		try {
			Chapter instance = (Chapter) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.Chapter", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Chapter instance) {
		log.debug("finding Chapter instance by example");
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
		log.debug("finding Chapter instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Chapter as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all Chapter instances");
		try {
			String queryString = "from Chapter";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Chapter merge(Chapter detachedInstance) {
		log.debug("merging Chapter instance");
		try {
			Chapter result = (Chapter) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Chapter instance) {
		log.debug("attaching dirty Chapter instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Chapter instance) {
		log.debug("attaching clean Chapter instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ChapterDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ChapterDAO) ctx.getBean("ChapterDAO");
	}
}