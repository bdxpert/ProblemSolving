package com.problem.solve.v2.streamAPI;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleLambda {
    class Notes{
        Integer id;
        String tagName;
        int count;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }

        public Notes(int id, String tagName, int count) {
            this.id = id;
            this.tagName = tagName;
            this.count = count;
        }
    }

    public static void main(String args[]){
        printCountEachCharacter();
        List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

        // The lambda expression passed to
        // reduce() method takes two Strings
        // and returns the longer String.
        // The result of the reduce() method is
        // an Optional because the list on which
        // reduce() is called may be empty.
        Optional<String> longestString = words.stream()
                .reduce((word1, word2)
                        -> word1.length() > word2.length()
                        ? word1 : word2);

        // Displaying the longest String
        longestString.ifPresent(System.out::println);



        List<String> list = new ArrayList<>();
        list.add("aa");list.add("bb"); list.add("aa");list.add("bb");

        System.out.println(list.stream().collect(Collectors.groupingBy(s->s))
                .entrySet().stream().filter(ent->ent.getValue().size()>1).map(ent->ent.getKey()).collect(Collectors.toList()));
        /*
        Given a string of lowercase letters, return a map of individual characters as keys and
        their occurrences in a string as values. You are only allowed to use Java Stream to solve this.
         */
        String str = "abcdEeff";
        System.out.println(Arrays.stream(str.split("")).map(e->e.toLowerCase()).
                collect(Collectors.groupingBy(s->s)).entrySet().stream().
                collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)));

        System.out.println(Arrays.stream(str.split("")).
                collect(Collectors.groupingBy(s->s, Collectors.counting())));

        String s = "giraffe";
//        Map<String, Long> freq =
                Arrays.stream(s.split("")).collect(
                Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream().filter(ent->ent.getValue()>=1).forEach(System.out::println);

//        freq.entrySet().forEach(System.out::println);
    }
    //Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
    void findEvenNumbers()
    {
        int[] arr = {1,3,5,6,7,8};
        // Version 1
        List<Integer> rec = Arrays.stream(arr).filter(item->item%2==0).boxed().toList();
        //Version 2
        int[] res = Arrays.stream(arr).filter(i->i%2==0).toArray();
    }
    //Given a list of integers, find out all the numbers starting with 1 using Stream functions?
    void getAllNumberStartWith1()
    {
        int[] arr = {1,3,5,6,7,8, 10, 101};
        List<Integer> input = Arrays.asList(1,3,5,6,7,8, 10, 101);
        List<Integer> res = input.stream().map(i-> i +"").filter(i->i.startsWith("1")).map(Integer::parseInt).collect(Collectors.toList());
    }
    // 3. How to find duplicate elements in a given integers list in java using Stream functions?
    void findDUplicateList()
    {
        int[] arr = {1,3,7,3,5,6,7,8, 10, 101};
        System.out.println(Arrays.asList(arr).stream()
                .collect(Collectors.groupingBy(d->d)).entrySet()
                .stream().filter(ent->ent.getValue().size()>1).collect(Collectors.toList()));

        // total number of element present in the list
        Arrays.asList(arr).stream().count();
    }
    void maximumNumber()
    {
        int[] arr = {1,3,5,3,5,6,7,8, 10, 101};
        List<Integer> arrList = Arrays.asList(1,3,4,6,7);
        arrList.stream().max(Integer::compare).get();
        String[] arrStr = {"1", "3", "5"};

        Integer[] res = Arrays.stream(arrStr).map(Integer::valueOf).toArray(Integer[]::new);
        int[] resInt = Arrays.stream(arrStr).mapToInt(Integer::valueOf).toArray();
    }
    //7. Given a String, find the first non-repeated character in it using Stream functions?
    void firstNonRepeatedChar()
    {
        String data ="attax";
        Arrays.asList(data.split("")).stream()
                .collect(Collectors.groupingBy(s->s, Collectors.counting()))
                .entrySet().stream().filter(ent->ent.getValue()==1L).map(Map.Entry::getKey).findFirst();

        //8. Given a String, find the first repeated character in it using Stream functions?
        Arrays.asList(data.split("")).stream()
                .collect(Collectors.groupingBy(s->s, Collectors.counting()))
                .entrySet().stream().filter(ent->ent.getValue()>1L).map(Map.Entry::getKey).findFirst();


    }
    //9. Given a list of integers, sort all the values present in it using Stream functions?
    void sortAllValues()
    {
        List<Integer> arrList = Arrays.asList(1,3,4,6,7);
        // Ascending order
        arrList.stream().sorted(Integer::compare).collect(Collectors.toList());
        // dscending order
        arrList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }
    //13. Write a Java 8 program to concatenate two Streams?
    void concatTwoStream()
    {
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");
        Stream<String> concatStream = Stream.concat(list2.stream(), list1.stream());
    }
    //14. Java 8 program to perform cube on list elements and filter numbers greater than 50.
    void performQube(){
        List<Integer> arrList = Arrays.asList(1,3,4,6,7);
        arrList.stream().map(item->item*item*item).filter(item->item>50).collect(Collectors.toList());
    }
    //16. How to use map to convert object into Uppercase in Java 8?


    //17. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
    void sortListData()
    {
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));

        noteLst.add(new Notes(6, "note4", 66));

        Map<String, Integer> notesMap = noteLst.stream().
                sorted(Comparator.comparingInt(Notes::getId).reversed()).
                collect(Collectors.toMap(Notes::getTagName, Notes::getId, (oldValue, newValue) -> oldValue,LinkedHashMap::new));


    }

    //18. How to count each element/word from the String ArrayList in Java8?
    void countElement()
    {
        List<String> str = Arrays.asList("aa", "df", "cc", "aa");
        Map<String, Long> res = str.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    //19. How to find only duplicate elements with its count from the String ArrayList in Java8?
    void findDuplicate()
    {
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> namesCount = names
                .stream()
                .filter(x->Collections.frequency(names, x)>1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    //20. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
    void listEmpty()
    {
        List<Notes> noteLst = new ArrayList<>();

        Optional.ofNullable(noteLst)
                .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
                .stream().filter(Objects::nonNull) //loop throgh each object and consider non null objects
                .map(Notes::getTagName) // method reference, consider only tag name
                .forEach(System.out::println); // it will print tag names
    }
    //21. Write a Program to find the Maximum element in an array?
    void maxElement()
    {
        List<Integer> arrList = Arrays.asList(1,3,4,6,7);
        arrList.stream().max(Integer::compare).get();

        int[] arr = {1,3,5,3,5,6,7,8, 10, 101};
        Arrays.stream(arr).max().getAsInt();
    }

    //22. Write a program to print the count of each character in a String?
    static void printCountEachCharacter()
    {
        String str = "aBccA";
        Arrays.stream(str.split(""))
                .map(String::toUpperCase)
                .collect(Collectors.groupingBy(i->i,LinkedHashMap::new, Collectors.counting()));
                //.entrySet().stream().map(Map.Entry::getKey, Map.Entry::getValue, (oldi, newi)-> oldi, LinkedHashMap::new).;
    }




}
