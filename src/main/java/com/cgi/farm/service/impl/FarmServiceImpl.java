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

@Service("FarmService")
@Transactional
public class FarmServiceImpl implements IFarmService, InitializingBean  {

	@Autowired
	IFarmDao dao;
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(dao, "dao can t be null");
		
	}
	@Override
	public Farm findByAddress(String name) {
		return dao.findByAddress(name);
	}

	public Farm findByFarmerName(String name){
		return dao.findFarmerName(name);
	}
	
	@Override
	public List<Farm> findAll() {
		return dao.findAll();
	}
	
	public void saveFarm(Farm aFarm){
		dao.save(aFarm);
	}
	public void updateFarm(Farm aFarm){
		dao.update(aFarm);
	}
	public void addAnimal(Farm aFarm, Animal anAnimal) {
		List<Animal> animalList = aFarm.getAnimals();
		if (animalList == null) {
			animalList = new ArrayList<>();
		}
		animalList.add(anAnimal);
		aFarm.setAnimals(animalList);
	}
}
