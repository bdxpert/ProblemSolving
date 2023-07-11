package com.problem.solve.v2.dynamic.twodarray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String args[]){
        System.out.println(findDuplicate());
    }
    static List<String> findDuplicate()
    {
        List<String> strVal = Arrays.asList("abs", "brt", "fff", "abc", "brt");
        Map<String, Integer> duplicate = new HashMap<>();
        String[] strVal2 = {"abs", "brt", "fff", "abc", "brt"};

        Arrays.asList(strVal2).stream().collect(Collectors.groupingBy(st->st)).entrySet().stream().filter(item->item.getValue().size()>1).collect(Collectors.toList());

        strVal.stream().map(str->{
            if(duplicate.containsKey(str)) duplicate.put(str, duplicate.get(str)+1);
            else duplicate.put(str, 1);
            return duplicate;} ).forEach(item->{
//                System.out.println(item);
                for(Map.Entry item1:item.entrySet()) {
           //Map.Entry<String, Integer> item1 = item.keySet();
                    //if(item1.getValue()>1)
                    System.out.println("Item:"+ item1.getKey() +" count"+item1.getValue());
            }
                //Map.entry(item).getKey()
        });
        return null;
        /*strVal.stream().
        return null;
            Arrays.stream(str).collect(Collectors::groupingBy(str)).

        Employee

        Select salary FROM employee where 4>(Select max(salary) FROM emplyee )*/
    }

}
