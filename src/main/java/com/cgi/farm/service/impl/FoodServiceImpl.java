package com.cgi.farm.service.impl;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cgi.farm.dao.IFoodDao;
import com.cgi.farm.model.Farm;
import com.cgi.farm.model.Food;
import com.cgi.farm.service.IFoodService;

@Service("FoodService")
@Transactional
public class FoodServiceImpl implements IFoodService, InitializingBean {

	@Autowired
	IFoodDao dao;

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(dao, "dao can t be null");
		
	}
	
	
	public void updateFood(Food aFood){
		dao.update(aFood);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Food findByID(int ID) {
		return dao.findByID(ID);
	}

	@Override
	public List<Food> findAll() {
		return dao.findAll();
	}
	
}
