package ru.annaalkh.pviewer.model;

import ru.annaalkh.pviewer.AccessLevel;

import java.lang.reflect.Method;

/**
 * Created by Anna on 3/26/15.
 */
public class MethodInfo {

    private String name;
    private Method method;
    private AccessLevel accessLevel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
}
