package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.Farm;
import com.cgi.farm.model.Farmer;

public interface FarmDao {

	List<Farm> findAll();
	void save(Farm aFarm);
	Farm findByAddress(String name);
}
