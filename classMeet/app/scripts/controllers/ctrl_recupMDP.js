define([
	'angular',
	'../services/srv_auth.js'
], function(ng) {
	var app=ng.module('classMeetApp.recupMDP',[
		'classMeetApp.authService'
	])
	.controller('RecupMDPCtrl', function ($scope,$window,RecupMDP) {
		$scope.codeU="";
 		$scope.recupMDP=function(){
 			if($scope.codeU=="")
 			{
				alert("Veuillez entrer votre code utilisateur.");
 			}
 			else
 			{
 				RecupMDP.envoyerMDPMock($scope.codeU).then(
					function(data)
					{
						alert("L'opération a été effectué avec succès.");
	 					$window.location.href="/#/login";
					},
					function(erreur)
					{
						alert(erreur);
					}
				)
 			}
 		}
 		$scope.annuler=function(){
 			$window.location.href="/#/login";
 		}
	});

	return app;
})