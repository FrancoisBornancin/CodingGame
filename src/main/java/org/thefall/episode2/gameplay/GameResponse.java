package org.thefall.episode2.gameplay;

import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;

public class GameResponse {
    public Coordinates coordinates;
    public GameDirection gameDirection;

    public GameResponse(Coordinates coordinates, GameDirection gameDirection) {
        this.coordinates = coordinates;
        this.gameDirection = gameDirection;
    }
}
