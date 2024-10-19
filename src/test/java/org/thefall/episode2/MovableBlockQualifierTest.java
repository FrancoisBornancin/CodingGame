package org.thefall.episode2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.info.MovableBlockQualifier;

public class MovableBlockQualifierTest {
    @Test
    void itShouldBeMovable(){
        String value = "4";
        MovableBlockQualifier movableBlockQualifier = new MovableBlockQualifier();

        Assertions.assertTrue(movableBlockQualifier.isMovable(value));
    }

    @Test
    void itShouldNotBeMovable(){
        String value = "-4";
        MovableBlockQualifier movableBlockQualifier = new MovableBlockQualifier();

        Assertions.assertFalse(movableBlockQualifier.isMovable(value));
    }
}
