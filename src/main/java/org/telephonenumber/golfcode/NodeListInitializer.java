package org.telephonenumber.golfcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NodeListInitializer {
    public List<Node> initList(List<String> telephoneNumberList){

        List<Node> nodeList =
            fillCommonElementNodeList(telephoneNumberList);

        fillSucessively(nodeList, telephoneNumberList);
        return nodeList;
    }

    private void fillSucessively(List<Node> nodeList, List<String> telephoneNumberList){
        nodeList.forEach(node -> {
            node.distinctElements = new ArrayList<>();
            try{
                List<String> truncatedTelephoneList =
                        telephoneNumberList.stream()
                                .filter(telephoneNumber -> telephoneNumber.startsWith(node.commonElement))
                                .map(telephoneNumber -> telephoneNumber.substring(1))
                                .filter(telephoneNumber -> !telephoneNumber.equals(""))
                                .collect(Collectors.toList());

                node.distinctElements
                        = fillCommonElementNodeList(truncatedTelephoneList);

                node.distinctElements.forEach(
                        distinctNode -> fillSucessively(node.distinctElements, truncatedTelephoneList)
                );
            }catch (StringIndexOutOfBoundsException e){
                node.distinctElements = List.of();
            }

        });
    }

    private List<Node> fillCommonElementNodeList(List<String> telephoneNumberList){
        return telephoneNumberList.stream()
                .map(element -> element.charAt(0))
                .distinct()
                .map(element -> {
                    Node node = new Node();
                    node.commonElement = element.toString();
                    return node;
                })
                .toList();
    }
}
