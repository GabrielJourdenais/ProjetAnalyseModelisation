define([
	'angular',
	'../services/srv_auth.js',
	'../services/srv_profil.js'
], function(ng) {
	var app=ng.module('classMeetApp.login',[
		'classMeetApp.authService',
		'classMeetApp.profilService'
	])
	.controller('LoginCtrl',function ($scope,$window,AuthService,Session,ProfilService,Profil,GroupesCoursUtilisateur,GroupesCoursUtilisateurService,$cookies) {
		$scope.username="";
		$scope.password="";
		$scope.session={};
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
						$scope.session=data;
						ProfilService.getProfil($scope.username).then(
							function(data)
							{
								if(data!=null&&data!="")
								{
									$scope.profil=data;
									GroupesCoursUtilisateurService.getGroupeCours($scope.username).then(
										function(data)
										{
											GroupesCoursUtilisateur.setGroupesCoursCourant(data);
											Profil.setProfilCourant($scope.profil);
											Session.setSession($scope.session);
											$window.location.href="/";
											
										},
										function(erreur)
										{
											alert(erreur);
										}
									)
								}
								else
								{
									alert("Votre code utilisateur est valide mais vous ne possédez pas de compte ClassMeet");
								}
							},
							function(erreur)
							{
								alert(erreur);
							}
						)
						
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
						var nouvProfil={};
						nouvProfil.codeUtilisateur=$scope.username;
  						nouvProfil.prenom=data.prenom;
  						nouvProfil.nom=data.nom;
  						nouvProfil.courriel=data.courriel;
  						nouvProfil.typeUtilisateur=data.type;

  						var groupecours=data.groupecours;

						ProfilService.addProfil(nouvProfil).then(
							function(data)
							{
								if(data.status==1)
								{
									alert("Votre compte a été créé avec succès")
								}
								else
								{
									alert("Ce code utilisateur possède déjà un compte ClassMeet");
								}
							},
							function(erreur)
							{
								alert(erreur);
							}
						)
						for(i=0;i<groupecours.length;i++)
						{
							GroupesCoursUtilisateurService.addGroupeCours(nouvProfil.codeUtilisateur,groupecours[i].sigle,groupecours[i].groupe);
						}
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
	});
	return app
})
