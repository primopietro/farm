package com.cgi.farm.service.impl;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cgi.farm.dao.IFoodDao;
import com.cgi.farm.model.Food;
import com.cgi.farm.service.IFoodService;


/**
 * The Class FoodServiceImpl.
 */
@Service("FoodService")
@Transactional
public class FoodServiceImpl implements IFoodService, InitializingBean {

	/** The dao. */
	@Autowired
	IFoodDao dao;

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(dao, "dao can t be null");
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.cgi.farm.service.IFoodService#updateFood(com.cgi.farm.model.Food)
	 */
	public void updateFood(Food aFood){
		dao.update(aFood);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public Food findByID(int ID) {
		return dao.findByID(ID);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Food> findAll() {
		return dao.findAll();
	}
	
}
