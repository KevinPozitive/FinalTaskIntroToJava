package by.epam.task05.oop_and_la.controller.impl;


import by.epam.task05.oop_and_la.controller.command.Command;
import by.epam.task05.oop_and_la.service.TransactionService;
import by.epam.task05.oop_and_la.service.exception.ServiceException;
import by.epam.task05.oop_and_la.service.factory.ServiceFactory;

public class DeleteTransaction implements Command {

    @Override
    public String execute(String request) {
        String[] params = request.split(" ");
        int id = Integer.parseInt(params[1]);
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionService transactionService = serviceFactory.getTransactionService();

        try {
            transactionService.deleteTransaction(id);
            response = "Transaction successfully deleted";
        } catch(ServiceException e) {
            response = "Error during deleting transaction";
        }

        return response;
    }
}
