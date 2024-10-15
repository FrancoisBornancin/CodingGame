package org.dontpanic.episode1;

import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.clone.CloneDirection;
import org.dontpanic.episode1.gameplay.clone.ClonePositionComparator;
import org.dontpanic.episode1.gameplay.clone.CloneQualifier;
import org.dontpanic.episode1.gameplay.clone.CloneState;
import org.dontpanic.episode1.gameplay.elements.FinishDoor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class ClonePositionComparatorTest {

    @Test
    void itShouldBeTrueIfNoBlockedClonesArePresent(){
        Clone clone = new Clone(2, 1, CloneDirection.LEFT);
        FinishDoor finishDoor = new FinishDoor(0, 0);

        Optional<Clone> upperBlockClone = Optional.empty();

        ClonePositionComparator clonePositionComparator = new ClonePositionComparator();

        Assertions.assertTrue(clonePositionComparator.isCloneAboveUpperBlockedClone(clone, upperBlockClone, finishDoor));
    }

    @Test
    void itShouldBeTrueThatCurrentCloneIsAboveUpperBlockClone_case1(){
        Clone clone = new Clone(2, 2, CloneDirection.LEFT);
        Clone blockClone1 = new Clone(2, 1, CloneQualifier.SOLDIER_CLONE, CloneState.BLOCKED, CloneDirection.LEFT);
        FinishDoor finishDoor = new FinishDoor(0, 0);

        Optional<Clone> optionalUpperBlockClone = Optional.of(blockClone1);

        ClonePositionComparator clonePositionComparator = new ClonePositionComparator();

        Assertions.assertTrue(clonePositionComparator.isCloneAboveUpperBlockedClone(clone, optionalUpperBlockClone, finishDoor));
    }

    @Test
    void itShouldBeTrueThatCurrentCloneIsAboveUpperBlockClone_case2(){
        Clone clone = new Clone(6, 1, CloneDirection.LEFT);
        Clone blockClone1 = new Clone(2, 1, CloneQualifier.SOLDIER_CLONE, CloneState.BLOCKED, CloneDirection.LEFT);
        FinishDoor finishDoor = new FinishDoor(8, 1);

        Optional<Clone> optionalUpperBlockClone = Optional.of(blockClone1);

        ClonePositionComparator clonePositionComparator = new ClonePositionComparator();

        Assertions.assertTrue(clonePositionComparator.isCloneAboveUpperBlockedClone(clone, optionalUpperBlockClone, finishDoor));
    }

    @Test
    void itShouldBeFalseThatCurrentCloneIsAboveUpperBlockClone_case1(){
        Clone clone = new Clone(6, 1, CloneDirection.LEFT);
        Clone blockClone1 = new Clone(2, 1, CloneQualifier.SOLDIER_CLONE, CloneState.BLOCKED, CloneDirection.LEFT);
        FinishDoor finishDoor = new FinishDoor(0, 0);

        Optional<Clone> optionalUpperBlockClone = Optional.of(blockClone1);

        ClonePositionComparator clonePositionComparator = new ClonePositionComparator();

        Assertions.assertFalse(clonePositionComparator.isCloneAboveUpperBlockedClone(clone, optionalUpperBlockClone, finishDoor));
    }

    @Test
    void itShouldBeFalseThatCurrentCloneIsAboveUpperBlockClone_case2(){
        Clone clone = new Clone(6, 1, CloneDirection.LEFT);
        Clone blockClone1 = new Clone(4, 1, CloneQualifier.SOLDIER_CLONE, CloneState.BLOCKED, CloneDirection.LEFT);
        FinishDoor finishDoor = new FinishDoor(2, 1);

        Optional<Clone> optionalUpperBlockClone = Optional.of(blockClone1);

        ClonePositionComparator clonePositionComparator = new ClonePositionComparator();

        Assertions.assertFalse(clonePositionComparator.isCloneAboveUpperBlockedClone(clone, optionalUpperBlockClone, finishDoor));
    }
}
