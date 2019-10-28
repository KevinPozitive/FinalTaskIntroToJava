package by.epam.task05.oop_and_la.controller.impl;


import by.epam.task05.oop_and_la.controller.command.Command;

public class WrongRequest implements Command {

    @Override
    public String execute(String request) {
        return "Wrong request";
    }
}
