'use strict';

angular.module('myspp',[]).factory('loginservice',['$http','$q',function($http,$q){
	var REST_URL = 'http://localhost:8081/angular/login/user';
	var factory ={
	   loginin : loginin,
	  
	};
	
	return factory;
	
	function loginin(user){
		var deferred = $q.defer();
		$http.post(REST_URL,user).then(
				function (response){
					deferred.resolve(response.data);
				},
				function (errResponse){
					console.error('error');
					deferred.reject(errResponse.data);
				}
		
		);
		return deferred.promise();
	}
	
	
	
	
}]);