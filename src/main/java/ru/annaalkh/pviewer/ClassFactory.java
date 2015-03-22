package ru.annaalkh.pviewer;

import ru.annaalkh.pviewer.model.ClassInfo;
import ru.annaalkh.pviewer.model.FileInfo;

import java.io.File;

/**
 * Created by Anna on 3/19/15.
 */
public class ClassFactory {

    public static ClassInfo getClassInfo(FileInfo sourceFileInfo) {
        assert sourceFileInfo.getType() == FileType.JAVA_SOURCE;

        ClassInfo classInfo = new ClassInfo();
        classInfo.setName(sourceFileInfo.getNameWithoutExtention());
        String packageName = Util.getPackage(sourceFileInfo.getFile());
        classInfo.setPackageName(packageName);
        classInfo.setSourceFile(sourceFileInfo);

        return classInfo;
    }


}
