package com.cgi.farm.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cgi.farm.dao.IAbstractDao;
import com.cgi.farm.dao.IFarmerDao;
import com.cgi.farm.model.Farmer;


/**
 * The Class FarmerDaoImpl.
 */
@Repository("farmerDao")
public class FarmerDaoImpl extends IAbstractDao<String, Farmer> implements IFarmerDao {

	/* (non-Javadoc)
	 * @see com.cgi.farm.dao.IFarmerDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Farmer> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<Farmer>)crit.list();
	}

	/* (non-Javadoc)
	 * @see com.cgi.farm.dao.IFarmerDao#findByName(java.lang.String)
	 */
	@Override
	public Farmer findByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		return (Farmer) crit.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.cgi.farm.dao.IFarmerDao#save(com.cgi.farm.model.Farmer)
	 */
	public void save(Farmer aFarmer){
		persist(aFarmer);
	}
	
}
