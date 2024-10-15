package org.dontpanic.episode1.gameplay.elements;

public enum GameElements {
    LEADING_CLONE('C'),
    SOLDIER_CLONE('c'),
    WHITE_SPACE('_'),
    STARTING_DOOR('S'),
    BLOCKED_CLONE('B'),
    FINISH_DOOR('F'),
    CLONE_ON_ELEVATOR('X'),
    ELEVATOR('E');

    public char value;

    GameElements(char value) {
        this.value = value;
    }
}
