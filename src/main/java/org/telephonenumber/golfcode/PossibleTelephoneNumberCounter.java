package org.telephonenumber.golfcode;

import java.util.List;

public class PossibleTelephoneNumberCounter {
    int count;
    public int countDistinctTelephoneNumbers(List<Node> nodeList){
        this.count += nodeList.size();

        nodeList.forEach(node -> countDistinctTelephoneNumbers(node.distinctElements));

        return count;
    }
}
