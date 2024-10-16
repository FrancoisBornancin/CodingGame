package org.thefall.episode1.logging.errors;

import org.thefall.episode1.gameplay.elements.tunnel.TunnelElement;

public class TunnelElementException extends RuntimeException{
    public TunnelElementException(String value) {
        super("TunnelElement with value: " + value + " does not exists");
    }

    public TunnelElementException(TunnelElement tunnelElement) {
        super("TunnelElement: " + tunnelElement + " does not exists");
    }
}
