package org.thefall.episode1.gameplay.elements.hero;

public enum HeroDirection {
    RIGHT("RIGHT"),
    LEFT("LEFT"),
    DOWN("DOWN");

    public String value;
    HeroDirection(String value) {
        this.value = value;
    }
}
