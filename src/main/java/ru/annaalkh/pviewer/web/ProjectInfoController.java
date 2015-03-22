package ru.annaalkh.pviewer.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.annaalkh.pviewer.analyzer.ProjectContent;
import ru.annaalkh.pviewer.service.ProjectProcessingService;

/**
 * Created by Anna on 3/22/15.
 */
@RestController
public class ProjectInfoController {

    @Autowired
    private ProjectProcessingService projectProcessingService;

    @RequestMapping("/projects/projectInfo.json")
    public ProjectContent getProjectContent(@RequestParam(value = "projectPath", required = false) String projectPath) {
        if (StringUtils.isEmpty(projectPath)) {
            return new ProjectContent();
        }

        return projectProcessingService.getProjectContent(projectPath);
    }



}
