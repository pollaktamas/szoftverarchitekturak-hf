angular.module('managementpageApp', []).controller('managementpageCtrl', function($scope, $http) {
	
	$scope.logout = function() {
		window.location.href="loginpage.html";
	};
	
});