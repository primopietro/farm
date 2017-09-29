package com.cgi.farm.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cgi.farm.model.Farm;
import com.cgi.farm.model.Farmer;

@Repository("farmDao")
public class FarmDaoImpl extends AbstractDao<String, Farm> implements FarmDao {

	@Override
	public List<Farm> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<Farm>)crit.list();
	}

	@Override
	public Farm findByAddress(String address) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("address", address));
		return (Farm) crit.uniqueResult();
	}
	
	public void save(Farm aFarm){
		persist(aFarm);
	}


	
	
}
