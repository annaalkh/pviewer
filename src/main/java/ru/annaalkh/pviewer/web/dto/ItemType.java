package ru.annaalkh.pviewer.web.dto;

/**
 * Created by Anna on 5/11/15.
 */
public enum ItemType {
    SOURCE_FILE(BaseType.FILE),
    CLASS_FILE(BaseType.FILE),
    XML_FILE(BaseType.FILE),
    JAVA_CLASS(BaseType.JAVA_ITEM),
    JAVA_INTERFACE(BaseType.JAVA_ITEM),
    JAVA_ENUM(BaseType.JAVA_ITEM);

    private BaseType baseType;

    ItemType(BaseType baseType) {
        this.baseType = baseType;
    }

    public BaseType getBaseType() {
        return baseType;
    }
}

enum BaseType {
     FILE, JAVA_ITEM
}
