define([
    'angular',
    '../services/srv_auth.js'
], function(ng) {
  var app=ng.module('classMeetApp.equipe', [
    "classMeetApp.profilService"
  ])
  .controller('EquipeCtrl',function($scope,$window,Profil,Equipes){
    $scope.groupecourscourant=Equipes.getGroupeCoursCourant();
    $scope.listeCoequipiers=null;
    $scope.envoyerMessage=function(){
    }
  })
  return app
})