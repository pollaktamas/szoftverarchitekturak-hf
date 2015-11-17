angular.module('loginpageApp', []).controller('loginpageCtrl', function($scope, $http) {
	
	$scope.login = function() {
		$http.post("http://localhost:8080/RestService/resources/service/login", JSON.stringify({ "username": $scope.username, "password": $scope.password })).success( function(response) {
					$scope.userReturned = response;
					
					if ($scope.userReturned.length == 0) {
						alert("Invalid username or password");
					} else {
						alert("Login successful, TODO: handle successful login");
					}
		});
    };
	
});