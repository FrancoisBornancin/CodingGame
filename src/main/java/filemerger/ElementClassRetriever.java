package filemerger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ElementClassRetriever {
    private static String PUBLIC_CLASS = "public class";
    private static String CLASS = "class";
    private static String PUBLIC_INTERFACE = "public interface";
    private static String INTERFACE = "interface";
    private static String PUBLIC_ABSTRACT_CLASS = "public abstract class";
    private static String ABSTRACT_CLASS = "abstract class";
    private static String PUBLIC_ENUM_CLASS = "public enum";
    private static String ENUM_CLASS = "enum";

    public Set<String> importList;
    public List<String> otherList;

    private Map<String, String> elementsToReplacesMap =
            Map.of(
                PUBLIC_CLASS, CLASS,
                PUBLIC_INTERFACE, INTERFACE,
                PUBLIC_ABSTRACT_CLASS, ABSTRACT_CLASS,
                PUBLIC_ENUM_CLASS, ENUM_CLASS
            );

    private void scanDirectory(File file){
        File[] listFiles = file.listFiles();
        if(listFiles != null){
            Arrays.stream(listFiles).toList()
                    .forEach(fileOrDir -> {
                        if(fileOrDir.isDirectory()) scanDirectory(fileOrDir);
                        else fillLists(fileOrDir);
                    });
        }
    }

    private void fillLists(File file){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String line : lines) {
            if(line.contains(PUBLIC_CLASS)) rewrite(PUBLIC_CLASS, line);
            else if(line.contains(PUBLIC_ABSTRACT_CLASS)) rewrite(PUBLIC_ABSTRACT_CLASS, line);
            else if(line.contains(PUBLIC_INTERFACE)) rewrite(PUBLIC_INTERFACE, line);
            else if(line.contains(PUBLIC_ENUM_CLASS)) rewrite(PUBLIC_ENUM_CLASS, line);
            else{
                if(!line.contains("package")){
                    if(line.contains("import")){
                        if(!line.contains(" org")) importList.add(line);
                    }
                    else otherList.add(line);
                }
            }
        }
    }

    public List<Collection<String>> retrieveElements(String inputDir) {
        importList = new HashSet<>();
        otherList = new ArrayList<>();

        File dir = new File(inputDir);
        scanDirectory(dir);

        return List.of(importList, otherList);
    }

    private void rewrite(String elementToRewrite, String lineToRewrite){
        otherList.add(
                lineToRewrite.replace(elementToRewrite, elementsToReplacesMap.get(elementToRewrite))
        );
    }
}
