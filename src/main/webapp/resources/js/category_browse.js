/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('SASurgical').controller('CategoryBrowseController',['$scope','dataHandler','helpers','$routeParams', function($scope, dataHandler, helpers, $routeParams){
        
        var categorybrowseController = this;
        var mainCtrl = $scope.mainCtrl;
        
        $scope.helpers = helpers;
        $scope.category = $routeParams.category
        
        dataHandler.getSubCategories($scope.category).then(function (sub_category){
            categorybrowseController.sub_category = sub_category;
            var foo = "FOO"
        });   
        
        $scope.ListView = function(){
            $('#products .item').addClass('list-group-item');            
        };
        
        $scope.GridView = function(){
            $('#products .item').removeClass('list-group-item');
            $('#products .item').addClass('grid-group-item');            
        };
                      
}]);
