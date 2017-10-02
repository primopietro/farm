package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.AnimalType;

public interface IAnimalTypeDao {

	List<AnimalType> findAll();
	
	AnimalType findByName(String name);
}
