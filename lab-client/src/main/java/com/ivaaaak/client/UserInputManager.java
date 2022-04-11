package com.ivaaaak.client;

import com.ivaaaak.client.util.FileManager;

import java.util.Scanner;

public class UserInputManager {

    /**
     * This class reads user input from keyboard or from file with the script
     */

    private boolean hasFile = false;
    private Scanner scanner;

    public String readCommand() {

        final Scanner sc =  new Scanner(System.in);

        if (hasFile) {
            if (scanner.hasNext()) {
                return scanner.nextLine();
            } else {
                hasFile = false;
                scanner.close();
                System.out.println("\nEnter new command:");
                return sc.nextLine();
            }
        } else {
            return sc.nextLine();
        }

    }

    public void connectToFile(String filePath) {
        hasFile = true;
        this.scanner = new Scanner(FileManager.read(filePath));
    }

    public static String readLine() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
