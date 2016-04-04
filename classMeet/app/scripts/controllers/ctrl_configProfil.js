define([
    'angular',
    '../services/srv_profil.js',
    '../services/srv_auth.js'
], function(ng) {
  var app=ng.module('classMeetApp.profil', [
    "classMeetApp.profilService",
    "classMeetApp.authService"
  ])
  .controller('ProfilCtrl',function($scope,$window,Profil,ProfilService,AuthService){
    $scope.profil=Profil.getProfilCourant();
    $scope.auth={};
    $scope.enregistrer=function(){
      if($scope.profil.nom==""||$scope.profil.prenom==""||$scope.profil.courriel=="")
      {
        alert("Veuillez remplir tout les champs");
      }
      if($scope.auth.mdp==""||$scope.auth.mdp==null)
      {
        alert("Veuillez entrez votre mot de passe");
      }
      else if($scope.auth.newmdp!=""&&$scope.auth.newmdp!=null)
      {
        if($scope.auth.newmdp2==""||$scope.auth.newmdp2==null)
        {
          alert("Veuillez répéter le nouveau mot de passe");
        }
        else if($scope.auth.newmdp!=$scope.auth.newmdp2)
        {
          alert("Les entrées pour le nouveau mot de passe ne correspondent pas");
        }
        else
        {
          AuthService.getAccess($scope.profil.codeUtilisateur,$scope.auth.mdp).then(
            function(data)
            {
              if(data.status==1)
              {
                ProfilService.updateProfil($scope.profil.codeUtilisateur,$scope.profil).then(
                function(data)
                {
                  if(data.status==1)
                  {

                    Profil.setProfilCourant($scope.profil);
                    AuthService.changerMDP($scope.profil.codeUtilisateur,$scope.auth.mdp,$scope.auth.newmdp).then(
                      function(data)
                      {
                        if(data.status==1)
                        {
                          alert("Votre compte a été modifié avec succès")
                          $window.location.href="/#";
                        }
                        else
                        {
                          alert("La requête a échoué");
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
                    alert("La requête a échoué");
                  }
                },
                function(erreur)
                {
                  alert(erreur);
                })
                
              }
              else
              {
                alert("Votre mot de passe est incorrect");
              }
            },
            function(error)
            {
              alert(error);
            }
          )
          
        }
      }
      else
      {
        AuthService.getAccess($scope.profil.codeUtilisateur,$scope.auth.mdp).then(
            function(data)
            {
              if(data.status==1)
              {
                ProfilService.updateProfil($scope.profil.codeUtilisateur,$scope.profil).then(
                function(data)
                {
                  if(data.status==1)
                  {
                    alert("Votre compte a été modifié avec succès");
                    Profil.setProfilCourant($scope.profil);
                    $window.location.href="/#";
                  }
                  else
                  {
                    alert("La requête a échoué");
                  }
                },
                function(erreur)
                {
                  alert(erreur);
                })
              }
              else
              {
                alert("Votre mot de passe est incorrect");
              }
            },
            function(error)
            {
              alert(error);
            }
          )
      }
    }
    $scope.annuler=function(){
      $window.location.href="/#";
    }
  })
  return app
})
