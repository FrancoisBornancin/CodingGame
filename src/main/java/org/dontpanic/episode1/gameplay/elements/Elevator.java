package org.dontpanic.episode1.gameplay.elements;

import org.dontpanic.episode1.gameplay.clone.Clone;

public class Elevator extends BaseElement{
    public Clone clone;
    public Elevator(int cordX, int cordY) {
        super(cordX, cordY);
    }

    public void linkClone(Clone clone){
        if(this.clone != null) this.clone = clone;
        else throw new IllegalStateException("A clone has already been associated to that elevator");
    }
}
