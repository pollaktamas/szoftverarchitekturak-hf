angular.module('listpageApp', []).controller('listpageCtrl', function($scope, $http) {
	$scope.showAnimalTableHeader = false;
    $scope.currentUser = localStorage.getItem('loggedInUserId');
    
	$scope.showTableHeader = function() {
        $scope.showAnimalTableHeader = true;
    };
	
    $scope.listAnimals = function() {
		$http.get("http://localhost:8080/RestService/resources/service/animals").success( function(response) {
			$scope.animals = response.animals;
		});
    };
   
    $scope.genButtonName = function(owner) {
    	if (owner == $scope.currentUser) {
    		return "Bring back";
    	} else {
    		return "Rent";
    	}
    };
    
    $scope.isRentDisabled = function(is_available, is_broken, owner) {
    	if ((owner != $scope.currentUser) && ((is_available == "N") || (is_broken == "Y"))) {
    		return true;
    	} else {
    		return false;
    	}
    };

    $scope.logout = function() {
    	alert(currentUser.username);
    	window.location.href="loginpage.html";
    };
	
});