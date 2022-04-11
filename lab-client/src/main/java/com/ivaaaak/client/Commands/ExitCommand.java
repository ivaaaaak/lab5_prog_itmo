package com.ivaaaak.client.Commands;

public class ExitCommand extends Command {

    public ExitCommand() {
        super("exit");
    }

    @Override
    public CommandResult execute(String arg) {
        return new CommandResult(true, "Exiting...");
    }
}
