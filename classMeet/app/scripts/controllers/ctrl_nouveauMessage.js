define([
	'angular',
	'../services/srv_profil.js'
], function(ng) {
	var app=ng.module('classMeetApp.nouveauMessage',[
		'classMeetApp.profilService'
	])
	.controller('NouveauMessageCtrl',function ($scope,$window,Profil,MessagerieService) {
		$scope.profil=Profil.getProfilCourant();
		$scope.messageCourant={
			'objet':"",
			'a':"",
			'texte':""
		}
		$scope.envoyerMessage=function(){
			if($scope.messageCourant.a!="")
			{
				MessagerieService.envoyerMessage($scope.profil.codeUtilisateur,$scope.messageCourant).then(
					function(data)
					{
						if(data.status==1)
						{
							$window.location="/#/messagerie";
						}
						else
						{
							alert("Cet usager n'existe pas dans le système");
						}
					},
					function(error)
					{
						alert(error);
					}
				)
			}
			else
			{
				alert("Veuillez entrez le code utilisateur du destinataire");
			}
		}
		$scope.annuler=function(){
			$window.location="/#/messagerie";
		}
	});
	return app
})