define([
    'angular',
    '../services/srv_profil.js'
], function(ng) {
  var app=ng.module('classMeetApp.profil', [
    "classMeetApp.profilService"
  ])
  .controller('ProfilCtrl',function($scope,$window,ProfilService){
    $scope.nom="Jourdenais-Hamel";
    $scope.prenom="Gabriel";
    $scope.email="jourdenais_hamel.gabriel@courrier.uqam.ca";
    $scope.MDP="";
    $scope.NMDP="";
    $scope.NMDP2="";
    $scope.enregistrer=function(){
      if($scope.nom==""||$scope.prenom==""||$scope.email==""||$scope.MDP=="")
      {
        alert("Veuillez remplir tout les champs");
      }
      else if($scope.NMDP!=$scope.NMDP2)
      {
        alert("Le nouveau de passe n'a pas été répété correctement");
      }
      else
      {
        if($scope.NMDP=="")
        {
          ProfilService.updateProfilMock($scope.nom,$scope.prenom,$scope.email,$scope.MDP).then(
          function(data)
          {

            alert("Votre compte a été modifié avec succès")
            $window.location.href="/#";
          },
          function(erreur)
          {
            alert(erreur);
          })
        }
        else
        {
          ProfilService.updateProfilMock($scope.nom,$scope.prenom,$scope.email,$scope.MDP,$scope.NMDP).then(
          function(data)
          {

            alert("Votre compte a été modifié avec succès")
            $window.location.href="/#";
          },
          function(erreur)
          {
            alert(erreur);
          })
        }
      }

    }
    $scope.annuler=function(){
      $window.location.href="/#";
    }
  })
  return app
})
