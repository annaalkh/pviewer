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
        sourceFiles: [],
        classFiles: [],
        xmlFiles: [],
        classes:  [],
        enums: [],
        interfaces: []
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

    $scope.urls = {
        getProjectInfo: '/projects/projectInfo.json',

        getAllFileList: '/projects/all_files.json',
        getSourceFileList: '/projects/source_files.json',
        getClassFileList: '/projects/class_files.json',
        getXmlFileList: '/projects/xml_files.json',
        getClassesList: '/projects/classes.json',
        getEnumsList: '/projects/enums.json',
        getInterfacesList: '/projects/interfaces.json',

        getItemInfo: '/projects/item_info.json'
    }

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


    $scope.getDataFromServer = function(url, processDataCallback, params) {
        $http({
            url: url,
            params: params,
            method: "GET"
        }).success(function(data, status, headers, config) {
                processDataCallback(data);
            })
            .error(function(data, status, headers, config) {
                alert("Some error occured, check your path is correct");
            });
    };

    $scope.setFilesListForSelect = function(dataUrl, fileType) {
        $scope.getDataFromServer(dataUrl, function(data) {
            $scope.filesForSelect = data;
            $scope.selectedFileType = fileType;
        })
    }


    $scope.setAllFilesForSelect = function() {
        $scope.setFilesListForSelect($scope.urls.getAllFileList, $scope.fileTypes.typeFile) ;
    };

    $scope.setSourceFilesForSelect = function() {
        $scope.setFilesListForSelect($scope.urls.getSourceFileList, $scope.fileTypes.typeFile) ;
    };

    $scope.setClassFilesForSelect = function() {
        $scope.setFilesListForSelect($scope.urls.getClassFileList, $scope.fileTypes.typeFile) ;
    };

    $scope.setXmlFilesForSelect = function() {
        $scope.setFilesListForSelect($scope.urls.getXmlFileList, $scope.fileTypes.typeFile) ;
    };

    $scope.setClassesForSelect = function() {
        $scope.setFilesListForSelect($scope.urls.getClassesList, $scope.fileTypes.typeClass) ;
    };

    $scope.setEnumsForSelect = function() {
        $scope.setFilesListForSelect($scope.urls.getEnumsLis, $scope.fileTypes.typeEnum) ;
    };

    $scope.setInterfacesForSelect = function() {
        $scope.setFilesListForSelect($scope.urls.getInterfacesList, $scope.fileTypes.typeInterface) ;
    };



    $scope.showItemInfo = function(projectItem) {
        $scope.getDataFromServer($scope.urls.getItemInfo, function(data) {
            $scope.dataToDisplay.info = prepareItemStructuredInfo(data, $scope.javaItemIsSelected());
            $scope.dataToDisplay.source = data.className;
        }, {id: projectItem.id});
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
