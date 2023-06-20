package com.problem.solve.v2.stringops;

public class SnakeCase {
    public static void main(String args[]){
        System.out.println(toSnake("whatIsYourName"));
    }
    public static String toSnakeCase(String str)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
           Character character = new Character(str.charAt(i));
           if(Character.isUpperCase(character)) {
               sb.append("_");
               sb.append((character));
           } else {
               sb.append(Character.toUpperCase(character));
           }
        }
        return sb.toString();
    }
    //lity in deciding when to use a lock on reading and writing.
    public static String camelToSnake(String str)
    {
        // Regular Expression
        String regex = "([a-z])([A-Z]+)";

        // Replacement string
        String replacement = "$1_$2";

        // Replace the given regex
        // with replacement string
        // and convert it to lower case.
        str = str
                .replaceAll(
                        regex, replacement)
                .toUpperCase();

        // return string
        return str;
    }
    static String toSnake(String str)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            Character chr = new Character(str.charAt(i));
            if(Character.isUpperCase(chr)){
                sb.append("_");
                sb.append((chr));
            } else {
                sb.append(Character.toUpperCase(chr));
            }
        }
        return sb.toString();

    }
}
