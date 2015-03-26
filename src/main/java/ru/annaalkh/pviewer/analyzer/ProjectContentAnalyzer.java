package ru.annaalkh.pviewer.analyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.annaalkh.pviewer.ClassType;
import ru.annaalkh.pviewer.FileType;
import ru.annaalkh.pviewer.model.ClassInfo;
import ru.annaalkh.pviewer.model.FileInfo;
import ru.annaalkh.pviewer.model.Project;
import ru.annaalkh.pviewer.model.ProjectItem;

import java.util.List;

/**
 * Created by Anna on 3/21/15.
 */
@Component
public class ProjectContentAnalyzer implements Analyzer {

    @Autowired
    ClassContentAnalyzer classContentAnalyzer;

    @Override
    public ProjectContent analyse(ProjectItem projectItem) {
        Project project = (Project) projectItem;

        ProjectContent projectContent = new ProjectContent();

        List<FileInfo> files = project.getFilesInfoView();
        List<ClassInfo> classes = project.getClassesView();

        projectContent.setProjectName(project.getName());
        projectContent.setTotalNumberOfFiles(files.size());
        projectContent.setNumberOfSourceFiles(countFilesOfType(files, FileType.JAVA_SOURCE));
        projectContent.setNumberOfClassFiles(countFilesOfType(files, FileType.CLASS));
        projectContent.setNumberOfXmlFiles(countFilesOfType(files, FileType.XML));

        int numberOfClasses = 0;
        int numberOfInterfaces = 0;
        int numberOfEnums = 0;

        for (ClassInfo classInfo: classes) {
            if (classInfo.isClass()) numberOfClasses++;
            else if (classInfo.isInterface()) numberOfInterfaces++;
            else if (classInfo.isEnum()) numberOfEnums++;

            ClassContent classContent = (ClassContent) classContentAnalyzer.analyse(classInfo);
            projectContent.getClasses().add(classContent);
        }

        projectContent.setNumberOfClasses(numberOfClasses);
        projectContent.setNumberOfInterfaces(numberOfInterfaces);
        projectContent.setNumberOfEnums(numberOfEnums);

        return projectContent;
    }

    private int countFilesOfType(List<FileInfo> files, FileType type) {
        return (int) files
                .stream()
                .filter(file -> file.getType() == type)
                .count();
    }
}
