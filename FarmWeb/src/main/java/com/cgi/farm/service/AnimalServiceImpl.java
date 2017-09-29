package com.cgi.farm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgi.farm.dao.AnimalDao;
import com.cgi.farm.dao.FarmerDao;
import com.cgi.farm.model.Animal;
import com.cgi.farm.model.Farmer;

@Service("AnimalService")
@Transactional
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	AnimalDao dao;
	
	@Override
	public Animal findByID(int ID) {
		return dao.findByID(ID);
	}

	@Override
	public List<Animal> findAll() {
		return dao.findAll();
	}
	
}
