/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('SASurgical').service('dataHandler', ['$rootScope', '$http', 'helpers', function($rootScope, $http, helpers){
    var mainCtrl = $rootScope.mainCtrl;
    
    var dataHandler = {
        getProducts: getProducts,
        getFrontPageCarousel:getFrontPageCarousel
    };
    
    return dataHandler;
    
    function getFrontPageCarousel(){
        return $http.get('resources/data/main.json').then(function(response){
            return response.data.carousel;
        });
    }
    
    function getProducts(categoryId){
        
    }
    
}]);

angular.module('SASurgical').service('helpers', [function(){
        
}]);