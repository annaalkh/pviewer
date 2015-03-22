package ru.annaalkh.pviewer.model;

import ru.annaalkh.pviewer.ClassFactory;
import ru.annaalkh.pviewer.FileType;

import java.io.File;
import java.util.*;

/**
 * Created by Anna on 3/19/15.
 */
public class Project implements ProjectItem {

    private String name;

    private List<FileInfo> files = new ArrayList<>();
    private List<ClassInfo> classes = new ArrayList<>();
    private List<FileInfo> compiledClassFiles = new ArrayList<>();

    private Map<String, ClassInfo> classNamesMap = new HashMap<>();
    private Map<String, FileInfo> compiledClassesMap = new HashMap<>();


    public void addFile(FileInfo fileInfo) {
        files.add(fileInfo);
        if (fileInfo.getType() == FileType.JAVA_SOURCE) {
            ClassInfo javaClassInfo = ClassFactory.getClassInfo(fileInfo);
            addClass(javaClassInfo);
        }  else if (fileInfo.getType() == FileType.CLASS) {
            addCompiledClassFile(fileInfo);
        }
    }

    public void boundClasses() {
        classNamesMap.forEach((className, classInfo) -> {
            FileInfo compiledClassFile = compiledClassesMap.get(className);
            if (compiledClassFile != null) {
                classInfo.setCompiledFile(compiledClassFile);
            }
        });
    }



    private void addClass(ClassInfo classInfo) {
        classes.add(classInfo);
        classNamesMap.put(classInfo.getName(), classInfo);
    }

    private void addCompiledClassFile(FileInfo compiledClassInfo) {
        compiledClassFiles.add(compiledClassInfo);
        compiledClassesMap.put(compiledClassInfo.getNameWithoutExtention(), compiledClassInfo);
    }




    public List<ClassInfo> getClassesView() {
        return Collections.unmodifiableList(classes);
    }

    public List<FileInfo> getFilesInfoView() {
        return Collections.unmodifiableList(files);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
