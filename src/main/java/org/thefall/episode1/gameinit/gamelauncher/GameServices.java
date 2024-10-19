package org.thefall.episode1.gameinit.gamelauncher;

import org.thefall.episode1.gameplay.elements.exit.ExitDoor;
import org.thefall.episode1.gameplay.elements.tunnel.TunnelMapElementRetriever;
import org.thefall.episode1.gameplay.nextblock.Coordinates;
import org.thefall.episode1.gameplay.nextblock.builder.NextBlockMapBuilder;
import org.thefall.episode1.gameplay.nextblock.info.NextBlockInfo;
import org.thefall.episode1.gameplay.nextblock.info.NextBlockInfoCalculator;

public class GameServices {
    public NextBlockInfoCalculator nextBlockInfoCalculator;
    TunnelMapElementRetriever tunnelMapElementRetriever;
    public String[][] mapTab;
    public ExitDoor exitDoor;
    public Coordinates heroCoordinates;
    NextBlockMapBuilder nextBlockMapBuilder;

    public GameServices() {
        tunnelMapElementRetriever = new TunnelMapElementRetriever();
        this.nextBlockMapBuilder = new NextBlockMapBuilder(tunnelMapElementRetriever);
        this.nextBlockInfoCalculator = new NextBlockInfoCalculator(tunnelMapElementRetriever, nextBlockMapBuilder);
        this.nextBlockInfo = new NextBlockInfo();
        nextBlockInfo.isANonBlockingBlock = false;
    }

    public NextBlockInfo nextBlockInfo;


}
