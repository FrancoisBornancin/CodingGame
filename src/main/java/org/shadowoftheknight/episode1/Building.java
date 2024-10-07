package org.shadowoftheknight.episode1;

public class Building {
    int width;
    int height;

    public Building(int Width, int height){
        this.width = Width;
        this.height = height;

        System.err.println("buildingWidth: " + Width);
        System.err.println("buildingHeight: " + height);
    }
}
