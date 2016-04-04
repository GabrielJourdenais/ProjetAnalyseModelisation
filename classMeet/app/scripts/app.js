define([
    'angular',
    'angular_route',
    'angular_ui_bootstrap',
    './scripts/services/srv_auth.js',
    './scripts/controllers/ctrl_acceuil.js',
    './scripts/controllers/ctrl_configProfil.js',
    './scripts/controllers/ctrl_messagerie.js',
    './scripts/controllers/ctrl_nouveauMessage.js',
    './scripts/controllers/ctrl_messagesEnvoyes.js',
    './scripts/controllers/ctrl_login.js',
    './scripts/controllers/ctrl_recupMDP.js',
    './scripts/controllers/ctrl_menu.js'
], function(ng) {
  var app=ng.module('classMeetApp', [
    'ngRoute',
    'classMeetApp.authService',
    'classMeetApp.acceuil',
    'classMeetApp.profil',
    'classMeetApp.messagerie',
    'classMeetApp.nouveauMessage',
    'classMeetApp.messagesEnvoyes',
    'classMeetApp.login',
    'classMeetApp.recupMDP',
    'classMeetApp.menu'
  ])
  .config(["$routeProvider","$locationProvider",function ($routeProvider,$locationProvider,Session) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/acceuil.html',
        controller: 'AcceuilCtrl',
        controllerAs: 'acceuil',
        resolve: {
          currentSession: function(Session){
            return Session.validateSession();
          }
        }
      })
      .when('/profil', {
        templateUrl: 'views/configProfil.html',
        controller: 'ProfilCtrl',
        controllerAs: 'profil',
        resolve: {
          currentSession: function(Session){
            return Session.validateSession();
          }
        }
      })
      .when('/messagerie', {
        templateUrl: 'views/messagerie.html',
        controller: 'MessagerieCtrl',
        controllerAs: 'messagerie',
        resolve: {
          currentSession: function(Session){
            return Session.validateSession();
          }
        }
      })
      .when('/messagesEnvoyes', {
        templateUrl: 'views/messagesEnvoyes.html',
        controller: 'MessagesEnvoyesCtrl',
        controllerAs: 'messagesEnvoyes',
        resolve: {
          currentSession: function(Session){
            return Session.validateSession();
          }
        }
      })
      .when('/nouveauMessage', {
        templateUrl: 'views/nouveauMessage.html',
        controller: 'NouveauMessageCtrl',
        controllerAs: 'nouveauMessage',
        resolve: {
          currentSession: function(Session){
            return Session.validateSession();
          }
        }
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'login',
        resolve: {
          empty: function(Session){
            return Session.noSession();
          }
        }
      })
      .when('/recuperMDP', {
        templateUrl: 'views/recupMDP.html',
        controller: 'RecupMDPCtrl',
        controllerAs: 'recupMDP',
        resolve: {
          empty: function(Session){
            return Session.noSession();
          }
        }
      })
      .otherwise({
        redirectTo: '/'
      });
  }]);
  app.run(["$rootScope","$window",function($rootScope,$window){
    $rootScope.$on('$routeChangeError', function (event, current, previous, rejection) {
        if(rejection == 'Null Session')
        {
           $window.location.href="/#/login";
        }
        else if(rejection == 'Already log')
        {
           $window.location.href="/";
        }
    });
  }]);
  return app
})
