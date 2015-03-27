package ru.annaalkh.pviewer.model;

import ru.annaalkh.pviewer.AccessLevel;

import java.lang.reflect.Member;

/**
 * Created by Anna on 3/27/15.
 */
public interface ClassContentItem {

    AccessLevel getAccessLevel();
    Member getCompiledItem();
}
