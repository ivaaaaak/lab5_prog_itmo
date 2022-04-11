package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;

public class InfoCommand extends Command {
    private final CollectionStorage collectionManager;

    public InfoCommand(CollectionStorage collectionManager) {
        super("info");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String inputArg) {
        return new CommandResult(false, "Тип коллекции "
                + collectionManager.getHashtable().getClass().toString() + "\n"
                + "Число элементов: " + collectionManager.getHashtable().size() + "\n"
                + "Дата создания: " + collectionManager.getCreationDate());

    }
}
