angular.module('listpageApp', []).controller('listpageCtrl', function($scope, $http, $location, $anchorScroll) {
	$scope.showAnimalTableHeader = false;
    $scope.currentUserId = localStorage.getItem('loggedInUserId');
    $scope.species = "";
    $scope.breed = "";
    $scope.cbIsAvailable = "N";
    $scope.cbIsBroken = "N";
    
	$scope.showTableHeader = function() {
        $scope.showAnimalTableHeader = true;
    };
	
    $scope.listAnimals = function() {
		$http.get("http://localhost:8080/RestService/resources/service/animals").success( function(response) {
			$scope.showAnimalTableHeader = true;
            $scope.animals = response.animals;
		});
    };
    
    $scope.searchAnimals = function() {
    	var search = { "species" : $scope.species, "breed" : $scope.breed, "is_available" : $scope.cbIsAvailable, "is_broken" : $scope.cbIsBroken};
		$http.post("http://localhost:8080/RestService/resources/service/search", JSON.stringify(search)).success( function(response) {			
			$scope.showAnimalTableHeader = true;
            $scope.animals = response.animals;
		});
    };  
   
    $scope.genButtonName = function(owner) {
    	if (owner == $scope.currentUserId) {
    		return "Bring back";
    	} else {
    		return "Rent";
    	}
    };
    
    $scope.isRentDisabled = function(is_available, is_broken, owner) {
    	if ((owner != $scope.currentUserId) && ((is_available == "N") || (is_broken == "Y"))) {
    		return true;
    	} else {
    		return false;
    	}
    };
    
    $scope.rentOrBringback = function(ownerId, animalId) {
        if (ownerId == $scope.currentUserId) {
        	$scope.bringBackAnimal(animalId);
    	} else {
    		$scope.rentAnimal(animalId);
    	}
    };
    
    $scope.determineButtonType = function(ownerId) {
        if (ownerId == $scope.currentUserId) {
        	return "btn-primary";
    	} else {
    		return "btn-success";
    	}
    };
    
    $scope.bringBackAnimal = function(animalId) {
        var animal = { "id" : animalId }
		$http.post("http://localhost:8080/RestService/resources/service/bringBack", JSON.stringify(animal)).success( function(response) {		
			// List the animals again, because their informations changed
            $scope.listAnimals();
		});
    };
    
    $scope.rentAnimal = function(animalId) {
        var userAnimal = { "u_id" : $scope.currentUserId, "a_id" : animalId }
		$http.post("http://localhost:8080/RestService/resources/service/rent", JSON.stringify(userAnimal)).success( function(response) {		
			// List the animals again, because their informations changed
            $scope.listAnimals();
		});
    };
    
    $scope.changeImage = function(imageSrc) {
        document.getElementById('animalImage').src= 'images/' + imageSrc;
        $scope.imageName = name;
        
        $scope.gotoImage();
    }
    
    $scope.gotoImage =  function () {
    	$location.hash('animalImage');
    	$anchorScroll();
    };
       
    $scope.logout = function() {
    	window.location.href="loginpage.html";
    };
	
});