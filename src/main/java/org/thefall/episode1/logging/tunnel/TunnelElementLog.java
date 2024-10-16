package org.thefall.episode1.logging.tunnel;

import org.thefall.episode1.gameplay.elements.tunnel.TunnelElement;

import java.util.List;
import java.util.Map;

public class TunnelElementLog {
    public static Map<TunnelElement, List<String>> tunnelElementLogsMap =
            Map.ofEntries(
                    Map.entry(
                            TunnelElement.DIRECTION_X_STRAIGHT_LINE, List.of(
                                    "XXXX",
                                    "    ",
                                    "XXXX"
                            )
                    ),
                    Map.entry(
                            TunnelElement.DIRECTION_X_Y_STRAIGHT_LINE, List.of(
                                    "X  X",
                                    "    ",
                                    "X  X"
                            )
                    ),
                    Map.entry(
                            TunnelElement.DIRECTION_Y_STRAIGHT_LINE, List.of(
                                    "X  X",
                                    "X  X",
                                    "X  X"
                            )
                    ),
                    Map.entry(
                            TunnelElement.DIRECTION_TWO_CURVES, List.of(
                                    "X XXX",
                                    "X XXX",
                                    "X    ",
                                    "XXXXX",
                                    "    X",
                                    "XXX X",
                                    "XXX X"
                            )
                    ),
                    Map.entry(
                            TunnelElement.DIRECTION_TWO_CURVES_REVERSE, List.of(
                                "XXX X",
                                "XXX X",
                                "    X",
                                "XXXXX",
                                "X    ",
                                "X XXX",
                                "X XXX"
                            )
                    ),
                    Map.entry(
                            TunnelElement.DIRECTION_STRAIGHT_SEMI_OPEN_ONE, List.of(
                                    "X X",
                                    "   ",
                                    "XXX"
                            )
                    ),
                    Map.entry(
                            TunnelElement.DIRECTION_STRAIGHT_SEMI_OPEN_TWO, List.of(
                                    "X X",
                                    "X  ",
                                    "X X"
                            )
                    ),
                    Map.entry(
                            TunnelElement.DIRECTION_STRAIGHT_SEMI_OPEN_THREE, List.of(
                                    "XXX",
                                    "   ",
                                    "X X"
                            )
                    ),
                    Map.entry(
                            TunnelElement.DIRECTION_STRAIGHT_SEMI_OPEN_FOUR, List.of(
                                    "X X",
                                    "  X",
                                    "X X"
                            )
                    ),
                    Map.entry(
                            TunnelElement.DIRECTION_ONE_CURVE_ONE, List.of(
                                    "X X",
                                    "  X",
                                    "XXX"
                            )
                    ),
                    Map.entry(
                            TunnelElement.DIRECTION_ONE_CURVE_TWO, List.of(
                                    "X X",
                                    "X  ",
                                    "XXX"
                            )
                    ),
                    Map.entry(
                            TunnelElement.DIRECTION_ONE_CURVE_THREE, List.of(
                                    "XXX",
                                    "X  ",
                                    "X X"
                            )
                    ),
                    Map.entry(
                            TunnelElement.DIRECTION_ONE_CURVE_FOUR, List.of(
                                    "XXX",
                                    "  X",
                                    "X X"
                            )
                    ),
                    Map.entry(
                            TunnelElement.DIRECTION_BLOCK, List.of(
                                    "XXX",
                                    "XXX",
                                    "XXX"
                            )
                    )
            );
}
