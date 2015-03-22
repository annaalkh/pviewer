package ru.annaalkh.pviewer.model;

import org.apache.commons.io.FilenameUtils;
import ru.annaalkh.pviewer.ClassType;
import ru.annaalkh.pviewer.Util;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Anna on 3/19/15.
 */
public class ClassInfo implements ProjectItem {

    private String name;
    private String packageName;
    private FileInfo sourceFile;
    private FileInfo compiledFile;
    private Class compiledClass;
    private ClassType classType = ClassType.UNDEFINED;



    public void setCompiledFile(FileInfo compiledFile) {
        this.compiledFile = compiledFile;
        reinitCompiledClass();
    }

    private void reinitCompiledClass() {
        if (compiledClass == null) {
            compiledClass = null;
            classType = ClassType.UNDEFINED;
        }
        try {
            String pathWithoutPackage = getPathWithoutPackage();
            URL url = new File(pathWithoutPackage).toURI().toURL();
            URL[] urls = new URL[]{url};
            ClassLoader loader = new URLClassLoader(urls);
            Class loadedClass = loader.loadClass(packageName + "." + name);
            compiledClass = loadedClass;
            reinitClassType();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reinitClassType() {
        if (compiledClass.isInterface()) {
            classType = ClassType.INTERFACE;
        } else if (compiledClass.isEnum()) {
            classType = ClassType.ENUM;
        }  else {
            classType = ClassType.CLASS;
        }
    }

    private String getPathWithoutPackage() {
        String path = FilenameUtils.getFullPath(compiledFile.getFile().getAbsolutePath());
        String packagePath = Util.getPathFromPackage(packageName);
        String result = path.replace(packagePath, "");
        return result;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public FileInfo getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(FileInfo sourceFile) {
        this.sourceFile = sourceFile;
    }

    public FileInfo getCompiledFile() {
        return compiledFile;
    }



    public Class getCompiledClass() {
        return compiledClass;
    }

    public void setCompiledClass(Class compiledClass) {
        this.compiledClass = compiledClass;
    }

    public boolean isClass() {
        return typeIs(ClassType.CLASS);
    }

    public boolean isInterface() {
        return typeIs(ClassType.INTERFACE);
    }

    public boolean isEnum() {
        return typeIs(ClassType.ENUM);
    }

    private boolean typeIs(ClassType classType) {
        return this.classType == classType;
    }
}
