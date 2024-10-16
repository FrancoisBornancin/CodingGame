package org.thefall.episode1.logging.tunnel;

import org.thefall.episode1.gameplay.elements.tunnel.TunnelElement;

public class TunnelElementConversion {
    public String mapValue;
    public TunnelElement tunnelElement;

    public TunnelElementConversion(String mapValue, TunnelElement tunnelElement) {
        this.mapValue = mapValue;
        this.tunnelElement = tunnelElement;
    }
}
