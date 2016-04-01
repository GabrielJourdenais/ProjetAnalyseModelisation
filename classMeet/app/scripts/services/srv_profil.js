define([
	'angular',
], function (ng) {
	var app=ng.module('classMeetApp.profilService',[
	])
	.factory('ProfilService', function($q,$http) {
		var service={};
		service.getCours=function(username){
			var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username+'cours',
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
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username,
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.addProfil=function(profil){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: 'http://localhost:7001/ClassMeet/v1/profils',
				data: profil
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.updateProfil=function(username){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username,
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
	.factory('Profil', function($q,$cookies) {
		var profilCookie={};
		profilCookie.setProfilCourant=function(profil){
			$cookies.put("profil",profil);
		}
		profilCookie.getProfilCourant=function(){
			return $cookies.get("profil");
		}
		profilCookie.deleteProfilCourant=function(){
			$cookies.remove("profil");
		}
		return profilCookie;
	})
	.factory('MessagerieService', function($q,$http) {
		var service={};
		service.envoyerMessage=function(username){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username+'/messagesEnvoyes',
			}).then(function successCallback(response) {
				defer.resolve("Le message a été envoyé");
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.supprimerMessage=function(username){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username+'/messagesSupprimes',
			}).then(function successCallback(response) {
				defer.resolve("Le message a été supprimé");
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.getMessagesRecus=function(username){
			var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username+'/messagesRecus',
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.getMessagesEnvoyes=function(username){
			var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username+'/messagesEnvoyes',
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.getMessagesSupprimes=function(username){
			var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username+'/messagesSupprimes',
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		return service;
	})
	return app;
})
