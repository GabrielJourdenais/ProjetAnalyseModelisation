define([
	'angular',
], function (ng) {
	var app=ng.module('classMeetApp.coursService',[
	])
	.factory('CoursService', function($q,$http) {
		var service={};
		service.getGroupeCours=function(username){
			var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username+'/groupesCours',
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.addGroupeCours=function(username,sigleCours,noGroupe){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username+'/groupesCours',
				data: {
						sigle:sigleCours,
    					noGroupeCours:noGroupe
    			}
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		return service;
	})
})
