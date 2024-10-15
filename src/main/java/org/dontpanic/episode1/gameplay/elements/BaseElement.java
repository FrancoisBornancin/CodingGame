package org.dontpanic.episode1.gameplay.elements;

public abstract class BaseElement {
    public int cordX;
    public int cordY;

    public BaseElement(int cordX, int cordY) {
        this.cordX = cordX;
        this.cordY = cordY;
    }
}
