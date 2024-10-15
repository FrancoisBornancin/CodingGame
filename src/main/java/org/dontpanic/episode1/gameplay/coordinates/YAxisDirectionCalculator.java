package org.dontpanic.episode1.gameplay.coordinates;

import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.elements.BaseElement;
import org.dontpanic.episode1.gameplay.elements.Elevator;
import org.dontpanic.episode1.gameplay.elements.FinishDoor;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;
import org.dontpanic.episode1.gameplay.elements.StartingDoor;

public class YAxisDirectionCalculator {
    GameElementsContainer gameElementsContainer;
    public static YAxisDirection yAxisDirection;
    public YAxisDirectionCalculator(GameElementsContainer gameElementsContainer){
        this.gameElementsContainer = gameElementsContainer;
    }

    public void calculateDirection(){
        FinishDoor finishDoor = gameElementsContainer.finishDoor;
        StartingDoor startingDoor = gameElementsContainer.startingDoor;

        if(finishDoor.cordY > startingDoor.cordY) yAxisDirection = YAxisDirection.BOTTOM_TO_TOP;
        else yAxisDirection = YAxisDirection.TOP_TO_BOTTOM;
    }

    public static boolean isUpperRegardingDirection(Clone leadingClone, BaseElement baseElement){
        if(YAxisDirectionCalculator.yAxisDirection == YAxisDirection.BOTTOM_TO_TOP) return leadingClone.cordY > baseElement.cordY;
        else return leadingClone.cordY < baseElement.cordY;
    }
}
