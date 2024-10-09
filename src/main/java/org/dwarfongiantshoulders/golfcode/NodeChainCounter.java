package org.dwarfongiantshoulders.golfcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NodeChainCounter {
    Set<Integer> allNodesElements;
    public Set<Integer> getAllPossibleCount(List<Node> nodeList){
        allNodesElements = new HashSet<>();

        nodeList.forEach(node -> {
            initCurrentAndPrevious(node);
            node.currentAndPreviousNodes.add(1);
            fillCurrentAndPreviousNodes(node);
        });

        return allNodesElements;
    }

    private void initCurrentAndPrevious(Node node){
        if(node.currentAndPreviousNodes == null) node.currentAndPreviousNodes = new HashSet<>();
    }

    private void fillCurrentAndPreviousNodes(Node node){
        initCurrentAndPrevious(node);
        if(!node.influenceesList.isEmpty()){
            node.influenceesList.forEach(influenceeNode -> {
                initCurrentAndPrevious(influenceeNode);
                node.currentAndPreviousNodes.forEach(nodeInt -> influenceeNode.currentAndPreviousNodes.add(nodeInt + 1));
                fillCurrentAndPreviousNodes(influenceeNode);
            });
        }else{
            allNodesElements.addAll(node.currentAndPreviousNodes);
        }
    }

}
