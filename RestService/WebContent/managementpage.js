angular.module('managementpageApp', ["xeditable"]).controller('managementpageCtrl', function($scope, $http) {
	
	
	$scope.listAnimals = function() {
		$http.get("http://localhost:8080/RestService/resources/service/animals").success( function(response) {
			$scope.showAnimalTableHeader = true;
            $scope.animals = response.animals;
		});
    };
    
    $scope.updateAnimal = function(animal) {
		var a = { "id" : animal.id, "species" : animal.species, "breed" : animal.breed, "sex" : animal.sex, "age" : animal.age, "color" : animal.color, "volume" : animal.volume, "weight" : animal.weight, "favourite_meal" : animal.favourite_meal, "hobby" : animal.hobby, "is_available" : animal.is_available, "is_broken" : animal.is_broken, "picture" : animal.picture, "owner" : animal.owner }
		$http.post("http://localhost:8080/RestService/resources/service/updateAnimal", JSON.stringify(a)).success( function(response) {		
			// List the animals again, because their informations changed
	        $scope.listAnimals();
		});
    };
	
	$scope.deleteAnimal = function(animalId) {
		var animal = { "id" : animalId }
		$http.post("http://localhost:8080/RestService/resources/service/deleteAnimal", JSON.stringify(animal)).success( function(response) {		
			// List the animals again, because their informations changed
	        $scope.listAnimals();
		});
    };
    
	$scope.logout = function() {
		window.location.href="loginpage.html";
	};
	
});