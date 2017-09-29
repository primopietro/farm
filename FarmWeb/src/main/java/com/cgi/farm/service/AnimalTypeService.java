package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.AnimalType;
import com.cgi.farm.model.Farmer;

public interface AnimalTypeService {
	AnimalType findByName(String name);
	List<AnimalType> findAll();
}
