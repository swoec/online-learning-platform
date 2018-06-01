'use strict';

angular.module('myspp',[]).controller('LoginController',['$scope','loginservice',function($scope,loginservice){
	var self = this;
	var user = {username:'',password:''};
	
	self.login = login;
	alert("222");
	function login(){
		loginservice.loginin(self.user).then(
		function (response){
			alert("3333");
			var indexUrl = window.location.protocol+"//"+window.location.host+"/angular/"+"login/user";
            window.location = indexUrl;
		},function(errResponse){
			alert('error!,try again!');
		}		
		);
	}
	
	function reset(){
        self.user={username:'',password:''};
        $scope.myForm.$setPristine(); //reset Form
    }
	
	
}]);