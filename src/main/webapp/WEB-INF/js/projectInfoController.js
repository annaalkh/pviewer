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


    $scope.fileTypes = {
        typeFile: {
            name: "File",
            isJava: false
        },
        typeClass: {
            name: "Class",
            isJava: true
        },
        typeInterface: {
            name: "Interface",
            isJava: true
        },
        typeEnum: {
            name: "Enum",
            isJava: true
        }};

    $scope.selectedFileType = $scope.fileTypes.typeFile;

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
                $scope.projectInfo.interfaces = data.interfaces;
                $scope.projectInfo.enums = data.enums;
            })
            .error(function(data, status, headers, config) {
                alert("Some error occured, check your path is correct");
            });
    };

    $scope.setSourceFilesForSelect = function() {
        $scope.filesForSelect = $scope.projectInfo.sourceFiles;
        $scope.selectedFileType = $scope.fileTypes.typeFile;
    };

    $scope.setClassFilesForSelect = function() {
        $scope.filesForSelect = $scope.projectInfo.classFiles;
        $scope.selectedFileType = $scope.fileTypes.typeFile;
    };

    $scope.setXmlFilesForSelect = function() {
        $scope.filesForSelect = $scope.projectInfo.xmlFiles;
        $scope.selectedFileType = $scope.fileTypes.typeFile;
    };

    $scope.setClassesForSelect = function() {
        $scope.filesForSelect = $scope.projectInfo.classes;
        $scope.selectedFileType = $scope.fileTypes.typeClass;
    };

    $scope.setEnumsForSelect = function() {
        $scope.filesForSelect = $scope.projectInfo.enums;
        $scope.selectedFileType = $scope.fileTypes.typeEnum;
    };

    $scope.setInterfacesForSelect = function() {
        $scope.filesForSelect = $scope.projectInfo.interfaces;
        $scope.selectedFileType = $scope.fileTypes.typeInterface;
    };


    $scope.showItemInfo = function(projectItem) {
        $scope.dataToDisplay.info = prepareItemStructuredInfo(projectItem, $scope.javaItemIsSelected());
        $scope.dataToDisplay.source = projectItem.className;
    }

    function prepareItemStructuredInfo(projectItem, isJavaItem) {
        if (isJavaItem) {
            return {
                title: projectItem.name,

                numberOfFields: projectItem.numberOfFields,
                numberOfPublicFields: projectItem.numberOfPublicFields,
                numberOfProtectedFields: projectItem.numberOfProtectedFields,
                numberOfPrivateFields: projectItem.numberOfPrivateFields,

                numberOfConstructors: projectItem.numberOfConstructors,
                numberOfPublicConstructors: projectItem.numberOfPublicConstructors,
                numberOfProtectedConstructors: projectItem.numberOfProtectedConstructors,
                numberOfPrivateConstructors: projectItem.numberOfPrivateConstructors,

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

    $scope.javaItemIsSelected = function() {
        return $scope.selectedFileType.isJava;
    }

});
