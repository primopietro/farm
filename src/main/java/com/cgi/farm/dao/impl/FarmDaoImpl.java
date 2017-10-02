package com.cgi.farm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cgi.farm.dao.IAbstractDao;
import com.cgi.farm.dao.IFarmDao;
import com.cgi.farm.model.Farm;

@Repository("farmDao")
public class FarmDaoImpl extends IAbstractDao<String, Farm> implements IFarmDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Farm> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<Farm>) crit.list();
	}

	@Override
	public Farm findFarmerName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("farmer.name", name));
		return (Farm) crit.uniqueResult();
	}

	@Override
	public Farm findByAddress(String address) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("address", address));
		return (Farm) crit.uniqueResult();
	}

	public void save(Farm aFarm) {
		persist(aFarm);
	}

}
