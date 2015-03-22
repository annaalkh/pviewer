package ru.annaalkh.pviewer;

/**
 * Created by Anna on 3/19/15.
 */
public enum FileType {
    JAVA_SOURCE("java"),
    XML("xml"),
    CLASS("class"),
    OTHER("");

    private String extention;

    FileType(String extention) {
        this.extention = extention;
    }

    public String getExtention() {
        return extention;
    }
}
