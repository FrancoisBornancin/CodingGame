package org.dontpanic.episode1.gameplay.clone;

import org.dontpanic.episode1.gameplay.elements.BaseElement;

public class Clone extends BaseElement {
    public CloneQualifier qualifier;
    public CloneState state;
    public CloneDirection direction;
    public Clone previousClone;

    public Clone(int cordX, int cordY, CloneDirection direction) {
        super(cordX, cordY);
        this.direction = direction;
    }

    public Clone(int cordX, int cordY, CloneQualifier qualifier, CloneState state, CloneDirection direction) {
        super(cordX, cordY);
        this.qualifier = qualifier;
        this.state = state;
        this.direction = direction;
    }
}
