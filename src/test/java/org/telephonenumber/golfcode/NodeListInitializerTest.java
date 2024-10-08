package org.telephonenumber.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NodeListInitializerTest {
    @Test
    void itShouldConstructAListWithDistinctElementsAtChat0(){
        NodeListInitializer nodeListInitializer = new NodeListInitializer();
        List<String> telephoneNumberList =
                List.of(
                        "0123456789",
                        "4123456789"
                );

        List<Node> initializedList =
                nodeListInitializer.initList(telephoneNumberList);

        Assertions.assertEquals(
                2,
                initializedList.size()
        );

        Assertions.assertEquals(
                "0",
                initializedList.get(0).commonElement
        );

        Assertions.assertEquals(
                "4",
                initializedList.get(1).commonElement
        );

    }

    @Test
    void itShouldFillDistinctElementOfANodeAtChar0_case1(){
        NodeListInitializer nodeListInitializer = new NodeListInitializer();
        List<String> telephoneNumberList =
                List.of(
                        "0223456789",
                        "0123456789"
                );

        List<Node> initializedList =
                nodeListInitializer.initList(telephoneNumberList);

        Assertions.assertEquals(
                1,
                initializedList.size()
        );

        Assertions.assertEquals(
                2,
                initializedList.get(0).distinctElements.size()
        );
    }

    @Test
    void itShouldFillDistinctElementOfANodeAtChar0_case2(){
        NodeListInitializer nodeListInitializer = new NodeListInitializer();
        List<String> telephoneNumberList =
                List.of(
                        "0223456789",
                        "0123456789",
                        "0148256789"
                );

        List<Node> initializedList =
                nodeListInitializer.initList(telephoneNumberList);

        Assertions.assertEquals(
                1,
                initializedList.size()
        );

        Assertions.assertEquals(
                2,
                initializedList.get(0).distinctElements.size()
        );
    }

    @Test
    void itShouldFillDistinctElementOfANodeAtChar0_case3(){
        NodeListInitializer nodeListInitializer = new NodeListInitializer();
        List<String> telephoneNumberList =
                List.of(
                        "0412578440"
//                        ,
//                        "0412199803",
//                        "0468892011",
//                        "112",
//                        "15"
                );

        List<Node> initializedList =
                nodeListInitializer.initList(telephoneNumberList);

        System.out.println("");
    }
}
