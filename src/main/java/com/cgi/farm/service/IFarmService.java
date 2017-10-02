package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.Animal;
import com.cgi.farm.model.Farm;


public interface IFarmService {
	Farm findByAddress(String name);
	Farm findByFarmerName(String name);
	List<Farm> findAll();
	void saveFarm(Farm aFarm);
	public void addAnimal(Farm aFarm, Animal anAnimal);
	void updateFarm(Farm farmToBeEdited);
}
