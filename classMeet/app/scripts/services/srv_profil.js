define([
	'angular',
], function (ng) {
	var app=ng.module('classMeetApp.profilService',[
	])
	.factory('ProfilService', function($q,$http) {
		var service={};
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
		service.updateProfil=function(username,profil){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username,
				data: profil
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		return service;
	})
	.factory('Profil', function($q,$cookies) {
		var profilCookie={};
		profilCookie.setProfilCourant=function(profil){
			$cookies.putObject("profil",profil);
		}
		profilCookie.getProfilCourant=function(){
			return $cookies.getObject("profil");
		}
		profilCookie.deleteProfilCourant=function(){
			$cookies.remove("profil");
		}
		return profilCookie;
	})
	.factory('GroupesCoursUtilisateur', function($q,$cookies) {
		var groupeCoursCookie={};
		groupeCoursCookie.setGroupesCoursCourant=function(groupesCours){
			$cookies.putObject("groupesCours",groupesCours);
		}
		groupeCoursCookie.getGroupesCoursCourant=function(){
			return $cookies.getObject("groupesCours");
		}
		groupeCoursCookie.deleteGroupesCoursCourant=function(){
			$cookies.remove("groupesCours");
		}
		return groupeCoursCookie;
	})
    .factory('Equipes', function($q,$cookies) {
        var profilCookie={};
        profilCookie.setGroupeCoursCourant=function(groupeCours){
            $cookies.putObject("groupeCours", groupeCours);
        }
        profilCookie.getGroupeCoursCourant=function(){
			return $cookies.getObject("groupeCours");
		}
		profilCookie.deleteGroupeCoursCourant=function(){
			$cookies.remove("groupeCours");
		}
        
        profilCookie.setEquipeCourante=function(equipe){
            $cookies.putObject("equipe", equipe);
        }
        profilCookie.getEquipeCourante=function(equipe){
            return $cookies.getObject("equipe");
        }
        profilCookie.deleteEquipeCourante=function(equipe){
            $cookies.remove("equipe");
        }
        return profilCookie;
    })
	.factory('GroupesCoursUtilisateurService', function($q,$http) {
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
	.factory('EquipeUtilisateurService', function($q,$http) {
		var service={};
		service.getEquipeGroupeCours=function(username,sigle){
			var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username+'/equipes/'+sigle,
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.addEquipe=function(username,equipe){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username+'/equipes',
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
	.factory('MessagerieService', function($q,$http) {
		var service={};
		service.envoyerMessage=function(username,message){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username+'/messages',
				data: message
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La requête a échoué");
			});
			return defer.promise;
		}
		service.getMessagesRecus=function(username){
			var defer=$q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username+'/messages',
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
		service.supprimerMessage=function(username,id){
			var defer=$q.defer();
			$http({
				method: 'DELETE',
				url: 'http://localhost:7001/ClassMeet/v1/profils/'+username+'/messages/'+id
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
