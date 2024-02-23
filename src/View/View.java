package View;

import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public int getMenuChoice() {
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public String getInputString(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    public int getInputInt(String message) {
        System.out.print(message);
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
