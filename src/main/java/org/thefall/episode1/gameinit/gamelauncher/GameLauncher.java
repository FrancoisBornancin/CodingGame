package org.thefall.episode1.gameinit.gamelauncher;

import org.thefall.episode1.gameinit.staticdata.InitializedData;
import org.thefall.episode1.logging.BaseDataLogger;

public interface GameLauncher {
    void launchGame(InitializedData initializedData, BaseDataLogger baseDataLogger);
}
