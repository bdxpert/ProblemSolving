package com.problem.solve.v2.miscellaneous;

public class SearchMatrix {
    public static void main(String args[]) {
        int[][] inp = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};//{{1,3,5,7}, {10,11,16,20},{23,30,34,50}};//{{1,3}};//{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(inp, 11));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int j=0;
        Boolean found = false;
        int targetIndex =0;
        int minDiff = 999999;
        for (int i=0; i<matrix.length;i++) {
            if(matrix[i][j] == target) {
                found = true;
            }
            if(!found) {
                int diffLastIndex = Math.abs(matrix[i][matrix[i].length-1] - target);
                int diffFirstIndex = Math.abs(matrix[i][j] - target);
                int diff = diffFirstIndex > diffLastIndex?diffLastIndex:diffFirstIndex;
                if(minDiff > diff) {
                    minDiff = diff;
                    targetIndex = i;
                }
            }
        }
        if(!found) {
            for (int k=1; k<matrix[targetIndex].length;k++) {
                if(matrix[targetIndex][k] == target) {
                    found = true;
                }
            }
        }
        return found;
    }
}