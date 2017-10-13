package com.cgi.farm.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Class IAbstractDao.
 *
 * @param <PK> the generic type
 * @param <T> the generic type
 */
public abstract class IAbstractDao<PK extends Serializable, T> {
	
	/** The persistent class. */
	private final Class<T> persistentClass;
	
	/**
	 * Instantiates a new i abstract dao.
	 */
	@SuppressWarnings("unchecked")
	public IAbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Gets the by key.
	 *
	 * @param key the key
	 * @return the by key
	 */
	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	/**
	 * Persist.
	 *
	 * @param entity the entity
	 */
	public void persist(T entity) {
		getSession().persist(entity);
	}
	
	/**
	 * Update.
	 *
	 * @param entity the entity
	 */
	public void update(T entity) {
		getSession().update(entity);
	}
	
	/**
	 * Delete.
	 *
	 * @param entity the entity
	 */
	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	/**
	 * Creates the entity criteria.
	 *
	 * @return the criteria
	 */
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}

}
