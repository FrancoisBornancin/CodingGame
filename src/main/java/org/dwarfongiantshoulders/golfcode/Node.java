package org.dwarfongiantshoulders.golfcode;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Node> influencorsList;
    List<Node> influenceesList;
    int currentValue;
    int influenceeValue;

    public Node(int currentValue, int influenceeValue){
        this.currentValue = currentValue;
        this.influenceeValue = influenceeValue;
    }

    public Node(int currentValue){
        this.currentValue = currentValue;
    }
}
