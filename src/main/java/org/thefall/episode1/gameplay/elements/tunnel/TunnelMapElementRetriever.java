package org.thefall.episode1.gameplay.elements.tunnel;

import org.thefall.episode1.logging.map.TunnelElementGameMapValue;
import org.thefall.episode1.logging.tunnel.TunnelElementConversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TunnelMapElementRetriever {
    private static List<TunnelElementConversion> tunnelElementList;
    public TunnelMapElementRetriever(){
        initList();
    }

    private void initList(){
        tunnelElementList = new ArrayList<>();
        tunnelElementList.add(new TunnelElementConversion("0", TunnelElement.DIRECTION_BLOCK));
        tunnelElementList.add(new TunnelElementConversion("1", TunnelElement.DIRECTION_X_Y_STRAIGHT_LINE));
        tunnelElementList.add(new TunnelElementConversion("2", TunnelElement.DIRECTION_X_STRAIGHT_LINE));
        tunnelElementList.add(new TunnelElementConversion("3", TunnelElement.DIRECTION_Y_STRAIGHT_LINE));
        tunnelElementList.add(new TunnelElementConversion("4", TunnelElement.DIRECTION_TWO_CURVES));
        tunnelElementList.add(new TunnelElementConversion("5", TunnelElement.DIRECTION_TWO_CURVES_REVERSE));
        tunnelElementList.add(new TunnelElementConversion("6", TunnelElement.DIRECTION_STRAIGHT_SEMI_OPEN_ONE));
        tunnelElementList.add(new TunnelElementConversion("7", TunnelElement.DIRECTION_STRAIGHT_SEMI_OPEN_TWO));
        tunnelElementList.add(new TunnelElementConversion("8", TunnelElement.DIRECTION_STRAIGHT_SEMI_OPEN_THREE));
        tunnelElementList.add(new TunnelElementConversion("9", TunnelElement.DIRECTION_STRAIGHT_SEMI_OPEN_FOUR));
        tunnelElementList.add(new TunnelElementConversion("10", TunnelElement.DIRECTION_ONE_CURVE_ONE));
        tunnelElementList.add(new TunnelElementConversion("11", TunnelElement.DIRECTION_ONE_CURVE_TWO));
        tunnelElementList.add(new TunnelElementConversion("12", TunnelElement.DIRECTION_ONE_CURVE_THREE));
        tunnelElementList.add(new TunnelElementConversion("13", TunnelElement.DIRECTION_ONE_CURVE_FOUR));
        tunnelElementList.add(new TunnelElementConversion("E", TunnelElement.EXIT));
        tunnelElementList.add(new TunnelElementConversion("H", TunnelElement.HERO));
    }

    public TunnelElement getByStringValue(String value){
        return tunnelElementList.stream()
                .filter(tunnelElementConversion -> tunnelElementConversion.mapValue.equals(value))
                .findFirst()
                .get()
                .tunnelElement;
    }

    public TunnelElement getByMapValue(TunnelElementGameMapValue mapValue){
        return tunnelElementList.stream()
                .filter(tunnelElementConversion -> tunnelElementConversion.mapValue == mapValue.value)
                .findFirst()
                .get()
                .tunnelElement;
    }

    public String getByTunnelElementValue(TunnelElement tunnelElement){
        return tunnelElementList.stream()
                .filter(tunnelElementConversion -> tunnelElementConversion.tunnelElement == tunnelElement)
                .findFirst()
                .get()
                .mapValue;
    }
}
