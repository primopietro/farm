package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.Farmer;
import com.cgi.farm.model.Food;

public interface FarmerDao {

	List<Farmer> findAll();
	public void save(Farmer aFarmer);
	Farmer findByName(String name);
}
