angular.module('managementpageApp', ["xeditable"]).controller('managementpageCtrl', function($scope, $http) {
	$scope.cbIsAvailable = "N";
    $scope.cbIsBroken = "N";
	
	$scope.listAnimals = function() {
		$http.get("http://localhost:8080/RestService/resources/service/animals").success( function(response) {
			$scope.showAnimalTableHeader = true;
            $scope.animals = response.animals;
		});
    };
    
    $scope.updateAnimal = function(animal) {
		var a = { "id" : animal.id, "species" : animal.species, "breed" : animal.breed, "sex" : animal.sex, "age" : animal.age, "color" : animal.color, "volume" : animal.volume, "weight" : animal.weight, "favourite_meal" : animal.favourite_meal, "hobby" : animal.hobby, "is_available" : animal.is_available, "is_broken" : animal.is_broken, "picture" : animal.picture, "owner" : animal.owner }
		$http.post("http://localhost:8080/RestService/resources/service/updateAnimal", JSON.stringify(a)).success( function(response) {		
			alert("Animal updated");
			
			// List the animals again, because their informations changed
	        $scope.listAnimals();
		});
    };
	
    $scope.insertAnimal = function() {  
    	if (($scope.u_species == null) || ($scope.u_breed == null) || ($scope.u_sex == null) || ($scope.u_age == null) || ($scope.u_color == null) || ($scope.u_volume == null) || ($scope.u_weight == null) || ($scope.u_favourite_meal == null) || ($scope.u_hobby == null) || ($scope.u_picture == null)) {
    		alert("You have to set all fields!");
    	} else {
    		var animal = { "species" : $scope.u_species, "breed" : $scope.u_breed, "sex" : $scope.u_sex, "age" : $scope.u_age, "color" : $scope.u_color, "volume" : $scope.u_volume, "weight" : $scope.u_weight, "favourite_meal" : $scope.u_favourite_meal, "hobby" : $scope.u_hobby, "is_available" : $scope.cbIsAvailable, "is_broken" : $scope.cbIsBroken, "picture" : $scope.u_picture }
    		$http.post("http://localhost:8080/RestService/resources/service/insertAnimal", JSON.stringify(animal)).success( function(response) {		
    			alert("Animal inserted");
    			
    			// List the animals again, because their informations changed
    			$scope.listAnimals();
    		});    		
    	}
    };
    
	$scope.deleteAnimal = function(animalId) {
		var animal = { "id" : animalId }
		$http.post("http://localhost:8080/RestService/resources/service/deleteAnimal", JSON.stringify(animal)).success( function(response) {		
			alert("Animal deleted");
			
			// List the animals again, because their informations changed
	        $scope.listAnimals();
		});
    };
    
	$scope.logout = function() {
		window.location.href="loginpage.html";
	};
	
});