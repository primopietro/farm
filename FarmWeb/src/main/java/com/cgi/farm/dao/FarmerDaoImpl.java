package com.cgi.farm.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cgi.farm.model.Farmer;
@Repository("farmerDao")
public class FarmerDaoImpl extends AbstractDao<String, Farmer> implements FarmerDao {

	@Override
	public List<Farmer> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<Farmer>)crit.list();
	}

	@Override
	public Farmer findByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		return (Farmer) crit.uniqueResult();
	}

	public void save(Farmer aFarmer){
		persist(aFarmer);
	}
	
}
