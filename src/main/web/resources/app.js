var ticketOffice = angular.module('ticketOffice', []);


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

        var update = function() {
            $http
                .get('/ticketOffice/cities')
                .then(function (response) {
                $scope.cities = response.data;
            });
        };

        update();

});
