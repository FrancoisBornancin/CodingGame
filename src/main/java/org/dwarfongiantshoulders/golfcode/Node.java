package org.dwarfongiantshoulders.golfcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Node {
    Set<Integer> currentAndPreviousNodes;
    List<Node> influencorsList;
    List<Node> influenceesList;
    int currentValue;
    int influenceeValue;
    boolean hasInfluenceeNotCounted;

    public Node(int currentValue, int influenceeValue){
        this.currentValue = currentValue;
        this.influenceeValue = influenceeValue;
    }

    public Node(int currentValue){
        this.currentValue = currentValue;
    }
}
