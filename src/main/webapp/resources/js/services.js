/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('SASurgical').service('dataHandler', ['$rootScope', '$http', 'helpers', function($rootScope, $http, helpers){
    var mainCtrl = $rootScope.mainCtrl;
    
    var dataHandler = {
        getParentCategory: getParentCategory,
        getFrontPageCarousel:getFrontPageCarousel,
        getSubCategories:getSubCategories
    };
    
    return dataHandler;
    
    function getFrontPageCarousel(){
        return $http.get('resources/data/main.json').then(function(response){
            return response.data.carousel;
        });
    }
    
    function getParentCategory(){
        var data_json = $http({method:'GET',url:'get_categories',data:{"category":0,"parent_category":1}}).then(function(response){
            return response;
        });
        return data_json;        
    }
    
    function getSubCategories(category){
        var data_json = $http.get("resources/data/main.json").then(function(response){
            if (category == "surgical")
                return response.data.category.sugical_sub;
            else if (category == "dental")
                return response.data.category.dental_sub;
        });
        return data_json;
    }    
}]);

angular.module('SASurgical').service('helpers', [function(){
        
}]);