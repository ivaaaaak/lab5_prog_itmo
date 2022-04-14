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

    public CommandStore(CollectionStorage collectionStorage, UserInputManager userInputManager) {
        commands.add(new InsertCommand(collectionStorage));
        commands.add(new ShowCommand(collectionStorage));
        commands.add(new HelpCommand());
        commands.add(new InfoCommand(collectionStorage));
        commands.add(new ClearCommand(collectionStorage));
        commands.add(new RemoveKeyCommand(collectionStorage));
        commands.add(new SaveCommand(collectionStorage));
        commands.add(new UpdateCommand(collectionStorage));
        commands.add(new ExitCommand());
        commands.add(new ExecuteScriptCommand(userInputManager));
        commands.add(new FilterByLocationCommand(collectionStorage));
        commands.add(new FilterStartsWithNameCommand(collectionStorage));
        commands.add(new RemoveLowerCommand(collectionStorage));
        commands.add(new MaxByHairColorCommand(collectionStorage));
        commands.add(new ReplaceIfGreaterCommand(collectionStorage));
        commands.add(new ReplaceIfLowerCommand(collectionStorage));
    }

    public HashSet<Command> getCommands() {
        return commands;
    }
}
