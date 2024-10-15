package org.dontpanic.episode1;

import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.clone.CloneDirection;
import org.dontpanic.episode1.gameplay.elements.Elevator;
import org.dontpanic.episode1.gameplay.elements.NearestElevatorRetriever;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class NearestElevatorRetrieverTest {
    @Test
    void nearestElevatorShouldBeNotBlocked(){
        Elevator elevator1 = new Elevator(0, 3);
        Elevator elevator2 = new Elevator(0, 4);

        Clone clone = new Clone(5, 3, CloneDirection.LEFT);
        Clone fakeClone1 = new Clone(5, 3, CloneDirection.LEFT);
        Clone fakeClone2 = new Clone(5, 3, CloneDirection.LEFT);

        elevator1.clone = fakeClone1;
        elevator2.clone = fakeClone2;

        List<Elevator> elevatorList = List.of(elevator1, elevator2);
        NearestElevatorRetriever nearestElevatorRetriever = new NearestElevatorRetriever();
        Optional<Elevator> optionalOfNearestElevator = nearestElevatorRetriever.getNearestElevator(clone, elevatorList);

        Assertions.assertTrue(optionalOfNearestElevator.isEmpty());
    }

    @Test
    void nearestElevatorShouldBeStrictlyUnderTheClone_case1(){
        Elevator elevator = new Elevator(8, 2);

        Clone clone = new Clone(5, 3, CloneDirection.LEFT);

        List<Elevator> elevatorList = List.of(elevator);
        NearestElevatorRetriever nearestElevatorRetriever = new NearestElevatorRetriever();
        Optional<Elevator> optionalOfNearestElevator = nearestElevatorRetriever.getNearestElevator(clone, elevatorList);

        Assertions.assertTrue(optionalOfNearestElevator.isEmpty());
    }

    @Test
    void nearestElevatorShouldBeStrictlyUnderTheClone_case2(){
        Elevator elevator = new Elevator(8, 2);

        Clone clone = new Clone(5, 3, CloneDirection.LEFT);

        List<Elevator> elevatorList = List.of(elevator);
        NearestElevatorRetriever nearestElevatorRetriever = new NearestElevatorRetriever();
        Optional<Elevator> optionalOfNearestElevator = nearestElevatorRetriever.getNearestElevator(clone, elevatorList);

        Assertions.assertTrue(optionalOfNearestElevator.isEmpty());
    }

    @Test
    void ifElevatorUnderCloneIsBlockedNearestShouldBeTheOneSameLevel(){
        Elevator elevator1 = new Elevator(5, 2);
        Elevator elevator2 = new Elevator(0, 3);

        Clone clone = new Clone(5, 3, CloneDirection.LEFT);
        Clone fakeClone = new Clone(5, 3, CloneDirection.LEFT);

        elevator1.clone = fakeClone;

        List<Elevator> elevatorList = List.of(elevator1, elevator2);
        NearestElevatorRetriever nearestElevatorRetriever = new NearestElevatorRetriever();
        Optional<Elevator> optionalOfNearestElevator = nearestElevatorRetriever.getNearestElevator(clone, elevatorList);

        Assertions.assertTrue(optionalOfNearestElevator.isPresent());
        Assertions.assertEquals(elevator2, optionalOfNearestElevator.get());
    }
}
