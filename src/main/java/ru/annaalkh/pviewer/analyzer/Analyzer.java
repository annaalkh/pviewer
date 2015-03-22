package ru.annaalkh.pviewer.analyzer;

import ru.annaalkh.pviewer.model.ProjectItem;

/**
 * Created by Anna on 3/21/15.
 */
public interface Analyzer {

    AnalysisResult analyse(ProjectItem projectItem);
}
