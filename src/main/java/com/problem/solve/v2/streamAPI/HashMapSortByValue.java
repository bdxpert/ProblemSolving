package com.problem.solve.v2.streamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMapSortByValue {
    /*
     * Contains hashmap you need to sort by value
     * return map sorted by value;
     */
    public LinkedHashMap<String, Integer> sortHashMapByValue()
    {
        Map<String, Integer> data = new HashMap<>();
        data.put("a", 1);
        data.put("d", 3);
        data.put("c", 1);

        Stream<Map.Entry<String, Integer>> res = data.entrySet().stream().sorted(Map.Entry.comparingByValue());

        LinkedHashMap<String, Integer> sorted =
                data.entrySet().stream().sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));

        return sorted;
    }

    void sortHashMapByValueV3()
    {
        Map<String, Integer> hashmap = new HashMap<>();

        hashmap.put("a", 80);
        hashmap.put("b", 60);
        hashmap.put("v", 45);
        hashmap.put("s", 60);
        hashmap.put("n", 75);

        //Before sorting
        System.out.println("The original map before sorting:");
        hashmap.forEach((key,value)->System.out.println(key + " -> " + value));

        //After sorting
        System.out.println("\nAfter sorting by their prices:");

        //Creating a list of the original hashmap in order to sort
        //the elements with sort() method
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashmap.entrySet());

        //Using Entry's comparingByValue() method for sorting in ascending order
        list.sort(Map.Entry.comparingByValue());
        //---OR----
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >()
        {
            //Compare method facilitates custom sorting order
            public int compare(Map.Entry<String, Integer> fruit1,
                               Map.Entry<String, Integer> fruit2)
            {
                return (fruit1.getValue()).compareTo(fruit2.getValue());
            }
        });


        //Printing the elements from the list
        list.forEach((fruit)->System.out.println(fruit.getKey() + " -> " + fruit.getValue()));

        // Store in a LinkedHashMap
        HashMap<String, Integer> sortedHashMap = new LinkedHashMap<String, Integer>();

        for (Map.Entry<String, Integer> fruit : list) {
            sortedHashMap.put(fruit.getKey(), fruit.getValue());
        }
    }

    public LinkedHashMap<String, Integer> sortHashMapByValueV2()
    {
        Map<String, Integer> data = new HashMap<>();
        data.put("a", 1);
        data.put("d", 3);
        data.put("c", 1);
        List<Integer> dataKey = new ArrayList<>();

        for(HashMap.Entry<String, Integer> datum:data.entrySet()) {
            dataKey.add(datum.getValue());
        }
        LinkedHashMap<String, Integer> res = new LinkedHashMap<>();
        Collections.sort(dataKey);

        for(Integer key:dataKey) {
            for(Map.Entry<String, Integer> map:data.entrySet()) {
                if(map.getValue().equals(key)) {
                    res.put(map.getKey(),map.getValue());
                }
            }
        }
        return res;
    }
}
