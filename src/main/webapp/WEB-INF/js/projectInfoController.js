angular.module('app', []).controller('ProjectInfoController',function ProjectInfoController($scope, $http) {
    $scope.projectInfo = {
        projectName: "",
        totalNumberOfFiles: 0,
        numberOfSourceFiles: 0,
        numberOfClassFiles: 0,
        numberOfXmlFiles: 0,
        numberOfClasses: 0,
        numberOfEnums: 0,
        numberOfInterfaces: 0
    };
    $scope.selectedPath = ""

    $scope.performAnalysis = function() {
        $http({
            url: '/projects/projectInfo.json',
            method: "GET",
            params:{projectPath: $scope.selectedPath}
        }).success(function(data, status, headers, config) {
                $scope.projectInfo.projectName = data.projectName;
                $scope.projectInfo.totalNumberOfFiles = data.totalNumberOfFiles;
                $scope.projectInfo.numberOfSourceFiles = data.numberOfSourceFiles;
                $scope.projectInfo.numberOfClassFiles = data.numberOfClassFiles;
                $scope.projectInfo.numberOfXmlFiles = data.numberOfXmlFiles;
                $scope.projectInfo.numberOfClasses = data.numberOfClasses;
                $scope.projectInfo.numberOfInterfaces = data.numberOfInterfaces;
                $scope.projectInfo.numberOfEnums = data.numberOfEnums;
            })
            .error(function(data, status, headers, config) {
                alert("Some error occured, check your path is correct");
            });
    }

});
