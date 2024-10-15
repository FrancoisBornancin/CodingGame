package org.dontpanic.episode1.gameplay.clone;

import org.dontpanic.episode1.gameplay.coordinates.YAxisDirection;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirectionCalculator;
import org.dontpanic.episode1.gameplay.elements.Elevator;
import org.dontpanic.episode1.gameplay.elements.FinishDoor;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CloneCoordinatesDirectionUpdater {
    public void updateClonesCoordinatesAndDirection(GameElementsContainer gameElementsContainer){
        List<Clone> cloneList = gameElementsContainer.cloneList;
        List<Elevator> elevatorList = gameElementsContainer.elevatorList;
        Set<Clone> clonesOnElevators = new HashSet<>();
        Set<Clone> clonesNotOnElevators = new HashSet<>();
        Set<Clone> blockClones =
                cloneList.stream()
                        .filter(clone -> clone.state == CloneState.BLOCKED)
                        .collect(Collectors.toSet());
        Set<Clone> notBlockedClones =
                cloneList.stream()
                        .filter(clone -> clone.state != CloneState.BLOCKED)
                        .collect(Collectors.toSet());

        FinishDoor finishDoor = gameElementsContainer.finishDoor;

        if(elevatorList.size() == 0){
            clonesNotOnElevators = new HashSet<>(cloneList);
        }else{
            List<Clone> notBlockedClonesList = notBlockedClones.stream().toList();
            for(int a = 0 ; a < notBlockedClonesList.size() ; a++){
                for(int b = 0 ; b < elevatorList.size() ; b++){
                    Clone clone = notBlockedClonesList.get(a);
                    Elevator elevator = elevatorList.get(b);
                    if(clone.cordX == elevator.cordX && clone.cordY == elevator.cordY){
                        clonesOnElevators.add(clone);
                    }
                }
            }
            clonesNotOnElevators = new HashSet<>(notBlockedClones);
            clonesNotOnElevators.removeAll(clonesOnElevators);
        }

        if(!blockClones.isEmpty() && !notBlockedClones.isEmpty()){
            for(int a = 0 ; a < notBlockedClones.size() ; a++){
                for(int b = 0 ; b < blockClones.size() ; b++){
                    Clone clone = notBlockedClones.stream().toList().get(a);
                    Clone blockClone = blockClones.stream().toList().get(b);
                    if(clone.cordX == blockClone.cordX && clone.cordY == blockClone.cordY){
                        if(clone.direction == CloneDirection.RIGHT) clone.direction = CloneDirection.LEFT;
                        else clone.direction = CloneDirection.RIGHT;
                    }
                }
            }
        }

        clonesNotOnElevators.stream()
                .filter(clone -> clone.state == CloneState.NOT_BLOCKED)
                .filter(clone -> clone.direction == CloneDirection.LEFT)
                .forEach(clone -> clone.cordX--);

        clonesNotOnElevators.stream()
                .filter(clone -> clone.state == CloneState.NOT_BLOCKED)
                .filter(clone -> clone.direction == CloneDirection.RIGHT)
                .forEach(clone -> clone.cordX++);

        Optional<Clone> cloneOnElevatorFinishDoorSameLevel =
                clonesOnElevators.stream()
                        .filter(clone -> clone.cordY == finishDoor.cordY)
                        .findFirst();

        clonesOnElevatorAndFinishDoorSameLevel(cloneOnElevatorFinishDoorSameLevel);

        clonesOnElevators.stream()
                .filter(clone -> clone.cordY != finishDoor.cordY)
                .filter(clone -> clone.state == CloneState.NOT_BLOCKED)
                .forEach(clone -> updateYAxis(clone));
    }

    private void updateYAxis(Clone clone){
        if(YAxisDirectionCalculator.yAxisDirection == YAxisDirection.BOTTOM_TO_TOP) clone.cordY++;
        else clone.cordY--;
    }

    private void clonesOnElevatorAndFinishDoorSameLevel(Optional<Clone> optionalOnFinishDoor){
        if(optionalOnFinishDoor.isPresent()){
            Clone clone = optionalOnFinishDoor.get();
            if(clone.direction == CloneDirection.RIGHT) clone.cordX++;
            else clone.cordX--;
        }
    }


}
