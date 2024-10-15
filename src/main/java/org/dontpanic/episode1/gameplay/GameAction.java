package org.dontpanic.episode1.gameplay;

public enum GameAction {
    WAIT("WAIT"),
    BLOCK("BLOCK");

    public String value;

    GameAction(String value) {
        this.value = value;
    }
}
