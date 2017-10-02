package com.cgi.farm.service.impl;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cgi.farm.dao.IAnimalTypeDao;
import com.cgi.farm.model.AnimalType;
import com.cgi.farm.service.IAnimalTypeService;

@Service("AnimalTypeService")
@Transactional
public class AnimalTypeServiceImpl implements IAnimalTypeService, InitializingBean  {

	@Autowired
	IAnimalTypeDao dao;
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(dao, "dao can t be null");
		
	}
	@Override
	public AnimalType findByName(String name) {
		return dao.findByName(name);
	}
	
	@Override
	public List<AnimalType> findAll() {
		return dao.findAll();
	}
	
}
