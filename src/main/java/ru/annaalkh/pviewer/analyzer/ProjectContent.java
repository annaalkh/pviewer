package ru.annaalkh.pviewer.analyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 3/21/15.
 */
public class ProjectContent implements AnalysisResult {

    private String projectName;

    private List<ClassContent> classes = new ArrayList<>();

    private int totalNumberOfFiles;
    private int numberOfSourceFiles;
    private int numberOfClassFiles;
    private int numberOfXmlFiles;
    private int numberOfClasses;
    private int numberOfEnums;
    private int numberOfInterfaces;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<ClassContent> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassContent> classes) {
        this.classes = classes;
    }

    public int getTotalNumberOfFiles() {
        return totalNumberOfFiles;
    }

    public void setTotalNumberOfFiles(int totalNumberOfFiles) {
        this.totalNumberOfFiles = totalNumberOfFiles;
    }

    public int getNumberOfSourceFiles() {
        return numberOfSourceFiles;
    }

    public void setNumberOfSourceFiles(int numberOfSourceFiles) {
        this.numberOfSourceFiles = numberOfSourceFiles;
    }

    public int getNumberOfClassFiles() {
        return numberOfClassFiles;
    }

    public void setNumberOfClassFiles(int numberOfClassFiles) {
        this.numberOfClassFiles = numberOfClassFiles;
    }

    public int getNumberOfXmlFiles() {
        return numberOfXmlFiles;
    }

    public void setNumberOfXmlFiles(int numberOfXmlFiles) {
        this.numberOfXmlFiles = numberOfXmlFiles;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public int getNumberOfEnums() {
        return numberOfEnums;
    }

    public void setNumberOfEnums(int numberOfEnums) {
        this.numberOfEnums = numberOfEnums;
    }

    public int getNumberOfInterfaces() {
        return numberOfInterfaces;
    }

    public void setNumberOfInterfaces(int numberOfInterfaces) {
        this.numberOfInterfaces = numberOfInterfaces;
    }
}
