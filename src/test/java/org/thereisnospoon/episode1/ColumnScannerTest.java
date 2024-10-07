package org.thereisnospoon.episode1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ColumnScannerTest {
    @Test
    void itShouldNotHaveANodeTestCase1(){
        ColumnScanner columnScanner = new ColumnScanner();

        Assertions.assertEquals(
                "-1 -1",
                columnScanner.getUnderNodeAsString(
                        List.of(
                                "00"
                        ),
                        2, 1
                )
        );
    }

    @Test
    void itShouldNotHaveANodeTestCase2(){
        ColumnScanner columnScanner = new ColumnScanner();

        Assertions.assertEquals(
                "-1 -1",
                columnScanner.getUnderNodeAsString(
                        List.of(
                                "00",
                                "..",
                                ".."
                        ),
                        2, 1
                )
        );
    }

    @Test
    void itShouldNotHaveANodeTestCase3(){
        ColumnScanner columnScanner = new ColumnScanner();

        Assertions.assertEquals(
                "-1 -1",
                columnScanner.getUnderNodeAsString(
                        List.of(
                                "00",
                                "..",
                                "..",
                                "00"
                        ),
                        2, 2
                )
        );
    }

    @Test
    void itShouldHaveANodeTestCase1(){
        ColumnScanner columnScanner = new ColumnScanner();

        Assertions.assertEquals(
                "-1 -1",
                columnScanner.getUnderNodeAsString(
                        List.of(
                                "00",
                                "..",
                                "..",
                                "00"
                        ),
                        2, 1
                )
        );
    }

    @Test
    void itShouldHaveANodeTestCase2(){
        ColumnScanner columnScanner = new ColumnScanner();

        Assertions.assertEquals(
                "-1 -1",
                columnScanner.getUnderNodeAsString(
                        List.of(
                                "00",
                                "..",
                                "..",
                                "00",
                                "..",
                                "00"
                        ),
                        2, 3
                )
        );
    }
}
