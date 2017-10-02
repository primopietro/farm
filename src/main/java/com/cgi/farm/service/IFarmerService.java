package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.Farmer;

public interface IFarmerService {
	Farmer findByName(String name);
	List<Farmer> findAll();
}
