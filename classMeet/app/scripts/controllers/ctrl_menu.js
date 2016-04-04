define([
    'angular',
    '../services/srv_auth.js',
    '../services/srv_profil.js'
], function(ng) {
  var app=ng.module('classMeetApp.menu', [
    "classMeetApp.authService",
    "classMeetApp.profilService"
  ])
  .controller('MenuCtrl',function($scope,$window,Session,Profil,GroupesCours){
   	$scope.deconnection=function()
    {
      Session.deleteSession();
      Profil.deleteProfilCourant();
      GroupesCours.deleteGroupesCoursCourant();
      $window.location.href="/";
    }
  })
  return app
})
