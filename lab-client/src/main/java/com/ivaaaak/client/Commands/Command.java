package com.ivaaaak.client.Commands;

public abstract class Command {

    private final String name;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract CommandResult execute(String arg);


}
