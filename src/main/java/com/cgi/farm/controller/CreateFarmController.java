package com.cgi.farm.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgi.farm.model.Animal;
import com.cgi.farm.model.AnimalType;
import com.cgi.farm.model.Farm;
import com.cgi.farm.model.Farmer;
import com.cgi.farm.model.Food;
import com.cgi.farm.model.FoodType;
import com.cgi.farm.service.IAnimalService;
import com.cgi.farm.service.IAnimalTypeService;
import com.cgi.farm.service.IFarmService;
import com.cgi.farm.service.IFarmerService;
import com.cgi.farm.service.IFoodService;
import com.cgi.farm.service.IFoodTypeService;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateFarmController.
 */
@Controller
public class CreateFarmController implements java.io.Serializable {
	
	/** The Constant serialVersionUID. */
	// Variables
	private static final long serialVersionUID = 3244193094927483286L;
	
	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(CreateFarmController.class);

	/** The farmer service. */
	@Autowired
	IFarmerService farmerService;

	/** The farm service. */
	@Autowired
	IFarmService farmService;

	/** The animal service. */
	@Autowired
	IAnimalService animalService;

	/** The food service. */
	@Autowired
	IFoodService foodService;

	/** The animal type service. */
	@Autowired
	IAnimalTypeService animalTypeService;

	/** The food type service. */
	@Autowired
	IFoodTypeService foodTypeService;

	/** The farm to be added. */
	// Farm to be created
	Farm farmToBeAdded;
	
	/** The last animal ID. */
	static int lastAnimalID = 0;
	
	/** The last food ID. */
	static int lastFoodID = 0;

	/**
	 * This method will return the page that contains two animal tables.
	 *
	 * @param model the model
	 * @return {@link String} the page to return
	 */
	@RequestMapping(value = { "/animalTables", }, method = RequestMethod.GET)
	public String getAnimalTables(ModelMap model) {
		Assert.notNull(model, "model must not be null");
		logger.info("Beginning of function getAnimalTables(model) with model:"
				+ model.toString());

		HashMap<String, Integer> foodTotals = new HashMap<>();

		model.addAttribute("hasAnimals", false);
		if (farmToBeAdded.getAnimals() != null) {
			if (farmToBeAdded.getAnimals().size() > 0) {

				for (Animal anAnimal : farmToBeAdded.getAnimals()) {
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
				model.addAttribute("farmToBeAdded", farmToBeAdded);
			}

		}
		logger.info("End of function getAnimalTables(): ");
		return "animalTables";
	}

	/**
	 * This method will provide the medium to save a new farm.
	 *
	 * @return the string
	 */
	@RequestMapping(value = { "/SaveFarm" }, method = RequestMethod.GET)
	public String saveFarm() {
		Assert.notNull(farmToBeAdded, "farmToBeAdded must not be null");
		logger.info("Beginning of function saveFarm(): ");
		farmService.saveFarm(farmToBeAdded);
		logger.info("End of function saveFarm(): ");
		return "valid";
	}

	/**
	 * This method will provide the medium to create a new farm.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/CreateFarm" }, method = RequestMethod.GET)
	public String newFarm(ModelMap model) {
		Assert.notNull(model, "model must not be null");
		logger.info("Beginning of function newFarm(ModelMap model): " + model);
		farmToBeAdded = new Farm();
		Farmer aFarmer = new Farmer();
		Animal anAnimal = new Animal();

		// Variables
		List<AnimalType> animalTypes;
		List<FoodType> foodTypes;

		// Get list of animal types
		animalTypes = animalTypeService.findAll();
		// Get list of food types
		foodTypes = foodTypeService.findAll();

		lastAnimalID = animalService.findAll().size();
		lastFoodID = foodService.findAll().size();

		// Add food types and animal types to model
		model.addAttribute("animalTypes", animalTypes);
		model.addAttribute("foodTypes", foodTypes);
		model.addAttribute("farm", farmToBeAdded);
		model.addAttribute("farmer", aFarmer);
		model.addAttribute("animal", anAnimal);
		model.addAttribute("edit", false);
		model.addAttribute("hasAnimals", false);
		logger.info("End of function newFarm(ModelMap model): ");
		return "createFarm";
	}

	/**
	 * This method will verify if a farm exists.
	 *
	 * @param model the model
	 * @param testAddress the test address
	 * @return the string
	 */
	@RequestMapping(value = { "/VerifyFarmAdress/{testAddress}" }, method = RequestMethod.GET)
	public String verifyFarmAdress(ModelMap model,
			@PathVariable String testAddress) {
		Assert.notNull(model, "model must not be null");
		Assert.notNull(testAddress, "testAddress must not be null");
		logger.info("Beginning of function verifyFarmAdress(@PathVariable String testAddress): "
				+ testAddress);
		
		Farm aTestFarm = farmService.findByAddress(testAddress);
		if (aTestFarm == null || !testAddress.equalsIgnoreCase("")) {

			// Also add farm to model
			// Init farm object
			farmToBeAdded.setAddress(testAddress);
			// Add to model
			model.addAttribute("farmToBeAdded", farmToBeAdded);
			return "valid";
		}
		// Clear farm model
		model.remove("farmToBeAdded");
		logger.info("End of function  verifyFarmAdress(@PathVariable String testAddress): ");

		return "invalid";
	}

	/**
	 * This method will verify if a farmer exists.
	 *
	 * @param model the model
	 * @param farmerName the farmer name
	 * @param farmerAge the farmer age
	 * @return the string
	 */
	@RequestMapping(value = { "/VerifyFarmer/{farmerName}/{farmerAge}" }, method = RequestMethod.GET)
	public String verifyFarmer(ModelMap model, @PathVariable String farmerName,
			@PathVariable Integer farmerAge) {
		Assert.notNull(model, "model can't be null");
		Assert.notNull(farmerName, "farmerName can't be null");
		Assert.notNull(farmerAge, "farmerAge can't be null");
		
		logger.info("Beginning of function verifyFarmer(@PathVariable String farmerName,@PathVariable int farmerAge) "
				+ farmerName + " - " + farmerAge);
		Farmer aTestFarmer = farmerService.findByName(farmerName);
		if (aTestFarmer == null || !farmerName.equalsIgnoreCase("")) {
			// Also add farmer to model
			// Init farmer object
			aTestFarmer = new Farmer();
			aTestFarmer.setName(farmerName);
			aTestFarmer.setAge(farmerAge);
			farmToBeAdded.setFarmer(aTestFarmer);
			// Add to model
			model.addAttribute("farmToBeAdded", farmToBeAdded);
			return "valid";
		}
		// Clear farmer model
		model.remove("farmerToBeAdded");

		logger.info("End of function verifyFarmer(@PathVariable String farmerName,@PathVariable int farmerAge): ");
		return "invalid";
	}

	/**
	 * This method will add food to a farm.
	 *
	 * @param model the model
	 * @param animalType the animal type
	 * @param foodType the food type
	 * @param quantity the quantity
	 * @return the string
	 */
	@RequestMapping(value = { "/AddFoodAnimal/{animalType}/{foodType}/{quantity}" }, method = RequestMethod.GET)
	public String AddFoodAnimal(ModelMap model,
			@PathVariable String animalType, @PathVariable String foodType,
			@PathVariable Integer quantity) {
		Assert.notNull(model, "model must not be null");
		Assert.notNull(animalType, "animalType must not be null");
		Assert.notNull(foodType, "foodType must not be null");
		Assert.notNull(quantity, "quantity must not be null");
		
		logger.info("Beginning of function addFood(args...) : ");

		lastAnimalID++;
		lastFoodID++;

		// Variables
		FoodType aFoodType = null;
		AnimalType anAnimalType = null;
		Animal aNewAnimal = new Animal();
		Food aNewFood = new Food();

		// Create food type entry
		// Get list of food types
		List<FoodType> foodTypes = foodTypeService.findAll();

		for (FoodType localFoodType : foodTypes) {
			if (localFoodType.getName().equals(foodType)) {
				aFoodType = localFoodType;
			}
		}

		// Create animal type entry
		List<AnimalType> animalTypes = animalTypeService.findAll();
		for (AnimalType localAnimalType : animalTypes) {
			if (localAnimalType.getName().equals(animalType)) {
				anAnimalType = localAnimalType;
			}
		}
		aNewFood.setId_food(lastFoodID);
		aNewFood.setQuantity(quantity);
		aNewFood.setFoodType(aFoodType);
		aNewAnimal.setId_animal(lastAnimalID);
		aNewAnimal.setfoodEated(0);
		aNewAnimal.setType(anAnimalType);
		aNewAnimal.setFarm(farmToBeAdded);
		animalService.addFood(aNewAnimal, aNewFood);
		aNewFood.setAnAnimal(aNewAnimal);
		// Assign food and animal to farm

		farmService.addAnimal(farmToBeAdded, aNewAnimal);
		model.addAttribute("hasAnimals", true);
		// update model
		model.addAttribute("farmToBeAdded", farmToBeAdded);
		logger.info("End of function addFood(args...): ");
		return "valid";
	}

}
