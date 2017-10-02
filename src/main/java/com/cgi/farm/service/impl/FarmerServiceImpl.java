package com.cgi.farm.service.impl;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cgi.farm.dao.IFarmerDao;
import com.cgi.farm.model.Farmer;
import com.cgi.farm.service.IFarmerService;

@Service("FarmerService")
public class FarmerServiceImpl implements IFarmerService, InitializingBean  {

	@Autowired
	IFarmerDao dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(dao, "dao can t be null");
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public Farmer findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<Farmer> findAll() {
		return dao.findAll();
	}
	
}
