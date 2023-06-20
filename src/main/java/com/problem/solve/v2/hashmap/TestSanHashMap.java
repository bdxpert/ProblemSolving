package com.problem.solve.v2.hashmap;

public class TestSanHashMap {
    public static void main(String args[]) {
        SanHashMap hashMap = new SanHashMap();
        hashMap.put(1, 100);
        hashMap.put(1, 200);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(1));
    }
}