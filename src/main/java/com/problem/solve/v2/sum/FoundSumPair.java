package com.problem.solve.v2.sum;

public class FoundSumPair {
    public static void main(String args[])
    {
        foundSumPair();
    }
    public static void foundSumPair()
    {
        int[] data = {10,15,18,25,12,11};
        int fsum1 = 0;
        int ssum2 = 0;
        int[] second = new int[2];
        int pair1=0,pair2=0;
        for (int i=0; i<data.length-1; i++){
            int j = i+1;
            int k = data.length;
            int sum1 = 0;

            while(j<k) {
                sum1 = data[i]+ data[j];
                if(sum1> fsum1) {
                    if(fsum1 !=0) {
                        ssum2 = fsum1;
                        second[0] = pair1;
                        second[1] = pair2;
                    }
                    fsum1 = sum1;
                    pair1 = data[i];
                    pair2 = data[j];
                } else if(sum1 > ssum2){
                    second[0]  = data[i];
                    second[1]  = data[j];
                    pair1 = data[i];
                    pair2 = data[j];
                    ssum2 = sum1;
                }
                j++;
            }
        }
        System.out.println(ssum2);
        System.out.println(second[0]);
        System.out.println(second[1]);
    }

    private static int largestPairSum(int[] arr, int n)
    {
        int second = 0;
        int j = 0;
        int max = n == 1 ? arr[0] + arr[1] : arr[0];
        int indexi=0, indexj=0;
        for (int i = 0; i < n; i++) {
            int sum = arr[j] + arr[i];
            if (sum > max) {
                second = max ;
                max = sum;
                if (arr[j] < arr[i]) {
                    indexi = i;
                    indexj = j;
                    j = i;
                }
            } else if(sum > second && second !=max) {
                second = sum;
                indexi = i;
                indexj = j;
            }
        }
        System.out.println(arr[indexi]+"---"+arr[indexj]);
        return max;
    }

    /*
    //{10,15,18,25,12,11}. output: {15,25}
		int[] data = {10,15,18,25,12,11};
		int fsum1 = 0;
		int ssum2 = 0;
		for (int i=2; i<data.length-1; i++){
//			sum1 = sum1 + data[0];
			int j = i+1;
			int k = data.length;
			int sum1 = 0
			while(j<k){
				sum1 = data[i]+ data[j];
				if(sum1> fsum1){
			}
		}
     */

}
