package org.dwarfongiantshoulders.golfcode;

import java.util.List;

public class FirstNodesRetriever {
    public List<Node> retrieveFirstNodes(List<Node> nodeList){
        return nodeList.stream()
                .filter(node -> node.influencorsList.isEmpty())
                .toList();
    }
}
