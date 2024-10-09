package org.dwarfongiantshoulders.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class NodeChainCounterTest {
    @Test
    void testCase1(){
        FirstNodesRetriever firstNodesRetriever = new FirstNodesRetriever();
        NodeSetContainer nodeSetContainer = new NodeSetContainer();
        NodeChainCounter nodeChainCounter = new NodeChainCounter();

        List<Node> relationShipList =
                List.of(
                        new Node(1, 2)
                );

        relationShipList.forEach(nodeSetContainer::fillNodeList);

        List<Node> firstNodeList =
                firstNodesRetriever.retrieveFirstNodes(
                        nodeSetContainer.noDuplicatesNodes
                );

        Set<Integer> expectedSet = Set.of(2);
        Set<Integer> elements = nodeChainCounter.getAllPossibleCount(firstNodeList);

        Assertions.assertTrue(expectedSet.containsAll(elements));
    }

    @Test
    void testCase2(){
        FirstNodesRetriever firstNodesRetriever = new FirstNodesRetriever();
        NodeSetContainer nodeSetContainer = new NodeSetContainer();
        NodeChainCounter nodeChainCounter = new NodeChainCounter();

        List<Node> relationShipList =
                List.of(
                        new Node(1, 2),
                        new Node(3, 2)
                );

        relationShipList.forEach(nodeSetContainer::fillNodeList);

        List<Node> firstNodeList =
                firstNodesRetriever.retrieveFirstNodes(
                        nodeSetContainer.noDuplicatesNodes
                );

        Set<Integer> expectedSet = Set.of(2);

        Set<Integer> elements = nodeChainCounter.getAllPossibleCount(firstNodeList);

        Assertions.assertTrue(expectedSet.containsAll(elements));
    }

    @Test
    void testCase3(){
        FirstNodesRetriever firstNodesRetriever = new FirstNodesRetriever();
        NodeSetContainer nodeSetContainer = new NodeSetContainer();
        NodeChainCounter nodeChainCounter = new NodeChainCounter();

        List<Node> relationShipList =
                List.of(
                        new Node(1, 2),
                        new Node(1, 3)
                );

        relationShipList.forEach(nodeSetContainer::fillNodeList);

        List<Node> firstNodeList =
                firstNodesRetriever.retrieveFirstNodes(
                        nodeSetContainer.noDuplicatesNodes
                );

        Set<Integer> expectedSet = Set.of(2);
        Set<Integer> elements = nodeChainCounter.getAllPossibleCount(firstNodeList);

        Assertions.assertTrue(expectedSet.containsAll(elements));
    }

    @Test
    void testCase4(){
        FirstNodesRetriever firstNodesRetriever = new FirstNodesRetriever();
        NodeSetContainer nodeSetContainer = new NodeSetContainer();
        NodeChainCounter nodeChainCounter = new NodeChainCounter();

        List<Node> relationShipList =
                List.of(
                        new Node(1, 2),
                        new Node(2, 4),
                        new Node(2, 3),
                        new Node(1, 3),
                        new Node(3, 4),
                        new Node(1, 4),
                        new Node(8, 9),
                        new Node(8, 4),
                        new Node(8, 2)
                );

        relationShipList.forEach(nodeSetContainer::fillNodeList);

        List<Node> firstNodeList =
                firstNodesRetriever.retrieveFirstNodes(
                        nodeSetContainer.noDuplicatesNodes
                );

        Set<Integer> expectedSet = Set.of(3, 4, 2);
        Set<Integer> elements = nodeChainCounter.getAllPossibleCount(firstNodeList);

        Assertions.assertTrue(expectedSet.containsAll(elements));
    }

    @Test
    void testCase5(){
        FirstNodesRetriever firstNodesRetriever = new FirstNodesRetriever();
        NodeSetContainer nodeSetContainer = new NodeSetContainer();
        NodeChainCounter nodeChainCounter = new NodeChainCounter();

        List<Node> relationShipList =
                List.of(
                        new Node(2, 3),
                        new Node(8, 9),
                        new Node(1, 2),
                        new Node(6, 3)
                );

        relationShipList.forEach(nodeSetContainer::fillNodeList);

        List<Node> firstNodeList =
                firstNodesRetriever.retrieveFirstNodes(
                        nodeSetContainer.noDuplicatesNodes
                );

        Set<Integer> expectedSet = Set.of(3, 2);
        Set<Integer> elements = nodeChainCounter.getAllPossibleCount(firstNodeList);

        Assertions.assertTrue(expectedSet.containsAll(elements));
    }

    @Test
    void testCase6(){
        FirstNodesRetriever firstNodesRetriever = new FirstNodesRetriever();
        NodeSetContainer nodeSetContainer = new NodeSetContainer();
        NodeChainCounter nodeChainCounter = new NodeChainCounter();
        List<Node> relationShipList =
                List.of(
                        new Node(7, 2),
                        new Node(8, 9),
                        new Node(1, 6),
                        new Node(6, 9),
                        new Node(1, 7),
                        new Node(1, 2),
                        new Node(3, 9),
                        new Node(2, 3),
                        new Node(6, 3)
                );


        relationShipList.forEach(nodeSetContainer::fillNodeList);

        List<Node> firstNodeList =
                firstNodesRetriever.retrieveFirstNodes(
                        nodeSetContainer.noDuplicatesNodes
                );

        Set<Integer> expectedSet = Set.of(5, 3, 4, 2);
        Set<Integer> elements = nodeChainCounter.getAllPossibleCount(firstNodeList);

        Assertions.assertTrue(expectedSet.containsAll(elements));
    }
}
