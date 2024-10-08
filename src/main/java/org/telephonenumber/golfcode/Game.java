package org.telephonenumber.golfcode;

public class Game {

    public String play(Solution solution){
        PossibleTelephoneNumberCounter possibleTelephoneNumberCounter = new PossibleTelephoneNumberCounter();
        NodeListInitializer nodeListInitializer = new NodeListInitializer();

        return String.valueOf(
                possibleTelephoneNumberCounter
                        .countDistinctTelephoneNumbers(
                                nodeListInitializer.initList(
                                        solution.telephonNumberList
                                )
                        )
        );
    }
}
