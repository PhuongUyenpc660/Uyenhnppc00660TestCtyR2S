var app = angular.module('admin-app', ['ngRoute']);
app.config(function ($routeProvider) {
    $routeProvider.when('/account', {
        templateUrl: "/assets/admin12/account/index.html",
        controller: 'account-ctrl'
    }).when('/authorize', {
        templateUrl: "/assets/admin12/authority/index.html",
        controller: 'authority-ctrl'
    }).when('/unauthorized', {
        templateUrl: "/assets/admin12/authority/unauthorized.html",
        controller: 'authority-ctrl'
    }).otherwise({
        template: "<h1 class='text-center'>FPT Polytechnic Administration</h1>"
    })
})