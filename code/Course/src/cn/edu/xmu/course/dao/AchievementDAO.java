package cn.edu.xmu.course.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.Achievement;

/**
 * A data access object (DAO) providing persistence and search support for
 * Achievement entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.Achievement
 * @author MyEclipse Persistence Tools
 */

public class AchievementDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(AchievementDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String FILE_NAME = "fileName";
	public static final String FILE_LINK = "fileLink";
	public static final String COURSE="course";
	
	protected void initDao() {
		// do nothing
	}

	public void save(Achievement transientInstance) {
		log.debug("saving Achievement instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Achievement persistentInstance) {
		log.debug("deleting Achievement instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Achievement findById(java.lang.Integer id) {
		log.debug("getting Achievement instance with id: " + id);
		try {
			Achievement instance = (Achievement) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.Achievement", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Achievement instance) {
		log.debug("finding Achievement instance by example");
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
		log.debug("finding Achievement instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Achievement as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findByCourse(int courseId){		
		return findByProperty("course.id", courseId);
		
	}
	public List findByCourse(Object course){		
		return findByProperty(COURSE, course);
		
	}
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByFileName(Object fileName) {
		return findByProperty(FILE_NAME, fileName);
	}

	public List findByFileLink(Object fileLink) {
		return findByProperty(FILE_LINK, fileLink);
	}
	
	public List findLastestSevenAchievements () {	 
	  	try {	  	  
	  		String queryString = 
	  			"select achievement from Achievement achievement order by achievement.time DESC";
	  		Query queryObject = getSession().createQuery(queryString);
	  		queryObject.setFirstResult(0); 
	  		queryObject.setMaxResults(7); 
	  		return queryObject.list();
	  	} catch(RuntimeException re) {
	  		log.error("find News failed", re);
	  		throw re;
	  	}
	  }

	public List findAll() {
		log.debug("finding all Achievement instances");
		try {
			String queryString = "from Achievement";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Achievement merge(Achievement detachedInstance) {
		log.debug("merging Achievement instance");
		try {
			Achievement result = (Achievement) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Achievement instance) {
		log.debug("attaching dirty Achievement instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Achievement instance) {
		log.debug("attaching clean Achievement instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AchievementDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AchievementDAO) ctx.getBean("AchievementDAO");
	}
}