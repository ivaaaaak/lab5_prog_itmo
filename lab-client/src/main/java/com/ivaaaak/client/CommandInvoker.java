package com.ivaaaak.client;

import com.ivaaaak.client.Commands.Command;
import com.ivaaaak.client.Commands.CommandResult;

public class CommandInvoker {

    private final CommandStore commandStore;

    public CommandInvoker(CommandStore commandStore) {
        this.commandStore = commandStore;
    }

    public CommandResult runCommand(String name, String arg) {

        for (Command c: commandStore.getCommands()) {
            if (c.getName().equals(name)) {
                return c.execute(arg);
            }
        }
        return new CommandResult(false, "Command not found. Use \"help\" to get information about commands");

    }
}
