package org.dwarfongiantshoulders.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FirstNodesRetrieverTest {
    @Test
    void itShouldRetrieveFirstNodes(){
        FirstNodesRetriever firstNodesRetriever = new FirstNodesRetriever();
        NodeSetContainer nodeSetContainer = new NodeSetContainer();
        List<Node> relationShipList =
                List.of(
                        new Node(1, 2),
                        new Node(1, 3),
                        new Node(3, 4),
                        new Node(5, 6)
                );

        relationShipList.forEach(nodeSetContainer::fillNodeList);

        List<Node> firstNodeList =
            firstNodesRetriever.retrieveFirstNodes(
                    nodeSetContainer.noDuplicatesNodes
            );

        Assertions.assertEquals(2, firstNodeList.size());

        List<Integer> currentValues =
                firstNodeList.stream()
                        .map(node -> node.currentValue)
                        .toList();

        Assertions.assertTrue(currentValues.contains(1));
        Assertions.assertTrue(currentValues.contains(5));
    }
}
