package com.problem.solve.v2.number;

public class Calculator {
    int n = 100;
    public void cal(int n){
        this.n = n * 10;
    }
    public void print(){
        System.out.println(n);
    }
    public static void main(String args[]){
        Calculator obj = new Calculator();
        obj.cal(2);
        obj.print();
    }
}
