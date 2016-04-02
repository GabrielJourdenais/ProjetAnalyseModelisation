define([
    'angular',
    '../services/srv_auth.js'
], function(ng) {
  var app=ng.module('classMeetApp.acceuil', [
    "classMeetApp.authService"
  ])
  .controller('EquipesCtrl',function($scope,$window,Session){
    $scope.listeEquipes=[
    {noEquipe:0, nomEquipe:"Test", chefEquipe:"Maxime", sigleCours:"INM5151",noGroupeCours:10},
    {noEquipe:1, nomEquipe:"Test2", chefEquipe:"Vincent", sigleCours:"INM5151",noGroupeCours:10}
    {noEquipe:2, nomEquipe:"Test3", chefEquipe:"Gabriel", sigleCours:"INM5151",noGroupeCours:10}
    ];
    $scope.listeCoequipiers=[
    {nom:"Test",prenom:"Test"}
    {nom:"Test1",prenom:"Test1"}
    {nom:"Test2",prenom:"Test2"}
    ];
    $scope.nouvelleEquipe={
        'noEquipe':"",
        'nomEquipe':"",
        'chefEquipe':"",
        'sigleCours':"",
        'noGroupeCours':""
    };
    $scope.creerEquipe=function(){
    }
  })
  return app
})