package ru.annaalkh.pviewer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.annaalkh.pviewer.analyzer.ProjectContent;
import ru.annaalkh.pviewer.analyzer.ProjectContentAnalyzer;
import ru.annaalkh.pviewer.model.FileInfo;
import ru.annaalkh.pviewer.model.Project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 3/22/15.
 */
@Controller
public class MainPageController {

    @RequestMapping("/index.html")
    public String getMainPage() {
        return "pages/project_info.html";
    }


}
