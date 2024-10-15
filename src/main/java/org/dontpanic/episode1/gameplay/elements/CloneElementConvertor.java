package org.dontpanic.episode1.gameplay.elements;

import org.dontpanic.episode1.gameplay.clone.CloneQualifier;
import org.dontpanic.episode1.gameplay.clone.CloneState;

import java.util.Map;

public class CloneElementConvertor {
    public static Map<CloneQualifier, GameElements> cloneQualifierToElementMap =
        Map.of(
            CloneQualifier.SOLDIER_CLONE, GameElements.SOLDIER_CLONE,
            CloneQualifier.LEADING_CLONE, GameElements.LEADING_CLONE
        );

    public static Map<CloneState, GameElements> cloneStateToElementMap =
            Map.of(CloneState.BLOCKED, GameElements.BLOCKED_CLONE);
}
