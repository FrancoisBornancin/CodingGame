package org.dontpanic.episode1.logging;

import java.util.Map;

public class MapPrinter <T, V> {
    public void printMap(Map<T, V> randomMap){
        randomMap.keySet().stream()
                .sorted()
                .forEach(key -> {
                    System.err.println("    key: " + key + " -> values: " + randomMap.get(key));
                });
    }
}
