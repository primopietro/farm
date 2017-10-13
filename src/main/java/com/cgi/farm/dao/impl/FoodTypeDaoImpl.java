package com.cgi.farm.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cgi.farm.dao.IAbstractDao;
import com.cgi.farm.dao.IFoodTypeDao;
import com.cgi.farm.model.FoodType;


/**
 * The Class FoodTypeDaoImpl.
 */
@Repository("foodTypeDao")
public class FoodTypeDaoImpl extends IAbstractDao<String, FoodType> implements IFoodTypeDao {

	
	/* (non-Javadoc)
	 * @see com.cgi.farm.dao.IFoodTypeDao#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<FoodType> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<FoodType>)crit.list();
	}

	/* (non-Javadoc)
	 * @see com.cgi.farm.dao.IFoodTypeDao#findByName(java.lang.String)
	 */
	@Override
	public FoodType findByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		return (FoodType) crit.uniqueResult();
	}

	
}
