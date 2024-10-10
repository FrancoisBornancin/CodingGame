package org.blunder.episode1.golfcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlunderMover {
    Direction direction;
    Direction directionToPrint;
    PrioritiesInversor prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
    Movements movements = Movements.CONTINUE;
    List<BlunderPosition> blunderPositionList;
    Map<PrioritiesInversor, List<Direction>> prioritiesMap;
    int prioritiesCount;

    public void move(Blunder blunder, MapScanner mapScanner){
        try {
            if(blunder.bunderPath == null) blunder.bunderPath = new ArrayList<>();
            if(blunderPositionList == null) blunderPositionList = new ArrayList<>();
            updateCoordinatesAndDirection(blunder, mapScanner);

            BlunderPosition blunderPosition = new BlunderPosition(blunder.coordinateX, blunder.coordinateY, direction);
            if((isBlunderPositionAlreadyPresent(blunderPosition) && blunder.beers == 0)) movements = Movements.LOOP;

            blunderPositionList.add(blunderPosition);

            blunder.bunderPath.add(directionToPrint);
        }catch (ArrayIndexOutOfBoundsException e){
            movements = Movements.LOOP;
        }
    }

    private boolean isBlunderPositionAlreadyPresent(BlunderPosition blunderPosition){
        try {
            int count = (int) blunderPositionList.stream()
                    .filter(blunderPos ->
                            blunderPos.cordX == blunderPosition.cordX
                        && blunderPos.cordY == blunderPosition.cordY
                        && blunderPos.direction == blunderPosition.direction
                    ).count();
            if(count > 2) return true;
            else return false;
        }catch (Exception e){
            return false;
        }
    }

    private void updateCoordinatesAndDirection(Blunder blunder, MapScanner mapScanner){
        if(direction.equals(Direction.SOUTH)) moveSouth(blunder, mapScanner);
        else if(this.direction.equals(Direction.EAST)) moveEast(blunder, mapScanner);
        else if(this.direction.equals(Direction.NORTH)) moveNorth(blunder, mapScanner);
        else moveWest(blunder, mapScanner);
    }

    private boolean manageSpecificCases(Character elementInMap, MapScanner mapScanner, Blunder blunder){
        if(elementInMap.equals(ElementsQualifiers.END_ELEMENT)) this.movements = Movements.STOP;
        if(elementInMap.equals(ElementsQualifiers.NORTH_ELEMENT)) this.direction = Direction.NORTH;
        if(elementInMap.equals(ElementsQualifiers.SOUTH_ELEMENT)) this.direction = Direction.SOUTH;
        if(elementInMap.equals(ElementsQualifiers.WEST_ELEMENT)) this.direction = Direction.WEST;
        if(elementInMap.equals(ElementsQualifiers.EAST_ELEMENT)) this.direction = Direction.EAST;
        if(elementInMap.equals(ElementsQualifiers.INVERSOR)){
            if(prioritiesInversor.equals(PrioritiesInversor.REVERSE_PRIORITIES)) prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            else prioritiesInversor = PrioritiesInversor.REVERSE_PRIORITIES;
        };
        if(elementInMap.equals(ElementsQualifiers.BEER)) blunder.drinkBeer();
        if(elementInMap.equals(ElementsQualifiers.BREAKABLE_OBSTACLE)) {
            BlunderBreaker blunderBreaker = new BlunderBreaker();
            boolean obstacleIsBroken = blunderBreaker.breakObstacle(blunder, mapScanner);
            if(!obstacleIsBroken) throw new IndexOutOfBoundsException();
            else return false;
        };
        if(elementInMap.equals(ElementsQualifiers.NO_BREAKABLE_OBSTACLE)) throw new IndexOutOfBoundsException();
        if(elementInMap.equals(ElementsQualifiers.TELEPORTER)) return moveToNextTeleporter(mapScanner, blunder);
        return false;
    }

    private boolean moveToNextTeleporter(MapScanner mapScanner, Blunder blunder){
        boolean hasMoved = false;

        mapScanner.findRemainingTeleports();
        ElementTeleporter elementTeleporter = getNextTeleporter(mapScanner);
        blunder.coordinateX = elementTeleporter.coordinateX;
        blunder.coordinateY = elementTeleporter.coordinateY;

        hasMoved = true;
        return hasMoved;
    }

    private ElementTeleporter getNextTeleporter(MapScanner mapScanner){
        return mapScanner.teleporterElements.stream()
                .filter(teleporter -> {
                    return (teleporter.coordinateX != mapScanner.nextCordX)
                            || (teleporter.coordinateY != mapScanner.nextCordY);
                })
                .findFirst().get();
    }

    private boolean getNextElementInMap(MapScanner mapScanner, Blunder blunder){
        this.directionToPrint = direction;
        Character elementInMap = mapScanner.map.get(mapScanner.nextCordY).charAt(mapScanner.nextCordX);
        boolean wasAnCoordinatesChanger = manageSpecificCases(elementInMap, mapScanner, blunder);
        if(prioritiesCount != 0) prioritiesCount = 0;
        return wasAnCoordinatesChanger;
    }

    private Character getNextCharValue(MapScanner mapScanner){
        return mapScanner.map.get(mapScanner.nextCordY).charAt(mapScanner.nextCordX);
    }

    private void goRegardingPriorities(Blunder blunder, MapScanner mapScanner){
        prioritiesCount++;
        Direction directionToGo = prioritiesMap.get(prioritiesInversor).get(prioritiesCount);
        if(directionToGo.equals(Direction.SOUTH)) updateAndMoveSouth(blunder, mapScanner);
        if(directionToGo.equals(Direction.NORTH)) updateAndMoveNorth(blunder, mapScanner);
        if(directionToGo.equals(Direction.EAST)) updateAndMoveEast(blunder, mapScanner);
        if(directionToGo.equals(Direction.WEST)) updateAndMoveWest(blunder, mapScanner);
    }

    private void moveEast(Blunder blunder, MapScanner mapScanner){
        try{
            mapScanner.nextCordX = blunder.coordinateX + 1;
            mapScanner.nextCordY = blunder.coordinateY;
            boolean wasAnCoordinatesChanger = getNextElementInMap(mapScanner, blunder);
            if(!wasAnCoordinatesChanger) blunder.coordinateX++;
        }catch (IndexOutOfBoundsException e){
            goRegardingPriorities(blunder, mapScanner);
        }
    }

    private void moveSouth(Blunder blunder, MapScanner mapScanner){
        try{
            mapScanner.nextCordX = blunder.coordinateX;
            mapScanner.nextCordY = blunder.coordinateY + 1;
            boolean wasAnCoordinatesChanger = getNextElementInMap(mapScanner, blunder);
            if(!wasAnCoordinatesChanger) blunder.coordinateY++;
        }catch (IndexOutOfBoundsException e){
            goRegardingPriorities(blunder, mapScanner);
        }
    }

    private void moveNorth(Blunder blunder, MapScanner mapScanner){
        try{
            mapScanner.nextCordX = blunder.coordinateX;
            mapScanner.nextCordY = blunder.coordinateY - 1;
            boolean wasAnCoordinatesChanger = getNextElementInMap(mapScanner, blunder);
            if(!wasAnCoordinatesChanger) blunder.coordinateY--;
        }catch (IndexOutOfBoundsException e){
            goRegardingPriorities(blunder, mapScanner);
        }
    }

    private void moveWest(Blunder blunder, MapScanner mapScanner){
        try{
            mapScanner.nextCordX = blunder.coordinateX - 1;
            mapScanner.nextCordY = blunder.coordinateY;
            boolean wasAnCoordinatesChanger = getNextElementInMap(mapScanner, blunder);
            if(!wasAnCoordinatesChanger) blunder.coordinateX--;
        }catch (IndexOutOfBoundsException e){
            goRegardingPriorities(blunder, mapScanner);
        }
    }

    private void updateAndMoveSouth(Blunder blunder, MapScanner mapScanner){
        this.direction = Direction.SOUTH;
        moveSouth(blunder, mapScanner);
    }

    private void updateAndMoveWest(Blunder blunder, MapScanner mapScanner){
        this.direction = Direction.WEST;
        moveWest(blunder, mapScanner);
    }

    private void updateAndMoveNorth(Blunder blunder, MapScanner mapScanner){
        this.direction = Direction.NORTH;
        moveNorth(blunder, mapScanner);
    }

    private void updateAndMoveEast(Blunder blunder, MapScanner mapScanner){
        this.direction = Direction.EAST;
        moveEast(blunder, mapScanner);
    }

}
