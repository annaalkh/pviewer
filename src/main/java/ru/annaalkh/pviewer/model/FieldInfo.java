package ru.annaalkh.pviewer.model;

import ru.annaalkh.pviewer.AccessLevel;

import java.lang.reflect.Field;
import java.lang.reflect.Member;

/**
 * Created by Anna on 3/26/15.
 */
public class FieldInfo implements ClassContentItem {

    private String name;
    private Field field;
    private AccessLevel accessLevel;

    @Override
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    @Override
    public Member getCompiledItem() {
        return field;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
}
