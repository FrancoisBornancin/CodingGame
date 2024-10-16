package org.thefall.episode1.logging.errors;

public class ElementOutOfMapWidth extends RuntimeException{
    public ElementOutOfMapWidth(int heroCordWidth, int mapWidth) {
        super("heroCordWidth: " + heroCordWidth + " - mapWidth: " + mapWidth);
    }

    public ElementOutOfMapWidth(int heroCordWidth) {
        super("heroCordWidth: " + heroCordWidth);
    }
}
