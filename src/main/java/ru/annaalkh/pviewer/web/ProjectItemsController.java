package ru.annaalkh.pviewer.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import ru.annaalkh.pviewer.analyzer.ProjectContent;
import ru.annaalkh.pviewer.web.dto.ProjectItemDto;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Anna on 5/11/15.
 */
@RestController
public class ProjectItemsController {

    @RequestMapping("/projects/classes.json")
    public List<ProjectItemDto> getClasses(HttpSession session) {
        ProjectContent projectContent = (ProjectContent) session.getAttribute("projectContent");
        List<ProjectItemDto> classesDtos = projectContent.getClasses()
                .stream()
                .map(projectClass -> {
                    ProjectItemDto itemDto = new ProjectItemDto();
                    itemDto.setId(1);
                    itemDto.setTitle(projectClass.getName());
                    return itemDto;
                })
                .collect(Collectors.toList());
        return classesDtos;
    }

}
