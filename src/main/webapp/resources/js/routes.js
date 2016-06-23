/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('SASurgical').config(['$httpProvider', '$routeProvider', '$locationProvider', function($httpProvider, $routeProvider, $locationProvider){
    
    $locationProvider.html5Mode({
        enabled: true
    });        
    
    $routeProvider.when('/',{
       templateUrl: 'resources/tpl/home_page.html',
       controller: 'HomePageController',
       controllerAs: 'homepageController'
    }).when('/browse/:category?',{
        templateUrl: 'resources/tpl/category_browse.html',
        controller: 'CategoryBrowseController',
        controllerAs: 'categorybrowseController'
    });
}]);