package org.thefall.episode1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.thefall.episode1.gameinit.gamelauncher.GameLauncher;
import org.thefall.episode1.gameinit.gamelauncher.TestGameLauncher;
import org.thefall.episode1.gameinit.staticdata.InitializedData;
import org.thefall.episode1.gameinit.staticdata.StaticGameInitializedData;
import org.thefall.episode1.gameplay.elements.exit.ExitDoor;
import org.thefall.episode1.gameplay.elements.hero.Hero;
import org.thefall.episode1.logging.BaseDataLogger;
import org.thefall.episode1.logging.TestDataLogger;

import java.util.List;

public class GameTest {

    @Nested
    public class stupidTest{
        private InitializedData initData(){
            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData =
                    new StaticGameInitializedData(
                            List.of(
                                    "0 3 0",
                                    "0 3 0",
                                    "0 3 0"
                            ),
                            1
                    );
            initializedData.hero = new Hero(1, 0);
            initializedData.exitDoor = new ExitDoor(1, 2);

            return initializedData;
        }
        @Test @Disabled
        void doStuff(){
            BaseDataLogger baseDataLogger = new TestDataLogger();
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData(), baseDataLogger);
        }
    }
}
