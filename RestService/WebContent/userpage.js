angular.module('userpageApp', []).controller('userpageCtrl', function($scope, $http) {
	$scope.showAnimalTableHeader = false;
    $scope.showTableHeader = function() {
        $scope.showAnimalTableHeader = true;
    };
	$scope.listAnimals = function() {
		$http.get("http://localhost:8080/RestService/resources/service/animals").success( function(response) {
					$scope.animals = response.animals;
		});
    };
	
});