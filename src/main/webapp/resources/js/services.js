/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('SASurgical').service('dataHandler', ['$rootScope', '$http', 'helpers', 'localStorageService', function($rootScope, $http, helpers, localStorageService){
    var mainCtrl = $rootScope.mainCtrl;
    
    var dataHandler = {
        getParentCategory: getParentCategory,
        getFrontPageCarousel:getFrontPageCarousel,
        getSubCategories:getSubCategories,
        getAllItemSub:getAllItemSub,
        storeLocalStorage:storeLocalStorage,
        getLocalStorage:getLocalStorage,
        removeLocalStorage:removeLocalStorage,
        clearLocalStorage:clearLocalStorage
    };
    
    return dataHandler;
    
    function storeLocalStorage(key, val){
        if(localStorageService.isSupported) {
            return localStorageService.set(key, val);
        }
        else if(localStorageService.cookie.isSupported) {
            return localStorageService.cookie.set(key, val);
        }
    }
    
    function getLocalStorage(key){
        if (localStorageService.isSupported){
            return localStorageService.get(key);
        }
        else if (localStorageService.cookie.isSupported){
            return localStorageService.cookie.get(key);
        }
    }
    
    function removeLocalStorage(key){
        if (localStorageService.isSupported){
            if (localStorageService.get(key) != null)
                return localStorageService.remove(key);
        }
        else if (localStorageService.cookie.isSupported){
            if (localStorageService.cookie.get(key) != null)
                return localStorageService.cookie.get(key);
        }
    }
    
    function clearLocalStorage(){
        if (localStorageService.isSupported){
            return localStorageService.clearAll();
        }
        else if (localStorageService.cookie.isSupported){
            return localStorageService.cookie.clearAll();
        }
    }
    
    function getFrontPageCarousel(){
        return $http.get('resources/data/main.json').then(function(response){
            return response.data.carousel;
        });
    }
    
    function getParentCategory(){
        var data_json = $http({method:'GET',url:'get_categories',params:{"category":0,"parent_category":1}}).then(function(response){
            return response.data;
        });
        return data_json;        
    }
    
    function getSubCategories(category){
        var data_json = $http({method:'GET',url:'get_categories',params:{"category":category,"parent_category":0}}).then(function(response){
            return response.data;
        });
        return data_json;  
    }    
    
    function getAllItemSub(category){
        var data_json = $http({method:'GET',url:'get_all_items_sub',params:{"category":category}}).then(function(response){
            return response.data;
        });
        return data_json;  
    }
}]);

angular.module('SASurgical').service('helpers', [function(){
        
}]);