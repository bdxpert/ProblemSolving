package com.problem.solve.v2.number;

public class PlusOne {
    /*
    Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
     */
    public int[] plusOne(int[] digits) {

        if((digits[digits.length-1] +1) > 9){
            int[] res = new int[digits.length+1];
            int remainVal = 1;
            //res[digits.length] = 0;
            for (int i=digits.length-1;i>=0;i--) {
                if((digits[i] +remainVal) > 9) {
                    res[i+1] = 0;
                    remainVal = 1;
                } else {
                    res[i+1] = digits[i] + remainVal;
                    remainVal = 0;
                }
            }
            if(remainVal ==1 ){
                res[0] = remainVal;
                return res;
            } else {
                int[] res2 = new int[digits.length];
                for(int i=1;i<=digits.length;i++){
                    res2[i-1] = res[i];
                }
                return res2;
            }

        } else {
            digits[digits.length-1] = digits[digits.length-1] +1;
            return digits;
        }
    }

    public int[] plusOnev2(int[] digits) {

        // Reverse iteration of the array
        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            else
                digits[i] = 0;
        }

        // The array has only '9'
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;

        return newDigits;
    }
}
