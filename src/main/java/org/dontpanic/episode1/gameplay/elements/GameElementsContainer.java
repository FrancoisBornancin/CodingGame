package org.dontpanic.episode1.gameplay.elements;

import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirection;

import java.util.List;

public class GameElementsContainer {
    public List<Clone> cloneList;
    public List<Elevator> elevatorList;
    public FinishDoor finishDoor;
    public StartingDoor startingDoor;
    public YAxisDirection yAxisDirection;
}
