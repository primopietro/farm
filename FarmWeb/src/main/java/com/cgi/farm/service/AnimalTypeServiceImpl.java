package com.cgi.farm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgi.farm.dao.AnimalTypeDao;
import com.cgi.farm.dao.FarmerDao;
import com.cgi.farm.model.AnimalType;
import com.cgi.farm.model.Farmer;

@Service("AnimalTypeService")
@Transactional
public class AnimalTypeServiceImpl implements AnimalTypeService {

	@Autowired
	AnimalTypeDao dao;
	
	@Override
	public AnimalType findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<AnimalType> findAll() {
		return dao.findAll();
	}
	
}
