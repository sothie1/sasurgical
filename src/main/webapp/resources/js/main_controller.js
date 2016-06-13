/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('SASurgical').controller('MainController', ['$rootScope', '$scope', 'dataHandler', function($rootScope, $scope, dataHandler){

        var mainCtrl = this;
        $rootScope.mainCtrl = mainCtrl;
        
        //Setting the global variabls
        mainCtrl.loggedIn = false;
               
}]);