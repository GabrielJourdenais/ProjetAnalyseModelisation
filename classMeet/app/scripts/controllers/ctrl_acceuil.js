define([
    'angular',
    '../services/srv_auth.js',
    '../services/srv_profil.js'
], function(ng) {
  var app=ng.module('classMeetApp.acceuil', [
    "classMeetApp.authService",
    "classMeetApp.profilService"
  ])
  .controller('AcceuilCtrl',function($scope,$window,Session,Profil,GroupesCours){
    $scope.profil=Profil.getProfilCourant();
    $scope.listeCours=GroupesCours.getGroupesCoursCourant();
    
  })
  return app
})
