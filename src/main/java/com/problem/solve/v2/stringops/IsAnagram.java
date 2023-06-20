package com.problem.solve.v2.stringops;

import java.util.Scanner;
@FunctionalInterface
interface sayable
{
    void say(String msg);
}
public class IsAnagram {

//    static boolean isAnagram(String a, String b) {
//        // Complete the function
//        Map<String,Integer> record = new HashMap<>();
//        Map<String,Integer> record2 = new HashMap<>();
//        char[] arr = a.toLowerCase().toCharArray();
//        char[] brr = b.toLowerCase().toCharArray();
//        if(a.length() != b.length()) return false;
//
//        Arrays.sort(arr);
//        Arrays.sort(brr);
//        for(int i=0; i<a.length();i++){
//            if((arr[i])!=(brr[i])) {
//                return false;
//            }
//        }
///*
//        for(int i=0;i<arr.length;i++) {
//            String ach = ("" + arr[i]).toLowerCase();
//            if(record.get(ach) !=null) {
//                int cnt = record.get(ach);
//                record.put(ach, cnt + 1);
//            }else {
//                record.put(ach,  1);
//            }
//            String bch =(""+ brr[i]).toLowerCase();
//            if(record2.get(bch) !=null) {
//                int cnt = record2.get(bch);
//                record2.put(bch, cnt + 1);
//            }else {
//                record2.put(bch,  1);
//            }
//        }
//        if(record.size() != record2.size()) return false;
//
//        Iterator<String> iterator = record.keySet().iterator();
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            if(record2.get(key) ==null || record2.get(key)!=record.get(key)) {
//                return false;
//            }
//
//        }
//
// */
//
//        return true;
//        /*record.forEach((k, v) -> {
//            if(record2.get(k) ==null || record2.get(k)!=v) {
//                res = false;
//            }
//        });*/
//
///*
//
//for(int i=0; i<a.length();i++) {
//            if(arrCnt[arr[i]-52] > 0){
//                arrCnt[arr[i]-52] = arrCnt[arr[i]-52] +1;
//            } else {
//                arrCnt[arr[i]-52] = 1;
//            }
//            //if((arr[i])!=(brr[i])) {
//              //  return false;
//            //}
//        }
//
//        for(int i=0;i<arr.length;i++) {
//            String ach = ("" + arr[i]).toLowerCase();
//            if(record.get(ach) !=null) {
//                int cnt = record.get(ach);
//                record.put(ach, cnt + 1);
//            }else {
//                record.put(ach,  1);
//            }
//            String bch =(""+ brr[i]).toLowerCase();
//            if(record2.get(bch) !=null) {
//                int cnt = record2.get(bch);
//                record2.put(bch, cnt + 1);
//            }else {
//                record2.put(bch,  1);
//            }
//        }
//        if(record.size() != record2.size()) return false;
//        Iterator<String> iterator = record.keySet().iterator();
//    while (iterator.hasNext()) {
//        String key = iterator.next();
//        if(record2.get(key) ==null || record2.get(key)!=record.get(key)) {
//                        return false;
//                    }
//
//            }
//
//
// */
//
//
//
//
//    }
static boolean isAnagram(String a, String b) {
    // Complete the function

    char[] arr = a.toLowerCase().toCharArray();
    char[] brr = b.toLowerCase().toCharArray();
    if(a.length() != b.length()) return false;

    int[] arrCnt = new int[26];
    int[] brrCnt = new int[26];


    //Arrays.sort(arr);
    //Arrays.sort(brr);
    for(int i=0; i<a.length();i++) {
        if(arrCnt[arr[i]-97] > 0){
            arrCnt[arr[i]-97] = arrCnt[arr[i]-97] +1;
        } else {
            arrCnt[arr[i]-97] = 1;
        }
        if(brrCnt[brr[i]-97] > 0){
            brrCnt[brr[i]-97] = brrCnt[brr[i]-97] +1;
        } else {
            brrCnt[brr[i]-97] = 1;
        }
    }
    for(int i=0; i<26;i++) {
        if(arrCnt[i] !=brrCnt[i]) return false;
    }

    return true;

}


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
        int[] data = new int[100];
        //myStream.forEach(x->System.out.println(x));mystream.collecitcollectors-toList0):
    }
}
