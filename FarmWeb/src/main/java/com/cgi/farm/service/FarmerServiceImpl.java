package com.cgi.farm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgi.farm.dao.FarmerDao;
import com.cgi.farm.model.Farmer;

@Service("FarmerService")
@Transactional
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	FarmerDao dao;
	
	@Override
	public Farmer findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<Farmer> findAll() {
		return dao.findAll();
	}
	
}
