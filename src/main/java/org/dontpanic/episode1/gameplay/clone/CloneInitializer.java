package org.dontpanic.episode1.gameplay.clone;

import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;
import org.dontpanic.episode1.gameplay.elements.StartingDoor;

import java.util.List;

public class CloneInitializer {
    public void addNewClone(GameElementsContainer gameElementsContainer, CloneDirection startingDirection){
        StartingDoor startingDoor = gameElementsContainer.startingDoor;

        List<Clone> notBlockedClones =
                gameElementsContainer.cloneList.stream()
                        .filter(clone -> clone.state != CloneState.BLOCKED)
                        .toList();

        CloneQualifier cloneQualifier;
        if(notBlockedClones.isEmpty()) cloneQualifier = CloneQualifier.LEADING_CLONE;
        else cloneQualifier = CloneQualifier.SOLDIER_CLONE;

        Clone newClone = new Clone(startingDoor.cordX, startingDoor.cordY, cloneQualifier, CloneState.NOT_BLOCKED, startingDirection);

        if(!notBlockedClones.isEmpty()){
            Clone cloneToLinkTo = getCloneToLinkTo(gameElementsContainer);
            cloneToLinkTo.previousClone = newClone;
        }

        gameElementsContainer.cloneList.add(newClone);
    }

    private Clone getCloneToLinkTo(GameElementsContainer gameElementsContainer){
        return gameElementsContainer.cloneList.stream()
                .filter(clone -> clone.state != CloneState.BLOCKED)
                .filter(clone -> clone.previousClone == null)
                .findFirst().get();
    }
}
