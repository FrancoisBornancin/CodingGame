package org.thefall.episode2.gameplay.nextblock.builder;

import org.thefall.episode2.gameplay.elements.tunnel.TunnelElement;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;
import org.thefall.episode2.gameplay.nextblock.TunnelQualifier;

import java.util.Map;

public class NextBlockMapBuilder{
    public NextBlockMapBuilder(){}

    public Map<String, Map<GameDirection, Map<String, Coordinates>>> buildMap(){
               return Map.ofEntries(
                        Map.entry(
                                TunnelQualifier.MINUS_ONE.value,
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities()
                                )
                        ),
                       Map.entry(
                               TunnelQualifier.ONE.value,
                               Map.of(
                                       GameDirection.DOWN,
                                       getDownPossibilities()
                               )
                       ),
                        Map.entry(
                                TunnelQualifier.MINUS_TWO.value,
                                Map.of(
                                        GameDirection.LEFT,
                                        getLeftPossibilities(),
                                        GameDirection.RIGHT,
                                        getRightPossibilities()
                                )
                        ),
                       Map.entry(
                               TunnelQualifier.TWO.value,
                               Map.of(
                                       GameDirection.LEFT,
                                       getLeftPossibilities(),
                                       GameDirection.RIGHT,
                                       getRightPossibilities()
                               )
                       ),
                        Map.entry(
                                TunnelQualifier.MINUS_THREE.value,
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities()
                                )
                        ),
                       Map.entry(
                               TunnelQualifier.THREE.value,
                               Map.of(
                                       GameDirection.DOWN,
                                       getDownPossibilities()
                               )
                       ),
                        Map.entry(
                                TunnelQualifier.MINUS_FOUR.value,
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.LEFT,
                                        getLeftPossibilities()
                                )
                        ),
                       Map.entry(
                               TunnelQualifier.FOUR.value,
                               Map.of(
                                       GameDirection.DOWN,
                                       getDownPossibilities(),
                                       GameDirection.LEFT,
                                       getLeftPossibilities()
                               )
                       ),
                        Map.entry(
                                TunnelQualifier.MINUS_FIVE.value,
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities(),
                                        GameDirection.RIGHT,
                                        getRightPossibilities()
                                )
                        ),
                       Map.entry(
                               TunnelQualifier.FIVE.value,
                               Map.of(
                                       GameDirection.DOWN,
                                       getDownPossibilities(),
                                       GameDirection.RIGHT,
                                       getRightPossibilities()
                               )
                       ),
                        Map.entry(
                                TunnelQualifier.MINUS_SIX.value,
                                Map.of(
                                        GameDirection.LEFT,
                                        getLeftPossibilities(),
                                        GameDirection.RIGHT,
                                        getRightPossibilities()
                                )
                        ),
                       Map.entry(
                               TunnelQualifier.SIX.value,
                               Map.of(
                                       GameDirection.LEFT,
                                       getLeftPossibilities(),
                                       GameDirection.RIGHT,
                                       getRightPossibilities()
                               )
                       ),
                        Map.entry(
                                TunnelQualifier.MINUS_SEVEN.value,
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities()
                                )
                        ),
                       Map.entry(
                               TunnelQualifier.SEVEN.value,
                               Map.of(
                                       GameDirection.DOWN,
                                       getDownPossibilities()
                               )
                       ),
                        Map.entry(
                                TunnelQualifier.MINUS_EIGHT.value,
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities()
                                )
                        ),
                       Map.entry(
                               TunnelQualifier.EIGHT.value,
                               Map.of(
                                       GameDirection.DOWN,
                                       getDownPossibilities()
                               )
                       ),
                        Map.entry(
                                TunnelQualifier.MINUS_NINE.value,
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities()
                                )
                        ),
                       Map.entry(
                               TunnelQualifier.NINE.value,
                               Map.of(
                                       GameDirection.DOWN,
                                       getDownPossibilities()
                               )
                       ),
                        Map.entry(
                                TunnelQualifier.MINUS_TEN.value,
                                Map.of(
                                        GameDirection.LEFT,
                                        getLeftPossibilities()
                                )
                        ),
                       Map.entry(
                               TunnelQualifier.TEN.value,
                               Map.of(
                                       GameDirection.LEFT,
                                       getLeftPossibilities()
                               )
                       ),
                        Map.entry(
                                TunnelQualifier.MINUS_ELEVEN.value,
                                Map.of(
                                        GameDirection.RIGHT,
                                        getRightPossibilities()
                                )
                        ),
                       Map.entry(
                               TunnelQualifier.ELEVEN.value,
                               Map.of(
                                       GameDirection.RIGHT,
                                       getRightPossibilities()
                               )
                       ),
                        Map.entry(
                                TunnelQualifier.MINUS_TWELVE.value,
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities()
                                )
                        ),
                       Map.entry(
                               TunnelQualifier.TWELVE.value,
                               Map.of(
                                       GameDirection.DOWN,
                                       getDownPossibilities()
                               )
                       ),
                        Map.entry(
                                TunnelQualifier.MINUS_THIRTEEN.value,
                                Map.of(
                                        GameDirection.DOWN,
                                        getDownPossibilities()
                                )
                        ),
                       Map.entry(
                               TunnelQualifier.THIRTEEN.value,
                               Map.of(
                                       GameDirection.DOWN,
                                       getDownPossibilities()
                               )
                       )
                );
    }

    private Map<String, Coordinates> getDownPossibilities(){
        return Map.ofEntries(
            Map.entry(TunnelQualifier.MINUS_ONE.value, downCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_ONE.value)),
            Map.entry(TunnelQualifier.MINUS_THREE.value, downCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_THREE.value)),
            Map.entry(TunnelQualifier.MINUS_FOUR.value, downCoordinates(GameDirection.LEFT, TunnelQualifier.MINUS_FOUR.value)),
            Map.entry(TunnelQualifier.MINUS_FIVE.value, downCoordinates(GameDirection.RIGHT, TunnelQualifier.MINUS_FIVE.value)),
            Map.entry(TunnelQualifier.MINUS_SEVEN.value, downCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_SEVEN.value)),
            Map.entry(TunnelQualifier.MINUS_NINE.value, downCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_NINE.value)),
            Map.entry(TunnelQualifier.MINUS_TEN.value, downCoordinates(GameDirection.LEFT, TunnelQualifier.MINUS_TEN.value)),
            Map.entry(TunnelQualifier.MINUS_ELEVEN.value, downCoordinates(GameDirection.RIGHT, TunnelQualifier.MINUS_ELEVEN.value)),
            Map.entry(TunnelQualifier.ONE.value, downCoordinates(GameDirection.DOWN, TunnelQualifier.ONE.value)),
            Map.entry(TunnelQualifier.THREE.value, downCoordinates(GameDirection.DOWN, TunnelQualifier.THREE.value)),
            Map.entry(TunnelQualifier.FOUR.value, downCoordinates(GameDirection.LEFT, TunnelQualifier.FOUR.value)),
            Map.entry(TunnelQualifier.FIVE.value, downCoordinates(GameDirection.RIGHT, TunnelQualifier.FIVE.value)),
            Map.entry(TunnelQualifier.SEVEN.value, downCoordinates(GameDirection.DOWN, TunnelQualifier.SEVEN.value)),
            Map.entry(TunnelQualifier.NINE.value, downCoordinates(GameDirection.DOWN, TunnelQualifier.NINE.value)),
            Map.entry(TunnelQualifier.TEN.value, downCoordinates(GameDirection.LEFT, TunnelQualifier.TEN.value)),
            Map.entry(TunnelQualifier.ELEVEN.value, downCoordinates(GameDirection.RIGHT, TunnelQualifier.ELEVEN.value))
        );
    }


    private Map<String, Coordinates> getLeftPossibilities(){
        return Map.ofEntries(
                Map.entry(TunnelQualifier.MINUS_ONE.value, leftCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_ONE.value)),
                Map.entry(TunnelQualifier.MINUS_TWO.value, leftCoordinates(GameDirection.LEFT, TunnelQualifier.MINUS_TWO.value)),
                Map.entry(TunnelQualifier.MINUS_FOUR.value, leftCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_FOUR.value)),
                Map.entry(TunnelQualifier.MINUS_SIX.value, leftCoordinates(GameDirection.LEFT, TunnelQualifier.MINUS_SIX.value)),
                Map.entry(TunnelQualifier.MINUS_SEVEN.value, leftCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_SEVEN.value)),
                Map.entry(TunnelQualifier.MINUS_EIGHT.value, leftCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_EIGHT.value)),
                Map.entry(TunnelQualifier.MINUS_TWELVE.value, leftCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_TWELVE.value)),
                Map.entry(TunnelQualifier.ONE.value, leftCoordinates(GameDirection.DOWN, TunnelQualifier.ONE.value)),
                Map.entry(TunnelQualifier.TWO.value, leftCoordinates(GameDirection.LEFT, TunnelQualifier.TWO.value)),
                Map.entry(TunnelQualifier.FOUR.value, leftCoordinates(GameDirection.DOWN, TunnelQualifier.FOUR.value)),
                Map.entry(TunnelQualifier.SIX.value, leftCoordinates(GameDirection.LEFT, TunnelQualifier.SIX.value)),
                Map.entry(TunnelQualifier.SEVEN.value, leftCoordinates(GameDirection.DOWN, TunnelQualifier.SEVEN.value)),
                Map.entry(TunnelQualifier.EIGHT.value, leftCoordinates(GameDirection.DOWN, TunnelQualifier.EIGHT.value)),
                Map.entry(TunnelQualifier.TWELVE.value, leftCoordinates(GameDirection.DOWN, TunnelQualifier.TWELVE.value))
        );
    }

    private Map<String, Coordinates> getRightPossibilities(){
        return Map.ofEntries(
                Map.entry(TunnelQualifier.MINUS_ONE.value, rightCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_ONE.value)),
                Map.entry(TunnelQualifier.MINUS_TWO.value, rightCoordinates(GameDirection.RIGHT, TunnelQualifier.MINUS_TWO.value)),
                Map.entry(TunnelQualifier.MINUS_FIVE.value, rightCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_FIVE.value)),
                Map.entry(TunnelQualifier.MINUS_SIX.value, rightCoordinates(GameDirection.RIGHT, TunnelQualifier.MINUS_SIX.value)),
                Map.entry(TunnelQualifier.MINUS_EIGHT.value, rightCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_EIGHT.value)),
                Map.entry(TunnelQualifier.MINUS_NINE.value, rightCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_NINE.value)),
                Map.entry(TunnelQualifier.MINUS_THIRTEEN.value, rightCoordinates(GameDirection.DOWN, TunnelQualifier.MINUS_THIRTEEN.value)),
                Map.entry(TunnelQualifier.ONE.value, rightCoordinates(GameDirection.DOWN, TunnelQualifier.ONE.value)),
                Map.entry(TunnelQualifier.TWO.value, rightCoordinates(GameDirection.RIGHT, TunnelQualifier.TWO.value)),
                Map.entry(TunnelQualifier.FIVE.value, rightCoordinates(GameDirection.DOWN, TunnelQualifier.FIVE.value)),
                Map.entry(TunnelQualifier.SIX.value, rightCoordinates(GameDirection.RIGHT, TunnelQualifier.SIX.value)),
                Map.entry(TunnelQualifier.EIGHT.value, rightCoordinates(GameDirection.DOWN, TunnelQualifier.EIGHT.value)),
                Map.entry(TunnelQualifier.NINE.value, rightCoordinates(GameDirection.DOWN, TunnelQualifier.NINE.value)),
                Map.entry(TunnelQualifier.THIRTEEN.value, rightCoordinates(GameDirection.DOWN, TunnelQualifier.THIRTEEN.value))
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
