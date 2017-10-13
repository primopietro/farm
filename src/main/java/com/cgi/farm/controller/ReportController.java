package com.cgi.farm.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgi.farm.model.Farm;
import com.cgi.farm.service.IFarmService;

/**
 * The Class ReportController.
 */
@Controller
public class ReportController implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	//Variables 
	private static final long serialVersionUID = 3244193094927483286L;
	
	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(CreateFarmController.class);

	/** The farm service. */
	@Autowired
	IFarmService farmService;

	/** The farm to be displayed. */
	// Farm to be edited
	Farm farmToBeDisplayed;
	
	/**
	 * This method will provide the medium to add a new farm.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/Report" }, method = RequestMethod.GET)
	public String GetFarmReport(ModelMap model) {
		Assert.notNull(model, "model must not be null");
		logger.info("Beginning of function  GetFarmReport(): " );
		
		
		farmToBeDisplayed = new Farm();
		model.addAttribute("farm", farmToBeDisplayed);
		logger.info("End of function  GetFarmReport(): ");
		return "farmReport";
	}
	
	/**
	 * This method will init the variables to get a farm report.
	 *
	 * @param model the model
	 * @param farmAddress the farm address
	 * @return the string
	 */
	@RequestMapping(value = { "/GenerateReport/{farmAddress}" }, method = RequestMethod.GET)
	public String GenerateReport(ModelMap model, @PathVariable String farmAddress) {
		Assert.notNull(model, "model must not be null");
		logger.info("Beginning of function  GetFarmReport(): " );		
		
		
		Farm aTestFarm = null;
		aTestFarm = farmService.findByAddress(farmAddress);
		if(aTestFarm == null){
			return "invalid";
		}
		
		farmToBeDisplayed = aTestFarm;
		model.addAttribute("farm", farmToBeDisplayed);
		logger.info("End of function  GetFarmReport(): ");
		return "valid";
	}
	
	/**
	 * This method will init the variables to get a farm report.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/GetReportTable" }, method = RequestMethod.GET)
	public String GetReportTable(ModelMap model) {
		Assert.notNull(farmToBeDisplayed, "farmToBeDisplayed must not be null");
		Assert.notNull(model, "model must not be null");
		logger.info("Beginning of function  GetReportTable(): " );		
		model.addAttribute("farm", farmToBeDisplayed);
		logger.info("End of function  GetReportTable(): ");
		return "reportTable";
	}
	
}
