package ru.annaalkh.pviewer.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.annaalkh.pviewer.analyzer.ProjectContent;
import ru.annaalkh.pviewer.web.dto.ProjectItemDto;
import ru.annaalkh.pviewer.web.dto.ProjectItemInfoSourceDto;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Anna on 4/4/15.
 */
@RestController
public class ProjectItemInfoInfoController {

    @RequestMapping("/projects/item_info.json")
    public ProjectItemInfoSourceDto getItemInfo(@RequestParam(value = "id", required = true) String itemId,
                                                      HttpSession session) {
        ProjectContent projectContent = (ProjectContent) session.getAttribute("projectContent");
        return findItemById(itemId);
    }

    private ProjectItemInfoSourceDto findItemById(String id) {
        ProjectItemInfoSourceDto dto = new ProjectItemInfoSourceDto();
        dto.setTitle("Source.java");
        dto.setNumberOfConstructors(2);
        dto.setNumberOfFields(14);
        return dto;
    }
}
