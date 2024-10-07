import filemerger.FileMerger;
import org.junit.jupiter.api.Test;

public class FileMergerTest {
    @Test
    void doStuff(){
        FileMerger fileMerger = new FileMerger();

        String inputDir = "src/main/java/org/shadowoftheknight/episode1";
        String outputFile = "src/main/java/filemerger/mergedFile.txt";

        fileMerger.mergeFiles(inputDir, outputFile);
    }
}
