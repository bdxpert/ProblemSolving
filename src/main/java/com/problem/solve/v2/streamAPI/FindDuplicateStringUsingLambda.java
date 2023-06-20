package com.problem.solve.v2.streamAPI;
/* Find duplicate in list java 8 from list of strings? */
//https://rathod-ajay.medium.com/senior-java-dev-interview-question-2023-series-17-contains-all-the-interview-questions-till-now-a3dd19121d67
//https://rathod-ajay.medium.com/java-developer-interview-question-series-7-coding-specific-acade80df710
import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateStringUsingLambda {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape", "orange");

        List<String> duplicates = strings.stream()
                .collect(Collectors.groupingBy(s -> s))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("Duplicates: " + duplicates);
        HashSetTest hashSetTest= new HashSetTest();
        hashSetTest.doSomethingWithHashSet();
    }

    List<String> myList(List<String> data)
    {
        return data.stream().collect(Collectors.groupingBy(s->s))
                .entrySet()
                .stream()
                .filter(val->val.getValue().size()>1)
                .map(ent->ent.getKey())
                .collect(Collectors.toList());
    }
    void eleminateDistinct()
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 3, 2, 5, 6, 4, 7, 8, 7, 6);

        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }
    void toUpperCaseLambda() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        List<String> upperCaseNames = names.stream()
                                      .map(String::toUpperCase)
                                      .collect(Collectors.toList());
                                      // Result: ["JOHN", "ALICE", "BOB"]
    }
    void flatmap()
    {
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<Integer> flattenedNumbers = numbers.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        // Result: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
    /*
    Find all employees who live in ‘Pune’ city,
    sort them by their name, and print the names of employees.
     */
    static class Employee{
        private Integer id;
        private String name;
        private String city;

        public Employee(Integer id,String name, String city) {
            this.id = id;
            this.name = name;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
    void sortByName()
    {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"sss", "sssd"));
        employeeList.stream()
                .filter(e -> e.getCity().equalsIgnoreCase("Pune"))
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(e -> System.out.println(e.getName()));
    }
    /*
    Find the Book id from a map whose name is “java” using stream API java-8.
    */
    void getBook()
    {
        Map<String, String> books = new HashMap<>();
        books.put("123-A", "DS");
        books.put( "324-A", "c++");
        books.put("213-B", "Java");
        //To create stream for map use entrySet and then stream.
        Optional<String> result = books.entrySet().
                stream().
                filter(e -> e.getValue().equalsIgnoreCase("Java")).
                map(Map.Entry::getKey).findFirst();
        System.out.println(result);
    }
    //Find the occurrence of names of employees from
    // the List<Employee>, and find the frequency of each name.
    void findEmployeeCount()
    {
        Employee emp1 = new Employee(1,"Ajay","dd");
        Employee emp2 = new Employee(1,"name","df");
        Employee emp3 = new Employee(1,"Ajay","fg");
        Employee emp4 = new Employee(1,"name","ffg");
        Employee emp5 = new Employee(1,"Ajay","ssss");

        List<Employee> empList = Arrays.asList(emp1,emp2,emp3,emp4,emp5);

        Map<String,Long> answer = empList.stream().
                                  collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));

        System.out.println(answer);
    }
//    Query to find employee numbers in each department.
//    SELECT emp_dept, COUNT(*) FROM emp_details GROUP BY emp_dept;
    //What would be the size of the HashSet?
    // What can we do to stop HashSet from adding duplicate students with the same name?
    // please tell us about the workaround.
static class HashSetTest {

    public  void doSomethingWithHashSet() {
        HashSet<Student> student = new HashSet();
        student.add(new Student("Ajay"));
        student.add(new Student("Ajay"));
        System.out.println("sizze of hashset : "+student.size());
    }

    /*public static void main(String[] args) {
        doSomethingWithHashSet();

    }*/
}
  static   class Student {

        String name;
        public Student(String name) {
            this.name = name;
        }
    }
}