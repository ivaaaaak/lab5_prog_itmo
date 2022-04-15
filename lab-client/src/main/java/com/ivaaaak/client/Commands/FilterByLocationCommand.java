package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Location;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.UserInputManager;
import com.ivaaaak.client.util.LocationMaker;

import java.util.List;
import java.util.StringJoiner;

public class FilterByLocationCommand extends Command {

    private final CollectionStorage collectionStorage;
    private final UserInputManager userInputManager;

    public FilterByLocationCommand(CollectionStorage collectionStorage,
                                   UserInputManager userInputManager) {
        super("filter_by_location");
        this.collectionStorage = collectionStorage;
        this.userInputManager = userInputManager;
    }

    @Override
    public CommandResult execute(String arg) {

        if (collectionStorage.getHashtable().isEmpty()) {
            return new CommandResult(false, "The collection is empty");
        }

        Location location = new LocationMaker(userInputManager).makeLocation();
        List<Person> list = collectionStorage.getMatchingPeople(location);
        StringJoiner output = new StringJoiner("\n\n");
        for (Person person : list) {
            output.add(person.toString());
        }
        if (output.toString().isEmpty()) {
            return new CommandResult(false, "There aren't any elements with this location");
        }
        return new CommandResult(false, output.toString());
    }
}
