package com.problem.solve.v2.stringops;

public class ZIGZAG {
    public static void main(String args[])
    {
        System.out.println(convert("PAHNAPLSIIGYIR", 3));
    }
    public static String convert(String s, int numRows) {

        StringBuilder res = new StringBuilder();
//If there is only one row, return original string
        if(numRows==1) {
            return s;
        }
        //Set first factor
        int factor1 = (numRows-1)*2;
        int factor2 = 0;


        for (int j = 0; j < numRows; j++) {
            //Set second factor for each row
            factor2 = factor1 - j*2;

            for (int i = 0; i <s.length() ; i+=factor1) {

                if(i+j<s.length()){
                    res.append(s.charAt(j + i));
                }
                //First and last row have one factor only, so we continue
                if(j==0 || j==numRows-1){
                    continue;
                }

                if(j+i+factor2<s.length()){
                    res.append(s.charAt(j+i+factor2));
                }

            }
        }
        return res.toString();
    }
}
