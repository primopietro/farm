package com.cgi.farm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cgi.farm.model.Animal;
import com.cgi.farm.model.AnimalType;
import com.cgi.farm.model.Farm;
import com.cgi.farm.model.Farmer;
import com.cgi.farm.model.Food;
import com.cgi.farm.model.FoodType;
import com.cgi.farm.service.AnimalService;
import com.cgi.farm.service.AnimalTypeService;
import com.cgi.farm.service.FarmService;
import com.cgi.farm.service.FarmerService;
import com.cgi.farm.service.FoodService;
import com.cgi.farm.service.FoodTypeService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	// Variables
	final static Logger logger = Logger.getLogger(AppController.class);

	@Autowired
	FarmerService farmerService;

	@Autowired
	FarmService farmService;

	@Autowired
	AnimalService animalService;
	
	@Autowired
	FoodService foodService;
	
	@Autowired
	AnimalTypeService animalTypeService;

	@Autowired
	FoodTypeService foodTypeService;

	// Farm to be created
	Farm farmToBeAdded;
	static int lastAnimalID =0;
	static int lastFoodID =0;

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/", "/list", "/home", "/default" }, method = RequestMethod.GET)
	public String listOptions(ModelMap model) {
		logger.info("Beginning of function  listOptions(): ");

		logger.info("End of function  listOptions(): ");
		return "mainPage";
	}

	/**
	 * This method will return the page that contains two animal tables.
	 */
	@RequestMapping(value = { "/animalTables", }, method = RequestMethod.GET)
	public String getAnimalTables(ModelMap model) {
		logger.info("Beginning of function getAnimalTables(): ");

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
	 * This method will provide the medium to add a new farm.
	 */
	@RequestMapping(value = { "/SaveFarm" }, method = RequestMethod.GET)
	public String saveFarm() {
		logger.info("Beginning of function saveFarm(): " );
		assert(farmToBeAdded != null);
		farmService.saveFarm(farmToBeAdded);
		logger.info("End of function saveFarm(): ");
		return "valid";
	}
	
	/**
	 * This method will provide the medium to add a new farm.
	 */
	@RequestMapping(value = { "/CreateFarm" }, method = RequestMethod.GET)
	public String newFarm(ModelMap model) {
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
	 */
	@RequestMapping(value = { "/VerifyFarmAdress/{testAddress}" }, method = RequestMethod.GET)
	public String verifyFarmAdress(ModelMap model,
			@PathVariable String testAddress) {
		logger.info("Beginning of function verifyFarmAdress(@PathVariable String testAddress): "
				+ testAddress);
		assert (testAddress != null && !testAddress.equalsIgnoreCase(""));
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
	 */
	@RequestMapping(value = { "/VerifyFarmer/{farmerName}/{farmerAge}" }, method = RequestMethod.GET)
	public String verifyFarmer(ModelMap model, @PathVariable String farmerName,
			@PathVariable int farmerAge) {
		logger.info("Beginning of function verifyFarmer(@PathVariable String farmerName,@PathVariable int farmerAge) "
				+ farmerName + " - " + farmerAge);
		assert (farmerName != null && farmerAge > 0 && farmerAge < 100);
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
	 * This method will add food to a farm
	 */
	@RequestMapping(value = { "/AddFoodAnimal/{animalType}/{foodType}/{quantity}" }, method = RequestMethod.GET)
	public String AddFoodAnimal(ModelMap model,
			@PathVariable String animalType, @PathVariable String foodType,
			@PathVariable int quantity) {
		lastAnimalID++;
		lastFoodID++;
		logger.info("Beginning of function addFood(args...) : ");
		assert (animalType != null && foodType != null && quantity > 0);

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
		aNewAnimal.addFood(aNewFood);
		aNewFood.setAnAnimal(aNewAnimal);
		// Assign food and animal to farm
		farmToBeAdded.addAnimal(aNewAnimal);
		model.addAttribute("hasAnimals", true);
		// update model
		model.addAttribute("farmToBeAdded", farmToBeAdded);
		logger.info("End of function addFood(args...): ");
		return "valid";
	}

}
