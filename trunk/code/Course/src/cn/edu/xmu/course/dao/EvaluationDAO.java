package cn.edu.xmu.course.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.Student;

/**
 * A data access object (DAO) providing persistence and search support for
 * Evaluation entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.Evaluation
 * @author MyEclipse Persistence Tools
 */

public class EvaluationDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(EvaluationDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String STATUS = "status";
	public static final String NAME = "name";
	public static final String COMPANY = "company";
	public static final String POSITION = "position";
	public static final String PHONE = "phone";
	public static final String EMAIL = "email";
	public static final String CONTENT = "content";
	public static final String SCORE = "score";

	protected void initDao() {
		// do nothing
	}

	public void save(Evaluation transientInstance) {
		log.debug("saving Evaluation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Evaluation persistentInstance) {
		log.debug("deleting Evaluation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Evaluation findById(java.lang.Integer id) {
		log.debug("getting Evaluation instance with id: " + id);
		try {
			Evaluation instance = (Evaluation) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.Evaluation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Evaluation instance) {
		log.debug("finding Evaluation instance by example");
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
	
	public List findCountAndScoreAvg(int courseId, int sort) {
		log.debug("finding Evaluation instance with property: course"
				+ ", value: " + courseId);
		try {
			String queryString = "select count(*),avg(score) from Evaluation as model where model.score != null and model.sort = "+sort+" and model.course.id"
					+"= "+courseId;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Evaluation instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Evaluation as model where model."
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
	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByCompany(Object company) {
		return findByProperty(COMPANY, company);
	}

	public List findByPosition(Object position) {
		return findByProperty(POSITION, position);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findAll() {
		log.debug("finding all Evaluation instances");
		try {
			String queryString = "from Evaluation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Evaluation merge(Evaluation detachedInstance) {
		log.debug("merging Evaluation instance");
		try {
			Evaluation result = (Evaluation) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Evaluation instance) {
		log.debug("attaching dirty Evaluation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Evaluation instance) {
		log.debug("attaching clean Evaluation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EvaluationDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EvaluationDAO) ctx.getBean("EvaluationDAO");
	}
	
	/**
	 * 根据用户名、课程查找
	 * @param course
	 * @param student
	 * @return
	 */
	public List findByCourseAndUsernameAndSort(Course course, Object username,int sort) {
		try {
			String queryString = "from Evaluation as model where model.course.id ="
					+ course.getId() + " and model.username= ? and model.sort="+sort;
			return getHibernateTemplate().find(queryString, username);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/**
	 * 根据SORT、课程查找
	 * @param course
	 * @param student
	 * @return
	 */
	public List findByCourseAndSort(Course course, Integer sort) {
		try {
			String queryString = "from Evaluation as model where model.course.id ="
					+ course.getId() + " and model.sort= "+sort;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}