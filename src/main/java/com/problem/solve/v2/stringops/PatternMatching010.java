package com.problem.solve.v2.stringops;

public class PatternMatching010 {
    public static void main(String args[]) {
        System.out.println(solution("codesignal", "100"));
    }

    static int solution(String sequence, String pattern) {
        int j = 0;
        int k = sequence.length()-1;
        char[] seqArr = sequence.toCharArray();
        char[] patArr = pattern.toCharArray();
        int count =0;
        for (int i = 0; i < (sequence.length()-pattern.length()); i++) {
            j =0;
            while (j < pattern.length()) {
                if(patArr[j] == '0'){
                    if(seqArr[i+j] == 'a' || seqArr[i+j] =='e'
                        || seqArr[i+j] == 'i' || seqArr[i+j] == 'o' || seqArr[i+j] == 'u') {
                        j++;
                    } else {
                        break;
                    }
                } else {
                    if(seqArr[i+j] != 'a' || seqArr[i+j] !='e'
                            || seqArr[i+j] != 'i' || seqArr[i+j] != 'o' || seqArr[i+j] != 'u') {
                        j++;
                    } else {
                        break;
                    }
                }
            }
            if(j==pattern.length()) {
                count++;
            }
        }
        return count;
    }
}
