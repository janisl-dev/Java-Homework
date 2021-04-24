package Homework6;

import java.util.Scanner;

public class Main {

    public static void taskCreation(ToDoItems list, Scanner scanner) {
        boolean doLoop = true;
        while (doLoop) {
            System.out.print(String.format("%s. jaunās darāmās lietas nosaukums sarakstā \"%s\": ", list.getSize(), list.getTitle()));
            String description = scanner.nextLine();
            System.out.print("Norādi prioritāti (low, medium, high): ");
            try {
                Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());
                ToDoItem item = new ToDoItem(0, description, priority, false);
                list.insertItem(item);
                list.addItem(item);
            } catch (java.lang.IllegalArgumentException e) {
                System.out.println("Tāda prioritāte neeksistē, darāmā lieta nav izveidota");
            }

            System.out.print("Spied jebkuru taustiņu, lai turpinātu vai \"q\", lai beigtu ievadi: ");
            String exit = scanner.nextLine();
            if (exit.equals("q")) {
                doLoop = false;
            }
        }
    }

    public static void main(String[] args) {

        System.out.print("Ievadi darāmo lietu saraksta nosaukumu: ");
        Scanner scanner = new Scanner(System.in);
        Connection connection = new Connection();
        String todoName = scanner.nextLine();
        ToDoItems object = new ToDoItems(todoName, connection.getConnection());

        boolean doCycle = true;
        while (doCycle) {

            System.out.println("Izvēlies darbību:\n\n" +
                    "1. Pievienot darāmās lietas\n" +
                    "2. Atzīmēt kā izdarītu\n" +
                    "3. Parādīt visas darāmās lietas\n" +
                    "4. Parādīt neizdarītās lietas\n" +
                    "5. Parādīt izdarītās lietas\n" +
                    "6. Izdzēst darāmo lietu\n" +
                            "7. Beigt darbu");

            String opcija = scanner.nextLine();

            switch (opcija) {
                case "1":
                    taskCreation(object, scanner);
                    break;
                case "2":
                    object.displayItems();
                    object.markCompletion(scanner.nextInt(), true);
                    break;
                case "3":
                    object.displayItems();
                    break;
                case "4":
                    object.displayUncompletedItems();
                    break;
                case "5":
                    object.displayCompletedItems();
                    break;
                case "6":
                    System.out.println("Ievadi darāmās lietas ID");
                    object.deleteItem(scanner.nextInt());
                    break;
                case "7":
                    doCycle = false;
                    break;
            }
        }
        scanner.close();
    }
}
