package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.Farm;

public interface IFarmDao {

	List<Farm> findAll();
	void save(Farm aFarm);
	void update(Farm aFarm);
	Farm findByAddress(String name);
	Farm findFarmerName(String name);
}
