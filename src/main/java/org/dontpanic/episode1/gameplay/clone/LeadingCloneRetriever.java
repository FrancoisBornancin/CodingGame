package org.dontpanic.episode1.gameplay.clone;

import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;

import java.util.Optional;

public class LeadingCloneRetriever {
    public Optional<Clone> getLeadingClone(GameElementsContainer gameElementsContainer){
        return gameElementsContainer.cloneList.stream()
                .filter(clone -> clone.qualifier.equals(CloneQualifier.LEADING_CLONE))
                .findFirst();
    }
}
