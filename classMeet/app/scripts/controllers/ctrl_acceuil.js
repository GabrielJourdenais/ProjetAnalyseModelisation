define([
    'angular',
    '../services/srv_auth.js'
], function(ng) {
  var app=ng.module('classMeetApp.acceuil', [
    "classMeetApp.authService"
  ])
  .controller('AcceuilCtrl',function($scope,$window,Session){
    $scope.listeCours=[
    {sigle:"INM5151",titre:"Projet d'analyse et de modélisation",groupe:10},
    {sigle:"INF5000",titre:"Théorie et construction des compilateurs",groupe:10},
    {sigle:"INF5153",titre:"Génie logiciel: conception",groupe:30}
    ];
    
  })
  return app
})
