define([    
     'angular',
     '../services/srv_profil.js',
     '../services/srv_cours.js'
 ], function(ng) {
	 var app=ng.module('classMeetApp.equipe', [
	 "classMeetApp.profilService",
	 "classMeetApp.coursService"
   ])
 	.controller('EquipeCtrl',function($scope,$window,Profil,Equipes,CoursService,EquipeUtilisateurService,EquipeService){
 	  $scope.profil=Profil.getProfilCourant();
 	  $scope.groupecourscourant=Equipes.getGroupeCoursCourant();
 	  EquipeUtilisateurService.getEquipeGroupeCours($scope.profil.codeUtilisateur,$scope.groupecourscourant.sigle).then(
 	  	function(data)
 	  	{
 	  		$scope.equipeCourante=data;
	 	  	EquipeService.getMembresEquipe($scope.equipeCourante.sigleCours,$scope.equipeCourante.noGroupeCours,$scope.equipeCourante.noEquipe).then(
		      function(data)
		      {
		      	$scope.membresEquipe=data;
		      },
		      function(error)
		      {
		        $window.location="/#/";
		        $window.location.reload();
		      }
	 	  	)
	 	  	EquipeService.getRequetesMembreEquipe($scope.equipeCourante.sigleCours,$scope.equipeCourante.noGroupeCours,$scope.equipeCourante.noEquipe).then(
		      function(data)
		      {
		      	$scope.requetesMembreEquipe=data;
		      },
		      function(error)
		      {
		        $window.location="/#/";
		        $window.location.reload();
		      }
	 	  	)
		},
 	  	function(error)
 	  	{
 	  		$window.location="/#/";
        	$window.location.reload();
 	  	}
    )
 	 $scope.accepterRequete=function(membre)
 	 {
 	 	if(confirm("Désirez-vous ajouter cet utilisateur à votre équipe?"))
 	 	{
 	 		EquipeUtilisateurService.addEquipe(membre.codeUtilisateur,$scope.equipeCourante).then(
 	 			function(data)
 	 			{
 	 				if(data.status==1)
 	 				{
 	 					alert("Le membre a été ajouté avec succès");

 	 				}
 	 				else
 	 				{
						alert("Cet utilisateur fait déjà parti d'une équipe");
 	 				}
 	 				EquipeService.removeRequeteMembreEquipe($scope.equipeCourante.sigleCours,$scope.equipeCourante.noGroupeCours,$scope.equipeCourante.noEquipe,membre.codeUtilisateur).then(
		 	 			function(data){},
		 	 			function(error)
		 	 			{
		 	 				alert(error);
		 	 			}
 	 				)
 	 				$window.location.reload();
 	 			},
 	 			function(error)
 	 			{
 	 				alert(error);
 	 			}
 	 		)
 	 	}
 	 }
 	 $scope.afficherProfil=function(membre){
     	alert(
     		"code utilisateur: "+membre.codeUtilisateur+"\n"+
     		"nom: "+membre.nom+"\n"+
     		"prenom: "+membre.prenom+"\n"+
     		"courriel: "+membre.courriel+"\n"
     		);
     }
   })
   return app
 }) 