package org.thefall.episode2.gameplay.nextblock.info;

import org.thefall.episode2.gameplay.nextblock.Coordinates;

public class MovableBlockQualifier {
    public boolean isMovable(String nextMapValue){
        return Integer.parseInt(nextMapValue) > 0;
    }
}
