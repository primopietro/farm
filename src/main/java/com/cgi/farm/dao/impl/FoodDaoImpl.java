package com.cgi.farm.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cgi.farm.dao.IAbstractDao;
import com.cgi.farm.dao.IFoodDao;
import com.cgi.farm.model.Food;


/**
 * The Class FoodDaoImpl.
 */
@Repository("foodDao")
public class FoodDaoImpl extends IAbstractDao<String, Food> implements IFoodDao {

	/* (non-Javadoc)
	 * @see com.cgi.farm.dao.IFoodDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Food> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<Food>)crit.list();
	}

	/* (non-Javadoc)
	 * @see com.cgi.farm.dao.IFoodDao#findByID(int)
	 */
	@Override
	public Food findByID(int ID) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id_food", ID));
		return (Food) crit.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.cgi.farm.dao.IFoodDao#save(com.cgi.farm.model.Food)
	 */
	public void save(Food aFood){
		persist(aFood);
	}
	
}
