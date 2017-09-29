package com.cgi.farm.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cgi.farm.model.AnimalType;
import com.cgi.farm.model.Farmer;

@Repository("animalTypeDao")
public class AnimalTypeDaoImpl extends AbstractDao<String, AnimalType> implements AnimalTypeDao {

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
