package com.cgi.farm.controller;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgi.farm.model.Animal;
import com.cgi.farm.model.Farm;
import com.cgi.farm.model.Food;
import com.cgi.farm.service.IAnimalService;
import com.cgi.farm.service.IFarmService;
import com.cgi.farm.service.IFoodService;
// TODO: Auto-generated Javadoc

/**
 * The Class FeedAnimalsController.
 */
@Controller
public class FeedAnimalsController implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	//Variables 
	private static final long serialVersionUID = 3244193094927483286L;
	
	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(CreateFarmController.class);

	/** The farm service. */
	@Autowired
	IFarmService farmService;
	
	/** The animal service. */
	@Autowired
	IAnimalService animalService;
	
	/** The food service. */
	@Autowired
	IFoodService foodService;
	
	/** The farm to be edited. */
	// Farm to be edited
	Farm farmToBeEdited;
	
	/**
	 * This method will provide the medium to add a new farm.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/FeedAnimals" }, method = RequestMethod.GET)
	public String GetPageFeedAnimals(ModelMap model) {
		Assert.notNull(model, "model must not be null");
		logger.info("Beginning of function  GetPageFeedAnimals(): " );
		
		
		farmToBeEdited = new Farm();
		model.addAttribute("farm", farmToBeEdited);
		logger.info("End of function  GetPageFeedAnimals(): ");
		return "feedAnimals";
	}
	
	
	/**
	 * This method will verify if a farmer exists.
	 *
	 * @param model the model
	 * @param searchType the search type
	 * @param searchValue the search value
	 * @return the string
	 */
	@RequestMapping(value = { "/SearchFarm/{searchType}/{searchValue}" }, method = RequestMethod.GET)
	public String searchFarm(ModelMap model, @PathVariable String searchType,
			@PathVariable String searchValue) {
		Assert.notNull(model, "model can't be null");
		Assert.notNull(searchType, "searchType can't be null");
		Assert.notNull(searchValue, "searchValue can't be null");
		
		logger.info("Beginning of function searchFarm(ModelMap model, @PathVariable String searchType,@PathVariable String searchValue)");

		Farm aTestFarm = null;
		//If search by farmer
		if(searchType.equalsIgnoreCase("farmer")){
			 aTestFarm = farmService.findByFarmerName(searchValue);
		}
		//Search by farm name
		else{
			 aTestFarm = farmService.findByAddress(searchValue);
		}
		logger.info("End of function searchFarm(ModelMap model, @PathVariable String searchType,@PathVariable String searchValue): ");
		
		if(aTestFarm != null){
			farmToBeEdited = aTestFarm;
			model.addAttribute("farmToBeEdited", farmToBeEdited);
			return "valid";
		}
		return "invalid";
	}
	
	/**
	 * This method will return the page that contains two animal tables.
	 *
	 * @param model the model
	 * @return {@link String} the page to return
	 */
	@RequestMapping(value = { "/foodTables", }, method = RequestMethod.GET)
	public String getFoodTables(ModelMap model) {
		Assert.notNull(model, "model must not be null");
		logger.info("Beginning of function getFoodTables(model) with model:"
				+ model.toString());

		setEnvironementVariables(model);
		
		logger.info("End of function getFoodTables(): ");
		return "foodTables";
	}
	
	/**
	 * This method will return the page that contains two animal tables.
	 *
	 * @param model the model
	 * @return {@link String} the page to return
	 */
	@RequestMapping(value = { "/EatAllFood", }, method = RequestMethod.GET)
	public String eatAllFood(ModelMap model) {
		Assert.notNull(model, "model must not be null");
		logger.info("Beginning of function eatAllFood(ModelMap model)with model:"
				+ model.toString());

		
		
		model.addAttribute("hasAnimals", false);
		HashMap<String, Integer> foodTotals = new HashMap<>();
		if (farmToBeEdited.getAnimals() != null) {
			if (farmToBeEdited.getAnimals().size() > 0) {

				for (Animal anAnimal : farmToBeEdited.getAnimals()) {
					for (Food aFood : anAnimal.getFoodList()) {
						anAnimal.setfoodEated(anAnimal.getfoodEated()+aFood.getQuantity());
						aFood.setQuantity(0);
					}
				}

				// Add to model
				model.addAttribute("foodTotals", foodTotals);
				model.addAttribute("hasAnimals", true);
				
			}
		}
		
	
		model.addAttribute("farmToBeAdded", farmToBeEdited);
		setEnvironementVariables(model);
		logger.info("End of function eatAllFood(ModelMap model): ");
		return "valid";
	}
	
	/**
	 * Update farm.
	 *
	 * @return the string
	 */
	@RequestMapping(value = { "/UpdateLocalFarm", }, method = RequestMethod.GET)
	public String updateFarm(){
		logger.info("Beginning of function  updateFarm():");

		if (farmToBeEdited.getAnimals() != null) {
			if (farmToBeEdited.getAnimals().size() > 0) {

				for (Animal anAnimal : farmToBeEdited.getAnimals()) {
					for (Food aFood : anAnimal.getFoodList()) {
						animalService.updateAnimal(anAnimal);
						foodService.updateFood(aFood);
					}
				}
			}
		}
		farmService.updateFarm(farmToBeEdited);
		logger.info("End of function updateFarm(): ");
		return "valid";
	}
	
	/**
	 * Sets the environement variables.
	 *
	 * @param model the new environement variables
	 */
	public void setEnvironementVariables(ModelMap model){
		model.addAttribute("hasAnimals", false);
		HashMap<String, Integer> foodTotals = new HashMap<>();
		if (farmToBeEdited.getAnimals() != null) {
			if (farmToBeEdited.getAnimals().size() > 0) {

				for (Animal anAnimal : farmToBeEdited.getAnimals()) {
					for (Food aFood : anAnimal.getFoodList()) {
						// Check if entry is empty
						// if empty, init it
						if (foodTotals.get(aFood.getFoodType().getName()) == null) {
							foodTotals.put(aFood.getFoodType().getName(),
									aFood.getQuantity());
						}
						// Else if not empty, add to it
						else {
							Integer newAmount = foodTotals.get(aFood
									.getFoodType().getName());
							newAmount += aFood.getQuantity();
							foodTotals.put(aFood.getFoodType().getName(),
									newAmount);
						}

					}
				}

				// Add to model
				model.addAttribute("foodTotals", foodTotals);
				model.addAttribute("hasAnimals", true);
				model.addAttribute("farmToBeAdded", farmToBeEdited);
			}

		}
	}
}
