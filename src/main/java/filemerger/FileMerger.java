package filemerger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class FileMerger {
    public void mergeFiles(String dirToScan, String outputFile){
        ElementClassRetriever elementClassRetriever = new ElementClassRetriever();
        elementClassRetriever.retrieveElements(dirToScan);

        List<Collection<String>> allList =
                List.of(
                        elementClassRetriever.importList,
                        elementClassRetriever.otherList
                );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            allList.forEach(list -> {
                list.forEach(element -> {
                    try {
                        writer.write(element);
                        writer.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
