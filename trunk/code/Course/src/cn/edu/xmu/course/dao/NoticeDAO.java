package cn.edu.xmu.course.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.Notice;

/**
 * A data access object (DAO) providing persistence and search support for
 * Notice entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.Notice
 * @author MyEclipse Persistence Tools
 */

public class NoticeDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(NoticeDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String SORT = "sort";
	public static final String COURSE = "course";

	protected void initDao() {
		// do nothing
	}

	public void save(Notice transientInstance) {
		log.debug("saving Notice instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Notice persistentInstance) {
		log.debug("deleting Notice instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Notice findById(java.lang.Integer id) {
		log.debug("getting Notice instance with id: " + id);
		try {
			Notice instance = (Notice) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.Notice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Notice instance) {
		log.debug("finding Notice instance by example");
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
		log.debug("finding Notice instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Notice as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findLastestFiveNews (Object course,int sort) {
	  	List list = new ArrayList() ;
	  	try {
	  	  
	  		String queryString = 
	  			"select notice from Notice notice where notice.course=? and sort=? order by notice.time DESC";
	  		Query queryObject = getSession().createQuery(queryString);
	  		queryObject.setParameter(0, course);
	  		queryObject.setParameter(1, sort);
	  		queryObject.setFirstResult(0); 
	  		queryObject.setMaxResults(5); 
	  		list=queryObject.list();

	  	  
	  	} catch(RuntimeException re) {
	  		log.error("find Message by page failed", re);
	  		re.printStackTrace() ;
	  	}
	  	return list ;
	  }
	public List findByCourseAndSort(Object courseId,Object sort){
		log.debug("finding Notice instance by course and sort");
		try {

			Query q = getSession().createQuery(
					"select notice from Notice notice where notice.course.id='" + courseId
							+ "' and sort='" + sort + "' order by notice.time DESC");
			List results = q.list();
			log.debug("find by course and sort successful, result size: "
							+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by course and sort failed", re);
			throw re;
		}
	}
	
	/**
	 * 分页查询
	 * 
	 * @param hql
	 *            查询的条件
	 * @param offset
	 *            开始记录
	 * @param length
	 *            一次查询几条记录
	 * @return
	 */
	public List queryForPage(final String hql, final int offset,
			final int length) {

		Query query = getSession().createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List list = query.list();
		return list;
	}
	/**
	 * 查询所有记录数
	 * 
	 * @param hql
	 *            查询的条件
	 * @return 总记录数
	 */
	public int getAllRowCount(String hql) {
		return getHibernateTemplate().find(hql).size();

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
	
	public List findByCourse(Object course) {
		return findByProperty(COURSE, course);
	}
	
	public List findByTeacher(Integer teacherId) {
		return findByProperty("course.teacher.id", teacherId);
	}

	public List findAll() {
		log.debug("finding all Notice instances");
		try {
			String queryString = "from Notice";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Notice merge(Notice detachedInstance) {
		log.debug("merging Notice instance");
		try {
			Notice result = (Notice) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Notice instance) {
		log.debug("attaching dirty Notice instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Notice instance) {
		log.debug("attaching clean Notice instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NoticeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NoticeDAO) ctx.getBean("NoticeDAO");
	}
}