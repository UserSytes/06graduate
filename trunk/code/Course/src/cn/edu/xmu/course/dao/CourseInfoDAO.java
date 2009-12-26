package cn.edu.xmu.course.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Query;
import cn.edu.xmu.course.pojo.CourseInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * CourseInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.CourseInfo
 * @author MyEclipse Persistence Tools
 */

public class CourseInfoDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CourseInfoDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String SORT = "sort";

	protected void initDao() {
		// do nothing
	}

	public void save(CourseInfo transientInstance) {
		log.debug("saving CourseInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CourseInfo persistentInstance) {
		log.debug("deleting CourseInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CourseInfo findById(java.lang.Integer id) {
		log.debug("getting CourseInfo instance with id: " + id);
		try {
			CourseInfo instance = (CourseInfo) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.CourseInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CourseInfo instance) {
		log.debug("finding CourseInfo instance by example");
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
		log.debug("finding CourseInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CourseInfo as model where model."
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

	public List findBySort(Object sort) {
		return findByProperty(SORT, sort);
	}

	public List findAll() {
		log.debug("finding all CourseInfo instances");
		try {
			String queryString = "from CourseInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CourseInfo merge(CourseInfo detachedInstance) {
		log.debug("merging CourseInfo instance");
		try {
			CourseInfo result = (CourseInfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public List findByCourse(int courseId,int sort){
		log.debug("finding CourseInfo instance by courseId and sort");
		try {

			Query q = getSession().createQuery(
					"select courseInfo from CourseInfo courseInfo where courseInfo.course.id='" + courseId
							+ "' and sort='" + sort + "'");
			List results = q.list();
			log
					.debug("find by Loginname and password successful, result size: "
							+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by Loginname and password failed", re);
			throw re;
		}
	}

	public void attachDirty(CourseInfo instance) {
		log.debug("attaching dirty CourseInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CourseInfo instance) {
		log.debug("attaching clean CourseInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CourseInfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CourseInfoDAO) ctx.getBean("CourseInfoDAO");
	}
}