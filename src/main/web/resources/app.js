var ticketOffice = angular.module('ticketOffice', ['ngRoute']);


ticketOffice.controller('homeController', function ($scope, $http) {
    $scope.arr = [];
    $http.get('/ticketOffice/').then(function (response) {
        $scope.arr = response.data;
        $scope.cities = response.data;
    });
});
ticketOffice.controller('cityCtrl', function ($scope, $http) {
    $scope.cities = [];


    $scope.deleteCity = function (city) {
        $http
            .delete('/ticketOffice/cities/' + city.id)
            .then(function (response) {
                update();
            })
    };
    $scope.addCity = function (city) {
        $http
            .post('/ticketOffice/cities/', {name: city.name})
            .then(function (response) {
                update();
            });
    };

    var update = function () {
        $http
            .get('/ticketOffice/cities')
            .then(function (response) {
                $scope.cities = response.data;
            });
    };

    update();

});

ticketOffice.controller('flightCtrl', function ($scope, $http) {
    $scope.cities = [];
    $scope.flights = [];
    var currentDate = new Date();
    $scope.currentDate = currentDate.toISOString().slice(0,10);

    $scope.deleteFlight = function (flight) {
        $http
            .delete('/ticketOffice/flights/' + flight.id)
            .then(function (response) {
                update();
            })
    };
    $scope.addFlight = function (flight) {
        $http
            .post('/ticketOffice/flights/', {
                name: flight.name,
                city: flight.city,
                dateTime: flight.dateTime,
                numberOfPlace: flight.numberOfPlace
            })
            .then(function (response) {
                update();
            });
    };

    var update = function () {
        $http
            .get('/ticketOffice/flights')
            .then(function (response) {
                $scope.flights = response.data;
            });
        $http
            .get('/ticketOffice/cities')
            .then(function (response) {
                $scope.cities = response.data;
            });
    };

    update();

});

ticketOffice.config(['$routeProvider', '$locationProvider',
    function ($routeProvider, $locationProvider) {
        $routeProvider.
        when('/home', {
            templateUrl: 'views/home.html',
            controller: 'homeController'
        }).
        when('/cities', {
            templateUrl: 'views/cities.html',
            controller: 'cityCtrl'
        }).
        when('/flights', {
            templateUrl: 'views/flights.html',
            controller: 'flightCtrl'
        }).
        otherwise({
            redirectTo: '/home'
        });
        $locationProvider.html5Mode(true);
    }]);


