require.config({
    paths: {
        angular: '../node_modules/angular/angular',
        angular_route: '../node_modules/angular-route/angular-route',
        angular_cookies: '../node_modules/angular-cookies/angular-cookies',
        angular_ui_bootstrap: '../node_modules/angular-ui-bootstrap/dist/ui-bootstrap-tpls',
        angular_ui_calendar: '../node_modules/angular-ui-calendar/src/calendar',
        app: 'app'
    },
    shim: {
        angular: {
            exports:'angular'
        },
        angular_route:{
            deps:["angular"]
        },
        angular_cookies:{
            deps:["angular"]
        },
        angular_ui_bootstrap:{
            deps:["angular"]
        },
        angular_ui_calendar:{
            deps:["angular"]
        }
    }
})
require(['angular','app'], function(ng)
{
    ng.bootstrap(document, ['classMeetApp'])
})