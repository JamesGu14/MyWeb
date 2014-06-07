package com.james.myweb.model;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * StudentCourseRegistration entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.james.myweb.model.StudentCourseRegistration
 * @author MyEclipse Persistence Tools
 */
public class StudentCourseRegistrationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(StudentCourseRegistrationDAO.class);

	// property constants

	public void save(StudentCourseRegistration transientInstance) {
		log.debug("saving StudentCourseRegistration instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StudentCourseRegistration persistentInstance) {
		log.debug("deleting StudentCourseRegistration instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudentCourseRegistration findById(java.lang.Integer id) {
		log.debug("getting StudentCourseRegistration instance with id: " + id);
		try {
			StudentCourseRegistration instance = (StudentCourseRegistration) getSession().get(
					"com.james.myweb.model.StudentCourseRegistration", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<StudentCourseRegistration> findByExample(StudentCourseRegistration instance) {
		log.debug("finding StudentCourseRegistration instance by example");
		try {
			List<StudentCourseRegistration> results = (List<StudentCourseRegistration>) getSession()
					.createCriteria("com.james.myweb.model.StudentCourseRegistration").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding StudentCourseRegistration instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from StudentCourseRegistration as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all StudentCourseRegistration instances");
		try {
			String queryString = "from StudentCourseRegistration";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StudentCourseRegistration merge(StudentCourseRegistration detachedInstance) {
		log.debug("merging StudentCourseRegistration instance");
		try {
			StudentCourseRegistration result = (StudentCourseRegistration) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StudentCourseRegistration instance) {
		log.debug("attaching dirty StudentCourseRegistration instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudentCourseRegistration instance) {
		log.debug("attaching clean StudentCourseRegistration instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}