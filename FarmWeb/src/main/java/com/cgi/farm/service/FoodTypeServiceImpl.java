package com.cgi.farm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgi.farm.dao.AnimalTypeDao;
import com.cgi.farm.dao.FarmerDao;
import com.cgi.farm.dao.FoodTypeDao;
import com.cgi.farm.model.AnimalType;
import com.cgi.farm.model.Farmer;
import com.cgi.farm.model.FoodType;

@Service("FoodTypeService")
@Transactional
public class FoodTypeServiceImpl implements FoodTypeService {

	@Autowired
	FoodTypeDao dao;
	
	@Override
	public FoodType findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<FoodType> findAll() {
		return dao.findAll();
	}
	
}
