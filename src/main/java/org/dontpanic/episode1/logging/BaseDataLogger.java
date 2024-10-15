package org.dontpanic.episode1.logging;

import org.dontpanic.episode1.gameinit.staticdata.StaticGameInitializedData;

public interface BaseDataLogger {
    void logStaticDatas(StaticGameInitializedData staticGameInitializedData);
    void logStartingCloneInfos(int floor, int position, String direction);
    void logDynamicTurnNumber(int turn);
}
