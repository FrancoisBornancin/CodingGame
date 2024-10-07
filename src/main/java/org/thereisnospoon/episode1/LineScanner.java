package org.thereisnospoon.episode1;

public class LineScanner {

    public String getRightNodeAsString(String element, int index, int heightIndex){
        String[] elementsToScan = element.substring(index).split("");

        for(int a = 1 ; a < elementsToScan.length ; a++){
            if(elementsToScan[a].equals("0")) return "" + (index + a) + " " + heightIndex;
        }

        return "-1 -1";

    }
}
