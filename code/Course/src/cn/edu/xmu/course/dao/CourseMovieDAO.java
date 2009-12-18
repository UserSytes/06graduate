package cn.edu.xmu.course.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.CourseMovie;

/**
 * A data access object (DAO) providing persistence and search support for
 * CourseMovie entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.CourseMovie
 * @author MyEclipse Persistence Tools
 */

public class CourseMovieDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CourseMovieDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String FILENAME = "filename";
	public static final String AUTHOR = "author";
	public static final String FILE_LINK = "fileLink";

	protected void initDao() {
		// do nothing
	}

	public void save(CourseMovie transientInstance) {
		log.debug("saving CourseMovie instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CourseMovie persistentInstance) {
		log.debug("deleting CourseMovie instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CourseMovie findById(java.lang.Integer id) {
		log.debug("getting CourseMovie instance with id: " + id);
		try {
			CourseMovie instance = (CourseMovie) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.CourseMovie", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CourseMovie instance) {
		log.debug("finding CourseMovie instance by example");
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
		log.debug("finding CourseMovie instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CourseMovie as model where model."
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

	public List findByFilename(Object filename) {
		return findByProperty(FILENAME, filename);
	}

	public List findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List findByFileLink(Object fileLink) {
		return findByProperty(FILE_LINK, fileLink);
	}

	public List findAll() {
		log.debug("finding all CourseMovie instances");
		try {
			String queryString = "from CourseMovie";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CourseMovie merge(CourseMovie detachedInstance) {
		log.debug("merging CourseMovie instance");
		try {
			CourseMovie result = (CourseMovie) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CourseMovie instance) {
		log.debug("attaching dirty CourseMovie instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CourseMovie instance) {
		log.debug("attaching clean CourseMovie instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CourseMovieDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CourseMovieDAO) ctx.getBean("CourseMovieDAO");
	}
}