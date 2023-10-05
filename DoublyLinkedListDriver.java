import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

public class DoublyLinkedListDriver {
    public static void main(String[] args) {
        File input = new File(args[0]);
        System.out.print("Enter list type (i - int, d - double, s - string): ");
        Scanner keyboard = new Scanner(System.in);
        String listType = keyboard.next();
        if (listType.equals("i")) {
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
            try {
                Scanner fileReader = new Scanner(input);
                while (fileReader.hasNext()) {
                    list.insertItem(fileReader.nextInt());
                }
                fileReader.close();
            } catch (FileNotFoundException fnfe) {
                System.out.println("File not found.");
            }
            runInt(list);(list);  
        } else if (listType.equals("d")) {
            DoublyLinkedList<Double> list = new DoublyLinkedList<>();
            try {
                Scanner fileReader = new Scanner(input);
                while (fileReader.hasNext()) {
                    list.insertItem(fileReader.nextDouble());
                }
                fileReader.close();
            } catch (FileNotFoundException fnfe) {
                System.out.println("File not found.");
            }
            runDouble(list);  
        } else if (listType.equals("s")) {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            try {
                Scanner fileReader = new Scanner(input);
                while (fileReader.hasNext()) {
                    list.insertItem(fileReader.next());
                }
                fileReader.close();
            } catch (FileNotFoundException fnfe) {
                System.out.println("File not found.");
            }
            runString(list);  
        } else {
            System.out.println("Invalid response. Exitting prgram");
            System.exit(0);
        }
        keyboard.close();
    }

    public static void runInt(DoublyLinkedList<Integer> list) {
        
        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Length");
        System.out.println("(t) - Print reverse");
        System.out.println("(r) - Reverse list");
        System.out.println("(b) - Delete subsection");
        System.out.println("(s) - Swap alternating");
        System.out.println("(q) - Quit program");
        System.out.println();

        Scanner keyboard = new Scanner(System.in);
        boolean isRunning = true;
        String userInput;
        while(isRunning) {
            System.out.println();
            System.out.print("Enter a command: ");
            userInput = keyboard.next();
            userInput.trim();
            switch (userInput) {
                case "p":
                    System.out.print("The list is: ");
                    list.print();
                    break;
                
                case "t":
                    System.out.print("The reverse list is: ");
                    list.printReverse();
                    break;
                
                case "l":
                    System.out.print("The length of the list is " + list.length());
                    break;

                case "i":
                    list.print();
                    System.out.print("Enter number to insert:");
                    int insertNum = keyboard.nextInt();
                    list.insertItem(insertNum);
                    list.print();
                    list.printReverse();
                    break;

                case "d":
                    list.print();
                    System.out.print("Enter a number to delete");
                    int delNum = keyboard.nextInt();
                    list.deleteItem(delNum);
                    list.print();
                    list.printReverse();

                case "b":
                    System.out.print("Enter the lower bound");
                    int low = keyboard.nextInt();
                    System.out.print("Enter the upper bound:");
                    int high = keyboard.nextInt();
                    list.print();
                    list.deleteSubsection(low, high);
                    list.print();

                case "s":
                    list.print();
                    list.swapAlternate();
                    list.print();
                    list.printReverse();

                case "r":
                    list.print();
                    list.reverseList();
                    list.print();
                    list.printReverse();

                default:
                    System.out.println("Invalid command try again.");
                    break;
            }
        }
        keyboard.close();
    }
}

public static void runDouble(DoublyLinkedList<Double> list) {
        
        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Length");
        System.out.println("(t) - Print reverse");
        System.out.println("(r) - Reverse list");
        System.out.println("(b) - Delete subsection");
        System.out.println("(s) - Swap alternating");
        System.out.println("(q) - Quit program");
        System.out.println();

        Scanner keyboard = new Scanner(System.in);
        boolean isRunning = true;
        String userInput;
        while(isRunning) {
            System.out.println();
            System.out.print("Enter a command: ");
            userInput = keyboard.next();
            userInput.trim();
            switch (userInput) {
                case "p":
                    System.out.print("The list is: ");
                    list.print();
                    break;
                
                case "t":
                    System.out.print("The reverse list is: ");
                    list.printReverse();
                    break;
                
                case "l":
                    System.out.print("The length of the list is " + list.length());
                    break;

                case "i":
                    list.print();
                    System.out.print("Enter number to insert:");
                    Double insertNum = keyboard.nextDouble();
                    list.insertItem(insertNum);
                    list.print();
                    list.printReverse();
                    break;

                case "d":
                    list.print();
                    System.out.print("Enter a number to delete");
                    double delNum = keyboard.nextDouble();
                    list.deleteItem(delNum);
                    list.print();
                    list.printReverse();

                case "b":
                    System.out.print("Enter the lower bound");
                    double low = keyboard.nextDouble();
                    System.out.print("Enter the upper bound:");
                    double high = keyboard.nextDouble();
                    list.print();
                    list.deleteSubsection(low, high);
                    list.print();

                case "s":
                    list.print();
                    list.swapAlternate();
                    list.print();
                    list.printReverse();

                case "r":
                    list.print();
                    list.reverseList();
                    list.print();
                    list.printReverse();

                default:
                    System.out.println("Invalid command try again.");
                    break;
            }
        }
        keyboard.close();
    }

    public static void runString(DoublyLinkedList<String> list) {
        
        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Length");
        System.out.println("(t) - Print reverse");
        System.out.println("(r) - Reverse list");
        System.out.println("(b) - Delete subsection");
        System.out.println("(s) - Swap alternating");
        System.out.println("(q) - Quit program");
        System.out.println();

        Scanner keyboard = new Scanner(System.in);
        boolean isRunning = true;
        String userInput;
        while(isRunning) {
            System.out.println();
            System.out.print("Enter a command: ");
            userInput = keyboard.next();
            userInput.trim();
            switch (userInput) {
                case "p":
                    System.out.print("The list is: ");
                    list.print();
                    break;
                
                case "t":
                    System.out.print("The reverse list is: ");
                    list.printReverse();
                    break;
                
                case "l":
                    System.out.print("The length of the list is " + list.length());
                    break;

                case "i":
                    list.print();
                    System.out.print("Enter String to insert:");
                    String insertNum = keyboard.next();
                    list.insertItem(insertNum);
                    list.print();
                    list.printReverse();
                    break;

                case "d":
                    list.print();
                    System.out.print("Enter a String to delete");
                    String delNum = keyboard.next();
                    list.deleteItem(delNum);
                    list.print();
                    list.printReverse();

                case "b":
                    System.out.print("Enter the lower bound");
                    String low = keyboard.next();
                    System.out.print("Enter the upper bound:");
                    String high = keyboard.next();
                    list.print();
                    list.deleteSubsection(low, high);
                    list.print();

                case "s":
                    list.print();
                    list.swapAlternate();
                    list.print();
                    list.printReverse();

                case "r":
                    list.print();
                    list.reverseList();
                    list.print();
                    list.printReverse();

                default:
                    System.out.println("Invalid command try again.");
                    break;
            }
        }
        keyboard.close();
    }
}
