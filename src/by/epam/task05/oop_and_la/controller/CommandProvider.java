package by.epam.task05.oop_and_la.controller;


import by.epam.task05.oop_and_la.controller.command.Command;
import by.epam.task05.oop_and_la.controller.command.CommandName;
import by.epam.task05.oop_and_la.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();


    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
    CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.CREATE_TRANSACTION, new CreateTransaction());
        repository.put(CommandName.READ_TRANSACTION, new ReadTransaction());
        repository.put(CommandName.UPDATE_TRANSACTION, new UpdateTransaction());
        repository.put(CommandName.DELETE_TRANSACTION, new DeleteTransaction());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }
}
