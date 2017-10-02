package com.cgi.farm.service.impl;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cgi.farm.dao.impl.FoodTypeDaoImpl;
import com.cgi.farm.model.FoodType;
import com.cgi.farm.service.IFoodTypeService;

@Service("FoodTypeService")
@Transactional
public class FoodTypeServiceImpl implements IFoodTypeService, InitializingBean {

	@Autowired
	FoodTypeDaoImpl dao;

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(dao, "dao can t be null");

	}

	@Override
	public FoodType findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<FoodType> findAll() {
		return dao.findAll();
	}

}
