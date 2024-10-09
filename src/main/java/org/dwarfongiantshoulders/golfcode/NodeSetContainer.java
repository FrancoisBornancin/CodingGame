package org.dwarfongiantshoulders.golfcode;

import java.util.ArrayList;
import java.util.List;

public class NodeSetContainer {
    List<Node> noDuplicatesNodes;

    public void fillNodeList(Node node){
        if(noDuplicatesNodes == null) noDuplicatesNodes = new ArrayList<>();

        Node nodeFromList = addIfNotPresent(node, noDuplicatesNodes);
        Node influenceeFromList = addIfNotPresent(new Node(node.influenceeValue), noDuplicatesNodes);

        addIfNotPresent(influenceeFromList, nodeFromList.influenceesList);
        addIfNotPresent(nodeFromList, influenceeFromList.influencorsList);
    }

    private Node addIfNotPresent(Node node, List<Node> nodeList){
        if(node.influenceesList == null) node.influenceesList = new ArrayList<>();
        if(node.influencorsList == null) node.influencorsList = new ArrayList<>();

        for(int a = 0 ; a < nodeList.size() ; a++){
            Node nodeFromList = nodeList.get(a);
            if(nodeFromList.currentValue == node.currentValue){
                return nodeFromList;
            }
        }
        nodeList.add(node);
        return node;
    }
}
