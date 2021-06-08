package com.productService.helper.query;

import java.util.List;

public final class QueryConstructor {
    /**
     * Construct in query<br>
     * For Example: If input is [1,2,3]<br>
     *              outPut will be (1,2,3)
     *
     * @param ids
     * @return
     */
    public static String constructInQuery(List<Integer> ids){
        String finalInOperator = "(";
        for(int id : ids){
            finalInOperator = finalInOperator.concat(Integer.toString(id)).concat(",");
        }
        finalInOperator = finalInOperator.substring(0, finalInOperator.length() - 1);
        finalInOperator = finalInOperator.concat(")");
        return finalInOperator;
    }
}
