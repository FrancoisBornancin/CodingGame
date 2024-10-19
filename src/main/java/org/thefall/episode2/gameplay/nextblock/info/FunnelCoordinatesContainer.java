package org.thefall.episode2.gameplay.nextblock.info;

import org.thefall.episode2.gameplay.GameResponse;

import java.util.List;

public class FunnelCoordinatesContainer {
    public List<GameResponse> funnelCoordinates;
    public GameResponse getGameResponse(){
        GameResponse gameResponse = funnelCoordinates.get(0);
        funnelCoordinates.remove(0);
        return gameResponse;
    }
}
