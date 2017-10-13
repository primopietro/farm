package com.cgi.farm.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cgi.farm.dao.IAbstractDao;
import com.cgi.farm.dao.IAnimalTypeDao;
import com.cgi.farm.model.AnimalType;


/**
 * The Class AnimalTypeDaoImpl.
 */
@Repository("animalTypeDao")
public class AnimalTypeDaoImpl extends IAbstractDao<String, AnimalType> implements IAnimalTypeDao {

	/* (non-Javadoc)
	 * @see com.cgi.farm.dao.IAnimalTypeDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AnimalType> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<AnimalType>)crit.list();
	}

	/* (non-Javadoc)
	 * @see com.cgi.farm.dao.IAnimalTypeDao#findByName(java.lang.String)
	 */
	@Override
	public AnimalType findByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		return (AnimalType) crit.uniqueResult();
	}

	
}
