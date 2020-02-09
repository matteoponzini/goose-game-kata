package it.matteoponzini;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Type command: ");
            String command = scanner.nextLine();
            System.out.println(command);
        }
    }
}
