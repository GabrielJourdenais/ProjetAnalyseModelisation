define([
    'angular',
    '../services/srv_auth.js',
    '../services/srv_profil.js'
], function(ng) {
  var app=ng.module('classMeetApp.acceuil', [
    "classMeetApp.authService",
    "classMeetApp.profilService"
  ])
<<<<<<< HEAD
  .controller('AcceuilCtrl',function($scope,$window,Session,Profil,GroupesCoursUtilisateur){
    $scope.profil=Profil.getProfilCourant();
    $scope.listeCours=GroupesCoursUtilisateur.getGroupesCoursCourant();
    
=======
  .controller('AcceuilCtrl',function($scope,$window,Session,Profil,GroupesCours,Equipes){
    $scope.profil=Profil.getProfilCourant();
    $scope.listeCours=GroupesCours.getGroupesCoursCourant();
    $scope.accederGroupe=function(cour){
        Equipes.setGroupeCoursCourant(cour);
        $window.location="/#/equipes";
    }
>>>>>>> bab7237d78e707b9ff83e0a8a14543854593b448
  })
  return app
})
