package Homework3;

import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ievadi vārdu un uzvārdu vienā rindā ar atstarpi: ");
        String fullName = scanner.nextLine();
        scanner.close();

        fullName = fullName.trim();

        String name = fullName.substring(0, fullName.indexOf(" "));
        String surname = fullName.substring(fullName.lastIndexOf(" ") +1);

        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        System.out.println("'" + name + "'");
        System.out.println("'" + surname.toUpperCase() + "'");
    }
}
