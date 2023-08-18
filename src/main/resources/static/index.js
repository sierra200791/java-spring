angular.module('app',[]).controller('indexController', function ($scope, $http){

    const contextPath = 'http://localhost';

    $scope.loadProduct = function () {
        $http.get(contextPath + '/')
            .then(function (response) {
                console.log(response);
                $scope.productList = response.data;
            })
    };

    $scope.loadProduct();



})