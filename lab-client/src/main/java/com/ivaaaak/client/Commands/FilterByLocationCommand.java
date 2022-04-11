package com.ivaaaak.client.Commands;

import com.ivaaaak.client.CollectionStorage;
import com.ivaaaak.client.Data.Location;
import com.ivaaaak.client.Data.Person;
import com.ivaaaak.client.util.LocationMaker;

import java.util.ArrayList;
import java.util.StringJoiner;

public class FilterByLocationCommand extends Command {

    private final CollectionStorage collectionStorage;

    public FilterByLocationCommand(CollectionStorage collectionStorage) {
        super("filter_by_location");
        this.collectionStorage = collectionStorage;
    }

    @Override
    public CommandResult execute(String arg) {

        Location l = LocationMaker.initialize();
        ArrayList<Person> list = collectionStorage.getMatchingPeople(l);

        if (list == null) {
            return new CommandResult(false, "The collection is empty");
        } else {
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
}
