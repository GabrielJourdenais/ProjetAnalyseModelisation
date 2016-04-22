define([
    'angular',
    '../services/srv_auth.js',
    '../services/srv_profil.js'
], function(ng) {
  var app=ng.module('classMeetApp.acceuil', [
    "classMeetApp.authService",
    "classMeetApp.profilService"
  ])
  .controller('AcceuilCtrl',function($scope,$window,Session,Profil,GroupesCoursUtilisateur){
    $scope.profil=Profil.getProfilCourant();
    $scope.listeCours=GroupesCoursUtilisateur.getGroupesCoursCourant();
    
  })
  return app
})
