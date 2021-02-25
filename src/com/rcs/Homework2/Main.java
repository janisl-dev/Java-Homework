package com.rcs.Homework2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ievadi X koordinātu ");
        int x = scanner.nextInt();
        System.out.print("Ievadi Y koordinātu ");
        int y = scanner.nextInt();
        scanner.close();
        if ((x > -2 && x < 3) && (y > -4 && y < 1)) {
            System.out.println("Koordinātas (" + x + "; " + y + ") atrodas figūras iekšpusē");
        } else if ((x == -2 || x == 3) && (y == 1 || y == -4)) {
            System.out.println("Koordinātas (" + x + "; " + y + ") atrodas uz figūras līnijas");
        } else {
            System.out.println("Koordinātas (" + x + "; " + y + ") atrodas figūras ārpusē");

        }

    }

}

