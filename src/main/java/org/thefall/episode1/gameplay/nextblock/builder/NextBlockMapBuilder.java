package org.thefall.episode1.gameplay.nextblock.builder;

import org.thefall.episode1.gameplay.elements.tunnel.TunnelElement;
import org.thefall.episode1.gameplay.elements.tunnel.TunnelMapElementRetriever;
import org.thefall.episode1.gameplay.nextblock.GameDirection;

import java.util.Map;
import java.util.Set;

public class NextBlockMapBuilder{
    TunnelMapElementRetriever tunnelMapElementRetriever;
    public NextBlockMapBuilder(TunnelMapElementRetriever tunnelMapElementRetriever){
        this.tunnelMapElementRetriever = tunnelMapElementRetriever;
    }

    public Map<TunnelElement, Map<GameDirection, Set<TunnelElement>>> buildMap(){
               return Map.ofEntries(
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("1"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        Set.of(),
                                        GameDirection.RIGHT,
                                        Set.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("2"),
                                Map.of(
                                        GameDirection.DOWN,
                                        Set.of(),
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
                                        Set.of(),
                                        GameDirection.RIGHT,
                                        Set.of()
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
                                        Set.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("5"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        Set.of(),
                                        GameDirection.RIGHT,
                                        getRightPossibilities()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("6"),
                                Map.of(
                                        GameDirection.DOWN,
                                        Set.of(),
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
                                        Set.of(),
                                        GameDirection.RIGHT,
                                        Set.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("8"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        Set.of(),
                                        GameDirection.RIGHT,
                                        Set.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("9"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        Set.of(),
                                        GameDirection.RIGHT,
                                        Set.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("10"),
                                Map.of(
                                        GameDirection.DOWN,
                                        Set.of(),
                                        GameDirection.LEFT,
                                        getLeftPossibilities(),
                                        GameDirection.RIGHT,
                                        Set.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("11"),
                                Map.of(
                                        GameDirection.DOWN,
                                        Set.of(),
                                        GameDirection.LEFT,
                                        Set.of(),
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
                                        Set.of(),
                                        GameDirection.RIGHT,
                                        Set.of()
                                )
                        ),
                        Map.entry(
                                tunnelMapElementRetriever.getByStringValue("13"),
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        Set.of(),
                                        GameDirection.RIGHT,
                                        Set.of()
                                )
                        )
                );
    }

    private Set<TunnelElement> getDownPossibilities(){
        return Set.of(
            tunnelMapElementRetriever.getByStringValue("1"),
            tunnelMapElementRetriever.getByStringValue("3"),
            tunnelMapElementRetriever.getByStringValue("4"),
            tunnelMapElementRetriever.getByStringValue("5"),
            tunnelMapElementRetriever.getByStringValue("7"),
            tunnelMapElementRetriever.getByStringValue("9"),
            tunnelMapElementRetriever.getByStringValue("10"),
            tunnelMapElementRetriever.getByStringValue("11")
        );
    }

    private Set<TunnelElement> getLeftPossibilities(){
        return Set.of(
            tunnelMapElementRetriever.getByStringValue("1"),
            tunnelMapElementRetriever.getByStringValue("2"),
            tunnelMapElementRetriever.getByStringValue("4"),
            tunnelMapElementRetriever.getByStringValue("6"),
            tunnelMapElementRetriever.getByStringValue("7"),
            tunnelMapElementRetriever.getByStringValue("8"),
            tunnelMapElementRetriever.getByStringValue("12")
        );
    }

    private Set<TunnelElement> getRightPossibilities(){
        return Set.of(
            tunnelMapElementRetriever.getByStringValue("1"),
            tunnelMapElementRetriever.getByStringValue("2"),
            tunnelMapElementRetriever.getByStringValue("5"),
            tunnelMapElementRetriever.getByStringValue("6"),
            tunnelMapElementRetriever.getByStringValue("8"),
            tunnelMapElementRetriever.getByStringValue("9"),
            tunnelMapElementRetriever.getByStringValue("13")
        );
    }
}
