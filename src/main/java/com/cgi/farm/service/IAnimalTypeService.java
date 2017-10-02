package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.AnimalType;

public interface IAnimalTypeService {
	AnimalType findByName(String name);
	List<AnimalType> findAll();
}
