import filemerger.FileMerger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileMergerTest {
    @Test
    void doStuff() throws IOException {
        String outputFile = "src/main/java/filemerger/mergedFile.txt";
        String inputDir = "src/main/java/org/dontpanic/episode1";
        new FileMerger()
                .mergeFiles(inputDir, outputFile);
        Assertions.assertTrue(
                (int) Files
                        .lines(
                                new File(outputFile).toPath()
                        )
                        .count() > 0
        );
    }
}
