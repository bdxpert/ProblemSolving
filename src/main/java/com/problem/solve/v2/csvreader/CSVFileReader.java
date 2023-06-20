package com.problem.solve.v2.csvreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
Write a program to convert camel case string to snake case string. whatIsYourName -> WHAT_IS_YOUR_NAME
 */
public class CSVFileReader {
    public static void main(String args[]) {
        //System.out.println(toSnake(null));
        try {

           BufferedReader bf = new BufferedReader(new FileReader(CSVFileReader.class.getResource("student.csv").getPath()));
           String ln ="";
           List<Student> studentList = new ArrayList<>();
           while((ln = bf.readLine())!=null)
           {
               String[] str = ln.split(",");
               Student student = new Student();
               student.setStudentId(Integer.parseInt(str[0]));
               student.setStudentName(str[1]);
               student.setStudentDOB(str[2]);
               studentList.add(student);
           }
            //studentList.stream().forEach(Student::toString);

            studentList.stream().forEach(std->{
                System.out.println(std);
            });
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    static String toSnake(String str)
    {
        if(str == null) return str;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < str.length();i++){
            char chr = str.charAt(i);
            Character newChr = new Character(chr);
            if(Character.isUpperCase(newChr)){
                sb.append("_");
                sb.append(newChr);
            } else {
                sb.append(Character.toUpperCase(newChr));
            }
        }
        return sb.toString();
    }
    /*
    student_id, student_name, student_dob
     */
    static class Student {
        Integer studentId;
        String studentName;
        String studentDOB;

        public Integer getStudentId() {
            return studentId;
        }

        public void setStudentId(Integer studentId) {
            this.studentId = studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getStudentDOB() {
            return studentDOB;
        }

        public void setStudentDOB(String studentDOB) {
            this.studentDOB = studentDOB;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "studentId=" + studentId +
                    ", studentName='" + studentName + '\'' +
                    ", studentDOB='" + studentDOB + '\'' +
                    '}';
        }
    }
/*
Student
name, subject, mark

SELECT name, sum(mark) as totalMark FROM student GROUP BY name Order By totalMarks DESC;
zip file
search by name "Sanjunath"

find file
find -type d /usr/dir/ -type f  "abc.txt"
chmode 475 finlename
rwx
 */
}
