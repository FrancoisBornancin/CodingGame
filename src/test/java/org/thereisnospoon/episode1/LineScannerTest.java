package org.thereisnospoon.episode1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineScannerTest {
    @Test
    void itShouldHaveANodeTestCase1(){
        LineScanner lineScanner = new LineScanner();

        String elementToScan = "0.0.0";
        int index = 0;
        int heightIndex = 0;

        Assertions.assertEquals(
                "2 0",
                lineScanner.getRightNodeAsString(elementToScan, index, heightIndex)
        );
    }

    @Test
    void itShouldHaveANodeTestCase2(){
        LineScanner lineScanner = new LineScanner();

        String elementToScan = "0.0.0";
        int index = 2;
        int heightIndex = 0;

        Assertions.assertEquals(
                "4 0",
                lineScanner.getRightNodeAsString(elementToScan, index, heightIndex)
        );
    }

    @Test
    void itShouldNotHaveANodeTestCase1(){
        LineScanner lineScanner = new LineScanner();

        String elementToScan = "0....";
        int index = 0;
        int heightIndex = 0;

        Assertions.assertEquals(
                "-1 -1",
                lineScanner.getRightNodeAsString(elementToScan, index, heightIndex)
        );
    }

    @Test
    void itShouldNotHaveANodeTestCase2(){
        LineScanner lineScanner = new LineScanner();

        String elementToScan = "0....";
        int index = 2;
        int heightIndex = 0;

        Assertions.assertEquals(
                "-1 -1",
                lineScanner.getRightNodeAsString(elementToScan, index, heightIndex)
        );
    }
}
