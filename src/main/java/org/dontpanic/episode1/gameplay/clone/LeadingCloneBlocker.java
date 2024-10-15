package org.dontpanic.episode1.gameplay.clone;

import org.dontpanic.episode1.gameplay.CurrentGameAction;
import org.dontpanic.episode1.gameplay.GameAction;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirection;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirectionCalculator;
import org.dontpanic.episode1.gameplay.elements.BaseElement;
import org.dontpanic.episode1.gameplay.elements.Elevator;
import org.dontpanic.episode1.gameplay.elements.FinishDoor;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;
import org.dontpanic.episode1.gameplay.elements.NearestElevatorRetriever;
import org.dontpanic.episode1.gameplay.coordinates.XCoordinatesComparator;

import java.util.List;
import java.util.Optional;

public class LeadingCloneBlocker {
    private CurrentGameAction currentGameAction;
    private XCoordinatesComparator cordXComparator;
    private LeadingCloneUpdater leadingCloneUpdater;
    private GameElementsContainer gameElementsContainer;

    public void blockClone(GameElementsContainer gameElementsContainer, CurrentGameAction currentGameAction){
        this.currentGameAction = currentGameAction;
        this.cordXComparator = new XCoordinatesComparator();
        this.leadingCloneUpdater = new LeadingCloneUpdater();
        this.gameElementsContainer = gameElementsContainer;
        ClonePositionComparator clonePositionComparator = new ClonePositionComparator();
        UpperBlockCloneRetriever upperBlockCloneRetriever = new UpperBlockCloneRetriever();
        NearestElevatorRetriever nearestElevatorRetriever = new NearestElevatorRetriever();
        FinishDoor finishDoor = gameElementsContainer.finishDoor;
        List<Elevator> elevatorList = gameElementsContainer.elevatorList;
        List<Clone> cloneList = gameElementsContainer.cloneList;

        Optional<Clone> optionalLeadingClone = cloneList.stream()
                .filter(clone -> clone.qualifier == CloneQualifier.LEADING_CLONE)
                .findFirst();

        if(optionalLeadingClone.isPresent()) {
            Clone leadingClone = optionalLeadingClone.get();

            Optional<Clone> optionalOfUpperBlockedClone = upperBlockCloneRetriever.getUpperBlockClone(cloneList);
            boolean isCloneAboveUpperBlockedClone = clonePositionComparator.isCloneAboveUpperBlockedClone(leadingClone, optionalOfUpperBlockedClone, finishDoor);

            if(isCloneAboveUpperBlockedClone || optionalOfUpperBlockedClone.isEmpty()){
                if(leadingClone.cordY == finishDoor.cordY) compareAndBlock(leadingClone, finishDoor);
                else{
                    Optional<Elevator> optionalOfNearestElevator = nearestElevatorRetriever.getNearestElevator(leadingClone, elevatorList);
                    Elevator nearestElevator;
                    if(optionalOfNearestElevator.isPresent()) {
                        nearestElevator = optionalOfNearestElevator.get();
                        if(YAxisDirectionCalculator.isUpperRegardingDirection(leadingClone, nearestElevator)){
                            Optional<Elevator> optionalSameLevelElevator = getSameLevelElevator(elevatorList, leadingClone);
                            optionalSameLevelElevator.ifPresent(elevator -> compareAndBlock(leadingClone, elevator));
                        }else compareAndBlock(leadingClone, nearestElevator);
                    }
                }
            }
        }
    }

    private void blockClone(){
        currentGameAction.gameAction = GameAction.BLOCK;
        leadingCloneUpdater.changeLeadingClone(this.gameElementsContainer);
    }

    private void compareAndBlock(Clone clone, BaseElement baseElement){
        if(cordXComparator.elementOnCloneLeft(clone, baseElement) && clone.direction == CloneDirection.RIGHT){
            blockClone();
            blockIfElevator(clone, baseElement);
        }else if(cordXComparator.elementOnCloneRight(clone, baseElement) && clone.direction == CloneDirection.LEFT){
            blockClone();
            blockIfElevator(clone, baseElement);
        }
    }

    private void blockIfElevator(Clone clone, BaseElement baseElement){
        if(baseElement instanceof Elevator) {
            Elevator elevatorToBlock = (Elevator) baseElement;
            elevatorToBlock.clone = clone;
        }
    }

    private Optional<Elevator> getSameLevelElevator(List<Elevator> elevatorList, Clone leadingClone){
        return elevatorList.stream()
                .filter(elevator -> elevator.clone == null)
                .filter(elevator -> elevator.cordY == leadingClone.cordY)
                .findFirst();
    }
}
