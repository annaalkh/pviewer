package ru.annaalkh.pviewer.analyzer;

/**
 * Created by Anna on 3/26/15.
 */
public class ClassContent implements AnalysisResult {

    private String name;
    private String classType;
    private int numberOfMethods;
    private int numberOfPublicMethods;
    private int numberOfProtectedMethods;
    private int numberOfPrivateMethods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getNumberOfMethods() {
        return numberOfMethods;
    }

    public void setNumberOfMethods(int numberOfMethods) {
        this.numberOfMethods = numberOfMethods;
    }

    public int getNumberOfPublicMethods() {
        return numberOfPublicMethods;
    }

    public void setNumberOfPublicMethods(int numberOfPublicMethods) {
        this.numberOfPublicMethods = numberOfPublicMethods;
    }

    public int getNumberOfProtectedMethods() {
        return numberOfProtectedMethods;
    }

    public void setNumberOfProtectedMethods(int numberOfProtectedMethods) {
        this.numberOfProtectedMethods = numberOfProtectedMethods;
    }

    public int getNumberOfPrivateMethods() {
        return numberOfPrivateMethods;
    }

    public void setNumberOfPrivateMethods(int numberOfPrivateMethods) {
        this.numberOfPrivateMethods = numberOfPrivateMethods;
    }
}
