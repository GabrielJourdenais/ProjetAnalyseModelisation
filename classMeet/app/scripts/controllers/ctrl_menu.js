define([
    'angular',
    '../services/srv_auth.js'
], function(ng) {
  var app=ng.module('classMeetApp.menu', [
    "classMeetApp.authService"
  ])
  .controller('MenuCtrl',function($scope,$window,Session){
   	$scope.deconnection=function()
    {
      Session.deleteSession();
      $window.location.href="/";
    }
  })
  return app
})
