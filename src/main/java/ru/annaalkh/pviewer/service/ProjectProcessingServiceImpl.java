package ru.annaalkh.pviewer.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.annaalkh.pviewer.analyzer.ProjectContent;
import ru.annaalkh.pviewer.analyzer.ProjectContentAnalyzer;
import ru.annaalkh.pviewer.model.FileInfo;
import ru.annaalkh.pviewer.model.Project;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 3/22/15.
 */
@Service
public class ProjectProcessingServiceImpl implements ProjectProcessingService {

    @Autowired
    private ProjectContentAnalyzer projectContentAnalyzer;

    @Override
    public ProjectContent getProjectContent(@Nonnull String projectPath) {
        Project currentProject = new Project();

        String projectName = FilenameUtils.getBaseName(FilenameUtils.normalizeNoEndSeparator(projectPath));
        currentProject.setName(projectName);

        File selectedDirectory = new File(projectPath);

        if (!selectedDirectory.exists()) {
            throw new IllegalArgumentException("Path should exist!");
        }

        List<File> filesFromDirectory = getFilesFromDirectory(selectedDirectory);
        filesFromDirectory.forEach(
                file -> {
                    FileInfo currentFileInfo = FileInfo.createFromFile(file);
                    currentProject.addFile(currentFileInfo);
                }
        );
        currentProject.boundClasses();

        ProjectContent projectContent = projectContentAnalyzer.analyse(currentProject);

        return projectContent;
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
}
