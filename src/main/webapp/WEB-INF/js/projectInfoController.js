angular.module('app', []).controller('ProjectInfoController',function ProjectInfoController($scope, $http) {
    $scope.projectInfo = {
        projectName: "",
        totalNumberOfFiles: 0,
        numberOfSourceFiles: 0,
        numberOfClassFiles: 0,
        numberOfXmlFiles: 0,
        numberOfClasses: 0,
        numberOfEnums: 0,
        numberOfInterfaces: 0,
        sourceFiles: [
            {id: "123", name: "First.java"},
            {id: "234", name: "Second.java"}
        ],
        classFiles: [
            {id: "777", name: "First.class"},
            {id: "555", name: "Second.class"}
        ],
        xmlFiles: [
            {id: "777", title: "pom.xml"},
            {id: "555", title: "applicationContext.xml"}
        ],
        classes: [
            {id: "777", title: "First"},
            {id: "555", title: "Second"}
        ],
        enums: [
            {id: "777", title: "FileType"}
        ],
        interfaces: [
            {id: "777", title: "Clickable"}
        ]
    };
    $scope.selectedPath = "";
    $scope.filesForSelect = [];
    $scope.dataToDisplay = {
        info: "",
        source: ""
    }
    $scope.selectedFileType = "File" // or Class

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

                $scope.projectInfo.classes = data.classes;
            })
            .error(function(data, status, headers, config) {
                alert("Some error occured, check your path is correct");
            });
    };

    $scope.setSourceFilesForSelect = function() {
        $scope.filesForSelect = $scope.projectInfo.sourceFiles;
        $scope.selectedFileType = "File";
    };

    $scope.setClassFilesForSelect = function() {
        $scope.filesForSelect = $scope.projectInfo.classFiles;
        $scope.selectedFileType = "File";
    };

    $scope.setXmlFilesForSelect = function() {
        $scope.filesForSelect = $scope.projectInfo.xmlFiles;
        $scope.selectedFileType = "File";
    };

    $scope.setClassesForSelect = function() {
        $scope.filesForSelect = $scope.projectInfo.classes;
        $scope.selectedFileType = "Class";
    };

    $scope.setEnumsForSelect = function() {
        $scope.filesForSelect = $scope.projectInfo.enums;
        $scope.selectedFileType = "Class";
    };

    $scope.setInterfacesForSelect = function() {
        $scope.filesForSelect = $scope.projectInfo.interfaces;
        $scope.selectedFileType = "Class";
    };


    $scope.showItemInfo = function(projectItem) {
        $scope.dataToDisplay.info = prepareItemStructuredInfo(projectItem, $scope.classIsSelected());
        $scope.dataToDisplay.source = projectItem.className;
    }

    function prepareItemStructuredInfo(projectItem, isClass) {
        if (isClass) {
            return {
                title: projectItem.name,
                numberOfMethods: projectItem.numberOfMethods,
                numberOfPublicMethods: projectItem.numberOfPublicMethods,
                numberOfProtectedMethods: projectItem.numberOfProtectedMethods,
                numberOfPrivateMethods: projectItem.numberOfPrivateMethods
            }
        } else {
            return {
                title: projectItem.name,
                description: "this is not java file"
            }
        }
    }

    $scope.classIsSelected = function() {
        return $scope.selectedFileType == "Class";
    }

});
