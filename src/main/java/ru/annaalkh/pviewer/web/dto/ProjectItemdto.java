package ru.annaalkh.pviewer.web.dto;

/**
 * Created by Anna on 5/11/15.
 */
public class ProjectItemDto {

    private int id;
    private String type;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
