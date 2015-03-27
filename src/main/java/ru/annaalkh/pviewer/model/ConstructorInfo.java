package ru.annaalkh.pviewer.model;

import ru.annaalkh.pviewer.AccessLevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;

/**
 * Created by Anna on 3/27/15.
 */
public class ConstructorInfo implements ClassContentItem {

    private Constructor constructor;
    private AccessLevel accessLevel;

    @Override
    public Member getCompiledItem() {
        return constructor;
    }

    @Override
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
}
