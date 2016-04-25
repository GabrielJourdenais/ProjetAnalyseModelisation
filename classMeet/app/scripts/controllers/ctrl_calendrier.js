define([
    'angular',
    'angular_ui_bootstrap',
    'angular_ui_calendar',
     '../services/srv_profil.js',
     '../services/srv_cours.js'
], function(ng) {
  var app=ng.module('classMeetApp.calendrier', [
    'ui.bootstrap',
    'ui.calendar',
    "classMeetApp.profilService",
    "classMeetApp.coursService"
  ])
  .controller('CalendrierCtrl',function($scope,$window,$compile,Session,uiCalendarConfig,Equipes,EquipeService){
    $scope.equipeCourante=Equipes.getEquipeCourante();

    if($scope.equipeCourante==null)
    {
      $window.location="/#/";
        $window.location.reload();
    }

    

    $scope.evenement={
      nom:"",
      description:"",
      dateHeureEvenement:new Date(),
      dureeM:1,
      lieu:""
    };

    $scope.events=[
    ];
    EquipeService.getMembresEquipe($scope.equipeCourante.sigleCours,$scope.equipeCourante.noGroupeCours,$scope.equipeCourante.noEquipe).then(
      function(data){},
      function(error)
      {
        $window.location="/#/";
        $window.location.reload();
      }
    )

    $scope.eventsF = function (start, end, timezone, callback) {
      EquipeService.getEvenementsEquipe($scope.equipeCourante.sigleCours,$scope.equipeCourante.noGroupeCours,$scope.equipeCourante.noEquipe).then(
        function(data)
        {
          $scope.events=[];
          if(data!=null&&data!="")
          {
            data.forEach(function(data)
            {
              $scope.events.push({title:data.nom,desc:data.description,lieu:data.lieu,start: new Date(data.dateHeureEvenement),duree: data.dureeM});
            });
          }
        },
        function(error)
        {
        }
      )
      callback($scope.events);
    };

    /* alert on eventClick */
    $scope.alertOnEventClick = function(currEvent, jsEvent, view){
        alert(
          "titre: "+currEvent.title +"\n"+
          "description: " +currEvent.desc + "\n"+
          "date: "+ new Date(currEvent.start) +"\n"+
          "duree: "+currEvent.duree+" minutes\n"+
          "lieu: "+currEvent.lieu);
    };

    /* add custom event*/
    $scope.addEvent = function(evenement) {
      if(evenement.nom==""||evenement.nom==null)
      {
        alert("Le champ Titre est vide");
      }
      else if(evenement.dateHeureEvenement==null)
      {
        alert("Le champ Date est vide");
      }
      else if(evenement.dureeM<1||evenement.dureeM==null)
      {
        alert("Le champ Duree est invalide");
      }
      else
      {
        EquipeService.addEvenementsEquipe($scope.equipeCourante.sigleCours,$scope.equipeCourante.noGroupeCours,$scope.equipeCourante.noEquipe,evenement).then(
          function(data)
          {
            if(data.status==1)
            {
              $scope.evenement={
                nom:"",
                description:"",
                dateHeureEvenement:new Date(),
                dureeM:1,
                lieu:""
              };
              alert("Évenement ajouté au calendrier");
            }
            else
            {
              alert("Un événement est déjà planifé pour cette date et heure");
            }
            
          },
          function(error)
          {
            alert(error);
          }
        )
      }
    };

    /* Change View */
    $scope.changeView = function(view,calendar) {
      uiCalendarConfig.calendars[calendar].fullCalendar('changeView',view);
    };
    /* Change View */
    $scope.renderCalender = function(calendar) {
      if(uiCalendarConfig.calendars[calendar]){
        uiCalendarConfig.calendars[calendar].fullCalendar('render');
      }
    };
     /* Render Tooltip */
    $scope.eventRender = function( event, element, view ) { 
        element.attr({'tooltip': event.title,
                     'tooltip-append-to-body': true});
        $compile(element)($scope);
    };


    $scope.uiConfig = {
      calendar:{
        height: 450,
        editable: false,
        header:{
          left: 'title',
          center: '',
          right: 'today prev,next'
        },
        eventClick: $scope.alertOnEventClick,
        eventRender: $scope.eventRender,
        loading: $scope.loading
      }
    };

     $scope.dateOptions = {
    dateDisabled: false,
    formatYear: 'yy',
    maxDate: new Date(2020, 5, 22),
    minDate: new Date(),
    startingDay: 1
  };

    $scope.isOpenDatePicker=false;
    $scope.openDatePicker=function()
    {
      $scope.isOpenDatePicker=true;
    }

    $scope.eventSources = [$scope.eventsF];

    $scope.format='yyyy-MM-dd';

    $scope.hstep = 1;
  $scope.mstep = 1;
  })
  return app;
})