package org.thefall.episode1.logging;

import org.thefall.episode1.gameinit.staticdata.StaticGameInitializedData;
import org.thefall.episode1.gameplay.elements.hero.Hero;

import java.io.PrintStream;

public class TestDataLogger implements BaseDataLogger{
    PrintStream printStream = System.err;

    @Override
    public void logStaticDatas(StaticGameInitializedData staticGameInitializedData){

    }

    @Override
    public void logDynamicDatas(Hero hero) {
        printStream.println("Hero cordX: " + hero.cordX);
        printStream.println("Hero cordY: " + hero.cordY);
        printStream.println("Hero direction: " + hero.heroDirection);
    }

    @Override
    public void logDynamicTurnsNumber(int turn) {
        printStream.println("turn n°: " + turn);
    }
}
