define([
	'angular',
	'../services/srv_profil.js'
], function(ng) {
	var app=ng.module('classMeetApp.messagerie',[
		'classMeetApp.profilService'
	])
	.controller('MessagerieCtrl',function ($scope,$window,Profil,MessagerieService) {
		$scope.profil=Profil.getProfilCourant();
		$scope.canDelete=false;
		$scope.messageCourant=null;
		MessagerieService.getMessagesRecus($scope.profil.codeUtilisateur).then(
			function(data){
				$scope.messagesRecus=data;
				for(i=0;i<$scope.messagesRecus.length;i++)
				{
					$scope.messagesRecus[i].selected=false;
				}
			}
		)
		$scope.ouvrirMessage=function(message){
			$scope.messageCourant=message;
		}
		$scope.nouveauMessage=function(){
			$window.location="/#/nouveauMessage";
		}
		$scope.supprimerMessage=function(){
			for(i=0;i<$scope.messagesRecus.length;i++)
			{
				if($scope.messagesRecus[i].selected)
				{
					MessagerieService.supprimerMessage($scope.profil.codeUtilisateur,$scope.messagesRecus[i].id).then()
				}
			}
			$window.location="/#/messagerie";
			$window.location.reload();
		}
		$scope.updateCheckbox=function(){
			$scope.canDelete=false;
			for(i=0;i<$scope.messagesRecus.length;i++)
			{
				if($scope.messagesRecus[i].selected)
				{
					$scope.canDelete=true;
				}
			}
		}

	});
	return app
})
