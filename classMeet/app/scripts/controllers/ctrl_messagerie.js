define([
	'angular',
	'../services/srv_profil.js'
], function(ng) {
	var app=ng.module('classMeetApp.messagerie',[
		'classMeetApp.profilService'
	])
	.controller('MessagerieCtrl',function ($scope,Profil,MessagerieService) {
		$scope.messagesRecus=[
			{
				'objet':"Test",
				'de':'Maxime',
				'date': '03/28/2016 : 11:30 AM'
			},
			{
				'objet':"Test2",
				'de':'Vincent',
				'date': '03/28/2016 : 11:30 AM'
			},
		];
		$scope.messagesEnvoyes=[];
		$scope.messagesSupprimes=[];
		$scope.ouvrirMessage=function(){
			
		}
		$scope.nouveauMessage=function(){
			
		}
		$scope.repondreMessage=function(){
			
		}
		$scope.supprimerMessage=function(){
			
		}
		$scope.ouvrirBoiteReception=function(){
			
		}
		$scope.ouvrirMessagesEnvoyes=function(){
			
		}
		$scope.ouvrirMessagesSupprimes=function(){
			
		}

	});
	return app
})
