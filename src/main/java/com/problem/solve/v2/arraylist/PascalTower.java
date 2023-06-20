package com.problem.solve.v2.arraylist;

import java.util.ArrayList;
import java.util.List;

public class PascalTower {
    public static void main(String args[])
    {
        generate(5);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ll = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    l.add(1);
                }else{
                    l.add((ll.get(i-1).get(j-1)+ll.get(i-1).get(j)));
                }
            }
            ll.add(l);
        }
        return ll;
    }
}
