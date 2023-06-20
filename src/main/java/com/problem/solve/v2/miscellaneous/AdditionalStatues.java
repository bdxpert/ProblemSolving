package com.problem.solve.v2.miscellaneous;

import java.util.Arrays;

public class AdditionalStatues {
    public static void main(String args[]) {
        int[] arr = {6, 2, 3, 8};
        System.out.println(solution(arr));
    }
   static int solution(int[] statues) {
        Arrays.sort(statues);
        int additionalS = 0;
        for(int i=0; i<statues.length-1; i++) {
            int tmp=(statues[i+1] - statues[i]);
            if(tmp >1) {
                additionalS = additionalS + (tmp-1);
            }
        }
        return additionalS;
    }
}
