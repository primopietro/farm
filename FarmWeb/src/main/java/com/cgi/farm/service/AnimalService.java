package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.Animal;
import com.cgi.farm.model.Farmer;

public interface AnimalService {
	Animal findByID(int ID);
	List<Animal> findAll();
}
