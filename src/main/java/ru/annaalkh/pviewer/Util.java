package ru.annaalkh.pviewer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Anna on 3/20/15.
 */
public class Util {

    public static String getFilenameWithoutExtention(File file) {
        return FilenameUtils.removeExtension(file.getName());
    }

    public static String getExtention(File file) {
        return FilenameUtils.getExtension(file.getName());
    }

    public static String getPackage(File file) {
        try {
            List<String> lines = FileUtils.readLines(file);
            for (String line:lines) {
                if (line.startsWith("package")) {
                    return getPackageNameFromLine(line);
                }
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getPackageNameFromLine(String line) {
        String[] splittedLine = line.split(" ");
        String result = splittedLine[splittedLine.length-1].replace(";", "");
        return result;
    }

    public static String getPathFromPackage(String packageName) {
        return packageName.replace(".", "\\").concat("\\");
    }


}
