package org.dontpanic.episode1;

import org.dontpanic.episode1.gameplay.Game;
import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.clone.CloneDirection;
import org.dontpanic.episode1.gameplay.clone.LeadingCloneUpdater;
import org.dontpanic.episode1.gameplay.clone.CloneQualifier;
import org.dontpanic.episode1.gameplay.clone.CloneState;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LeadingCloneUpdaterTest {

    @Test
    void itShouldChangeTheLeadingClone(){
        LeadingCloneUpdater leadingCloneUpdater = new LeadingCloneUpdater();
        Clone clone1 = new Clone(2, 3, CloneQualifier.LEADING_CLONE, CloneState.BLOCKED, CloneDirection.RIGHT);
        Clone clone2 = new Clone(2, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone clone3 = new Clone(2, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        clone1.previousClone = clone3;

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList =
                List.of(clone1, clone2, clone3);

        leadingCloneUpdater.changeLeadingClone(gameElementsContainer);

        Clone leadingClone =
            gameElementsContainer.cloneList.stream()
                .filter(soldierClone -> soldierClone.qualifier == CloneQualifier.LEADING_CLONE)
                .findFirst().get();

        Assertions.assertEquals(leadingClone, clone3);
    }

    @Test
    void itShouldBlockThePreviousLeadingClone(){
        LeadingCloneUpdater leadingCloneUpdater = new LeadingCloneUpdater();
        Clone previousLeadingClone = new Clone(2, 3, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone clone2 = new Clone(2, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone newLeadingClone = new Clone(2, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        previousLeadingClone.previousClone = newLeadingClone;

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList =
                List.of(previousLeadingClone, clone2, newLeadingClone);

        leadingCloneUpdater.changeLeadingClone(gameElementsContainer);

        Assertions.assertEquals(CloneState.BLOCKED, previousLeadingClone.state);
    }

    @Test
    void itThePreviousLeadingCloneShouldBeASoldierNow(){
        LeadingCloneUpdater leadingCloneUpdater = new LeadingCloneUpdater();
        Clone previousLeadingClone = new Clone(2, 3, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone clone2 = new Clone(2, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone newLeadingClone = new Clone(2, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        previousLeadingClone.previousClone = newLeadingClone;

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList =
                List.of(previousLeadingClone, clone2, newLeadingClone);

        leadingCloneUpdater.changeLeadingClone(gameElementsContainer);

        Assertions.assertEquals(CloneQualifier.SOLDIER_CLONE, previousLeadingClone.qualifier);
    }
}
