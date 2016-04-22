define([
    'angular',
    '../services/srv_auth.js'
], function(ng) {
  var app=ng.module('classMeetApp.equipes', [
    "classMeetApp.profilService"
  ])
  .controller('EquipesCtrl',function($scope,$window,Profil,Equipes){
    $scope.groupecourscourant=Equipes.getGroupeCoursCourant();
    $scope.listeEquipes=null;
    $scope.nouvelleEquipe={
        'noEquipe':"",
        'nomEquipe':"",
        'chefEquipe':"",
        'sigleCours':"",
        'noGroupeCours':""
    };
    $scope.creerEquipe=function(){
    };
  })
  return app
})