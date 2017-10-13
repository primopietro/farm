package com.cgi.farm.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO: Auto-generated Javadoc
/**
 * The Class MainPageController.
 */
@Controller
@RequestMapping("/")
public class MainPageController implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3244193094927483286L;

	/** The Constant logger. */
	// Variables
	final static Logger logger = Logger.getLogger(MainPageController.class);

	/**
	 * This method will list all existing users.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/", "/list", "/home", "/default" }, method = RequestMethod.GET)
	public String listOptions(ModelMap model) {
		Assert.notNull(model, "model must not be null");
		logger.info("Beginning of function  listOptions(model): " + model.toString());

		logger.info("End of function  listOptions(model): "+ model.toString());
		return "mainPage";
	}

	
}
