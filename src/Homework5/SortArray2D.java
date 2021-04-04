package Homework5;

import java.util.Random;
import java.util.Scanner;

public class SortArray2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ievadi 2D masīva rindu skaitu no 5 līdz 15: ");

        int X = scanner.nextInt();

        while (X < 5 || X > 15) {
            System.out.print("Nepareizi, ievadi no 5 līdz 15: ");
            X = scanner.nextInt();
        }

        scanner.close();
        Random random = new Random();
        int Y = random.nextInt(12) + 4;
        int[][] array2D = new int[X][Y];

        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                array2D[i][j] = random.nextInt(900) + 100;
            }
        }
        for (int[] row : array2D) {
            for (int column : row) {
                System.out.printf("%7d", column);
            }
            System.out.println();
        }

        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                for (int k = 0; k < array2D[i].length - j - 1; k++) {
                    if (array2D[i][k] < array2D[i][k + 1]) {
                        int temp = array2D[i][k];
                        array2D[i][k] = array2D[i][k + 1];
                        array2D[i][k + 1] = temp;
                    }
                }
            }
        }

        int[] temp = array2D[0];
        int oppositeIndex = array2D.length - 1;
        array2D[0] = array2D[oppositeIndex];
        array2D[array2D.length - 1] = temp;

        System.out.println();

        for (int[] row : array2D) {
            for (int column : row) {
                System.out.printf("%7d", column);
            }
            System.out.println();
        }
    }
}
