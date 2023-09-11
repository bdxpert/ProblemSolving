package com.problem.solve.v2.streamAPI;

import java.util.*;
import java.util.stream.Collectors;

//Reference: https://blog.devgenius.io/java-8-real-time-coding-interview-questions-and-answers-fce01f3c4080
public class EmployeeStreamOps {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public EmployeeStreamOps(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public static void main(String[] args)
    {
        List<EmployeeStreamOps> employeeList = new ArrayList<EmployeeStreamOps>();

        employeeList.add(new EmployeeStreamOps(111, "Aryan Huia", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new EmployeeStreamOps(122, "Paul Miun", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new EmployeeStreamOps(133, "Mkis Lops", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new EmployeeStreamOps(144, "Lopa Sar", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new EmployeeStreamOps(155, "Miok Seoy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new EmployeeStreamOps(166, "Sana ussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new EmployeeStreamOps(177, "Kolo Sai", 35, "Male", "Account And Finance", 2010, 27000.0));

    }

    /*
     * 1. Find out the count of male and female employees present in the organization?
     */
    void findCountOfMaleFemale(List<EmployeeStreamOps> employees)
    {
        // novice solution
        employees.stream().filter(emp->emp.getGender().equals("Male")).count();
        employees.stream().filter(emp->emp.getGender().equals("Female")).count();
        // best solution
        Map<String, Long> noOfMaleAndFemaleEmployees =
                employees.stream()
                        .collect(Collectors.groupingBy(EmployeeStreamOps::getGender, Collectors.counting()));

        System.out.println(noOfMaleAndFemaleEmployees);
    }
    /*
     * 2. Write a program to print the names of all departments in the organization.
     */
    void getDepartments(List<EmployeeStreamOps> employees)
    {
        // not a optimize solutions
        List<String> departments = employees.stream().collect(Collectors.groupingBy(EmployeeStreamOps::getDepartment)).entrySet().stream().map(emp->emp.getKey()).collect(Collectors.toList());
        System.out.println(departments);
        // Best solutions
        employees.stream()
                .map(EmployeeStreamOps::getDepartment)
                .distinct()
                .forEach(System.out::println);
    }
    // 3. Find the average age of Male and Female Employees.
    void getAvgEmpAge(List<EmployeeStreamOps> employees)
    {
        // this is employee agv age
        employees.stream().map(emp->emp.getAge()).mapToDouble(d->d).average();
        // male and female employee age(similar to male & female age count)
        Map<String, Double> avgAge = employees.stream()
                .collect(Collectors.groupingBy(EmployeeStreamOps::getGender,
                                Collectors.averagingInt(EmployeeStreamOps::getAge)));
    }

    // 4. Get the Names of employees who joined after 2015.
    void getNumberOfEmployeeAfter2015(List<EmployeeStreamOps> employees)
    {
        employees.stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .map(EmployeeStreamOps::getName)
                .forEach(System.out::println);

        employees.stream().filter(emp->emp.getYearOfJoining()>2015).map(EmployeeStreamOps::getName).
                collect(Collectors.toList());
    }
    // 5. Count the number of employees in each department.
    void countNoOfEmployeeByDept(List<EmployeeStreamOps> employees)
    {
        Map<String, Long> res= employees.stream().
                collect(Collectors.groupingBy(EmployeeStreamOps::getDepartment, Collectors.counting()));
        Set<Map.Entry<String, Long>> resEntry =res.entrySet();
        for(Map.Entry<String, Long> entry:resEntry){
            System.out.println("Dept::"+entry.getKey());
            System.out.println("Count::"+entry.getValue());
        }
    }
    // 6. Find out the average salary of each department.
    void findAvgSalaryByDept(List<EmployeeStreamOps> employees) {
        Map<String, Double> res =employees.stream().collect(Collectors.groupingBy(EmployeeStreamOps::getDepartment,
                Collectors.averagingDouble(EmployeeStreamOps::getSalary)));
        for(Map.Entry<String, Double> entry: res.entrySet()) {
            System.out.println("Dept::"+entry.getKey());
            System.out.println("AvgSalary::"+entry.getValue());
        }
    }
    //7. Find out the oldest employee, his/her age and department?
    void findOldestEmployeeByDept(List<EmployeeStreamOps> employees) {
        Optional<EmployeeStreamOps> emp=
                employees.stream().max(Comparator.comparing(EmployeeStreamOps::getAge));
        if(emp.isPresent()) {
            EmployeeStreamOps empRe = emp.get();
            System.out.println("Dept::"+empRe.getDepartment());
            System.out.println("Name::"+empRe.getName());
            System.out.println("Age::"+empRe.getAge());
        }
    }
    //8. Find out the average and total salary of the organization.
    void findAvgAndTotalSalaryEmployeeByDept(List<EmployeeStreamOps> employees) {
        DoubleSummaryStatistics re = employees.stream().collect(Collectors.summarizingDouble(EmployeeStreamOps::getSalary));

        System.out.println("Avg::"+re.getAverage());
        System.out.println("SUM::"+re.getSum());
    }
    //9. List down the employees of each department.
    void employeeForEachDept(List<EmployeeStreamOps> employees)
    {
        Map<String, List<EmployeeStreamOps>> res = employees.stream().collect(Collectors.groupingBy(EmployeeStreamOps::getDepartment));
        for(Map.Entry<String,List<EmployeeStreamOps>> data:res.entrySet()) {

            List<EmployeeStreamOps> employeeStreamOpsList = data.getValue();
        }
    }
    // 10. Find out the height of experienced employees in the organization
    void getExperienceEmployee(List<EmployeeStreamOps>  employees)
    {
        Optional<EmployeeStreamOps> res = employees.stream().sorted(Comparator.comparing(EmployeeStreamOps::getYearOfJoining)).findFirst();
        System.out.println(res.get().getName());
        System.out.println(res.get().getAge());
        System.out.println(res.get().getDepartment());
        System.out.println(res.get().getYearOfJoining());
    }
}