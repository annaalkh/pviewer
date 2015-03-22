package ru.annaalkh.pviewer.model;

import ru.annaalkh.pviewer.FileType;
import ru.annaalkh.pviewer.FileTypeIdentifier;
import ru.annaalkh.pviewer.Util;

import java.io.File;

/**
 * Created by Anna on 3/19/15.
 */
public class FileInfo implements ProjectItem {

    private File file;
    private String name;
    private String nameWithoutExtention;
    private FileType type;


    public static FileInfo createFromFile(File file) {
        FileInfo info = new FileInfo();
        info.file = file;
        info.name = file.getName();
        info.nameWithoutExtention = Util.getFilenameWithoutExtention(file);
        info.type = FileTypeIdentifier.identifyType(file);
        return info;
    }



    public String getName() {
        return name;
    }

    public String getNameWithoutExtention() {
        return nameWithoutExtention;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public FileType getType() {
        return type;
    }
}
