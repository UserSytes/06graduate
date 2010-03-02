package cn.edu.xmu.course.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.edu.xmu.course.pojo.Message;

/**
 * A data access object (DAO) providing persistence and search support for
 * Message entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.Message
 * @author MyEclipse Persistence Tools
 */

public class MessageDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(MessageDAO.class);
	// property constants
	public static final String CONTENT = "content";
	public static final String GRADE = "grade";

	protected void initDao() {
		// do nothing
	}

	public void save(Message transientInstance) {
		log.debug("saving Message instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Message persistentInstance) {
		log.debug("deleting Message instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Message findById(java.lang.Integer id) {
		log.debug("getting Message instance with id: " + id);
		try {
			Message instance = (Message) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.Message", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Message instance) {
		log.debug("finding Message instance by example");
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
		log.debug("finding Message instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Message as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//·ÖÒ³²éÑ¯
	  public List queryByPage (Object topic,int pageSize, int pageNow) {
	  	List list = new ArrayList() ;
	  	try {
	  	  if (pageSize>0 && pageNow>0) {
	  		String queryString = 
	  			"select message from Message message where message.topic=? order by message.time";
	  		Query queryObject = getSession().createQuery(queryString);
	  		queryObject.setParameter(0, topic);
	  		queryObject.setFirstResult((pageNow*pageSize-pageSize)); 
	  		queryObject.setMaxResults(pageSize); 
	  		list=queryObject.list();
	  	  }
	  	  
	  	} catch(RuntimeException re) {
	  		log.error("find Message by page failed", re);
	  		re.printStackTrace() ;
	  	}
	  	return list ;
	  }
	  
	public List findByTopic(Object topic) {
		return findByProperty("topic", topic);
	}
	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByGrade(Object grade) {
		return findByProperty(GRADE, grade);
	}

	public List findAll() {
		log.debug("finding all Message instances");
		try {
			String queryString = "from Message";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Message merge(Message detachedInstance) {
		log.debug("merging Message instance");
		try {
			Message result = (Message) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Message instance) {
		log.debug("attaching dirty Message instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Message instance) {
		log.debug("attaching clean Message instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MessageDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MessageDAO) ctx.getBean("MessageDAO");
	}
}