package org.thefall.episode1.logging.tunnel;

import org.thefall.episode1.gameplay.elements.tunnel.TunnelMapElementRetriever;
import org.thefall.episode1.gameplay.elements.tunnel.TunnelElement;
import org.thefall.episode1.logging.map.TunnelElementGameMapValue;

import java.util.List;

public class TunnelDirectionLogPrinter {
    public void printLog(TunnelElement tunnelElement){
        System.out.println(tunnelElement + " :");
        List<String> listToPrint =
            TunnelElementLog.tunnelElementLogsMap
                .get(tunnelElement);
        listToPrint.stream()
                .forEach(System.out::println);
        System.out.println();
    }

    public void printLog(int intValuevalue){
        String stringValue = "" + intValuevalue;
        printLog(stringValue);
    }

    public void printLog(String value){
        TunnelMapElementRetriever tunnelMapElementRetriever = new TunnelMapElementRetriever();
        System.out.print(value + " : ");
        TunnelElement tunnelElement =
                tunnelMapElementRetriever.getByMapValue(TunnelElementGameMapValue.valueOf(value));
        printLog(tunnelElement);
    }
}
