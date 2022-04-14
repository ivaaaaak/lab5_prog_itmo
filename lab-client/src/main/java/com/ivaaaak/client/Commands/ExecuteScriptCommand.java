package com.ivaaaak.client.Commands;

import com.ivaaaak.client.util.UserInputManager;

import java.io.IOException;


public class ExecuteScriptCommand extends Command {

    public ExecuteScriptCommand() {
        super("execute_script");
    }

    @Override
    public CommandResult execute(String arg) {
        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the file path:");
        }
        try {
            UserInputManager.connectToFile(arg);
        } catch (IOException e) {
            return new CommandResult(false, e.getMessage());
        }
        return new CommandResult(false, "");
    }
}
