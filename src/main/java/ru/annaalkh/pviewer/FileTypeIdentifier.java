package ru.annaalkh.pviewer;

import java.io.File;

/**
 * Created by Anna on 3/19/15.
 */
public class FileTypeIdentifier {

    public static FileType identifyType(File file) {
        String extention = Util.getExtention(file);

        if (extention.equals(FileType.JAVA_SOURCE.getExtention())) {
            return FileType.JAVA_SOURCE;
        } else if (extention.equals(FileType.XML.getExtention())) {
            return FileType.XML;
        } else if (extention.equals(FileType.CLASS.getExtention())) {
            return FileType.CLASS;
        }
        return FileType.OTHER;
    }
}
