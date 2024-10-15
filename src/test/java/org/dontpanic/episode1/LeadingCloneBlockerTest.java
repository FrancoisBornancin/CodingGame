package org.dontpanic.episode1;

import org.dontpanic.episode1.gameplay.CurrentGameAction;
import org.dontpanic.episode1.gameplay.GameAction;
import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.clone.CloneDirection;
import org.dontpanic.episode1.gameplay.clone.CloneQualifier;
import org.dontpanic.episode1.gameplay.clone.CloneState;
import org.dontpanic.episode1.gameplay.clone.LeadingCloneBlocker;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirection;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirectionCalculator;
import org.dontpanic.episode1.gameplay.elements.Elevator;
import org.dontpanic.episode1.gameplay.elements.FinishDoor;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LeadingCloneBlockerTest {

    @Test
    void itShouldBlockTheLeadingCloneWhenGoesRightAndElevatorOnHisLeft(){
        CurrentGameAction currentGameAction = new CurrentGameAction();
        currentGameAction.gameAction = GameAction.WAIT;
        Clone leadingClone = new Clone(6, 3, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Elevator elevator = new Elevator(2, 3);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(leadingClone);
        gameElementsContainer.elevatorList = List.of(elevator);
        gameElementsContainer.finishDoor = new FinishDoor(0, 0);

        LeadingCloneBlocker leadingCloneBlocker = new LeadingCloneBlocker();
        leadingCloneBlocker.blockClone(gameElementsContainer, currentGameAction);

        Assertions.assertEquals(CloneState.BLOCKED, leadingClone.state);
        Assertions.assertEquals(GameAction.BLOCK, currentGameAction.gameAction);
    }

    @Test
    void itShouldBlockTheLeadingCloneWhenGoesLeftAndElevatorOnHisRight(){
        CurrentGameAction currentGameAction = new CurrentGameAction();
        currentGameAction.gameAction = GameAction.WAIT;
        Clone leadingClone = new Clone(2, 3, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.LEFT);
        Elevator elevator = new Elevator(6, 3);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(leadingClone);
        gameElementsContainer.elevatorList = List.of(elevator);
        gameElementsContainer.finishDoor = new FinishDoor(0, 0);

        LeadingCloneBlocker leadingCloneBlocker = new LeadingCloneBlocker();
        leadingCloneBlocker.blockClone(gameElementsContainer, currentGameAction);

        Assertions.assertEquals(CloneState.BLOCKED, leadingClone.state);
        Assertions.assertEquals(GameAction.BLOCK, currentGameAction.gameAction);
    }

    @Test
    void itShouldNotBlockTheLeadingCloneWhenGoesLeftAndElevatorOnHisLeft(){
        CurrentGameAction currentGameAction = new CurrentGameAction();
        currentGameAction.gameAction = GameAction.WAIT;
        Clone leadingClone = new Clone(6, 3, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.LEFT);
        Elevator elevator = new Elevator(2, 3);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(leadingClone);
        gameElementsContainer.elevatorList = List.of(elevator);
        gameElementsContainer.finishDoor = new FinishDoor(0, 0);

        LeadingCloneBlocker leadingCloneBlocker = new LeadingCloneBlocker();
        leadingCloneBlocker.blockClone(gameElementsContainer, currentGameAction);

        Assertions.assertEquals(CloneState.NOT_BLOCKED, leadingClone.state);
        Assertions.assertEquals(GameAction.WAIT, currentGameAction.gameAction);
    }

    @Test
    void itShouldNotBlockTheLeadingCloneWhenGoesRightAndElevatorOnHisRight(){
        CurrentGameAction currentGameAction = new CurrentGameAction();
        currentGameAction.gameAction = GameAction.WAIT;
        Clone leadingClone = new Clone(2, 3, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Elevator elevator = new Elevator(6, 3);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(leadingClone);
        gameElementsContainer.elevatorList = List.of(elevator);
        gameElementsContainer.finishDoor = new FinishDoor(0, 0);

        LeadingCloneBlocker leadingCloneBlocker = new LeadingCloneBlocker();
        leadingCloneBlocker.blockClone(gameElementsContainer, currentGameAction);

        Assertions.assertEquals(CloneState.NOT_BLOCKED, leadingClone.state);
        Assertions.assertEquals(GameAction.WAIT, currentGameAction.gameAction);
    }

    @Test
    void itShouldPreferBlockLeadingCloneRegardingFinishDoorThanElevator(){
        CurrentGameAction currentGameAction = new CurrentGameAction();
        currentGameAction.gameAction = GameAction.WAIT;
        Clone leadingClone = new Clone(6, 3, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Elevator elevator = new Elevator(9, 3);
        FinishDoor finishDoor = new FinishDoor(2, 3);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(leadingClone);
        gameElementsContainer.elevatorList = List.of(elevator);
        gameElementsContainer.finishDoor = finishDoor;

        LeadingCloneBlocker leadingCloneBlocker = new LeadingCloneBlocker();
        leadingCloneBlocker.blockClone(gameElementsContainer, currentGameAction);

        Assertions.assertEquals(CloneState.BLOCKED, leadingClone.state);
        Assertions.assertEquals(GameAction.BLOCK, currentGameAction.gameAction);
    }

    @Test
    void itShouldBlockTheLeadingCloneRegardingNearestElevator(){
        YAxisDirectionCalculator.yAxisDirection = YAxisDirection.BOTTOM_TO_TOP;
        CurrentGameAction currentGameAction = new CurrentGameAction();
        currentGameAction.gameAction = GameAction.WAIT;
        Clone leadingClone = new Clone(6, 3, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Elevator elevator1 = new Elevator(2, 3);
        Elevator elevator2 = new Elevator(8, 2);
        Elevator elevator3 = new Elevator(6, 4);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(leadingClone);
        gameElementsContainer.elevatorList = List.of(elevator2, elevator1, elevator3);
        gameElementsContainer.finishDoor = new FinishDoor(0, 0);

        LeadingCloneBlocker leadingCloneBlocker = new LeadingCloneBlocker();
        leadingCloneBlocker.blockClone(gameElementsContainer, currentGameAction);

        Assertions.assertEquals(CloneState.BLOCKED, leadingClone.state);
        Assertions.assertEquals(GameAction.BLOCK, currentGameAction.gameAction);
    }

    @Test
    void itShouldNotBlockTheLeadingCloneIfItIsAlreadyBlocked(){
        CurrentGameAction currentGameAction = new CurrentGameAction();
        currentGameAction.gameAction = GameAction.WAIT;
        Clone leadingClone = new Clone(6, 3, CloneQualifier.LEADING_CLONE, CloneState.BLOCKED, CloneDirection.RIGHT);
        Elevator elevator = new Elevator(2, 3);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(leadingClone);
        gameElementsContainer.elevatorList = List.of(elevator);
        gameElementsContainer.finishDoor = new FinishDoor(0, 0);

        LeadingCloneBlocker leadingCloneBlocker = new LeadingCloneBlocker();
        leadingCloneBlocker.blockClone(gameElementsContainer, currentGameAction);

        Assertions.assertEquals(CloneState.BLOCKED, leadingClone.state);
    }

    @Test
    void itShouldBlockTheLeadingCloneRegardingFinishDoor_case1(){
        CurrentGameAction currentGameAction = new CurrentGameAction();
        currentGameAction.gameAction = GameAction.WAIT;
        Clone leadingClone = new Clone(6, 3, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(leadingClone);
        gameElementsContainer.elevatorList = List.of();
        gameElementsContainer.finishDoor = new FinishDoor(2, 3);

        LeadingCloneBlocker leadingCloneBlocker = new LeadingCloneBlocker();
        leadingCloneBlocker.blockClone(gameElementsContainer, currentGameAction);

        Assertions.assertEquals(CloneState.BLOCKED, leadingClone.state);
        Assertions.assertEquals(GameAction.BLOCK, currentGameAction.gameAction);
    }

    @Test
    void itShouldBlockTheLeadingCloneRegardingFinishDoor_case2(){
        CurrentGameAction currentGameAction = new CurrentGameAction();
        currentGameAction.gameAction = GameAction.WAIT;
        Clone leadingClone = new Clone(6, 3, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Elevator elevator = new Elevator(9, 3);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(leadingClone);
        gameElementsContainer.elevatorList = List.of(elevator);
        gameElementsContainer.finishDoor = new FinishDoor(2, 3);

        LeadingCloneBlocker leadingCloneBlocker = new LeadingCloneBlocker();
        leadingCloneBlocker.blockClone(gameElementsContainer, currentGameAction);

        Assertions.assertEquals(CloneState.BLOCKED, leadingClone.state);
        Assertions.assertEquals(GameAction.BLOCK, currentGameAction.gameAction);
    }

    @Test
    void leadingCloneShouldBeDetachedFromPreviousCloneWhenItIsBlocked(){
        CurrentGameAction currentGameAction = new CurrentGameAction();
        currentGameAction.gameAction = GameAction.WAIT;
        Clone leadingClone = new Clone(6, 3, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone otherClone = new Clone(6, 3, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);

        leadingClone.previousClone = otherClone;

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(leadingClone, otherClone);
        gameElementsContainer.elevatorList = List.of(new Elevator(2, 3));
        gameElementsContainer.finishDoor = new FinishDoor(0, 0);

        LeadingCloneBlocker leadingCloneBlocker = new LeadingCloneBlocker();
        leadingCloneBlocker.blockClone(gameElementsContainer, currentGameAction);

        Assertions.assertNull(leadingClone.previousClone);
    }

    @Test
    void leadingCloneShouldBeBlockedOnlyIfItIsAboveTheUpperBlockedClone_case1(){
        CurrentGameAction currentGameAction = new CurrentGameAction();
        currentGameAction.gameAction = GameAction.WAIT;
        Clone leadingClone = new Clone(6, 2, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone otherClone = new Clone(6, 3, CloneQualifier.LEADING_CLONE, CloneState.BLOCKED, CloneDirection.RIGHT);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(leadingClone, otherClone);
        gameElementsContainer.elevatorList = List.of();
        gameElementsContainer.finishDoor = new FinishDoor(0, 0);

        LeadingCloneBlocker leadingCloneBlocker = new LeadingCloneBlocker();
        leadingCloneBlocker.blockClone(gameElementsContainer, currentGameAction);

        Assertions.assertEquals(CloneState.NOT_BLOCKED, leadingClone.state);
        Assertions.assertEquals(GameAction.WAIT, currentGameAction.gameAction);
    }

    @Test
    void ifAnElevatorIsBlockedItShouldRegisterTheBlockedClone(){
        CurrentGameAction currentGameAction = new CurrentGameAction();
        currentGameAction.gameAction = GameAction.WAIT;
        Clone leadingClone = new Clone(6, 1, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Elevator elevator = new Elevator(2, 1);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(leadingClone);
        gameElementsContainer.elevatorList = List.of(elevator);
        gameElementsContainer.finishDoor = new FinishDoor(0, 0);

        LeadingCloneBlocker leadingCloneBlocker = new LeadingCloneBlocker();
        leadingCloneBlocker.blockClone(gameElementsContainer, currentGameAction);

        Assertions.assertEquals(leadingClone, elevator.clone);
    }
}
