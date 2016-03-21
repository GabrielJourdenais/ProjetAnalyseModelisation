define([
	'angular',
    'angular_cookies'
], function (ng) {
	var app=ng.module('classMeetApp.authService',[
	'ngCookies'
	])
	.factory('AuthService', function($q,$http) {
		var service={};
		service.getAccess=function(username,password){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: 'http://localhost/authuqam/service/authentification.php',
				data: {
					user:username,
					password:password
				}
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("La connection au serveur a échoué");
			});
			return defer.promise;
		}
		service.getAccessMock=function(username,password){
			var defer=$q.defer();
			defer.resolve("ok");
			return defer.promise;
		}
		service.getRegister=function(username){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: '/api/register/',
				data: {
					username:username
				}
			}).then(function successCallback(response) {
				defer.resolve(response.data);
			}, function errorCallback(response) {
				defer.reject("Ce code utilisateur n'existe pas ou le compte a déjà été créé");
			});
			return defer.promise;
		}
		service.getRegisterMock=function(username){
			var defer=$q.defer();
			defer.resolve("Votre compte a été créé avec succès");
			return defer.promise;
		}
		return service;
	})
	.factory('Session',function($cookies,$q) {
		var sessionCookie={};
		sessionCookie.setSession=function(session){
			$cookies.put("session",session);
		}
		sessionCookie.getSession=function(){
			return $cookies.get("session");
		}
		sessionCookie.deleteSession=function(){
			$cookies.remove("session");
		}
		sessionCookie.validateSession=function(){
			var defer=$q.defer();
			var session=$cookies.get("session");
			if(session!=null)
			{
				defer.resolve(session);
			}
			else
			{
				defer.reject("Null Session");
			}
			return defer.promise;
		}
		sessionCookie.noSession=function(){
			var defer=$q.defer();
			var session=$cookies.get("session");
			if(session!=null)
			{
				defer.reject("Already log");
			}
			else
			{
				defer.resolve(null);
			}
			return defer.promise;
		}
		return sessionCookie;
	})
	.factory('RecupMDP',function($cookies,$q) {
		var service={};
		service.envoyerMDP=function(username){
			var defer=$q.defer();
			$http({
				method: 'POST',
				url: '/api/recupMDP/',
				data: {
					username:username
				}
			}).then(function successCallback(response) {
				defer.resolve(null);
			}, function errorCallback(response) {
				defer.reject("Ce code utilsateur n'existe pas");
			});
			return defer.promise;
		}
		service.envoyerMDPMock=function(username){
			var defer=$q.defer();
			defer.resolve(null);
			return defer.promise;
		}
		return service;
	});
	return app;
})
