package org.dontpanic.episode1.logging;

import org.dontpanic.episode1.gameinit.staticdata.StaticGameInitializedData;

import java.io.PrintStream;

public class TestDataLogger implements BaseDataLogger{
    PrintStream printStream = System.out;

    @Override
    public void logStaticDatas(StaticGameInitializedData staticGameInitializedData) {

    }

    @Override
    public void logStartingCloneInfos(int floor, int position, String direction) {
    }

    @Override
    public void logDynamicTurnNumber(int turn) {
        printStream.println("turn n°: " + turn);
    }
}
