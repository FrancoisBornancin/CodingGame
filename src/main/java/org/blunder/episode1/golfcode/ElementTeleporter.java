package org.blunder.episode1.golfcode;

public class ElementTeleporter extends ElementBase {
    public ElementTeleporter(int cordX, int cordY){
        this.coordinateX = cordX;
        this.coordinateY = cordY;
        this.qualifier = ElementsQualifiers.TELEPORTER;
    }
}
