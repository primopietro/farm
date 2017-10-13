package com.cgi.farm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cgi.farm.dao.IFarmDao;
import com.cgi.farm.model.Animal;
import com.cgi.farm.model.Farm;
import com.cgi.farm.service.IFarmService;


/**
 * The Class FarmServiceImpl.
 */
@Service("FarmService")
@Transactional
public class FarmServiceImpl implements IFarmService, InitializingBean  {

	/** The dao. */
	@Autowired
	IFarmDao dao;
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(dao, "dao can t be null");
		
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Farm findByAddress(String name) {
		return dao.findByAddress(name);
	}

	/* (non-Javadoc)
	 * @see com.cgi.farm.service.IFarmService#findByFarmerName(java.lang.String)
	 */
	public Farm findByFarmerName(String name){
		return dao.findFarmerName(name);
	}
	
	/* (non-Javadoc)
	 * @see com.cgi.farm.service.IFarmService#findAll()
	 */
	@Override
	public List<Farm> findAll() {
		return dao.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.cgi.farm.service.IFarmService#saveFarm(com.cgi.farm.model.Farm)
	 */
	public void saveFarm(Farm aFarm){
		dao.save(aFarm);
	}
	
	/* (non-Javadoc)
	 * @see com.cgi.farm.service.IFarmService#updateFarm(com.cgi.farm.model.Farm)
	 */
	public void updateFarm(Farm aFarm){
		dao.update(aFarm);
	}
	
	/* (non-Javadoc)
	 * @see com.cgi.farm.service.IFarmService#addAnimal(com.cgi.farm.model.Farm, com.cgi.farm.model.Animal)
	 */
	public void addAnimal(Farm aFarm, Animal anAnimal) {
		List<Animal> animalList = aFarm.getAnimals();
		if (animalList == null) {
			animalList = new ArrayList<>();
		}
		animalList.add(anAnimal);
		aFarm.setAnimals(animalList);
	}
}
