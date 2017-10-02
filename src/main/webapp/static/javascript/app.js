/**
 * 
 */
var defaultPath = "/FarmWeb";
/**
 * **************************************************ADD FARM
 * RELATED**************************************************
 */
// Get farm by search type
$(document).on("click", "#confirmSearchType", function() {
	console.log("Begin of confirmSearchType");
	var searchType = $("#searchFarm").is(':checked');
	var searchedValue = $("#address").val();
	if (searchType == true) {
		searchType = "farm";
	} else {
		searchType = "farmer";
	}
	$.ajax({
		url : defaultPath + "/SearchFarm/" + searchType + "/" + searchedValue,
		success : function(data) {
			if (data == "valid") {
				console.log("Farm found");
				$("#foodTables").load(defaultPath + "/foodTables");

			} else {
				console.log("Farm not found");
				$("#foodTables").html("");
			}
		},
	});
	console.log("End of confirmSearchType");
});
$(document).on("click", "#eatAllFood", function() {
	$.ajax({
		url : defaultPath + "/EatAllFood",
		success : function(data) {
			if (data == "valid") {
				$("#foodTables").load(defaultPath + "/foodTables");
			}
		},
	});
});

$(document).on("change", "#address", function() {
	$("#foodTables").html("");
});

// Verify valid farm
$(document).on("click", "#verifyFarmAdress", function() {
	console.log("Begin of verify farm address");
	var farmAddress = $("#address").val();
	$.ajax({
		url : defaultPath + "/VerifyFarmAdress/" + farmAddress,
		success : function(data) {
			if (data == "valid") {
				console.log("Valid address");
				$("#address").removeClass("invalidInput");
				$("#address").addClass("validInput");
				toggleFarmerForm("show");
				toggleAnimalForm("hide");
			} else {
				console.log("Address not valid");
				$("#address").removeClass("validInput");
				$("#address").addClass("invalidInput");
				toggleFarmerForm("hide");
				toggleAnimalForm("hide");
			}
		},
	});
	console.log("End of verify farm address");
});

// Verify valid farmer
$(document).on("click", "#verifyFarmer", function() {
	console.log("Begin of verify farmer ");
	var farmerName = $("#name").val();
	var farmerAge = $("#age").val();
	$.ajax({
		url : defaultPath + "/VerifyFarmer/" + farmerName + "/" + farmerAge,
		success : function(data) {
			if (data == "valid") {
				console.log("Farmer valid");
				$("#formFarmer input").removeClass("invalidInput");
				$("#formFarmer input").addClass("validInput");
				toggleAnimalForm("show");

			} else {
				console.log("Farmer not valid");
				$("#formFarmer input").removeClass("validInput");
				$("#formFarmer input").addClass("invalidInput");
				toggleAnimalForm("hide");
			}

		},
	});
	console.log("End of verify farmer");
});

// Add food and animal to the farm
$(document).on(
		"click",
		"#addFoodAnimal",
		function() {
			console.log("Begin of add food animal ");
			var animalType = $("#animalType").val();
			var foodType = $("#foodType").val();
			var quantity = $("#foodEated").val();
			$.ajax({
				url : defaultPath + "/AddFoodAnimal/" + animalType + "/"
						+ foodType + "/" + quantity,
				success : function(data) {
					$("#animalDataTable").load(defaultPath + "/animalTables");
				},
			});
			console.log("End of add food animal");
		});

// Verify Farmer name
function toggleFarmerForm(data) {
	console.log("Begin of toggleFarmerForm(data)");
	// if valid, show form
	if (data == "valid") {
		showFarmerForm();
	}
	// Else hide form
	else {
		hideFarmerForm();
	}
	console.log("End of toggleFarmerForm(data)");
}

// Remove class on change
$(document).on(
		"change",
		"input",
		function() {
			console.log("Begin of $(document).on('change', 'input'");
			$(this).removeClass("validInput");
			$(this).removeClass("invalidInput");
			if ($(this).attr("name") == "address") {
				toggleFarmerForm("hide");
				toggleAnimalForm("hide");
			} else if ($(this).attr("name") == "name"
					|| $(this).attr("name") == "age") {
				toggleAnimalForm("hide");
			}
			console.log("End of $(document).on('change', 'input'");
		});
// Register farm
$(document).on("click", "#saveFarm", function() {
	console.log("Begin of $(document).on('click', '#saveFarm'");
	$.ajax({
		url : defaultPath + "/SaveFarm",
		success : function(data) {
			console.log(data);
			window.location.href = defaultPath + '/';
		},
	});
	console.log("End of $(document).on('click', '#saveFarm'");
});
$(document).ready(function() {
	console.log("Begin of $(document).ready");
	toggleFarmerForm("hide");
	toggleAnimalForm("hide");
	console.log("End of $(document).ready");
})
function toggleAnimalForm(action) {
	console.log("Begin of toggleAnimalForm(action)");
	if (action == "show") {
		$("#animalForm").show();
	} else {
		$("#animalForm").hide();
	}
	console.log("Begin of toggleAnimalForm(action)");
}
function toggleFarmerForm(action) {
	console.log("Begin of toggleFarmerForm(action)");
	if (action == "show") {
		$("#formFarmer").show();
	} else {
		$("#formFarmer").hide();
	}
	console.log("End of toggleFarmerForm(action)");
}