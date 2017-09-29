package com.cgi.farm.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cgi.farm.model.Farmer;
import com.cgi.farm.model.Food;

@Repository("foodDao")
public class FoodDaoImpl extends AbstractDao<String, Food> implements FoodDao {

	@Override
	public List<Food> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<Food>)crit.list();
	}

	@Override
	public Food findByID(int ID) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id_food", ID));
		return (Food) crit.uniqueResult();
	}

	public void save(Food aFood){
		persist(aFood);
	}
	
}
