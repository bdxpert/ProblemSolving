package com.problem.solve.v2.array;
//https://leetcode.com/problems/container-with-most-water/solutions/1915172/java-c-easiest-explanations/
public class ContainerMostWater {
    public int maxArea(int[] height) {
        int maxA = 0;
        int i=0,j=height.length-1;
        while(i<j){
            int newArea = (j-i)*Math.min(height[i],height[j]);
            if(newArea> maxA) maxA = newArea;

            if(height[i]<height[j]) {
                i++;
            } else if(height[i]>height[j]){
                j--;
            } else {
                i++;
                j--;
            }
        }
        return maxA;
    }
}
