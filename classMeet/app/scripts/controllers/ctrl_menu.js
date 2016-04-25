define([
    'angular',
    '../services/srv_auth.js',
    '../services/srv_profil.js'
], function(ng) {
  var app=ng.module('classMeetApp.menu', [
    "classMeetApp.authService",
    "classMeetApp.profilService"
  ])
  .controller('MenuCtrl',function($scope,$window,Session,Profil,GroupesCoursUtilisateur,Equipes){
   	$scope.deconnection=function()
    {
      Session.deleteSession();
      Profil.deleteProfilCourant();
      GroupesCoursUtilisateur.deleteGroupesCoursCourant();
      Equipes.deleteEquipeCourante()
      $window.location.href="/";
    }
  })
  return app
})
