package ru.annaalkh.pviewer.analyzer;

import org.springframework.stereotype.Component;
import ru.annaalkh.pviewer.model.ClassInfo;
import ru.annaalkh.pviewer.model.MethodInfo;
import ru.annaalkh.pviewer.model.ProjectItem;

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
        classContent.setClassType(classInfo.getClassType().name());

        List<MethodInfo> methodInfos = classInfo.getMethods();

        int numberOfPublicMethods = 0;
        int numberOfProtectedMethods = 0;
        int numberOfPrivateMethods = 0;

        for (MethodInfo methodInfo: methodInfos) {
            switch (methodInfo.getAccessLevel()) {
                case PUBLIC:
                    numberOfPublicMethods++;
                    break;
                case PROTECTED:
                    numberOfProtectedMethods++;
                    break;
                case PRIVATE:
                    numberOfPrivateMethods++;
                    break;
            }
        };

        classContent.setNumberOfPublicMethods(numberOfPublicMethods);
        classContent.setNumberOfProtectedMethods(numberOfProtectedMethods);
        classContent.setNumberOfPrivateMethods(numberOfPrivateMethods);

        classContent.setNumberOfMethods(methodInfos.size());

        return classContent;
    }
}
