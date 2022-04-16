package com.ivaaaak.client;

import com.ivaaaak.client.util.FileManager;

import java.util.ArrayDeque;
import java.util.Scanner;

public class UserInputManager {

    /**
     * This class reads user input from keyboard or from file with the script
     */


    private final ArrayDeque<ArrayDeque<String>> allScripts = new ArrayDeque<>();
    private final ArrayDeque<String> filePaths = new ArrayDeque<>();
    private final Scanner scanner =  new Scanner(System.in);


    public String readLine() {
        if (!allScripts.isEmpty()) {
            ArrayDeque<String> currenScript = allScripts.peek();
            if (!currenScript.isEmpty()) {
                String command = currenScript.peek();
                if (command.equals(currenScript.peekLast())) {
                    allScripts.pop();
                    filePaths.pop();
                }
                currenScript.pop();
                return command;
            }
        }
        return scanner.nextLine();
    }

    public void connectToFile(String filePath) {
        if (filePaths.contains(filePath)) {
            System.err.println("The file contains recursion");
        } else {
            try (Scanner sc = new Scanner(FileManager.read(filePath))) {
                ArrayDeque<String> script = new ArrayDeque<>();
                while (sc.hasNextLine()) {
                    script.add(sc.nextLine());
                }
                allScripts.push(script);
                filePaths.push(filePath);
            }
        }
    }

}
