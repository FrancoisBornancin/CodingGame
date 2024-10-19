package org.thefall.episode2.gameinit.gamelauncher;

import org.thefall.episode2.gameplay.elements.exit.ExitDoor;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.FunnelCoordinatesListUpdater;
import org.thefall.episode2.gameplay.nextblock.builder.TurnBlockMapBuilder;
import org.thefall.episode2.gameplay.nextblock.info.FunnelCoordinatesContainer;
import org.thefall.episode2.gameplay.nextblock.info.HeroPathCalculator;
import org.thefall.episode2.gameplay.rocks.RockBlocker;

import java.util.List;

public class GameServices {
    public HeroPathCalculator heroPathCalculator;
    public Coordinates heroCoordinates;
    public FunnelCoordinatesListUpdater funnelCoordinatesListUpdater;
    public RockBlocker rockBlocker;
    public String[][] mapTab;
    public ExitDoor exitDoor;
    public List<Coordinates> rockList;
    public int countTurn = 0;

    public GameServices(FunnelCoordinatesContainer funnelCoordinatesContainer, String[][] mapTab, ExitDoor exitDoor) {
        this.funnelCoordinatesListUpdater = new FunnelCoordinatesListUpdater(funnelCoordinatesContainer);
        this.heroPathCalculator = new HeroPathCalculator(funnelCoordinatesContainer);
        this.heroPathCalculator.mapTab = mapTab;
        this.heroPathCalculator.exitDoor = exitDoor;
        this.mapTab = mapTab;
        this.exitDoor = exitDoor;
        this.rockBlocker = new RockBlocker(funnelCoordinatesListUpdater, mapTab);
    }


}
