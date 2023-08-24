package com.problem.solve.v2.streamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleLambda {
    public static void main(String args[]){

        List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

        // The lambda expression passed to
        // reduce() method takes two Strings
        // and returns the longer String.
        // The result of the reduce() method is
        // an Optional because the list on which
        // reduce() is called may be empty.
        Optional<String> longestString = words.stream()
                .reduce((word1, word2)
                        -> word1.length() > word2.length()
                        ? word1 : word2);

        // Displaying the longest String
        longestString.ifPresent(System.out::println);



        List<String> list = new ArrayList<>();
        list.add("aa");list.add("bb"); list.add("aa");list.add("bb");

        System.out.println(list.stream().collect(Collectors.groupingBy(s->s))
                .entrySet().stream().filter(ent->ent.getValue().size()>1).map(ent->ent.getKey()).collect(Collectors.toList()));
        /*
        Given a string of lowercase letters, return a map of individual characters as keys and
        their occurrences in a string as values. You are only allowed to use Java Stream to solve this.
         */
        String str = "abcdEeff";
        System.out.println(Arrays.stream(str.split("")).map(e->e.toLowerCase()).
                collect(Collectors.groupingBy(s->s)).entrySet().stream().
                collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)));

        System.out.println(Arrays.stream(str.split("")).
                collect(Collectors.groupingBy(s->s, Collectors.counting())));

        String s = "giraffe";
//        Map<String, Long> freq =
                Arrays.stream(s.split("")).collect(
                Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream().filter(ent->ent.getValue()>=1).forEach(System.out::println);

//        freq.entrySet().forEach(System.out::println);
    }
}
