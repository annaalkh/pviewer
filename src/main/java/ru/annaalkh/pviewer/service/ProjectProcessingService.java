package ru.annaalkh.pviewer.service;

import ru.annaalkh.pviewer.analyzer.ProjectContent;

import javax.annotation.Nonnull;

/**
 * Created by Anna on 3/22/15.
 */
public interface ProjectProcessingService {

    public ProjectContent getProjectContent(@Nonnull String projectPath);
}
