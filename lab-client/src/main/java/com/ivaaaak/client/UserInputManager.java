package com.ivaaaak.client;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class UserInputManager {

    /**
     * This class reads user input from keyboard or from file with the script
     */

    private static final Stack<BufferedReader> scripts = new Stack<>();
    private static final Stack<String> filePaths = new Stack<>();
    private static final Scanner scanner =  new Scanner(System.in);



    public static String readLine() {
        if (!scripts.isEmpty()) {
            try {
                String command = scripts.peek().readLine();
                if (command == null) {
                    filePaths.pop();
                    scripts.pop().close();
                    return readLine();
                }
                return command;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return "";
            }
        } else {
            return scanner.nextLine();
        }
    }

    public void connectToFile(String filePath) throws IOException {
        if (filePaths.contains(filePath)) {
            System.err.println("The file contains recursion");
        } else {
            BufferedReader bf = new BufferedReader(new FileReader(filePath));
            scripts.push(bf);
            filePaths.push(filePath);
        }
    }

}
