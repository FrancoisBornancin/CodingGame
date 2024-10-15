package org.dontpanic.episode1.gameplay.coordinates;

import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.elements.BaseElement;

public class XCoordinatesComparator {
    public boolean elementOnCloneRight(Clone clone, BaseElement baseElement2){
        return (baseElement2.cordX - clone.cordX) > 0;
    }
    public boolean elementOnCloneLeft(Clone clone, BaseElement baseElement2){
        return (clone.cordX - baseElement2.cordX) > 0;
    }
}
