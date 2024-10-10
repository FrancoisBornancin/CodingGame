package org.blunder.episode1.golfcode;

public enum Direction {
    FAKE("FAKE"),
    NORTH("NORTH"),
    SOUTH("SOUTH"),
    EAST("EAST"),
    WEST("WEST");

    String value;

    Direction(String value) {
        this.value = value;
    }
}
