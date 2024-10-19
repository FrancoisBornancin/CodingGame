package org.thefall.episode2;



import org.thefall.episode2.gameinit.gamelauncher.GameLauncher;
import org.thefall.episode2.gameinit.gamelauncher.ProdGameLauncher;
import org.thefall.episode2.gameinit.staticdata.DataInitializer;
import org.thefall.episode2.gameinit.staticdata.InitializedData;
import org.thefall.episode2.gameinit.staticdata.ProdDataInitializer;

public class Player {
    public static void main(String args[]) {
        DataInitializer dataInitializer = new ProdDataInitializer();
        GameLauncher gameLauncher = new ProdGameLauncher();

        InitializedData initializedData = dataInitializer.initData();

        gameLauncher.launchGame(initializedData);
    }
}
