package com.problem.solve.v2.streamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    }
}
