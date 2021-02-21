package com.rcs.Homework1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ievadi grādus pēc Fārenheita: ");
        float F = scanner.nextFloat();
        float C = ((5*(F-32))/9);
        System.out.println("Grādi pēc Fārenheita: " + F);
        System.out.println("Grādi pēc Celsija: " + C);
    }
}
