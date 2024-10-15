package org.dontpanic.episode1;

import org.dontpanic.episode1.gameinit.gamelauncher.GameLauncher;
import org.dontpanic.episode1.gameinit.gamelauncher.ProdGameLauncher;
import org.dontpanic.episode1.gameinit.staticdata.DataInitializer;
import org.dontpanic.episode1.gameinit.staticdata.InitializedData;
import org.dontpanic.episode1.gameinit.staticdata.ProdDataInitializer;
import org.dontpanic.episode1.logging.ProdDataLogger;

public class Player {
    public static void main(String args[]) {
        DataInitializer dataInitializer = new ProdDataInitializer();
        GameLauncher gameLauncher = new ProdGameLauncher();

        InitializedData initializedData = dataInitializer.initData(new ProdDataLogger());

        gameLauncher.launchGame(initializedData);
    }
}
