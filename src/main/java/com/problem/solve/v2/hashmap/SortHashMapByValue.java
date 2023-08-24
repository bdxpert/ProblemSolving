package com.problem.solve.v2.hashmap;

import java.util.*;

/*
 * https://www.digitalocean.com/community/tutorials/java-programming-interview-questions
 */
public class SortHashMapByValue {
    public static void main(String args[]) {

        Map<String, Integer> map = new HashMap<>();
        map.put("San", 4);
        map.put("San1", 2);
        map.put("San2", 1);
        map.put("San3", 3);
        Map<String, Integer> res = sortByHashMapValueUsingLinkedList(map);

        for(Map.Entry<String, Integer> data :  res.entrySet()) {
            System.out.println("Key:"+data.getKey());
            System.out.println("Key:"+data.getValue());
        }

    }
    static Map<String, Integer> sortByHashMapValueUsingLinkedList(Map<String, Integer> map)
    {
        Map<String, Integer> sortedByValue = new LinkedHashMap<>();

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entrySet);
        entryList.sort((x,y)->x.getValue().compareTo(y.getValue()));
        System.out.println(entryList);

        for(Map.Entry<String, Integer> val: entryList) {
            sortedByValue.put(val.getKey(), val.getValue());
        }

        return sortedByValue;
    }

}
