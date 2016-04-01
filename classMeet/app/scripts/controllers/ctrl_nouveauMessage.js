define([
	'angular',
	'../services/srv_profil.js'
], function(ng) {
	var app=ng.module('classMeetApp.nouveauMessage',[
		'classMeetApp.profilService'
	])
	.controller('NouveauMessageCtrl',function ($scope,Profil,MessagerieService) {
		$scope.messageCourant={
			'objet':"",
			'a':"",
			'texte':""
		}
		$scope.envoyerMessage=function(){
			
		}
		$scope.annuler=function(){
			
		}
	});
	return app
})