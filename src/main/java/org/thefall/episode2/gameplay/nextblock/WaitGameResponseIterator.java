package org.thefall.episode2.gameplay.nextblock;

import org.thefall.episode2.gameplay.Game;
import org.thefall.episode2.gameplay.GameResponse;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class WaitGameResponseIterator {
    public int getNextWaitIndex(List<GameResponse> gameResponseList){
        ListIterator<GameResponse> gameResponseListIterator =
                gameResponseList.listIterator();

        while (gameResponseListIterator.hasNext()){
            GameResponse gameResponse = gameResponseListIterator.next();
            if(gameResponse.gameDirection == null) return gameResponseListIterator.previousIndex();
        }
        return -1;
    }

    public void recalculatedReverseDirection(List<GameResponse> gameResponseList){
        gameResponseList.stream()
                .filter(gameResponse -> gameResponse.gameDirection == GameDirection.REVERSE)
                .peek(gameResponse -> gameResponse.gameDirection = GameDirection.RIGHT)
                .forEach(gameResponse -> updateWaitGameResponse(gameResponse, gameResponseList));
    }

    private void updateWaitGameResponse(GameResponse gameResponse, List<GameResponse> gameResponseList){
        ListIterator<GameResponse> listIterator =
                gameResponseList.stream()
                        .toList()
                        .listIterator();

        Optional<ListIterator<GameResponse>> optionalListIterator = iterateTowardNewRightResponse(listIterator, gameResponse);
        if(optionalListIterator.isPresent()){
            ListIterator<GameResponse> gameResponseListIterator = optionalListIterator.get();
            iterateTowardNearWaitResponse(gameResponseListIterator, gameResponse);
        }
    }

    private void iterateTowardNearWaitResponse(ListIterator<GameResponse> listIterator, GameResponse gameResponse){
        while (listIterator.hasPrevious()){
            if(listIterator.previous().gameDirection == null){
                GameResponse waitResponse = listIterator.next();
                waitResponse.coordinates = gameResponse.coordinates;
                waitResponse.gameDirection = gameResponse.gameDirection;
                return;
            }
        }
    }

    private Optional<ListIterator<GameResponse>> iterateTowardNewRightResponse(ListIterator<GameResponse> listIterator, GameResponse gameResponse){
        while (listIterator.hasNext()){
            if(listIterator.next().coordinates.equals(gameResponse.coordinates)){
                return Optional.of(listIterator);
            }
        }
        return Optional.empty();
    }


}
