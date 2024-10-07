package org.thereisnospoon.episode1;

import java.util.List;

public class ColumnScanner {
    public String getUnderNodeAsString(List<String> elementsToScan, int widthIndex, int heightIndex){

        for(int a = (heightIndex + 1) ; a < elementsToScan.size() ; a++){
            try{
                if(elementsToScan.get(a).charAt(widthIndex) == '0') return "" + widthIndex + " " + a;
            }catch (Exception e){
                return "-1 -1";
            }
        }

        return "-1 -1";
    }
}
