package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.Farmer;

public interface IFarmerDao {

	List<Farmer> findAll();
	public void save(Farmer aFarmer);
	Farmer findByName(String name);
}
