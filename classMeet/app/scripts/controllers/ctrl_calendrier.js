define([
    'angular',
    'angular_ui_calendar'
], function(ng) {
  var app=ng.module('classMeetApp.calendrier', [
    'ui.calendar'
  ])
  .controller('CalendrierCtrl',function($scope,$window,$compile,Session,uiCalendarConfig){
    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();

    //$scope.

    
    /* event source that contains custom events on the scope */
    $scope.events = [
      {title: "Rencontre d'équipe", start: new Date(2016, 4 - 1, 8, 13, 30)},
      {title: "Rencontre d'équipe", start: new Date(2016, 4 - 1, 15, 13, 30)},
      {title: "Présentation Sprint 3", start: new Date(2016, 4 - 1, 25, 13, 20)}
    ];
    /* event source that calls a function on every view switch */
    $scope.eventsF = function (start, end, timezone, callback) {
      var s = new Date(start).getTime() / 1000;
      var e = new Date(end).getTime() / 1000;
      var m = new Date(start).getMonth();
      var events = [{title: 'Feed Me ' + m,start: s + (50000),end: s + (100000),allDay: false, className: ['customFeed']}];
      callback(events);
    };

    /* alert on eventClick */
    $scope.alertOnEventClick = function( date, jsEvent, view){
        $scope.alertMessage = (date.title + ' was clicked ');
    };
    /* add and removes an event source of choice */
    $scope.addRemoveEventSource = function(sources,source) {
      var canAdd = 0;
      angular.forEach(sources,function(value, key){
        if(sources[key] === source){
          sources.splice(key,1);
          canAdd = 1;
        }
      });
      if(canAdd === 0){
        sources.push(source);
      }
    };
    /* add custom event*/
    $scope.addEvent = function() {
      $scope.events.push({
        title: 'Open Sesame',
        start: new Date(y, m, 28)
      });
    };
    /* remove event */
    $scope.remove = function(index) {
      $scope.events.splice(index,1);
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
    /* config object */
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
        eventRender: $scope.eventRender
      }
    };

    /* event sources array*/
    $scope.eventSources = [$scope.events];
  })
  return app;
})