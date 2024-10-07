package filemerger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileMerger {
    public void mergeFiles(String inputDir, String outputFile) {
        File dir = new File(inputDir);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("The directory does not exist or is not a directory.");
            return;
        }

        File[] files = dir.listFiles((d, name) -> name.endsWith(".java"));

        if (files == null || files.length == 0) {
            System.out.println("No files to merge in the directory.");
            return;
        }

        List<String> importLists = new ArrayList<>();
        List<String> otherLists = new ArrayList<>();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (File file : files) {
                List<String> lines = Files.readAllLines(file.toPath());
                for (String line : lines) {
                    if(line.contains("public class")){
                        line = line.replace("public class", "class");
                        otherLists.add(line);
                    }else{
                        if(!line.contains("package")){
                            if(line.contains("import")) importLists.add(line);
                            else otherLists.add(line);
                        }
                    }
                }
            }

            importLists.forEach(element -> {
                try {
                    writer.write(element);
                    writer.newLine();
//                    writer.write("\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            otherLists.forEach(element -> {
                try {
                    writer.write(element);
                    writer.newLine();
//                    writer.write("\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            System.out.println("All files merged into " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
