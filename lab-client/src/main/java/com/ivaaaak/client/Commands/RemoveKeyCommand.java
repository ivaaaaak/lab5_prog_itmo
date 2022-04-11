package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;

public class RemoveKeyCommand extends Command {
    private final CollectionStorage collectionManager;

    public RemoveKeyCommand(CollectionStorage collectionManager) {
        super("remove_key");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {

        if (arg.isEmpty()) {
            return new CommandResult(false, "This command needs an argument. Please try again and enter the key:");
        } else {
            try {
                int key = Integer.parseInt(arg);
                collectionManager.remove(key);
                return new CommandResult(false, "The element has been removed");
            } catch (NumberFormatException e) {
                return new CommandResult(false, "KEY is an integer number. Use \"show\" to get information about elements\n");
            }
        }

    }
}
