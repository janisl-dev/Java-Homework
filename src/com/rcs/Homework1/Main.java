package com.rcs.Homework1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class    Main {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ievadi grādus pēc Fārenheita: ");
        float F = scanner.nextFloat();
        scanner.close();
        float C = 5 * (F - 32) / 9;
        char c = '\u2103';
        char f = '\u2109';
        System.out.println("Grādi pēc Fārenheita: " + df.format(F) + f);
        System.out.println("Grādi pēc Celsija: " + df.format(C) + c);
    }
}
