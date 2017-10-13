package com.cgi.farm.service.impl;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cgi.farm.dao.IAnimalTypeDao;
import com.cgi.farm.model.AnimalType;
import com.cgi.farm.service.IAnimalTypeService;


/**
 * The Class AnimalTypeServiceImpl.
 */
@Service("AnimalTypeService")
@Transactional
public class AnimalTypeServiceImpl implements IAnimalTypeService, InitializingBean  {

	/** The dao. */
	@Autowired
	IAnimalTypeDao dao;
	
	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(dao, "dao can t be null");
		
	}
	
	/* (non-Javadoc)
	 * @see com.cgi.farm.service.IAnimalTypeService#findByName(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public AnimalType findByName(String name) {
		return dao.findByName(name);
	}
	
	/* (non-Javadoc)
	 * @see com.cgi.farm.service.IAnimalTypeService#findAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AnimalType> findAll() {
		return dao.findAll();
	}
	
}
