package org.thefall.episode1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thefall.episode1.gameplay.nextblock.Coordinates;
import org.thefall.episode1.gameplay.nextblock.GameDirection;
import org.thefall.episode1.gameplay.nextblock.nextdirection.NextDirectionCalculator;

import java.util.List;
import java.util.Map;

public class NextDirectionCalculatorTest {
    private String getCoordinateValue(GameDirection gameDirection, Map<GameDirection, Coordinates> nearestDirections){
        return nearestDirections.keySet().stream()
                .filter(direction -> direction == gameDirection)
                .map(nearestDirections::get)
                .findFirst().get()
                .value;
    }

    @Test
    void it_should_calculate_next_directions_when_no_previous_direction(){
        NextDirectionCalculator nextDirectionCalculatorReverse = new NextDirectionCalculator();
        Coordinates coordinates = new Coordinates(1, 0, "E");
        String[][] stringTab = new String[2][];
        stringTab[0] = List.of("L","E","R").toArray(String[]::new);
        stringTab[1] = List.of("X","D","X").toArray(String[]::new);

        Map<GameDirection, Coordinates> nearestDirections =
            nextDirectionCalculatorReverse.getNearestDirections(coordinates, stringTab);

        Assertions.assertEquals(3, nearestDirections.size());
        Assertions.assertEquals(
                "L",
                getCoordinateValue(GameDirection.LEFT, nearestDirections)
            );
        Assertions.assertEquals(
                "R",
                getCoordinateValue(GameDirection.RIGHT, nearestDirections)
        );
        Assertions.assertEquals(
                "D",
                getCoordinateValue(GameDirection.DOWN, nearestDirections)
        );
    }

    @Test
    void it_should_calculate_next_directions_when_previous_direction_right(){
        NextDirectionCalculator nextDirectionCalculatorReverse = new NextDirectionCalculator();
        Coordinates coordinates = new Coordinates(1, 0, "E");
        coordinates.direction = GameDirection.RIGHT;
        String[][] stringTab = new String[2][];
        stringTab[0] = List.of("L","E","R").toArray(String[]::new);
        stringTab[1] = List.of("X","D","X").toArray(String[]::new);

        Map<GameDirection, Coordinates> nearestDirections =
                nextDirectionCalculatorReverse.getNearestDirections(coordinates, stringTab);

        Assertions.assertEquals(2, nearestDirections.size());
        Assertions.assertEquals(
                "R",
                getCoordinateValue(GameDirection.RIGHT, nearestDirections)
        );
        Assertions.assertEquals(
                "D",
                getCoordinateValue(GameDirection.DOWN, nearestDirections)
        );
    }

    @Test
    void it_should_calculate_next_directions_when_previous_direction_left(){
        NextDirectionCalculator nextDirectionCalculatorReverse = new NextDirectionCalculator();
        Coordinates coordinates = new Coordinates(1, 0, "E");
        coordinates.direction = GameDirection.LEFT;
        String[][] stringTab = new String[2][];
        stringTab[0] = List.of("L","E","R").toArray(String[]::new);
        stringTab[1] = List.of("X","D","X").toArray(String[]::new);

        Map<GameDirection, Coordinates> nearestDirections =
                nextDirectionCalculatorReverse.getNearestDirections(coordinates, stringTab);

        Assertions.assertEquals(2, nearestDirections.size());
        Assertions.assertEquals(
                "L",
                getCoordinateValue(GameDirection.LEFT, nearestDirections)
        );
        Assertions.assertEquals(
                "D",
                getCoordinateValue(GameDirection.DOWN, nearestDirections)
        );
    }

    @Test
    void it_should_calculate_next_directions_when_previous_direction_top(){
        NextDirectionCalculator nextDirectionCalculatorReverse = new NextDirectionCalculator();
        Coordinates coordinates = new Coordinates(1, 0, "E");
        coordinates.direction = GameDirection.DOWN;
        String[][] stringTab = new String[2][];
        stringTab[0] = List.of("L","E","R").toArray(String[]::new);
        stringTab[1] = List.of("X","D","X").toArray(String[]::new);

        Map<GameDirection, Coordinates> nearestDirections =
                nextDirectionCalculatorReverse.getNearestDirections(coordinates, stringTab);

        Assertions.assertEquals(3, nearestDirections.size());
        Assertions.assertEquals(
                "R",
                getCoordinateValue(GameDirection.RIGHT, nearestDirections)
        );
        Assertions.assertEquals(
                "L",
                getCoordinateValue(GameDirection.LEFT, nearestDirections)
        );
        Assertions.assertEquals(
                "D",
                getCoordinateValue(GameDirection.DOWN, nearestDirections)
        );
    }
}
