package org.dwarfongiantshoulders.golfcode;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Game {
    public int play(List<Node> relationShipList){
        NodeSetContainer nodeSetContainer = new NodeSetContainer();
        FirstNodesRetriever firstNodesRetriever = new FirstNodesRetriever();
        NodeChainCounter nodeChainCounter = new NodeChainCounter();

        relationShipList.forEach(nodeSetContainer::fillNodeList);

        List<Node> firstNodesList =
            firstNodesRetriever.retrieveFirstNodes(nodeSetContainer.noDuplicatesNodes);

        Set<Integer> allNodesElements =
                nodeChainCounter.getAllPossibleCount(firstNodesList);

        return Collections.max(allNodesElements);

    }
}
