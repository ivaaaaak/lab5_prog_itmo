package com.ivaaaak.client;

import com.ivaaaak.client.Commands.CommandResult;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.util.FileManager;
import com.ivaaaak.client.util.JsonParser;

import java.util.Hashtable;

public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) {

        final CollectionStorage collectionStorage = new CollectionStorage();
        final UserInputManager userInputManager = new UserInputManager();
        final CommandStore commandStore = new CommandStore(collectionStorage, userInputManager);
        final CommandInvoker commandInvoker = new CommandInvoker(commandStore);


        String fileData = FileManager.read(FileManager.FILE_PATH);
        Hashtable<Integer, Person> ht = JsonParser.deserialize(fileData);
        collectionStorage.initializeHashtable(ht);

        CommandResult result;
        do {
            String name = "";
            String arg = "";
            String[] command = UserInputManager.readLine().split(" ");

            if (command.length >= 1) {
                name = command[0];
            }
            if (command.length >= 2) {
                arg = command[1];
            }

            result = commandInvoker.runCommand(name, arg);
            System.out.println(result.getMessage());

        } while (!result.isExit());
    }
}
