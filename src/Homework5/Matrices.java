package Homework5;

import java.util.Random;
import java.util.Scanner;

public class Matrices {
    public static void main(String[] args) {
        Random random = new Random();
        int N = random.nextInt(4) + 3;
        int[][] array2D = new int[N][N];

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ievadi A, lai norādītu masīva vērtības manuāli vai B, " +
                "lai piešķirtu masīva elementiem nejauši izvēlētas vērtības no 1 līdz 100: ");
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("A") && !input.equalsIgnoreCase("B")) {
            System.out.print("Nepareizi, ievadi A vai B: ");
            input = scanner.nextLine();
        }
        if (input.equalsIgnoreCase("A")) {
            for (int i = 0; i < array2D.length; i++) {
                for (int j = 0; j < array2D[i].length; j++) {
                    System.out.printf("Masīvs[%d][%d] = ", i, j);
                    array2D[i][j] = scanner.nextInt();
                }
            }
            System.out.println();
        }
        else if (input.equalsIgnoreCase("B")) {
            for (int i = 0; i < array2D.length; i++) {
                for (int j = 0; j < array2D[i].length; j++) {
                    array2D[i][j] = random.nextInt(100) + 1;
                }
            }
            scanner.close();
        }
        for (int[] row : array2D) {
            for (int column : row) {
                System.out.printf("%8d", column);
            }
            System.out.println();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    array2D[i][j] = 0;
                }
            }
        }
        System.out.println();
        for (int[] row : array2D) {
            for (int column : row) {
                System.out.printf("%8d", column);
            }
            System.out.println();
        }
    }
}