package com.ivaaaak.client;

import com.ivaaaak.client.util.FileManager;

import java.util.ArrayDeque;
import java.util.Scanner;

public class UserInputManager {

    /**
     * This class reads user input from keyboard or from file with the script
     */


    private final ArrayDeque<Scanner> scripts = new ArrayDeque<>();
    private final ArrayDeque<String> filePaths = new ArrayDeque<>();
    private final Scanner scanner =  new Scanner(System.in);


    public String readLine() {
        if (!scripts.isEmpty()) {
            Scanner currentScanner = scripts.peek();
            if (currentScanner.hasNextLine()) {
                return currentScanner.nextLine();
            }
            filePaths.pop();
            scripts.pop().close();
            return readLine();
        }
        return scanner.nextLine();
    }

    public void connectToFile(String filePath) {
        if (filePaths.contains(filePath)) {
            System.err.println("The file contains recursion");
        } else {
            scripts.push(new Scanner(FileManager.read(filePath)));
            filePaths.push(filePath);
        }
    }

}
