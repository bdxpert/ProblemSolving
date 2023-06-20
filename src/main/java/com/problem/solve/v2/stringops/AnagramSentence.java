package com.problem.solve.v2.stringops;

public class AnagramSentence {
    public static void main(String args[])
    {

    }
    public Boolean isAnagram(String s, String t)
    {
       String[] strOfS = s.split(" ");
       String[] strOfT = t.split(" ");
       if(strOfS.length != strOfT.length) return false;
       for(int i=0; i<strOfS.length; i++) {
           vaildateAnagram(strOfS[i], strOfT[i]);
       }
        return false;
    }
    public Boolean vaildateAnagram(String t1, String t2)
    {
        Boolean res = true;
        if(t1.length() == t2.length() ) {
            char[] t1chr = t1.toCharArray();
            for(int i=0; i<t1chr.length; i++) {
                if(t1.indexOf(t1chr[i]) < 0) {
                    res = false;
                }
            }
        } else {
            return false;
        }

         return res;
    }
}
