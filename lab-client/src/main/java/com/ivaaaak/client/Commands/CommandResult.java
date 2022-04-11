package com.ivaaaak.client.Commands;

public class CommandResult {
    private final String message;
    private final boolean exit;

    public CommandResult(boolean exit, String message) {
        this.exit = exit;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isExit() {
        return exit;
    }
}
