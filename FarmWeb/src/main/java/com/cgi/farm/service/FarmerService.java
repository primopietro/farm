package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.Farmer;

public interface FarmerService {
	Farmer findByName(String name);
	List<Farmer> findAll();
}
