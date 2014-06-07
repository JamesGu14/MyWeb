package com.james.myweb.model;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TeacherCourseRegistration entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.james.myweb.model.TeacherCourseRegistration
 * @author MyEclipse Persistence Tools
 */
public class TeacherCourseRegistrationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TeacherCourseRegistrationDAO.class);

	// property constants

	public void save(TeacherCourseRegistration transientInstance) {
		log.debug("saving TeacherCourseRegistration instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TeacherCourseRegistration persistentInstance) {
		log.debug("deleting TeacherCourseRegistration instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeacherCourseRegistration findById(java.lang.Integer id) {
		log.debug("getting TeacherCourseRegistration instance with id: " + id);
		try {
			TeacherCourseRegistration instance = (TeacherCourseRegistration) getSession().get(
					"com.james.myweb.model.TeacherCourseRegistration", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TeacherCourseRegistration> findByExample(TeacherCourseRegistration instance) {
		log.debug("finding TeacherCourseRegistration instance by example");
		try {
			List<TeacherCourseRegistration> results = (List<TeacherCourseRegistration>) getSession()
					.createCriteria("com.james.myweb.model.TeacherCourseRegistration").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TeacherCourseRegistration instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from TeacherCourseRegistration as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TeacherCourseRegistration instances");
		try {
			String queryString = "from TeacherCourseRegistration";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TeacherCourseRegistration merge(TeacherCourseRegistration detachedInstance) {
		log.debug("merging TeacherCourseRegistration instance");
		try {
			TeacherCourseRegistration result = (TeacherCourseRegistration) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeacherCourseRegistration instance) {
		log.debug("attaching dirty TeacherCourseRegistration instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeacherCourseRegistration instance) {
		log.debug("attaching clean TeacherCourseRegistration instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}