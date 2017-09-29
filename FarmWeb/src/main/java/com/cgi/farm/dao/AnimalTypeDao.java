package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.AnimalType;
import com.cgi.farm.model.Farmer;

public interface AnimalTypeDao {

	List<AnimalType> findAll();
	
	AnimalType findByName(String name);
}
