 define([    
     'angular',
     '../services/srv_profil.js',
     '../services/srv_cours.js'
 ], function(ng) {
	 var app=ng.module('classMeetApp.equipes', [
	 "classMeetApp.profilService",
	 "classMeetApp.coursService"
   ])
 	.controller('EquipesCtrl',function($scope,$window,Profil,Equipes,CoursService,EquipeUtilisateurService,EquipeService){
	 $scope.profil=Profil.getProfilCourant();
	 $scope.groupecourscourant=Equipes.getGroupeCoursCourant();

	 EquipeUtilisateurService.getEquipeGroupeCours($scope.profil.codeUtilisateur,$scope.groupecourscourant.sigle).then(
	 	function(data)
	 	{
	 		if(data!=null&&data!="")
	 		{
	 			Equipes.setEquipeCourante(data);
     			$window.location="/#/equipe";
	 		}
	 	}
	 )

	 CoursService.getEquipesGroupeCours($scope.groupecourscourant.sigle,$scope.groupecourscourant.noGroupeCours).then(
	 	function(data)
	 	{
	 		$scope.listeEquipes=data;
	 	},
	 	function(error)
	 	{
	 		$scope.listeEquipes=[];
	 	}
	 )

	 CoursService.getMembresGroupeCours($scope.groupecourscourant.sigle,$scope.groupecourscourant.noGroupeCours).then(
	 	function(data)
	 	{
	 		$scope.listeMembres=data;
	 	},
	 	function(error)
	 	{
	 		$scope.listeMembres=[];
	 	}
	 )
	 
	 
     $scope.nouvelleEquipe={
         'nomEquipe':"",
         'chefEquipe':$scope.profil.codeUtilisateur,
         'sigleCours': $scope.groupecourscourant.sigle,
         'noGroupeCours': $scope.groupecourscourant.noGroupeCours
     };
     $scope.creerEquipe=function(equipe){
     	CoursService.addEquipeGroupeCours($scope.groupecourscourant.sigle,$scope.groupecourscourant.noGroupeCours,equipe).then(
     		function(data)
     		{
     			if(data.status==1)
     			{
     				EquipeUtilisateurService.addEquipe($scope.profil.codeUtilisateur,equipe).then(
			     		function(data)
			     		{
			     			if(data.status==1)
			     			{
			     				$window.location="/#/equipes";
			     				$window.location.reload();
			     			}
			     			else
			     			{
			     				alert("Vous faites déjà partie d'une équipe");
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
     				alert("Vous êtes déjà chef d'une équipe");
     			}
     		},
     		function(error)
     		{
     			alert(error)
     		}
     	)
     	
     };

     $scope.requeteMembreEquipe=function(equipe){
     	if(confirm("Désirez-vous faire une requête pour joindre cette équipe?"))
     	{
	     	EquipeService.addRequeteMembreEquipe(equipe.sigleCours,equipe.noGroupeCours,equipe.noEquipe,$scope.profil).then(
		      function(data)
		      {
		      	if(data.status==1)
		      	{
		      		alert("Votre requête a été effectué avec succès");
		      	}
		      	else
		      	{
		      		alert("Vous avez déjà fait une requête auprès de cette équipe");
		      	}
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