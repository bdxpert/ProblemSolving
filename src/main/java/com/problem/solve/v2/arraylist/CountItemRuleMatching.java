package com.problem.solve.v2.arraylist;

import java.util.ArrayList;
import java.util.List;

public class CountItemRuleMatching {
    static int id = 999;
    public static void main(String args[]) {
        int arr[];
        int[] arr2 = new int[2];
        int[] arr3 = {12,15,16,17,19,23};
        int[] arr4 = null;

        List<List<String>> data = new ArrayList<>();
        List<String> data1 = new ArrayList<>();

        data1.add("phone");
        data1.add("blue");
        data1.add("pixel");
        data.add(data1);

        List<String> data2 = new ArrayList<>();

        data2.add("computer");
        data2.add("silver");
        data2.add("lenovo");

        data.add(data2);

        List<String> data3 = new ArrayList<>();

        data3.add("phone");
        data3.add("gold");
        data3.add("iphone");

        data.add(data3);

        for(int i=arr3.length-1;i>0;i--){
            if(i%3 !=0){
                --i;
            }
            System.out.println(arr3[i] +"--");
        }
        System.out.println(id);
       /* [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]];
                ruleKey = "color", ruleValue = "silver"
        countMatches({{"phone","blue","pixel"},{"computer","silver","lenovo"},{"phone","gold","iphone"}},)*/
        System.out.println(countMatches(data, "color", "Silver"));
    }


    public static int countMatches (List < List < String >> items, String ruleKey, String ruleValue) {
        if ( ruleKey.equalsIgnoreCase("type")) {
            return (int) items.stream().filter(item -> item.get(0).equalsIgnoreCase(ruleValue)).count();
        } else if (ruleKey.equalsIgnoreCase( "color")) {
            return (int)items.stream().filter(item -> item.get(1).equalsIgnoreCase(ruleValue)).count();
        } else if (ruleKey.equalsIgnoreCase( "name")) {
            return (int)items.stream().filter(item -> item.get(2).equalsIgnoreCase(ruleValue)).count();
        }
        return 0;
    }
}
