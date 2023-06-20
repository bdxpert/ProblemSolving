package com.problem.solve.v2.csvreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CSVReaderV2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/root/customers/data.csv"));
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        List<Customer> customers = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] cd = lines.get(i).split(",");
            Customer customer = new Customer(Integer.parseInt(cd[0]), cd[1], cd[2], cd[3], cd[4], cd[5], Integer.parseInt(cd[6]), Double.parseDouble(cd[7]));
            customers.add(customer);
        }
        System.out.println("Total customers:");
        System.out.println(customers.size());
        Map<String, Integer> byCity = getCountByCity(customers);
        System.out.println("Customers by city:");
        for (Map.Entry<String, Integer> entry : byCity.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Customers by country:");
        Map<String, Integer> byCountry = getCountByCountry(customers);
        for (Map.Entry<String, Integer> entry : byCountry.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Country with the largest number of customers' contracts:");
        printCountryWithLargestNumberOfContracts(customers);
        System.out.println("Unique cities with at least one customer:");
        System.out.println(byCity.size());
    }


    public static void printCountryWithLargestNumberOfContracts(List<Customer> customers) {
        Map<String, Integer> map = new HashMap<>();
        for (Customer c : customers) {
            map.put(c.country, map.getOrDefault(c.country, 0) + c.contrcnt);
        }
        Map.Entry<String, Integer> maxEntry = map.entrySet().stream().
                max(Map.Entry.comparingByValue()).get();
        System.out.println(maxEntry.getKey() + " (" + maxEntry.getValue() + " contracts)");
    }

    public static Map<String, Integer> getCountByCity(List<Customer> customers) {
        Map<String, Integer> map = new TreeMap<>();
        for (Customer c : customers) {
            map.put(c.city, map.getOrDefault(c.city, 0) + 1);
        }
        return map;
    }


    public static Map<String, Integer> getCountByCountry(List<Customer> customers) {
        Map<String, Integer> map = new TreeMap<>();
        for (Customer c : customers) {
            map.put(c.country, map.getOrDefault(c.country, 0) + 1);
        }
        return map;
    }


    static class Customer {
        int id;
        String name;
        String city;
        String country;
        String cperson;
        String emplcnt;
        int contrcnt;
        double contrcost;


        public Customer(int id, String name, String city, String country, String cperson, String emplcnt, int contrcnt, double contrcost) {
            this.id = id;
            this.name = name;
            this.city = city;
            this.country = country;
            this.cperson = cperson;
            this.emplcnt = emplcnt;
            this.contrcnt = contrcnt;
            this.contrcost = contrcost;
        }
    }
}