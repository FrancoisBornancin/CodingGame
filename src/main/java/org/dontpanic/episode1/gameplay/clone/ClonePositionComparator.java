package org.dontpanic.episode1.gameplay.clone;

import org.dontpanic.episode1.gameplay.coordinates.YAxisDirectionCalculator;
import org.dontpanic.episode1.gameplay.elements.BaseElement;
import org.dontpanic.episode1.gameplay.coordinates.XCoordinatesComparator;

import java.util.Optional;

public class ClonePositionComparator {
    private XCoordinatesComparator xCordComparator;
    public boolean isCloneAboveUpperBlockedClone(Clone leadingClone, Optional<Clone> optionalUpperBlockedClone, BaseElement baseElement){
        this.xCordComparator = new XCoordinatesComparator();

        if(!optionalUpperBlockedClone.isPresent()) return true;
        else {
            Clone upperBlockClone = optionalUpperBlockedClone.get();
            if(YAxisDirectionCalculator.isUpperRegardingDirection(leadingClone, upperBlockClone)) return true;
            if(leadingClone.cordY == upperBlockClone.cordY){
                if(xCordComparator.elementOnCloneLeft(leadingClone, upperBlockClone) && xCordComparator.elementOnCloneRight(leadingClone, baseElement)){
                    return true;
                }
                else if(xCordComparator.elementOnCloneRight(leadingClone, upperBlockClone) && xCordComparator.elementOnCloneLeft(leadingClone, baseElement)){
                    return true;
                }
            }
        }

        return false;
    }
}
