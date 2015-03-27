package ru.annaalkh.pviewer.analyzer;

import org.springframework.stereotype.Component;
import ru.annaalkh.pviewer.AccessLevel;
import ru.annaalkh.pviewer.model.*;

import java.util.List;

/**
 * Created by Anna on 3/21/15.
 */
@Component
public class ClassContentAnalyzer implements Analyzer {

    @Override
    public AnalysisResult analyse(ProjectItem projectItem) {
        ClassInfo classInfo = (ClassInfo) projectItem;

        ClassContent classContent = new ClassContent();
        classContent.setName(classInfo.getName());
        classContent.setClassType(classInfo.getClassType());

        List<FieldInfo> fieldInfos = classInfo.getFields();
        AccessLevelNumberInfo fieldsNumberInfo = getNumbersInfo(fieldInfos);

        classContent.setNumberOfFields(fieldsNumberInfo.totalNumber);
        classContent.setNumberOfPublicFields(fieldsNumberInfo.numberOfPublic);
        classContent.setNumberOfProtectedFields(fieldsNumberInfo.numberOfProtected);
        classContent.setNumberOfPrivateFields(fieldsNumberInfo.numberOfPrivate);

        List<ConstructorInfo> constructorInfos = classInfo.getConstructors();
        AccessLevelNumberInfo constructorsNumberInfo = getNumbersInfo(constructorInfos);

        classContent.setNumberOfConstructors(constructorsNumberInfo.totalNumber);
        classContent.setNumberOfPublicConstructors(constructorsNumberInfo.numberOfPublic);
        classContent.setNumberOfProtectedConstructors(constructorsNumberInfo.numberOfProtected);
        classContent.setNumberOfPrivateConstructors(constructorsNumberInfo.numberOfPrivate);

        List<MethodInfo> methodInfos = classInfo.getMethods();
        AccessLevelNumberInfo methodsNumberInfo = getNumbersInfo(methodInfos);

        classContent.setNumberOfMethods(methodsNumberInfo.totalNumber);
        classContent.setNumberOfPublicMethods(methodsNumberInfo.numberOfPublic);
        classContent.setNumberOfProtectedMethods(methodsNumberInfo.numberOfProtected);
        classContent.setNumberOfPrivateMethods(methodsNumberInfo.numberOfPrivate);

        return classContent;
    }

    private AccessLevelNumberInfo getNumbersInfo(List<? extends ClassContentItem> contentItems) {
        AccessLevelNumberInfo numberInfo = new AccessLevelNumberInfo();
        numberInfo.totalNumber = contentItems.size();

        for (ClassContentItem item: contentItems) {
            switch (item.getAccessLevel()) {
                case PUBLIC:
                    numberInfo.numberOfPublic++;
                    break;
                case PROTECTED:
                    numberInfo.numberOfProtected++;
                    break;
                case PRIVATE:
                    numberInfo.numberOfPrivate++;
                    break;
            }
        };

        return numberInfo;
    }

    private static class AccessLevelNumberInfo {
        int totalNumber = 0;

        int numberOfPublic = 0;
        int numberOfProtected = 0;
        int numberOfPrivate = 0;
    }
}
