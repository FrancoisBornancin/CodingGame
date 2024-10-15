package org.dontpanic.episode1.gameplay.elements;

import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirection;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirectionCalculator;

import java.util.List;
import java.util.Optional;

public class NearestElevatorRetriever {
    public Optional<Elevator> getNearestElevator(Clone clone, List<Elevator> elevatorList){
        List<Elevator> notBlockedElevators =
                elevatorList.stream()
                        .filter(elevator -> elevator.clone == null)
                        .toList();

        if(notBlockedElevators.isEmpty()) return Optional.empty();
        else {
            Optional<Elevator> optionalStrictlyUnderElevator =
                    notBlockedElevators.stream()
                            .filter(elevator -> isStrictlyUnder(elevator, clone))
                            .findFirst();

            if(optionalStrictlyUnderElevator.isPresent()) return optionalStrictlyUnderElevator;
            else {
                return notBlockedElevators.stream()
                        .filter(elevator -> elevator.cordY == clone.cordY)
                        .findFirst();
            }
        }
    }

    private boolean isStrictlyUnder(Elevator elevator, Clone clone){
        int elevatorYcoordinateToCompare;
        if(YAxisDirectionCalculator.yAxisDirection == YAxisDirection.BOTTOM_TO_TOP) elevatorYcoordinateToCompare = 1;
        else elevatorYcoordinateToCompare = -1;
        return clone.cordY == (elevator.cordY + elevatorYcoordinateToCompare) && clone.cordX == elevator.cordX;
    }
}
