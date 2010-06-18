package cn.edu.xmu.course.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.Popedom;

/**
 * A data access object (DAO) providing persistence and search support for
 * Popedom entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.Popedom
 * @author MyEclipse Persistence Tools
 */

public class PopedomDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(PopedomDAO.class);
	// property constants
	public static final String OUTLINE = "outline";
	public static final String COURSEWARE = "courseware";
	public static final String EXERCISE = "exercise";
	public static final String EXPERIMENT = "experiment";
	public static final String MOVIE = "movie";
	public static final String EXAMINATION = "examination";
	public static final String BOOK = "book";

	protected void initDao() {
		// do nothing
	}

	public void save(Popedom transientInstance) {
		log.debug("saving Popedom instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Popedom persistentInstance) {
		log.debug("deleting Popedom instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Popedom findById(java.lang.Integer id) {
		log.debug("getting Popedom instance with id: " + id);
		try {
			Popedom instance = (Popedom) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.Popedom", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Popedom instance) {
		log.debug("finding Popedom instance by example");
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
		log.debug("finding Popedom instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Popedom as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOutline(Object outline) {
		return findByProperty(OUTLINE, outline);
	}

	public List findByCourseware(Object courseware) {
		return findByProperty(COURSEWARE, courseware);
	}

	public List findByExercise(Object exercise) {
		return findByProperty(EXERCISE, exercise);
	}

	public List findByExperiment(Object experiment) {
		return findByProperty(EXPERIMENT, experiment);
	}

	public List findByMovie(Object movie) {
		return findByProperty(MOVIE, movie);
	}

	public List findByExamination(Object examination) {
		return findByProperty(EXAMINATION, examination);
	}

	public List findByBook(Object book) {
		return findByProperty(BOOK, book);
	}

	public List findAll() {
		log.debug("finding all Popedom instances");
		try {
			String queryString = "from Popedom";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Popedom merge(Popedom detachedInstance) {
		log.debug("merging Popedom instance");
		try {
			Popedom result = (Popedom) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Popedom instance) {
		log.debug("attaching dirty Popedom instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Popedom instance) {
		log.debug("attaching clean Popedom instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PopedomDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PopedomDAO) ctx.getBean("PopedomDAO");
	}
}