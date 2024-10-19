package org.thefall.episode1.gameplay.nextblock.builder;

import org.thefall.episode1.gameplay.Game;
import org.thefall.episode1.gameplay.elements.tunnel.TunnelElement;
import org.thefall.episode1.gameplay.elements.tunnel.TunnelMapElementRetriever;
import org.thefall.episode1.gameplay.nextblock.Coordinates;
import org.thefall.episode1.gameplay.nextblock.GameDirection;

import java.util.Map;
import java.util.Set;

public class NextBlockMapBuilder{
    TunnelMapElementRetriever tunnelMapElementRetriever;
    public NextBlockMapBuilder(TunnelMapElementRetriever tunnelMapElementRetriever){
        this.tunnelMapElementRetriever = tunnelMapElementRetriever;
    }

    public Map<TunnelElement, Map<GameDirection, Map<TunnelElement, Coordinates>>> buildMap(){
               return Map.ofEntries(
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("1"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        Map.of(),
                                        GameDirection.RIGHT,
                                        Map.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("2"),
                                Map.of(
                                        GameDirection.DOWN,
                                        Map.of(),
                                        GameDirection.LEFT,
                                        getLeftPossibilities(),
                                        GameDirection.RIGHT,
                                        getRightPossibilities()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("3"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        Map.of(),
                                        GameDirection.RIGHT,
                                        Map.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("4"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        getLeftPossibilities(),
                                        GameDirection.RIGHT,
                                        Map.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("5"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        Map.of(),
                                        GameDirection.RIGHT,
                                        getRightPossibilities()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("6"),
                                Map.of(
                                        GameDirection.DOWN,
                                        Map.of(),
                                        GameDirection.LEFT,
                                        getLeftPossibilities(),
                                        GameDirection.RIGHT,
                                        getRightPossibilities()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("7"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        Map.of(),
                                        GameDirection.RIGHT,
                                        Map.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("8"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        Map.of(),
                                        GameDirection.RIGHT,
                                        Map.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("9"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        Map.of(),
                                        GameDirection.RIGHT,
                                        Map.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("10"),
                                Map.of(
                                        GameDirection.DOWN,
                                        Map.of(),
                                        GameDirection.LEFT,
                                        getLeftPossibilities(),
                                        GameDirection.RIGHT,
                                        Map.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("11"),
                                Map.of(
                                        GameDirection.DOWN,
                                        Map.of(),
                                        GameDirection.LEFT,
                                        Map.of(),
                                        GameDirection.RIGHT,
                                        getRightPossibilities()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("12"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        Map.of(),
                                        GameDirection.RIGHT,
                                        Map.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("13"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        Map.of(),
                                        GameDirection.RIGHT,
                                        Map.of()
                                )
                        )
                );
    }

    private Map<TunnelElement, Coordinates> getDownPossibilities(){
        return Map.of(
            tunnelMapElementRetriever.getByStringValue("1"), downCoordinates(GameDirection.DOWN, "1"),
            tunnelMapElementRetriever.getByStringValue("3"), downCoordinates(GameDirection.DOWN, "3"),
            tunnelMapElementRetriever.getByStringValue("4"), downCoordinates(GameDirection.LEFT, "4"),
            tunnelMapElementRetriever.getByStringValue("5"), downCoordinates(GameDirection.RIGHT, "5"),
            tunnelMapElementRetriever.getByStringValue("7"), downCoordinates(GameDirection.DOWN, "7"),
            tunnelMapElementRetriever.getByStringValue("9"), downCoordinates(GameDirection.DOWN, "9"),
            tunnelMapElementRetriever.getByStringValue("10"), downCoordinates(GameDirection.LEFT, "10"),
            tunnelMapElementRetriever.getByStringValue("11"), downCoordinates(GameDirection.RIGHT, "11")
        );
    }


    private Map<TunnelElement, Coordinates> getLeftPossibilities(){
        return Map.of(
            tunnelMapElementRetriever.getByStringValue("1"), leftCoordinates(GameDirection.DOWN, "1"),
            tunnelMapElementRetriever.getByStringValue("2"), leftCoordinates(GameDirection.LEFT, "2"),
            tunnelMapElementRetriever.getByStringValue("4"), leftCoordinates(GameDirection.DOWN, "4"),
            tunnelMapElementRetriever.getByStringValue("6"), leftCoordinates(GameDirection.LEFT, "6"),
            tunnelMapElementRetriever.getByStringValue("7"), leftCoordinates(GameDirection.DOWN, "7"),
            tunnelMapElementRetriever.getByStringValue("8"), leftCoordinates(GameDirection.DOWN, "8"),
            tunnelMapElementRetriever.getByStringValue("12"), leftCoordinates(GameDirection.DOWN, "12")
        );
    }

    private Map<TunnelElement, Coordinates> getRightPossibilities(){
        return Map.of(
                tunnelMapElementRetriever.getByStringValue("1"), rightCoordinates(GameDirection.DOWN, "1"),
                tunnelMapElementRetriever.getByStringValue("2"), rightCoordinates(GameDirection.RIGHT, "2"),
                tunnelMapElementRetriever.getByStringValue("5"), rightCoordinates(GameDirection.DOWN, "5"),
                tunnelMapElementRetriever.getByStringValue("6"), rightCoordinates(GameDirection.RIGHT, "6"),
                tunnelMapElementRetriever.getByStringValue("8"), rightCoordinates(GameDirection.DOWN, "8"),
                tunnelMapElementRetriever.getByStringValue("9"), rightCoordinates(GameDirection.DOWN, "9"),
                tunnelMapElementRetriever.getByStringValue("13"), rightCoordinates(GameDirection.DOWN, "13")
        );
    }

    private Coordinates downCoordinates(GameDirection gameDirection, String value){
        return new Coordinates(0,1, gameDirection, value);
    }

    private Coordinates leftCoordinates(GameDirection gameDirection, String value){
        return new Coordinates(-1,0, gameDirection, value);
    }

    private Coordinates rightCoordinates(GameDirection gameDirection, String value){
        return new Coordinates(1,0, gameDirection, value);
    }
}
