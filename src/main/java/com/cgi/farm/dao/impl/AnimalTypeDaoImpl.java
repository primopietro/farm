package com.cgi.farm.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cgi.farm.dao.IAbstractDao;
import com.cgi.farm.dao.IAnimalTypeDao;
import com.cgi.farm.model.AnimalType;

@Repository("animalTypeDao")
public class AnimalTypeDaoImpl extends IAbstractDao<String, AnimalType> implements IAnimalTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<AnimalType> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<AnimalType>)crit.list();
	}

	@Override
	public AnimalType findByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		return (AnimalType) crit.uniqueResult();
	}

	
}
