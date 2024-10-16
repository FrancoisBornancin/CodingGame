package org.thefall.episode1.logging;

import org.thefall.episode1.gameinit.staticdata.StaticGameInitializedData;
import org.thefall.episode1.gameplay.elements.hero.Hero;

public interface BaseDataLogger {
    void logStaticDatas(StaticGameInitializedData staticGameInitializedData);
    void logDynamicDatas(Hero hero);
    void logDynamicTurnsNumber(int turn);
}
