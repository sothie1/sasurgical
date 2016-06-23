/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('SASurgical').controller('HomePageController',['$scope','dataHandler','helpers', function($scope, dataHandler, helpers){
        
        var homepageController = this;
        var mainCtrl = $scope.mainCtrl;
        
        $scope.helpers = helpers;
        $scope.active = 0;
        $scope.view_tab = 'tab1';
        
        $scope.changeTab = function(tab){
            $scope.view_tab = tab;
        }
        
        dataHandler.getFrontPageCarousel().then(function (imgData){
            homepageController.imgData = imgData;
            var foo = "Foo"
        });                
}]);
