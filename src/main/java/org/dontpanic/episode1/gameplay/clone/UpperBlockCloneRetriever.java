package org.dontpanic.episode1.gameplay.clone;

import org.dontpanic.episode1.gameplay.coordinates.YAxisDirection;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirectionCalculator;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UpperBlockCloneRetriever {
    public Optional<Clone> getUpperBlockClone(List<Clone> cloneList){
        Optional<Clone> optionalUpperBlockedClone =
                cloneList.stream()
                        .filter(cloneToRetrieve -> cloneToRetrieve.state == CloneState.BLOCKED)
                        .findFirst();

        if(optionalUpperBlockedClone.isEmpty()) return Optional.empty();
        else {
            return cloneList.stream()
                    .filter(clone -> clone.state == CloneState.BLOCKED)
                    .filter(blockedClone -> blockedClone.cordY == getUpperYClones(cloneList))
                    .findFirst();
        }
    }

    private int getUpperYClones(List<Clone> cloneList){
        List<Integer> blockedCloneYList =
                cloneList.stream()
                        .filter(cloneToRetrieve -> cloneToRetrieve.state == CloneState.BLOCKED)
                        .map(blockedClone -> blockedClone.cordY)
                        .toList();
        if(YAxisDirectionCalculator.yAxisDirection == YAxisDirection.BOTTOM_TO_TOP) return Collections.max(blockedCloneYList);
        else return Collections.min(blockedCloneYList);
    }
}
