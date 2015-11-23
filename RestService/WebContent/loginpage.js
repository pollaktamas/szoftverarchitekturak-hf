angular.module('loginpageApp', []).controller('loginpageCtrl', function($scope, $http) {
	$scope.alertBox = false;
	$scope.alertType = "danger";
	$scope.alertPre = "ERROR!";
	$scope.alertMessage = "You have to give a username and password!";
	
	$scope.login = function() {
		if (($scope.username == "") || ($scope.password == "") || ($scope.username == null) || ($scope.password == null)) {
			$scope.alertMessage = "You have to give a username and password!";
			$scope.showAlertBox(true, "danger", "ERROR!");
		} else {	
			var user = { "username": $scope.username, "password": $scope.password }
			$http.post("http://localhost:8080/RestService/resources/service/login", JSON.stringify(user)).success( function(response) {
						$scope.userReturned = response;
						
						if ($scope.userReturned.length == 0) {
							$scope.alertMessage = "Invalid username or password!";
							$scope.showAlertBox(true, "danger", "ERROR!");
						} else {
							if ($scope.userReturned.is_admin == "Y") {
								window.location.href="managementpage.html";
							} else {
								localStorage.setItem('loggedInUserId', $scope.userReturned.id);
								window.location.href="listpage.html";
							}
						}
			});
		}
    };
    
    $scope.register = function() {
    	if (($scope.username == "") || ($scope.password == "") || ($scope.username == null) || ($scope.password == null)) {
    		$scope.alertMessage = "You have to give a username and password!";
    		$scope.showAlertBox(true, "danger", "ERROR!");
		} else {	
	    	var user = { "username": $scope.username, "password": $scope.password }
			$http.post("http://localhost:8080/RestService/resources/service/register", JSON.stringify(user)).success( function(response) {
						$scope.userReturned = response;
						
						if ($scope.userReturned.length == 0) {
							$scope.alertMessage = "Username already in use, choose other username!";
							$scope.showAlertBox(true, "danger", "ERROR!");
						} else {
							$scope.alertMessage = "Registration successful!";
							$scope.showAlertBox(true, "success", "");
						}
			});
		};
    }
    
    $scope.showAlertBox = function(set, type, pre) {
    	$scope.alertBox = set;
    	$scope.alertType = type;
    	$scope.alertPre = pre;
    }
});