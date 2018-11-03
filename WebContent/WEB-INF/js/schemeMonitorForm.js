var app = angular.module("digi_Module", [ 'ngRoute', 'ngAnimate',
		'ui.bootstrap' ]);

app.config([ '$routeProvider', function($routeProvider) {
	console.log("routeProvider")
	$routeProvider.when("/admin", {
		templateUrl : 'admin',
		
	}).otherwise({
		redirectTo : 'index'
	});
	/* when("/logout",{
	 	templateUrl: 'logoutUser',
	 }).*/
} ]);

app.controller("user_Controller", function($http, $window, $scope, $location,
		$timeout) {

	$scope.user = function() {
		$http({
			method : "post",
			url : "userreg",
			data : {
				"username" : $scope.username,
				"email" : $scope.email,
				"password" : $scope.password,
				"phno" : $scope.phno,
				"role" : $scope.role,
				"approved" : $scope.approved
			}
		}).then(function(result) {
			$window.alert("ddetails submitted");

		});
	}

});
