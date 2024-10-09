package org.dwarfongiantshoulders.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NodeSetContainerTest {
    @Test
    void itShouldHaveNoDuplicates(){
        NodeSetContainer nodeSetContainer = new NodeSetContainer();

        List.of(
                new Node(1, 2),
                new Node(3, 2),
                new Node(3, 1)
        )
        .stream()
        .forEach(node -> nodeSetContainer.fillNodeList(node));

        Assertions.assertEquals(3, nodeSetContainer.noDuplicatesNodes.size());

        List<Integer> currentValuesList =
                nodeSetContainer.noDuplicatesNodes.stream()
                        .map(node -> node.currentValue)
                        .toList();

        Assertions.assertTrue(currentValuesList.contains(1));
        Assertions.assertTrue(currentValuesList.contains(2));
        Assertions.assertTrue(currentValuesList.contains(3));
    }

    @Test
    void itShouldFillCurrentNodeWithInfluencees_case1(){
        NodeSetContainer nodeSetContainer = new NodeSetContainer();

        Node node1 = new Node(1, 2);

        Node node2 = new Node(1, 3);

        nodeSetContainer.fillNodeList(node1);
        nodeSetContainer.fillNodeList(node2);

        List<Integer> influenceesCurrentValues =
                nodeSetContainer.noDuplicatesNodes.stream()
                        .filter(node -> node.currentValue == 1)
                        .findFirst().get()
                        .influenceesList.stream()
                        .map(influencee -> influencee.currentValue)
                        .toList();

        Assertions.assertTrue(influenceesCurrentValues.contains(2));
        Assertions.assertTrue(influenceesCurrentValues.contains(3));
    }

    @Test
    void itShouldFillCurrentNodeWithInfluencors_case1(){
        NodeSetContainer nodeSetContainer = new NodeSetContainer();

        Node node1 = new Node(1, 2);

        Node node2 = new Node(3, 2);

        nodeSetContainer.fillNodeList(node1);
        nodeSetContainer.fillNodeList(node2);

        List<Integer> influenceesCurrentValues =
                nodeSetContainer.noDuplicatesNodes.stream()
                        .filter(node -> node.currentValue == 2)
                        .findFirst().get()
                        .influencorsList.stream()
                        .map(influencee -> influencee.currentValue)
                        .toList();

        Assertions.assertTrue(influenceesCurrentValues.contains(1));
        Assertions.assertTrue(influenceesCurrentValues.contains(3));
    }

    @Test
    void itShouldFillCurrentNodeWithInfluencees_case2(){
        NodeSetContainer nodeSetContainer = new NodeSetContainer();
        List<Node> relationShipList =
                List.of(
                        new Node(1, 2),
                        new Node(1, 3),
                        new Node(3, 4),
                        new Node(5, 6)
                );

        relationShipList.forEach(nodeSetContainer::fillNodeList);

        List<Integer> influenceesCurrentValues =
                nodeSetContainer.noDuplicatesNodes.stream()
                        .filter(node -> node.currentValue == 1)
                        .findFirst()
                        .get()
                        .influenceesList.stream()
                            .filter(influenceeNode -> influenceeNode.currentValue == 3)
                            .findFirst()
                            .get()
                            .influenceesList.stream()
                                .map(influenceeNode -> influenceeNode.currentValue)
                                .toList();


        Assertions.assertTrue(influenceesCurrentValues.contains(4));
    }

    @Test
    void itShouldFillCurrentNodeWithInfluencors_case2(){
        NodeSetContainer nodeSetContainer = new NodeSetContainer();
        List<Node> relationShipList =
                List.of(
                        new Node(1, 2),
                        new Node(1, 3),
                        new Node(3, 4),
                        new Node(5, 6)
                );

        relationShipList.forEach(nodeSetContainer::fillNodeList);

        List<Integer> influencorsCurrentValues =
                nodeSetContainer.noDuplicatesNodes.stream()
                        .filter(node -> node.currentValue == 4)
                        .findFirst()
                        .get()
                        .influencorsList.stream()
                        .filter(influencorNode -> influencorNode.currentValue == 3)
                        .findFirst()
                        .get()
                        .influencorsList.stream()
                        .map(influencorNode -> influencorNode.currentValue)
                        .toList();


        Assertions.assertTrue(influencorsCurrentValues.contains(1));
    }

    @Test
    void itShouldAddInfluencorToList(){
        Node node1 = new Node(2, 1);
        Node node2 = new Node(3, 1);

        NodeSetContainer nodeSetContainer = new NodeSetContainer();
        nodeSetContainer.noDuplicatesNodes = new ArrayList<>();
        nodeSetContainer.noDuplicatesNodes.add(node2);

        nodeSetContainer.fillNodeList(node1);

        Assertions.assertEquals(3, nodeSetContainer.noDuplicatesNodes.size());

        List<Integer> currentValues =
                nodeSetContainer.noDuplicatesNodes.stream()
                        .map(node -> node.currentValue)
                        .toList();

        Assertions.assertTrue(currentValues.contains(1));
        Assertions.assertTrue(currentValues.contains(2));
        Assertions.assertTrue(currentValues.contains(3));
    }

    @Test
    void influencorOfANodeShouldAlsoBePresentInTheList(){
        NodeSetContainer nodeSetContainer = new NodeSetContainer();
        Node node2 = new Node(2, 1);

        nodeSetContainer.fillNodeList(node2);

        Node nodeFromList =
                nodeSetContainer.noDuplicatesNodes.stream()
                        .filter(node -> node.currentValue == 2)
                        .findFirst().get();

        Assertions.assertEquals(node2, nodeFromList);
    }

    @Test
    void influenceeOfANodeShouldAlsoBePresentInTheList(){
        NodeSetContainer nodeSetContainer = new NodeSetContainer();
        Node node1 = new Node(2, 1);

        nodeSetContainer.fillNodeList(node1);

        Node node1FromList =
                nodeSetContainer.noDuplicatesNodes.stream()
                        .filter(node -> node.currentValue == 1)
                        .findFirst().get();

        Node node1FromNode =
        nodeSetContainer.noDuplicatesNodes.stream()
                .filter(node -> node.currentValue == 2)
                .findFirst().get()
                .influenceesList.stream()
                .filter(influenceeNode -> influenceeNode.currentValue == 1)
                .findFirst().get();

        Assertions.assertEquals(node1FromList, node1FromNode);
    }

    @Test
    void influenceeAndInfluencorsOfANodeShouldAlsoBePresentInTheList_case1(){
        NodeSetContainer nodeSetContainer = new NodeSetContainer();

        List<Node> relationShipList =
                List.of(
                        new Node(1, 2),
                        new Node(1, 3),
                        new Node(3, 4),
                        new Node(5, 6),
                        new Node(5, 4)
                );

        relationShipList.forEach(nodeSetContainer::fillNodeList);

        Node nodeToInspect =
                nodeSetContainer.noDuplicatesNodes.stream()
                        .filter(nodeToRetrieve -> nodeToRetrieve.currentValue == 3)
                        .findFirst()
                        .get();

        Node influencorToInspect =
                nodeToInspect.influencorsList.stream()
                        .filter(influencorToRetrieve -> influencorToRetrieve.currentValue == 1)
                        .findFirst()
                        .get();

        Node influenceeToInspect =
                nodeToInspect.influenceesList.stream()
                        .filter(influenceeToRetrieve -> influenceeToRetrieve.currentValue == 4)
                        .findFirst()
                        .get();

        Assertions.assertTrue(nodeSetContainer.noDuplicatesNodes.contains(influencorToInspect));
        Assertions.assertTrue(nodeSetContainer.noDuplicatesNodes.contains(influenceeToInspect));
    }

    @Test
    void influenceeAndInfluencorsOfANodeShouldAlsoBePresentInTheList_case2(){
        NodeSetContainer nodeSetContainer = new NodeSetContainer();

        List<Node> relationShipList =
                List.of(
                        new Node(1, 2),
                        new Node(1, 3),
                        new Node(3, 4),
                        new Node(5, 6),
                        new Node(5, 4),
                        new Node(4, 1),
                        new Node(4, 2)
                );

        relationShipList.forEach(nodeSetContainer::fillNodeList);

        System.out.println();

        Node nodeToInspect =
                nodeSetContainer.noDuplicatesNodes.stream()
                        .filter(nodeToRetrieve -> nodeToRetrieve.currentValue == 4)
                        .findFirst()
                        .get();

        Node influencorToInspect1 =
                nodeToInspect.influencorsList.stream()
                        .filter(influencorToRetrieve -> influencorToRetrieve.currentValue == 5)
                        .findFirst()
                        .get();

        Node influencorToInspect2 =
                nodeToInspect.influencorsList.stream()
                        .filter(influencorToRetrieve -> influencorToRetrieve.currentValue == 3)
                        .findFirst()
                        .get();

        Node influenceeToInspect1 =
                nodeToInspect.influenceesList.stream()
                        .filter(influenceeToRetrieve -> influenceeToRetrieve.currentValue == 1)
                        .findFirst()
                        .get();

        Node influenceeToInspect2 =
                nodeToInspect.influenceesList.stream()
                        .filter(influenceeToRetrieve -> influenceeToRetrieve.currentValue == 2)
                        .findFirst()
                        .get();

        Assertions.assertTrue(nodeSetContainer.noDuplicatesNodes.contains(influencorToInspect1));
        Assertions.assertTrue(nodeSetContainer.noDuplicatesNodes.contains(influencorToInspect2));
        Assertions.assertTrue(nodeSetContainer.noDuplicatesNodes.contains(influenceeToInspect1));
        Assertions.assertTrue(nodeSetContainer.noDuplicatesNodes.contains(influenceeToInspect2));
    }
}
