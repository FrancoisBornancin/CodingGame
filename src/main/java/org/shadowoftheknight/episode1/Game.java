package org.shadowoftheknight.episode1;

public class Game {

    public String play(Player player, Bomb bomb, Batman batman, Building building){
        initValues(player, bomb, batman, building);

        int countTurn = 0;

        System.err.println("");

        // game loop
        while (this.possiblyContinueLoop(bomb, batman, player.useCodeGymValues)) {
            countTurn ++;
            if(countTurn > player.N){
                return "YOU LOST";
            }else {
                bomb.updateBeforeDirection();
                bomb.updateActualDirection(player, batman);

                batman.updateCoordinates(bomb);

                System.err.println("");

                System.err.println("bombDir: " + bomb.actualDir);
                System.err.println("bombDirX: " + bomb.coordinateX + " bombDirY: " + bomb.coordinateY);
                System.err.println("player.actualX: " + batman.actualX + " player.actualY: " + batman.actualY);
                System.out.println(("" + batman.actualX) + " " + ("" + batman.actualY));

                bomb.updateBeforeDirectionAfterEachTurn();
            }
        }
        return "YOU WIN";
    }

    private void initValues(Player player, Bomb bomb, Batman batman, Building building){
        batman.minY = 0;
        batman.minX = 0;

        batman.maxY = building.height;
        batman.maxX = building.width;

        batman.actualX = batman.initialX;
        batman.actualY = batman.initialY;

        if(player.useCodeGymValues){
            bomb.coordinateX = 0;
            bomb.coordinateY = 0;
        }
    }

    private boolean possiblyContinueLoop(Bomb bomb, Batman batman, boolean useCodeGymValue){
        if(useCodeGymValue) return useCodeGymValue;
        else return !((batman.actualX == bomb.coordinateX) && (batman.actualY == bomb.coordinateY));
    }
}