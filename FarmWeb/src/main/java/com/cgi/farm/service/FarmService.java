package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.Farm;
import com.cgi.farm.model.Farmer;


public interface FarmService {
	Farm findByAddress(String name);
	List<Farm> findAll();
	void saveFarm(Farm aFarm);
}
