package org.blunder.episode1.golfcode;

public class BlunderBreaker {
    public boolean breakObstacle(Blunder blunder, MapScanner mapScanner){
        if(blunder.beers == 1) {
            char[] charArray = mapScanner.map.get(mapScanner.nextCordY).toCharArray();
            charArray[mapScanner.nextCordX] = ' ';
            mapScanner.map.set(mapScanner.nextCordY, String.valueOf(charArray));
            return true;
        }else return false;
    }
}
