define([
	'angular',
], function (ng) {
	var app=ng.module('classMeetApp.coursService',[
	])
	.factory('CoursService', function($q,$http) {
		var service={};
		service.getGroupeCours=function(sigle,noGroupe){
			var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/cours/'+sigle+'/groupes/'+noGroupe,
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.getMembresGroupeCours=function(sigle,noGroupe){
			var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/cours/'+sigle+'/groupes/'+noGroupe+'/membres',
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.getEquipesGroupeCours=function(sigle,noGroupe){
			var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/cours/'+sigle+'/groupes/'+noGroupe+'/equipes',
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
