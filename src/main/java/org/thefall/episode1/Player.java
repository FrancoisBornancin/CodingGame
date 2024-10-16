package org.thefall.episode1;



import org.thefall.episode1.gameinit.gamelauncher.GameLauncher;
import org.thefall.episode1.gameinit.gamelauncher.ProdGameLauncher;
import org.thefall.episode1.gameinit.staticdata.DataInitializer;
import org.thefall.episode1.gameinit.staticdata.InitializedData;
import org.thefall.episode1.gameinit.staticdata.ProdDataInitializer;
import org.thefall.episode1.logging.BaseDataLogger;
import org.thefall.episode1.logging.ProdDataLogger;

import java.util.Scanner;

public class Player {
    public static void main(String args[]) {
        DataInitializer dataInitializer = new ProdDataInitializer();
        GameLauncher gameLauncher = new ProdGameLauncher();
        BaseDataLogger baseDataLogger = new ProdDataLogger();

        InitializedData initializedData = dataInitializer.initData();
        baseDataLogger.logStaticDatas(initializedData.staticGameInitializedData);

        gameLauncher.launchGame(initializedData, baseDataLogger);
    }
}
