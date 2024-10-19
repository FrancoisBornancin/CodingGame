package org.thefall.episode2.gameplay.nextblock.builder;

import org.thefall.episode2.gameplay.nextblock.GameDirection;
import org.thefall.episode2.gameplay.nextblock.TunnelQualifier;

import java.util.Map;

public class TurnBlockMapBuilder {
    Map<GameDirection, Map<String, String>> nextBlockValueAfterTurnedMap =
        Map.ofEntries(
                Map.entry(
                        GameDirection.RIGHT,
                        Map.ofEntries(
                                Map.entry(TunnelQualifier.TWO.value, TunnelQualifier.THREE.value),
                                Map.entry(TunnelQualifier.THREE.value, TunnelQualifier.TWO.value),
                                Map.entry(TunnelQualifier.FOUR.value, TunnelQualifier.FIVE.value),
                                Map.entry(TunnelQualifier.FIVE.value, TunnelQualifier.FOUR.value),
                                Map.entry(TunnelQualifier.SIX.value, TunnelQualifier.SEVEN.value),
                                Map.entry(TunnelQualifier.SEVEN.value, TunnelQualifier.EIGHT.value),
                                Map.entry(TunnelQualifier.EIGHT.value, TunnelQualifier.NINE.value),
                                Map.entry(TunnelQualifier.NINE.value, TunnelQualifier.SIX.value),
                                Map.entry(TunnelQualifier.TEN.value, TunnelQualifier.ELEVEN.value),
                                Map.entry(TunnelQualifier.ELEVEN.value, TunnelQualifier.TWELVE.value),
                                Map.entry(TunnelQualifier.TWELVE.value, TunnelQualifier.THIRTEEN.value),
                                Map.entry(TunnelQualifier.THIRTEEN.value, TunnelQualifier.TEN.value),
                                Map.entry(TunnelQualifier.MINUS_TWO.value, TunnelQualifier.THREE.value),
                                Map.entry(TunnelQualifier.MINUS_THREE.value, TunnelQualifier.TWO.value),
                                Map.entry(TunnelQualifier.MINUS_FOUR.value, TunnelQualifier.FIVE.value),
                                Map.entry(TunnelQualifier.MINUS_FIVE.value, TunnelQualifier.FOUR.value),
                                Map.entry(TunnelQualifier.MINUS_SIX.value, TunnelQualifier.SEVEN.value),
                                Map.entry(TunnelQualifier.MINUS_SEVEN.value, TunnelQualifier.EIGHT.value),
                                Map.entry(TunnelQualifier.MINUS_EIGHT.value, TunnelQualifier.NINE.value),
                                Map.entry(TunnelQualifier.MINUS_NINE.value, TunnelQualifier.SIX.value),
                                Map.entry(TunnelQualifier.MINUS_TEN.value, TunnelQualifier.ELEVEN.value),
                                Map.entry(TunnelQualifier.MINUS_ELEVEN.value, TunnelQualifier.TWELVE.value),
                                Map.entry(TunnelQualifier.MINUS_TWELVE.value, TunnelQualifier.THIRTEEN.value),
                                Map.entry(TunnelQualifier.MINUS_THIRTEEN.value, TunnelQualifier.TEN.value)
                        )
                ),
                Map.entry(
                        GameDirection.LEFT,
                        Map.ofEntries(
                                Map.entry(TunnelQualifier.TWO.value, TunnelQualifier.THREE.value),
                                Map.entry(TunnelQualifier.THREE.value, TunnelQualifier.TWO.value),
                                Map.entry(TunnelQualifier.FOUR.value, TunnelQualifier.FIVE.value),
                                Map.entry(TunnelQualifier.FIVE.value, TunnelQualifier.FOUR.value),
                                Map.entry(TunnelQualifier.SIX.value, TunnelQualifier.NINE.value),
                                Map.entry(TunnelQualifier.SEVEN.value, TunnelQualifier.SIX.value),
                                Map.entry(TunnelQualifier.EIGHT.value, TunnelQualifier.SEVEN.value),
                                Map.entry(TunnelQualifier.NINE.value, TunnelQualifier.EIGHT.value),
                                Map.entry(TunnelQualifier.TEN.value, TunnelQualifier.THIRTEEN.value),
                                Map.entry(TunnelQualifier.ELEVEN.value, TunnelQualifier.TEN.value),
                                Map.entry(TunnelQualifier.TWELVE.value, TunnelQualifier.ELEVEN.value),
                                Map.entry(TunnelQualifier.THIRTEEN.value, TunnelQualifier.TWELVE.value),
                                Map.entry(TunnelQualifier.MINUS_TWO.value, TunnelQualifier.THREE.value),
                                Map.entry(TunnelQualifier.MINUS_THREE.value, TunnelQualifier.TWO.value),
                                Map.entry(TunnelQualifier.MINUS_FOUR.value, TunnelQualifier.FIVE.value),
                                Map.entry(TunnelQualifier.MINUS_FIVE.value, TunnelQualifier.FOUR.value),
                                Map.entry(TunnelQualifier.MINUS_SIX.value, TunnelQualifier.NINE.value),
                                Map.entry(TunnelQualifier.MINUS_SEVEN.value, TunnelQualifier.SIX.value),
                                Map.entry(TunnelQualifier.MINUS_EIGHT.value, TunnelQualifier.SEVEN.value),
                                Map.entry(TunnelQualifier.MINUS_NINE.value, TunnelQualifier.EIGHT.value),
                                Map.entry(TunnelQualifier.MINUS_TEN.value, TunnelQualifier.THIRTEEN.value),
                                Map.entry(TunnelQualifier.MINUS_ELEVEN.value, TunnelQualifier.TEN.value),
                                Map.entry(TunnelQualifier.MINUS_TWELVE.value, TunnelQualifier.ELEVEN.value),
                                Map.entry(TunnelQualifier.MINUS_THIRTEEN.value, TunnelQualifier.TWELVE.value)
                        )
                ),
                Map.entry(
                        GameDirection.REVERSE,
                        Map.ofEntries(
                                Map.entry(TunnelQualifier.TWO.value, TunnelQualifier.TWO.value),
                                Map.entry(TunnelQualifier.THREE.value, TunnelQualifier.THREE.value),
                                Map.entry(TunnelQualifier.FOUR.value, TunnelQualifier.FOUR.value),
                                Map.entry(TunnelQualifier.FIVE.value, TunnelQualifier.FIVE.value),
                                Map.entry(TunnelQualifier.SIX.value, TunnelQualifier.EIGHT.value),
                                Map.entry(TunnelQualifier.SEVEN.value, TunnelQualifier.NINE.value),
                                Map.entry(TunnelQualifier.EIGHT.value, TunnelQualifier.SIX.value),
                                Map.entry(TunnelQualifier.NINE.value, TunnelQualifier.SEVEN.value),
                                Map.entry(TunnelQualifier.TEN.value, TunnelQualifier.TWELVE.value),
                                Map.entry(TunnelQualifier.ELEVEN.value, TunnelQualifier.THIRTEEN.value),
                                Map.entry(TunnelQualifier.TWELVE.value, TunnelQualifier.TEN.value),
                                Map.entry(TunnelQualifier.THIRTEEN.value, TunnelQualifier.ELEVEN.value),
                                    Map.entry(TunnelQualifier.MINUS_TWO.value, TunnelQualifier.TWO.value),
                                    Map.entry(TunnelQualifier.MINUS_THREE.value, TunnelQualifier.THREE.value),
                                    Map.entry(TunnelQualifier.MINUS_FOUR.value, TunnelQualifier.FOUR.value),
                                    Map.entry(TunnelQualifier.MINUS_FIVE.value, TunnelQualifier.FIVE.value),
                                    Map.entry(TunnelQualifier.MINUS_SIX.value, TunnelQualifier.EIGHT.value),
                                    Map.entry(TunnelQualifier.MINUS_SEVEN.value, TunnelQualifier.NINE.value),
                                    Map.entry(TunnelQualifier.MINUS_EIGHT.value, TunnelQualifier.SIX.value),
                                    Map.entry(TunnelQualifier.MINUS_NINE.value, TunnelQualifier.SEVEN.value),
                                    Map.entry(TunnelQualifier.MINUS_TEN.value, TunnelQualifier.TWELVE.value),
                                    Map.entry(TunnelQualifier.MINUS_ELEVEN.value, TunnelQualifier.THIRTEEN.value),
                                    Map.entry(TunnelQualifier.MINUS_TWELVE.value, TunnelQualifier.TEN.value),
                                    Map.entry(TunnelQualifier.MINUS_THIRTEEN.value, TunnelQualifier.ELEVEN.value)
                        )
                )
        );
    
    public String getNextBlockValueAfterTurned(GameDirection turnDirection, String previousBlockValue){
        return nextBlockValueAfterTurnedMap.get(turnDirection).get(previousBlockValue);
    }
}
