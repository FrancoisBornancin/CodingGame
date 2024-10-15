package org.dontpanic.episode1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestToDelete {
    @Test
    void doStuff(){
        Map<Integer, List<Integer>> testMap =
        Map.of(
                8, List.of(8, 9, 10),
                2, List.of(1, 2, 3),
                4, List.of(4, 5, 6)
        );

        testMap.keySet().stream()
                .sorted()
                .forEach(key -> {
                    System.out.println("key: " + key + " -> values: " + testMap.get(key));
                });

        System.out.println();
    }
}
