package com.cgi.farm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgi.farm.dao.FarmDao;
import com.cgi.farm.dao.FarmerDao;
import com.cgi.farm.model.Farm;
import com.cgi.farm.model.Farmer;

@Service("FarmService")
@Transactional
public class FarmServiceImpl implements FarmService {

	@Autowired
	FarmDao dao;
	
	@Override
	public Farm findByAddress(String name) {
		return dao.findByAddress(name);
	}

	@Override
	public List<Farm> findAll() {
		return dao.findAll();
	}
	
	public void saveFarm(Farm aFarm){
		dao.save(aFarm);
	}
	
}
