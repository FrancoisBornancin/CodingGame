package org.thefall.episode1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thefall.episode1.gameplay.elements.tunnel.TunnelMapElementRetriever;
import org.thefall.episode1.gameplay.nextblock.Coordinates;
import org.thefall.episode1.gameplay.nextblock.GameDirection;
import org.thefall.episode1.gameplay.nextblock.info.NextBlockInfo;
import org.thefall.episode1.gameplay.nextblock.info.NextBlockInfoCalculator;
import org.thefall.episode1.gameplay.nextblock.builder.NextBlockMapBuilder;

import java.util.List;

public class NextBlockInfoTest {
    @Test
    void itShouldBeANonBlockingBlock(){
        String currentCordValue = "3";
        String nextCordValue = "7";
        Coordinates coordinates = new Coordinates(1,0,currentCordValue);
        coordinates.direction = GameDirection.DOWN;
        Coordinates nextCoordinates = new Coordinates(1,1,nextCordValue);
        String[][] stringTab = new String[2][];
        stringTab[0] = List.of("0",currentCordValue,"0").toArray(String[]::new);
        stringTab[1] = List.of("0",nextCordValue,"0").toArray(String[]::new);
        TunnelMapElementRetriever tunnelMapElementRetriever = new TunnelMapElementRetriever();
        NextBlockMapBuilder nextBlockMapBuilder = new NextBlockMapBuilder(tunnelMapElementRetriever);
        NextBlockInfoCalculator nextBlockInfoCalculator = new NextBlockInfoCalculator(tunnelMapElementRetriever, nextBlockMapBuilder);
        NextBlockInfo nextBlockInfo = nextBlockInfoCalculator.isNextBlockNonBlocking(stringTab, coordinates, nextCoordinates, new NextBlockInfo());
        Assertions.assertTrue(nextBlockInfo.isANonBlockingBlock);
        Assertions.assertFalse(nextBlockInfo.isAFunnelCase);
    }

    @Test
    void itShouldNotBeANonBlockingBlock(){
        String currentCordValue = "3";
        String nextCordValue = "8";
        Coordinates coordinates = new Coordinates(1,0,currentCordValue);
        coordinates.direction = GameDirection.DOWN;
        Coordinates nextCoordinates = new Coordinates(1,1,nextCordValue);
        String[][] stringTab = new String[2][];
        stringTab[0] = List.of("0",currentCordValue,"0").toArray(String[]::new);
        stringTab[1] = List.of("0",nextCordValue,"0").toArray(String[]::new);
        TunnelMapElementRetriever tunnelMapElementRetriever = new TunnelMapElementRetriever();
        NextBlockMapBuilder nextBlockMapBuilder = new NextBlockMapBuilder(tunnelMapElementRetriever);
        NextBlockInfoCalculator nextBlockInfoCalculator = new NextBlockInfoCalculator(tunnelMapElementRetriever, nextBlockMapBuilder);
        NextBlockInfo nextBlockInfo = nextBlockInfoCalculator.isNextBlockNonBlocking(stringTab, coordinates, nextCoordinates, new NextBlockInfo());
        Assertions.assertFalse(nextBlockInfo.isANonBlockingBlock);
        Assertions.assertFalse(nextBlockInfo.isAFunnelCase);
    }

    @Test
    void block5ShouldBeANonBlockingBlockAndAFunnelCase_case1(){
        String cordValue_N = "3";
        String cordValue_N1 = "5";
        String cordValue_N2 = "8";
        Coordinates coordinates = new Coordinates(1,0,cordValue_N);
        coordinates.direction = GameDirection.DOWN;
        Coordinates nextCoordinates = new Coordinates(1,1,cordValue_N1);
        String[][] stringTab = new String[2][];
        stringTab[0] = List.of("0",cordValue_N,"0").toArray(String[]::new);
        stringTab[1] = List.of("0",cordValue_N1,cordValue_N2).toArray(String[]::new);
        TunnelMapElementRetriever tunnelMapElementRetriever = new TunnelMapElementRetriever();
        NextBlockMapBuilder nextBlockMapBuilder = new NextBlockMapBuilder(tunnelMapElementRetriever);
        NextBlockInfoCalculator nextBlockInfoCalculator = new NextBlockInfoCalculator(tunnelMapElementRetriever, nextBlockMapBuilder);
        NextBlockInfo nextBlockInfo = nextBlockInfoCalculator.isNextBlockNonBlocking(stringTab, coordinates, nextCoordinates, new NextBlockInfo());
        Assertions.assertTrue(nextBlockInfo.isANonBlockingBlock);
        Assertions.assertTrue(nextBlockInfo.isAFunnelCase);
    }

    @Test
    void block5ShouldBeABlockingBlock_case1(){
        String cordValue_N = "3";
        String cordValue_N1 = "5";
        String cordValue_N2 = "7";
        Coordinates coordinates = new Coordinates(1,0,cordValue_N);
        coordinates.direction = GameDirection.DOWN;
        Coordinates nextCoordinates = new Coordinates(1,1,cordValue_N1);
        String[][] stringTab = new String[2][];
        stringTab[0] = List.of("0",cordValue_N,"0").toArray(String[]::new);
        stringTab[1] = List.of("0",cordValue_N1,cordValue_N2).toArray(String[]::new);
        TunnelMapElementRetriever tunnelMapElementRetriever = new TunnelMapElementRetriever();
        NextBlockMapBuilder nextBlockMapBuilder = new NextBlockMapBuilder(tunnelMapElementRetriever);
        NextBlockInfoCalculator nextBlockInfoCalculator = new NextBlockInfoCalculator(tunnelMapElementRetriever, nextBlockMapBuilder);
        NextBlockInfo nextBlockInfo = nextBlockInfoCalculator.isNextBlockNonBlocking(stringTab, coordinates, nextCoordinates, new NextBlockInfo());
        Assertions.assertFalse(nextBlockInfo.isANonBlockingBlock);
        Assertions.assertFalse(nextBlockInfo.isAFunnelCase);
    }

    @Test
    void block5ShouldBeANonBlockingBlockAndAFunnelCase_case2(){
        String cordValue_N = "2";
        String cordValue_N1 = "5";
        String cordValue_N2 = "7";
        Coordinates coordinates = new Coordinates(1,0,cordValue_N);
        coordinates.direction = GameDirection.RIGHT;
        Coordinates nextCoordinates = new Coordinates(2,0,cordValue_N1);
        String[][] stringTab = new String[3][];
        stringTab[0] = List.of("0",cordValue_N,cordValue_N1).toArray(String[]::new);
        stringTab[1] = List.of("0","0",cordValue_N2).toArray(String[]::new);
        TunnelMapElementRetriever tunnelMapElementRetriever = new TunnelMapElementRetriever();
        NextBlockMapBuilder nextBlockMapBuilder = new NextBlockMapBuilder(tunnelMapElementRetriever);
        NextBlockInfoCalculator nextBlockInfoCalculator = new NextBlockInfoCalculator(tunnelMapElementRetriever, nextBlockMapBuilder);
        NextBlockInfo nextBlockInfo = nextBlockInfoCalculator.isNextBlockNonBlocking(stringTab, coordinates, nextCoordinates, new NextBlockInfo());
        Assertions.assertTrue(nextBlockInfo.isANonBlockingBlock);
        Assertions.assertTrue(nextBlockInfo.isAFunnelCase);
    }

    @Test
    void block5ShouldBeABlockingBlock_case2(){
        String cordValue_N = "2";
        String cordValue_N1 = "5";
        String cordValue_N2 = "8";
        Coordinates coordinates = new Coordinates(1,0,cordValue_N);
        coordinates.direction = GameDirection.RIGHT;
        Coordinates nextCoordinates = new Coordinates(2,0,cordValue_N1);
        String[][] stringTab = new String[3][];
        stringTab[0] = List.of("0",cordValue_N,cordValue_N1).toArray(String[]::new);
        stringTab[1] = List.of("0","0",cordValue_N2).toArray(String[]::new);
        TunnelMapElementRetriever tunnelMapElementRetriever = new TunnelMapElementRetriever();
        NextBlockMapBuilder nextBlockMapBuilder = new NextBlockMapBuilder(tunnelMapElementRetriever);
        NextBlockInfoCalculator nextBlockInfoCalculator = new NextBlockInfoCalculator(tunnelMapElementRetriever, nextBlockMapBuilder);
        NextBlockInfo nextBlockInfo = nextBlockInfoCalculator.isNextBlockNonBlocking(stringTab, coordinates, nextCoordinates, new NextBlockInfo());
        Assertions.assertFalse(nextBlockInfo.isANonBlockingBlock);
        Assertions.assertFalse(nextBlockInfo.isAFunnelCase);
    }

    @Test
    void block4ShouldBeANonBlockingBlockAndAFunnelCase_case1(){
        String cordValue_N = "3";
        String cordValue_N1 = "4";
        String cordValue_N2 = "7";
        Coordinates coordinates = new Coordinates(1,0,cordValue_N);
        coordinates.direction = GameDirection.DOWN;
        Coordinates nextCoordinates = new Coordinates(1,1,cordValue_N1);
        String[][] stringTab = new String[2][];
        stringTab[0] = List.of("0",cordValue_N,"0").toArray(String[]::new);
        stringTab[1] = List.of(cordValue_N2,cordValue_N1,"0").toArray(String[]::new);
        TunnelMapElementRetriever tunnelMapElementRetriever = new TunnelMapElementRetriever();
        NextBlockMapBuilder nextBlockMapBuilder = new NextBlockMapBuilder(tunnelMapElementRetriever);
        NextBlockInfoCalculator nextBlockInfoCalculator = new NextBlockInfoCalculator(tunnelMapElementRetriever, nextBlockMapBuilder);
        NextBlockInfo nextBlockInfo = nextBlockInfoCalculator.isNextBlockNonBlocking(stringTab, coordinates, nextCoordinates, new NextBlockInfo());
        Assertions.assertTrue(nextBlockInfo.isANonBlockingBlock);
        Assertions.assertTrue(nextBlockInfo.isAFunnelCase);
    }

    @Test
    void block4ShouldBeABlockingBlock_case1(){
        String cordValue_N = "3";
        String cordValue_N1 = "4";
        String cordValue_N2 = "9";
        Coordinates coordinates = new Coordinates(1,0,cordValue_N);
        coordinates.direction = GameDirection.DOWN;
        Coordinates nextCoordinates = new Coordinates(1,1,cordValue_N1);
        String[][] stringTab = new String[2][];
        stringTab[0] = List.of("0",cordValue_N,"0").toArray(String[]::new);
        stringTab[1] = List.of(cordValue_N2,cordValue_N1,"0").toArray(String[]::new);
        TunnelMapElementRetriever tunnelMapElementRetriever = new TunnelMapElementRetriever();
        NextBlockMapBuilder nextBlockMapBuilder = new NextBlockMapBuilder(tunnelMapElementRetriever);
        NextBlockInfoCalculator nextBlockInfoCalculator = new NextBlockInfoCalculator(tunnelMapElementRetriever, nextBlockMapBuilder);
        NextBlockInfo nextBlockInfo = nextBlockInfoCalculator.isNextBlockNonBlocking(stringTab, coordinates, nextCoordinates, new NextBlockInfo());
        Assertions.assertFalse(nextBlockInfo.isANonBlockingBlock);
        Assertions.assertFalse(nextBlockInfo.isAFunnelCase);
    }

    @Test
    void block4ShouldBeANonBlockingBlockAndAFunnelCase_case2(){
        String cordValue_N = "2";
        String cordValue_N1 = "4";
        String cordValue_N2 = "7";
        Coordinates coordinates = new Coordinates(1,0,cordValue_N);
        coordinates.direction = GameDirection.LEFT;
        Coordinates nextCoordinates = new Coordinates(0,0,cordValue_N1);
        String[][] stringTab = new String[2][];
        stringTab[0] = List.of(cordValue_N1,cordValue_N,"0").toArray(String[]::new);
        stringTab[1] = List.of(cordValue_N2,"0","0").toArray(String[]::new);
        TunnelMapElementRetriever tunnelMapElementRetriever = new TunnelMapElementRetriever();
        NextBlockMapBuilder nextBlockMapBuilder = new NextBlockMapBuilder(tunnelMapElementRetriever);
        NextBlockInfoCalculator nextBlockInfoCalculator = new NextBlockInfoCalculator(tunnelMapElementRetriever, nextBlockMapBuilder);
        NextBlockInfo nextBlockInfo = nextBlockInfoCalculator.isNextBlockNonBlocking(stringTab, coordinates, nextCoordinates, new NextBlockInfo());
        Assertions.assertTrue(nextBlockInfo.isANonBlockingBlock);
        Assertions.assertTrue(nextBlockInfo.isAFunnelCase);
    }

    @Test
    void block4ShouldBeABlockingBlock_case2(){
        String cordValue_N = "2";
        String cordValue_N1 = "4";
        String cordValue_N2 = "8";
        Coordinates coordinates = new Coordinates(1,0,cordValue_N);
        coordinates.direction = GameDirection.LEFT;
        Coordinates nextCoordinates = new Coordinates(0,0,cordValue_N1);
        nextCoordinates.direction = GameDirection.DOWN;
        String[][] stringTab = new String[2][];
        stringTab[0] = List.of(cordValue_N1,cordValue_N,"0").toArray(String[]::new);
        stringTab[1] = List.of(cordValue_N2,"0","0").toArray(String[]::new);
        TunnelMapElementRetriever tunnelMapElementRetriever = new TunnelMapElementRetriever();
        NextBlockMapBuilder nextBlockMapBuilder = new NextBlockMapBuilder(tunnelMapElementRetriever);
        NextBlockInfoCalculator nextBlockInfoCalculator = new NextBlockInfoCalculator(tunnelMapElementRetriever, nextBlockMapBuilder);
        NextBlockInfo nextBlockInfo = nextBlockInfoCalculator.isNextBlockNonBlocking(stringTab, coordinates, nextCoordinates, new NextBlockInfo());
        Assertions.assertFalse(nextBlockInfo.isANonBlockingBlock);
        Assertions.assertFalse(nextBlockInfo.isAFunnelCase);
    }
}
