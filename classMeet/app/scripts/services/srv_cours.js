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
		service.addEquipeGroupeCours=function(sigle,noGroupe,equipe){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: 'http://localhost:7001/ClassMeet/v1/cours/'+sigle+'/groupes/'+noGroupe+'/equipes',
				data: equipe
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		return service;
	})
	.factory('EquipeService', function($q,$http) {
        var service={};

        service.getEquipe=function(sigle,noGroupe,noEquipe){
            var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/cours/'+sigle+'/groupes/'+noGroupe+'/equipes/'+noEquipe,
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
        }
        service.getMembresEquipe=function(sigle,noGroupe,noEquipe){
            var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/cours/'+sigle+'/groupes/'+noGroupe+'/equipes/'+noEquipe+'/membres',
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
        }
        service.getRequetesMembreEquipe=function(sigle,noGroupe,noEquipe){
            var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/cours/'+sigle+'/groupes/'+noGroupe+'/equipes/'+noEquipe+'/requetesMembre',
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
        }
        service.addRequeteMembreEquipe=function(sigle,noGroupe,noEquipe,utilisateur){
            var defer=$q.defer();
			$http({
				method: 'POST',
				url: 'http://localhost:7001/ClassMeet/v1/cours/'+sigle+'/groupes/'+noGroupe+'/equipes/'+noEquipe+'/requetesMembre',
				data: utilisateur
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
        }
        service.removeRequeteMembreEquipe=function(sigle,noGroupe,noEquipe,codeUtilisateur){
            var defer=$q.defer();
			$http({
				method: 'DELETE',
				url: 'http://localhost:7001/ClassMeet/v1/cours/'+sigle+'/groupes/'+noGroupe+'/equipes/'+noEquipe+'/requetesMembre/'+codeUtilisateur,
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
        }
        service.getEvenementsEquipe=function(sigle,noGroupe,noEquipe){
            var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/cours/'+sigle+'/groupes/'+noGroupe+'/equipes/'+noEquipe+'/evenements',
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
        }
        service.addEvenementsEquipe=function(sigle,noGroupe,noEquipe,evenement){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: 'http://localhost:7001/ClassMeet/v1/cours/'+sigle+'/groupes/'+noGroupe+'/equipes/'+noEquipe+'/evenements',
				data: evenement
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
