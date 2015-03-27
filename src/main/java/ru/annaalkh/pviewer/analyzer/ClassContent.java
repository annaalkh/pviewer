package ru.annaalkh.pviewer.analyzer;

import ru.annaalkh.pviewer.ClassType;

/**
 * Created by Anna on 3/26/15.
 */
public class ClassContent implements AnalysisResult {

    private String name;
    private ClassType classType;

    private int numberOfFields;
    private int numberOfPublicFields;
    private int numberOfProtectedFields;
    private int numberOfPrivateFields;

    private int numberOfConstructors;
    private int numberOfPublicConstructors;
    private int numberOfProtectedConstructors;
    private int numberOfPrivateConstructors;

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

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public int getNumberOfFields() {
        return numberOfFields;
    }

    public void setNumberOfFields(int numberOfFields) {
        this.numberOfFields = numberOfFields;
    }

    public int getNumberOfPublicFields() {
        return numberOfPublicFields;
    }

    public void setNumberOfPublicFields(int numberOfPublicFields) {
        this.numberOfPublicFields = numberOfPublicFields;
    }

    public int getNumberOfProtectedFields() {
        return numberOfProtectedFields;
    }

    public void setNumberOfProtectedFields(int numberOfProtectedFields) {
        this.numberOfProtectedFields = numberOfProtectedFields;
    }

    public int getNumberOfPrivateFields() {
        return numberOfPrivateFields;
    }

    public void setNumberOfPrivateFields(int numberOfPrivateFields) {
        this.numberOfPrivateFields = numberOfPrivateFields;
    }

    public int getNumberOfConstructors() {
        return numberOfConstructors;
    }

    public void setNumberOfConstructors(int numberOfConstructors) {
        this.numberOfConstructors = numberOfConstructors;
    }

    public int getNumberOfPublicConstructors() {
        return numberOfPublicConstructors;
    }

    public void setNumberOfPublicConstructors(int numberOfPublicConstructors) {
        this.numberOfPublicConstructors = numberOfPublicConstructors;
    }

    public int getNumberOfProtectedConstructors() {
        return numberOfProtectedConstructors;
    }

    public void setNumberOfProtectedConstructors(int numberOfProtectedConstructors) {
        this.numberOfProtectedConstructors = numberOfProtectedConstructors;
    }

    public int getNumberOfPrivateConstructors() {
        return numberOfPrivateConstructors;
    }

    public void setNumberOfPrivateConstructors(int numberOfPrivateConstructors) {
        this.numberOfPrivateConstructors = numberOfPrivateConstructors;
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
