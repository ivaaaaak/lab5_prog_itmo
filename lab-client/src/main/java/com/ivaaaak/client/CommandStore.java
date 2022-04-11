package com.ivaaaak.client;

import com.ivaaaak.client.Commands.Command;
import com.ivaaaak.client.Commands.HelpCommand;
import com.ivaaaak.client.Commands.InsertCommand;
import com.ivaaaak.client.Commands.ShowCommand;
import com.ivaaaak.client.Commands.InfoCommand;
import com.ivaaaak.client.Commands.ExecuteScriptCommand;
import com.ivaaaak.client.Commands.FilterStartsWithNameCommand;
import com.ivaaaak.client.Commands.RemoveKeyCommand;
import com.ivaaaak.client.Commands.ReplaceIfGreaterCommand;
import com.ivaaaak.client.Commands.ReplaceIfLowerCommand;
import com.ivaaaak.client.Commands.ClearCommand;
import com.ivaaaak.client.Commands.SaveCommand;
import com.ivaaaak.client.Commands.UpdateCommand;
import com.ivaaaak.client.Commands.ExitCommand;
import com.ivaaaak.client.Commands.RemoveLowerCommand;
import com.ivaaaak.client.Commands.MaxByHairColorCommand;
import com.ivaaaak.client.Commands.FilterByLocationCommand;

import java.util.HashSet;

public class CommandStore {
    /**
     * This class stores instances of all commands
     */

    private final HashSet<Command> commands = new HashSet<>();

    public CommandStore(CollectionStorage collectionManager, UserInputManager userInputManager) {
        commands.add(new InsertCommand(collectionManager));
        commands.add(new ShowCommand(collectionManager));
        commands.add(new HelpCommand());
        commands.add(new InfoCommand(collectionManager));
        commands.add(new ClearCommand(collectionManager));
        commands.add(new RemoveKeyCommand(collectionManager));
        commands.add(new SaveCommand(collectionManager));
        commands.add(new UpdateCommand(collectionManager));
        commands.add(new ExitCommand());
        commands.add(new ExecuteScriptCommand(userInputManager));
        commands.add(new FilterByLocationCommand(collectionManager));
        commands.add(new FilterStartsWithNameCommand(collectionManager));
        commands.add(new RemoveLowerCommand(collectionManager));
        commands.add(new MaxByHairColorCommand(collectionManager));
        commands.add(new ReplaceIfGreaterCommand(collectionManager));
        commands.add(new ReplaceIfLowerCommand(collectionManager));
    }

    public HashSet<Command> getCommands() {
        return commands;
    }
}
