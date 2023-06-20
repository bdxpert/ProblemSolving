package com.problem.solve.v2.hashmap;

import java.time.LocalDate;
import java.util.*;

class Student implements Comparable<Student> {
    public int id;
    public String name;
    public LocalDate dob;

    public Student(String name, int id, LocalDate dob) {
        this.name = name;
        this.id = id;
        this.dob = dob;
    }

//    public int hashCode() {
//        return this.id;
//    }
//    public int hashCode() {
//        int res = 37;
//        res = res + Integer.hashCode(this.id);
//        res = res + this.name.hashCode();
//        return res;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dob);
    }

    public String toString() {
        return "Student: " + this.name + "@" +
                Integer.toHexString(hashCode());
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student s = (Student) o;
            return s.id == this.id ? true : false;
        }
        return false;
    }
    public int compareTo(Student std)
    {
        return name.compareTo(std.name);
    }
}

public class UpdateHashSet {
    public static void main(String[] args) {
        HashSet<Student> studentList = new HashSet<>();
        Student st1 = new Student("Nimit", 1, LocalDate.now());
        Student st2 = new Student("Rahul", 3, LocalDate.now().minusMonths(1));
        Student st3 = new Student("Nimit", 2, LocalDate.now().minusMonths(2));
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        System.out.println(studentList.size());
        st1.id = 3;
        System.out.println(studentList.size());
        TreeMap<Student, String> treeMapTest = new TreeMap<>();
        treeMapTest.put(st1, "d");

        TreeMap<LocalDate, Student> treeMap = new TreeMap<>();
        treeMap.put(LocalDate.now(), st1);
        treeMap.put(LocalDate.now().minusMonths(1), st2);
        treeMap.put(LocalDate.now().minusMonths(2), st3);

        SortedMap<LocalDate, Student> newMap = treeMap.subMap(LocalDate.now().minusMonths(2), LocalDate.now().plusDays(2));
        for (Map.Entry<LocalDate, Student> data:  newMap.entrySet()) {
            System.out.println("Key::"+data.getKey());
            System.out.println("Map::"+data.getValue());
        }
        //newMap.subMap()
        //(s1, s2)->{s1.getDob()>s2.getDob()}
        TreeSet<Student> treeSet = new TreeSet<>();
        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);

        SortedSet<Student> newTreeSet = treeSet.subSet(new Student("",0, LocalDate.now().plusDays(2)), new Student("", 0,LocalDate.now().minusMonths(3)));
        for (Student student:  newTreeSet) {
            System.out.println("DOB::"+student.getDob());
            System.out.println("Name::"+student.getName());
            System.out.println("ID::"+student.getId());
        }
        //Collections.binarySearch();
    }
}
