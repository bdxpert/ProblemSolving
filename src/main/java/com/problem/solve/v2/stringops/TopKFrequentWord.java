package com.problem.solve.v2.stringops;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWord {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String, Integer> map = new TreeMap<>(String::compareTo);
        Arrays.stream(words).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
        return map.entrySet().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }
    public List<String> topKFrequentV2(String[] words, int k) {
        return Arrays.stream(words).collect(Collectors.groupingBy(s->s, Collectors.counting()))
                .entrySet().stream()
                .sorted((a , b) -> b.getValue() != a.getValue() ?
                        (int)(b.getValue() - a.getValue()) : a.getKey().compareTo(b.getKey()))
                .map(ent->ent.getKey()).limit(k).toList();
    }
    public List<String> topKFrequentV3(String[] words, int k) {
        HashMap<String,Integer> freq=new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            freq.put(words[i],freq.getOrDefault(words[i],0)+1);
        }
        List<String> res = new ArrayList(freq.keySet());
        //sorting
        //if two words have the same frequency, then the word with the lower alphabetical order comes first.
        //else most frequent words will come first
        Collections.sort(res, (w1, w2) -> freq.get(w1).equals(freq.get(w2)) ?
                                            w1.compareTo(w2) : freq.get(w2) - freq.get(w1));

        return res.subList(0, k);
    }
}
