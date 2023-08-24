package com.problem.solve.v2.hackerrank;

public class CopyEndy {
    /*
    copyEndy({9, 11, 90, 22, 6}, 2) → {9, 90}
    copyEndy({9, 11, 90, 22, 6}, 3) → {9, 90, 6}
    copyEndy({12, 1, 1, 13, 0, 20}, 2) → {1, 1}
     */
    public static void main(String args[])
    {
        int[] arr = {9, 11, 90, 22, 6};
        int[] res = copyEndy(arr, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    static int[] copyEndy(int[] arr, int count) {
        int[] res = new int[count];
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isEndy(arr[i])) {
                res[counter] = arr[i];
                counter++;
            }
            if (counter == count) return res;
        }
        return res;
    }

    static Boolean isEndy(int n) {
        return (n >= 0 && n <= 10) || (n >= 90 && n <= 1000);
    }
}
