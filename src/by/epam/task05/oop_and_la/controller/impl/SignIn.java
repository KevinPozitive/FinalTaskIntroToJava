package by.epam.task05.oop_and_la.controller.impl;


import by.epam.task05.oop_and_la.bean.AuthorizationInfo;
import by.epam.task05.oop_and_la.controller.command.Command;
import by.epam.task05.oop_and_la.service.UserService;
import by.epam.task05.oop_and_la.service.exception.ServiceException;
import by.epam.task05.oop_and_la.service.factory.ServiceFactory;

public class SignIn implements Command {

    @Override
    public String execute(String request) {
        String[] params = request.split(" ");

        String login = params[1];
        String password = params[2];
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        try {
            userService.signIn(new AuthorizationInfo(login, password));
            response = "Welcome";
        } catch (ServiceException e) {
            response = "Error during authorization procedure";
        }

        return response;
    }
}
