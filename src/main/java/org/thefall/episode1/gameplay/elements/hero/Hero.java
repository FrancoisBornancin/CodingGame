package org.thefall.episode1.gameplay.elements.hero;

import org.thefall.episode1.gameplay.elements.support.BaseElement;
import org.thefall.episode1.logging.errors.ElementOutOfMapHeight;
import org.thefall.episode1.logging.errors.ElementOutOfMapWidth;

public class Hero extends BaseElement {
    public HeroDirection heroDirection;
    public Hero(int cordX, int cordY) {
        super(cordX, cordY);
        if(cordX < 0) throw new ElementOutOfMapWidth(cordX);
        if(cordY < 0) throw new ElementOutOfMapHeight(cordY);
    }
}
