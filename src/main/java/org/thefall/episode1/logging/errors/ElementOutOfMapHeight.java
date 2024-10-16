package org.thefall.episode1.logging.errors;

public class ElementOutOfMapHeight extends RuntimeException{
    public ElementOutOfMapHeight(int heroCordHeight, int mapHeight) {
        super("heroCordHeight: " + heroCordHeight + " - mapHeight: " + mapHeight);
    }

    public ElementOutOfMapHeight(int heroCordHeight) {
        super("heroCordHeight: " + heroCordHeight);
    }
}
