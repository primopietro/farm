package com.cgi.farm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgi.farm.dao.AnimalTypeDao;
import com.cgi.farm.dao.FarmerDao;
import com.cgi.farm.dao.FoodDao;
import com.cgi.farm.dao.FoodTypeDao;
import com.cgi.farm.model.AnimalType;
import com.cgi.farm.model.Farmer;
import com.cgi.farm.model.Food;
import com.cgi.farm.model.FoodType;

@Service("FoodService")
@Transactional
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodDao dao;
	
	@Override
	public Food findByID(int ID) {
		return dao.findByID(ID);
	}

	@Override
	public List<Food> findAll() {
		return dao.findAll();
	}
	
}
