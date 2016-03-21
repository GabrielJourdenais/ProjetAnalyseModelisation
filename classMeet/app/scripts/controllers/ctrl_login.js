define([
	'angular',
	'../services/srv_auth.js',
	'../services/srv_profil.js'
], function(ng) {
	var app=ng.module('classMeetApp.login',[
		'classMeetApp.authService',
		'classMeetApp.profilService'
	])
	.controller('LoginCtrl',function ($scope,$window,AuthService,Session,ProfilService) {
		$scope.username="";
		$scope.password="";
		$scope.login=function(){
			if($scope.username=="")
			{
				alert("Veuillez entrer votre code utilisateur");
			}
			else if($scope.password=="")
			{
				alert("Veuillez entrer votre mot de passe");
			}
			else
 			{
				AuthService.getAccess($scope.username,$scope.password).then(
				function(data)
				{
					if(data.status==1)
					{
						Session.setSession(data);
						$window.location.href="/";
					}
					else
					{
						alert("Votre code usager ou votre mot de passe est incorrect");
					}
				},
				function(erreur)
				{
					alert(erreur);
				})
			}
		}
		$scope.enregistrer=function(){
			if($scope.username=="")
			{
				alert("Veuillez entrer votre code utilisateur");
			}
			else
			{
				AuthService.getRegisterMock($scope.username).then(
				function(data)
				{

					alert("Votre compte a été créé avec succès")
					$window.location.href="/#login";
				},
				function(erreur)
				{
					alert(erreur);
				})
			}
		}
	});
	return app
})
