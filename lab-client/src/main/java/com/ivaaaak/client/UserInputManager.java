package com.ivaaaak.client;

import com.ivaaaak.client.util.FileManager;

import java.util.Scanner;

public class UserInputManager {

    /**
     * This class reads user input from keyboard or from file with the script
     */

    private static boolean hasFile = false;
    private static Scanner scanner;

    public static String readLine() {

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
        if (FileManager.read(filePath).contains(filePath)) {
            throw new UnsupportedOperationException("The file contains recursion");
        } else {
            hasFile = true;
            scanner = new Scanner(FileManager.read(filePath));
        }
    }

}
