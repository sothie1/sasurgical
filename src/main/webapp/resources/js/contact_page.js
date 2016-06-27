/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('SASurgical').controller('ContactController',['$scope','dataHandler','helpers', function($scope, dataHandler, helpers){
        
        var contactController = this;
        var mainCtrl = $scope.mainCtrl;
        
        $scope.firstName = "";
        $scope.lastName = "";
        $scope.contactEmail = "";
        $scope.phoneNumber = "";
        
        $scope.showSuccessBanner = true;
        $scope.showErrorBanner = true;
        $scope.errorMsg = ""
}]);
