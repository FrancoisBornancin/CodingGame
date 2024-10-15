package org.dontpanic.episode1.gameplay.clone;

import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;

import java.util.List;

public class LeadingCloneUpdater {
    public void changeLeadingClone(GameElementsContainer gameElementsContainer){
        LeadingCloneRetriever leadingCloneRetriever = new LeadingCloneRetriever();
        Clone leadingClone = leadingCloneRetriever.getLeadingClone(gameElementsContainer).get();
        Clone previousClone = leadingClone.previousClone;
        leadingClone.qualifier = CloneQualifier.SOLDIER_CLONE;
        leadingClone.state = CloneState.BLOCKED;
        if(previousClone != null){
            previousClone.qualifier = CloneQualifier.LEADING_CLONE;
            leadingClone.previousClone = null;
        }
    }
}
