package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;

public class InfoCommand extends Command {
    private final CollectionStorage collectionStorage;

    public InfoCommand(CollectionStorage collectionStorage) {
        super("info");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String inputArg) {
        return new CommandResult(false, "Тип коллекции "
                + collectionStorage.getHashtable().getClass().toString() + "\n"
                + "Число элементов: " + collectionStorage.getHashtable().size() + "\n"
                + "Дата создания: " + collectionStorage.getCreationDate());

    }
}
