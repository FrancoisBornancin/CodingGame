package org.telephonenumber.golfcode;

import java.util.List;
import java.util.stream.Collectors;

public class NodeListInitializer {
    public List<Node> initList(List<String> telephoneNumberList){

        List<Node> nodeList =
            fillCommonElementNodeList(telephoneNumberList);

        return nodeList;
    }

    private void fillWithTruncatedTelephoneList(Node node, List<String> telephoneNumberList){
            try{
                List<String> truncatedTelephoneList =
                        telephoneNumberList.stream()
                                .filter(telephoneNumber -> telephoneNumber.startsWith(node.commonElement))
                                .map(telephoneNumber -> telephoneNumber.substring(1))
                                .filter(telephoneNumber -> !telephoneNumber.equals(""))
                                .collect(Collectors.toList());

                node.distinctElements
                        = fillCommonElementNodeList(truncatedTelephoneList);
            }catch (StringIndexOutOfBoundsException e){
                node.distinctElements = List.of();
            }
    }

    private List<Node> fillCommonElementNodeList(List<String> telephoneNumberList){
        return telephoneNumberList.stream()
                .map(element -> element.charAt(0))
                .distinct()
                .map(element -> {
                    Node node = new Node();
                    node.commonElement = element.toString();

                    fillWithTruncatedTelephoneList(node, telephoneNumberList);

                    return node;
                })
                .toList();
    }
}
