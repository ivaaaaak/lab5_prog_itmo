package com.ivaaaak.client.Commands;

import com.ivaaaak.client.UserInputManager;



public class ExecuteScriptCommand extends Command {
    private final UserInputManager userInputManager;

    public ExecuteScriptCommand(UserInputManager userInputManager) {
        super("execute_script");
        this.userInputManager = userInputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the file path:");
        }
        userInputManager.connectToFile(arg);

        return new CommandResult(false, "");
    }
}
