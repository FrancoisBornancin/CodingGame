package org.telephonenumber.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PossibleTelephoneNumberCounterTest {
    @Test
    void itShouldReturn10_case1(){
        PossibleTelephoneNumberCounter possibleTelephoneNumberCounter = new PossibleTelephoneNumberCounter();
        NodeListInitializer nodeListInitializer = new NodeListInitializer();
        List<String> telephoneNumberList =
                List.of(
                        "0123456789"
                );

        List<Node> nodeList = nodeListInitializer.initList(telephoneNumberList);

        possibleTelephoneNumberCounter
                .countDistinctTelephoneNumbers(nodeList);

        Assertions.assertEquals(
            10,
            possibleTelephoneNumberCounter.count
        );
    }

    @Test
    void itShouldReturn20(){
        PossibleTelephoneNumberCounter possibleTelephoneNumberCounter = new PossibleTelephoneNumberCounter();
        NodeListInitializer nodeListInitializer = new NodeListInitializer();
        List<String> telephoneNumberList =
                List.of(
                        "0123456789",
                        "1123456789"
                );

        possibleTelephoneNumberCounter
                .countDistinctTelephoneNumbers(
                        nodeListInitializer.initList(telephoneNumberList)
                );

        Assertions.assertEquals(
                20,
            possibleTelephoneNumberCounter.count
        );
    }

    @Test
    void itShouldReturn10_case2(){
        PossibleTelephoneNumberCounter possibleTelephoneNumberCounter = new PossibleTelephoneNumberCounter();
        NodeListInitializer nodeListInitializer = new NodeListInitializer();
        List<String> telephoneNumberList =
                List.of(
                        "0123456789",
                        "0123"
                );

        possibleTelephoneNumberCounter
                .countDistinctTelephoneNumbers(
                        nodeListInitializer.initList(telephoneNumberList)
                );

        Assertions.assertEquals(
                10,
                possibleTelephoneNumberCounter.count
        );
    }

    @Test
    void itShouldReturn28(){
        PossibleTelephoneNumberCounter possibleTelephoneNumberCounter = new PossibleTelephoneNumberCounter();
        NodeListInitializer nodeListInitializer = new NodeListInitializer();
        List<String> telephoneNumberList =
                List.of(
                        "0412578440",
                        "0412199803",
                        "0468892011",
                        "112",
                        "15"
                );

        possibleTelephoneNumberCounter
                .countDistinctTelephoneNumbers(
                        nodeListInitializer.initList(telephoneNumberList)
                );

        Assertions.assertEquals(
                28,
                possibleTelephoneNumberCounter.count
        );
    }
}
