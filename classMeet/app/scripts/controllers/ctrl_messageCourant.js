define([
  'angular',
  '../services/srv_profil.js'
], function(ng) {
  var app=ng.module('classMeetApp.messageCourant',[
    'classMeetApp.profilService'
  ])
  .controller('MessageCourantCtrl',function ($scope,$window,Profil,MessagerieService) {
    $scope.profil=Profil.getProfilCourant();


  });
  return app
})
