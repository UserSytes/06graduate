package cn.edu.xmu.course.pojo;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.TeacherTeam;

/**
 * A data access object (DAO) providing persistence and search support for
 * TeacherTeam entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.TeacherTeam
 * @author MyEclipse Persistence Tools
 */

public class TeacherTeamDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TeacherTeamDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String POSITION = "position";
	public static final String LINK = "link";
	public static final String REMARK = "remark";
	public static final String FIELD = "field";

	protected void initDao() {
		// do nothing
	}

	public void save(TeacherTeam transientInstance) {
		log.debug("saving TeacherTeam instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TeacherTeam persistentInstance) {
		log.debug("deleting TeacherTeam instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeacherTeam findById(java.lang.Integer id) {
		log.debug("getting TeacherTeam instance with id: " + id);
		try {
			TeacherTeam instance = (TeacherTeam) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.TeacherTeam", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TeacherTeam instance) {
		log.debug("finding TeacherTeam instance by example");
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
		log.debug("finding TeacherTeam instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TeacherTeam as model where model."
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

	public List findByPosition(Object position) {
		return findByProperty(POSITION, position);
	}

	public List findByLink(Object link) {
		return findByProperty(LINK, link);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByField(Object field) {
		return findByProperty(FIELD, field);
	}

	public List findAll() {
		log.debug("finding all TeacherTeam instances");
		try {
			String queryString = "from TeacherTeam";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TeacherTeam merge(TeacherTeam detachedInstance) {
		log.debug("merging TeacherTeam instance");
		try {
			TeacherTeam result = (TeacherTeam) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeacherTeam instance) {
		log.debug("attaching dirty TeacherTeam instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeacherTeam instance) {
		log.debug("attaching clean TeacherTeam instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TeacherTeamDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TeacherTeamDAO) ctx.getBean("TeacherTeamDAO");
	}
}