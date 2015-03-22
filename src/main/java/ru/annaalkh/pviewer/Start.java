package ru.annaalkh.pviewer;

import com.sun.org.apache.regexp.internal.recompile;
import org.apache.commons.io.FilenameUtils;
import ru.annaalkh.pviewer.analyzer.ProjectContent;
import ru.annaalkh.pviewer.analyzer.ProjectContentAnalyzer;
import ru.annaalkh.pviewer.model.ClassInfo;
import ru.annaalkh.pviewer.model.FileInfo;
import ru.annaalkh.pviewer.model.Project;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anna on 3/19/15.
 */
public class Start {

    public static void main(String[] args) {
        Start theStart = new Start();
        Project currentProject = new Project();

        File selectedDirectory = new File("d:\\Programs\\BookRecommender\\");
//        File selectedDirectory = new File("d:\\Programs\\projectViewer\\");
//        File selectedDirectory = new File("d:\\Programs\\RefFramework\\");
        List<File> filesFromDirectory = theStart.getFilesFromDirectory(selectedDirectory);
        filesFromDirectory.forEach(
                file -> {
                    FileInfo currentFileInfo = FileInfo.createFromFile(file);
                    currentProject.addFile(currentFileInfo);
                }
        );
        currentProject.boundClasses();
        ProjectContentAnalyzer projectContentAnalyzer = new ProjectContentAnalyzer();
        ProjectContent projectContent = projectContentAnalyzer.analyse(currentProject);
        printProjectContentInfo(projectContent);
    }

    private List<File> getFilesFromDirectory(File directory) {
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("argument should be directory!");
        }
        List<File> resultList = new ArrayList<>();
        writeInListFilesFromDirectory(directory, resultList);
        return resultList;
    }

    private void writeInListFilesFromDirectory(File directory, List<File> resultList) {
        assert resultList != null;
        File[] listOfFiles = directory.listFiles();
        for  (File currentFile: listOfFiles) {
            if (currentFile.isDirectory()) {
                writeInListFilesFromDirectory(currentFile, resultList);
            } else {
                resultList.add(currentFile);
            }
        }
    }

    private static void printProjectContentInfo(ProjectContent projectContent) {
        System.out.println("Number of files: " + projectContent.getTotalNumberOfFiles());
        System.out.println("Number of java files: " + projectContent.getNumberOfSourceFiles());
        System.out.println("Number of class files: " + projectContent.getNumberOfClassFiles());
        System.out.println("Number of xml files: " + projectContent.getNumberOfXmlFiles());
        System.out.println("Number of classes: " + projectContent.getNumberOfClasses());
        System.out.println("Number of interfaces: " + projectContent.getNumberOfInterfaces());
        System.out.println("Number of enums: " + projectContent.getNumberOfEnums());
    }


}
