package cn.edu.xmu.course.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.Topic;

/**
 * A data access object (DAO) providing persistence and search support for Topic
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see cn.edu.xmu.course.pojo.Topic
 * @author MyEclipse Persistence Tools
 */

public class TopicDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TopicDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String AUTHOR_NAME = "authorName";
	public static final String LAST_ANSWER = "lastAnswer";
	public static final String COUNT_PERSON = "countPerson";
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	protected void initDao() {
		// do nothing
	}

	public void save(Topic transientInstance) {
		log.debug("saving Topic instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Topic persistentInstance) {
		log.debug("deleting Topic instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Topic findById(java.lang.Integer id) {
		log.debug("getting Topic instance with id: " + id);
		try {
			Topic instance = (Topic) getHibernateTemplate().get(
					"cn.edu.xmu.course.pojo.Topic", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Topic instance) {
		log.debug("finding Topic instance by example");
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
		log.debug("finding Topic instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Topic as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * 根据学院查找留言
	 * 
	 * @param school
	 * @return
	 */
	public List getTopicByShcool(School school) {
		try {
			String queryString = "from Topic as model where model.course.department.school = ?";
			return getHibernateTemplate().find(queryString, school);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * 根据老师查找留言
	 * 
	 * @param teacher
	 * @return
	 */
	public List getTopicByTeacher(Teacher teacher) {
		try {
			String queryString = "from Topic as model where model.course.teacher = ?";
			return getHibernateTemplate().find(queryString, teacher);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List getTopicByDate(Teacher teacher, String date) {
		try {
			String queryString = "from Topic as model where model.lastUpdate > "
					+ date + " and model.course.teacher.id =" + teacher.getId();
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * 根据主题关键字以及学院模糊查找
	 * 
	 * @param key
	 * @return
	 * @auther 郑冰凌
	 */
	public List<Topic> searchTopicByKey(String key, School school) {
		try {
			String queryString = "from Topic as model where model.name like '%"
					+ key + "%' and model.course.department.school = ?";
			return getHibernateTemplate().find(queryString, school);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCourse(Course course) {
		try {
			String queryString = "from Topic as model where model.course.id=" + course.getId()+" order by model.lastUpdate DESC";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by key name failed", re);
			throw re;
		}
	}

	
	public List<Topic> findByName(Course course, Object name) {
		try {
			String queryString = "from Topic as model where model.name like '%"
					+ name + "%' and model.course.id=" + course.getId();
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by key name failed", re);
			throw re;
		}
	}

	public List<Topic> findByAuthorName(Course course, Object authorName) {
		try {
			String queryString = "from Topic as model where model.authorName like '%"
					+ authorName + "%' and model.course.id=" + course.getId();
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by key authorName failed", re);
			throw re;
		}
	}

	public List<Topic> findByNameAndAuthorName(Course course, Object name,
			Object authorName) {
		try {
			String queryString = "from Topic as model where model.name like '%"
					+ name + "%' and model.authorName like '%" + authorName
					+ "%' and model.course.id=" + course.getId();
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name and authorName failed", re);
			throw re;
		}
	}

	public List<Topic> findByTime(Course course, Date time) {
		String dftime = df.format(time);
		System.out.println("传入" + dftime);
		List<Topic> list = findByCourse(course);
		Iterator<Topic> it = list.iterator();
		while (it.hasNext()) {
			Topic topic = it.next();
			String dftime2 = df.format(topic.getTime());
			System.out.println(topic.getName() + "时间：" + dftime2);
			System.out.println(dftime2);
			if (!dftime2.equals(dftime))
				it.remove();
		}
		return list;
	}

	public List<Topic> findByAuthorNameAndTime(Course course,
			String authorName, Date time) {
		String dftime = df.format(time);
		List<Topic> list = findByAuthorName(course, authorName);
		Iterator<Topic> it = list.iterator();
		while (it.hasNext()) {
			Topic topic = it.next();
			String dftime2 = df.format(topic.getTime());
			if (!dftime2.equals(dftime))
				it.remove();
		}
		return list;
	}

	public List<Topic> findByNameAndAuthorNameAndTime(Course course,
			String name, String authorName, Date time) {
		String dftime = df.format(time);
		List<Topic> list = findByNameAndAuthorName(course, name, authorName);
		Iterator<Topic> it = list.iterator();
		while (it.hasNext()) {
			Topic topic = it.next();
			String dftime2 = df.format(topic.getTime());
			if (!dftime2.equals(dftime))
				it.remove();
		}
		return list;
	}

	public List<Topic> findByNameAndTime(Course course, String name, Date time) {
		String dftime = df.format(time);
		System.out.println("传入" + dftime);
		List<Topic> list = findByName(course, name);
		Iterator<Topic> it = list.iterator();
		while (it.hasNext()) {
			Topic topic = it.next();
			String dftime2 = df.format(topic.getTime());
			System.out.println(topic.getName() + "时间：" + dftime2);
			if (!dftime2.equals(dftime))
				it.remove();
		}
		return list;
	}

	public List findByLastAnswer(Object lastAnswer) {
		return findByProperty(LAST_ANSWER, lastAnswer);
	}

	public List findByCountPerson(Object countPerson) {
		return findByProperty(COUNT_PERSON, countPerson);
	}

	public List findAll() {
		log.debug("finding all Topic instances");
		try {
			String queryString = "from Topic";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Topic merge(Topic detachedInstance) {
		log.debug("merging Topic instance");
		try {
			Topic result = (Topic) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Topic instance) {
		log.debug("attaching dirty Topic instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Topic instance) {
		log.debug("attaching clean Topic instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TopicDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TopicDAO) ctx.getBean("TopicDAO");
	}
}