package Homework4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ievadi masīva izmēru no 20 līdz 40: ");
        int arraySize = scanner.nextInt();
        while (arraySize < 20 || arraySize > 40) {
            System.out.print("Nepareizi, ievadi no 20 līdz 40: ");
            arraySize = scanner.nextInt();
        }
        scanner.close();
        int[] array = new int[arraySize];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(90) + 10;
        }
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        System.out.println(Arrays.toString(array));
    }
}


