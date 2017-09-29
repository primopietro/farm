package com.cgi.farm.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cgi.farm.model.AnimalType;
import com.cgi.farm.model.Farmer;
import com.cgi.farm.model.FoodType;

@Repository("foodTypeDao")
public class FoodTypeDaoImpl extends AbstractDao<String, FoodType> implements FoodTypeDao {

	@Override
	public List<FoodType> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<FoodType>)crit.list();
	}

	@Override
	public FoodType findByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		return (FoodType) crit.uniqueResult();
	}

	
}
