package com.problem.solve.v2.streamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class DataSort {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(2);
        list.add(7);
        //Ascending Order
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        //Descending Order
        List<Integer> sortedDescList = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedDescList);
        String[] words = {"i", "love", "code","i","love"};

        /*
        return Arrays.stream(words).collect(Collectors.groupingBy(s->s, Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).map(ent->ent.getKey()).limit(k).sorted((p1, p2) -> p1.compareTo(p2)).toList();
        */
        //return Arrays.stream(words).collect(Collectors.groupingBy(s->s, Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(Collectors.toMap(Map::keySet,Map.).toMap().map(ent->ent.getKey()).sorted(Collections.reverseOrder()).limit(k).toList();
        int k=3;
        //return Arrays.stream(words).collect(Collectors.groupingBy(s->s, Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().thenComparing(Map.Entry.comparingByKey()).reversed()).map(ent->ent.getKey()).limit(k).sorted((p1, p2) -> p1.compareTo(p2)).toList();


    }
}
class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(x -> x , Collectors.counting()))
                .entrySet().stream()
                .sorted((a , b) -> b.getValue()!= a.getValue() ?
                        (int)(b.getValue() - a.getValue()) : a.getKey().compareTo(b.getKey()))
                .limit(k).map(Map.Entry::getKey).toList();
    }
}
