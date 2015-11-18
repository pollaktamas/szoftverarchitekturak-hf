angular.module('loginpageApp', []).controller('loginpageCtrl', function($scope, $http) {
	
	$scope.login = function() {
		var user = { "username": $scope.username, "password": $scope.password }
		$http.post("http://localhost:8080/RestService/resources/service/login", JSON.stringify(user)).success( function(response) {
					$scope.userReturned = response;
					
					if ($scope.userReturned.length == 0) {
						alert("Invalid username or password");
					} else {
						alert("Login successful");
						if ($scope.userReturned.is_admin == "Y") {
							window.location.href="managementpage.html";
						} else {
							localStorage.setItem('loggedInUserId', $scope.userReturned.id);
							window.location.href="listpage.html";
						}
					}
		});
    };
    
    $scope.register = function() {
    	var user = { "username": $scope.username, "password": $scope.password }
		$http.post("http://localhost:8080/RestService/resources/service/register", JSON.stringify(user)).success( function(response) {
					$scope.userReturned = response;
					
					if ($scope.userReturned.length == 0) {
						alert("Username already in use, choose other username");
					} else {
						alert("Registration successful");
					}
		});
    };
	
});