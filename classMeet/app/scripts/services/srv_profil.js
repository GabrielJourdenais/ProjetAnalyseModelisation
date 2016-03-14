define([
	'angular',
], function (ng) {
	var app=ng.module('classMeetApp.profilService',[
	])
	.factory('ProfilService', function($q) {
		var service={};
		service.getCours=function(username){
			var defer=$q.defer();
			$http({
				method: 'GET',
				url: '/api/profils/'+username+'cours',
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.getProfil=function(username){
			var defer=$q.defer();
			$http({
				method: 'GET',
				url: '/api/profils/'+username,
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.addProfil=function(username){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: '/api/profils/'+username,
			}).then(function successCallback(response) {
				defer.resolve("Votre compte a été créé avec succès");
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.updateProfil=function(username){
			var defer=$q.defer();
			$http({
				method: 'PUT',
				url: '/api/profils/'+username,
			}).then(function successCallback(response) {
				defer.resolve("Votre compte a été modifié avec succès");
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.updateProfilMock=function(username){
			var defer=$q.defer();
			defer.resolve("Votre compte a été modifié avec succès");
			return defer.promise;
		}
		return service;
	})
	return app;
})
