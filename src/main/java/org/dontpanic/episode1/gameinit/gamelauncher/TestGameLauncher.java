package org.dontpanic.episode1.gameinit.gamelauncher;

import org.dontpanic.episode1.gameplay.Game;
import org.dontpanic.episode1.gameplay.GameAction;
import org.dontpanic.episode1.gameplay.GameServices;
import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.clone.LeadingCloneRetriever;
import org.dontpanic.episode1.gameplay.elements.FinishDoor;
import org.dontpanic.episode1.gameinit.staticdata.InitializedData;
import org.dontpanic.episode1.logging.TestDataLogger;
import org.dontpanic.episode1.utils.Environment;

import java.util.Optional;

public class TestGameLauncher implements GameLauncher{
    GameServices gameServices;
    @Override
    public void launchGame(InitializedData initializedData) {
        gameServices = new GameServices(initializedData, Environment.TEST);
        Game game = new Game();
        LeadingCloneRetriever leadingCloneRetriever = new LeadingCloneRetriever();

        FinishDoor finishDoor;

        doPlayGame(gameServices, game, initializedData);

        boolean isLeadingCloneNotOnFinishDoor = true;

        while (isLeadingCloneNotOnFinishDoor){
            Clone leadingClone;
            Optional<Clone> optionalLeadingClone = leadingCloneRetriever.getLeadingClone(gameServices.gameElementsContainer);
            if(optionalLeadingClone.isPresent()) {
                leadingClone = optionalLeadingClone.get();
                finishDoor = gameServices.gameElementsContainer.finishDoor;
                isLeadingCloneNotOnFinishDoor = !leadingCloneOnFinishDoor(finishDoor, leadingClone);
            }
            else isLeadingCloneNotOnFinishDoor = true;
            if(isLeadingCloneNotOnFinishDoor) doPlayGame(gameServices, game, initializedData);
        }
    }

    private void doPlayGame(GameServices gameServices, Game game, InitializedData initializedData){
        gameServices.countTurn++;
        gameServices.currentGameAction.gameAction = GameAction.WAIT;

        game.play(
                gameServices,
                initializedData.firstClone.direction.value,
                initializedData.firstClone.cordY,
                initializedData.firstClone.cordX
        );
    }

    private boolean leadingCloneOnFinishDoor(FinishDoor finishDoor, Clone leadingClone){
        return leadingClone.cordY == finishDoor.cordY && leadingClone.cordX == finishDoor.cordX;
    }
}
