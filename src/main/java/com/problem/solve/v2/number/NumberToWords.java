package com.problem.solve.v2.number;

import java.util.Scanner;

public class NumberToWords {
    private static final String[] units = { "", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen" };
    private static final String[] tens = { "", "", "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety" };
    private static final String[] fractions = { "zero", "tenths", "hundredths", "thousandths", "ten-thousandths", "hundred-thousandths", "millionths" };

    private static String convertNumberToWords(int number) {
        if (number == 0) {
            return "zero";
        }
        if (number < 0) {
            return "minus " + convertNumberToWords(Math.abs(number));
        }
        String words = "";
        if ((number / 1000000) > 0) {
            words += convertNumberToWords(number / 1000000) + " million ";
            number %= 1000000;
        }
        if ((number / 1000) > 0) {
            words += convertNumberToWords(number / 1000) + " thousand ";
            number %= 1000;
        }
        if ((number / 100) > 0) {
            words += convertNumberToWords(number / 100) + " hundred ";
            number %= 100;
        }
        if (number > 0) {
            if (number < 20) {
                words += units[number];
            } else {
                words += tens[number / 10] + " " + units[number % 10];
            }
        }
        return words.trim();
    }

    private static String convertDecimalToWords(int decimal) {
        String words = convertNumberToWords(decimal);
        if (decimal > 1) {
            words += " " + fractions[decimal];
        }
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double number = scanner.nextDouble();
        scanner.close();
        int wholeNumber = (int) number;
        int decimal = (int) ((number - wholeNumber) * 100);
        String wholeNumberWords = convertNumberToWords(wholeNumber);
        String decimalWords = convertDecimalToWords(decimal);
        System.out.println("Number in words: " + wholeNumberWords + " dollars and " + decimalWords + " cents");
    }
}