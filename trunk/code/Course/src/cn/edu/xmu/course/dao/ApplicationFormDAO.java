package cn.edu.xmu.course.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;

/**
 * A data access object (DAO) providing persistence and search support for
 * ApplicationForm entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.ApplicationForm
 * @author MyEclipse Persistence Tools
 */

public class ApplicationFormDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ApplicationFormDAO.class);
	// property constants
	public static final String UNIT = "unit";
	public static final String SCHOOL = "school";
	public static final String NAME = "name";
	public static final String LEVEL = "level";
	public static final String SORT = "sort";
	public static final String FIRST_SUBJECT = "firstSubject";
	public static final String SECOND_SUBJET = "secondSubjet";
	public static final String RESPONSER = "responser";
	public static final String FILE_LINK = "fileLink";
	public static final String FILENAME = "filename";

	protected void initDao() {
		// do nothing
	}

	public void save(ApplicationForm transientInstance) {
		log.debug("saving ApplicationForm instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ApplicationForm persistentInstance) {
		log.debug("deleting ApplicationForm instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ApplicationForm findById(java.lang.Integer id) {
		log.debug("getting ApplicationForm instance with id: " + id);
		try {
			ApplicationForm instance = (ApplicationForm) getHibernateTemplate()
					.get("cn.edu.xmu.course.pojo.ApplicationForm", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ApplicationForm instance) {
		log.debug("finding ApplicationForm instance by example");
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
		log.debug("finding ApplicationForm instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ApplicationForm as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUnit(Object unit) {
		return findByProperty(UNIT, unit);
	}

	public List findBySchool(Object school) {
		return findByProperty(SCHOOL, school);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List findBySort(Object sort) {
		return findByProperty(SORT, sort);
	}

	public List findByFirstSubject(Object firstSubject) {
		return findByProperty(FIRST_SUBJECT, firstSubject);
	}

	public List findBySecondSubjet(Object secondSubjet) {
		return findByProperty(SECOND_SUBJET, secondSubjet);
	}

	public List findByResponser(Object responser) {
		return findByProperty(RESPONSER, responser);
	}

	public List findByFileLink(Object fileLink) {
		return findByProperty(FILE_LINK, fileLink);
	}

	public List findByFilename(Object filename) {
		return findByProperty(FILENAME, filename);
	}
	public List findByCourse(int courseId)
	{
		System.out.println("\nfindByCourse&&&&&&&&&&&&&&&&&&"+courseId);
		return findByProperty("course.id", courseId);
	}
	public List findAll() {
		log.debug("finding all ApplicationForm instances");
		try {
			String queryString = "from ApplicationForm";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ApplicationForm merge(ApplicationForm detachedInstance) {
		log.debug("merging ApplicationForm instance");
		try {
			ApplicationForm result = (ApplicationForm) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ApplicationForm instance) {
		log.debug("attaching dirty ApplicationForm instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ApplicationForm instance) {
		log.debug("attaching clean ApplicationForm instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ApplicationFormDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ApplicationFormDAO) ctx.getBean("ApplicationFormDAO");
	}
}