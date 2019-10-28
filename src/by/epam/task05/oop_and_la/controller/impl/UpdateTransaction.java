package by.epam.task05.oop_and_la.controller.impl;


import by.epam.task05.oop_and_la.bean.Transaction;
import by.epam.task05.oop_and_la.controller.command.Command;
import by.epam.task05.oop_and_la.service.TransactionService;
import by.epam.task05.oop_and_la.service.exception.ServiceException;
import by.epam.task05.oop_and_la.service.factory.ServiceFactory;

public class UpdateTransaction implements Command {

    @Override
    public String execute(String request) {
        String[] params = request.split(" ");
        int id = Integer.parseInt(params[1]);
        String description = params[2];
        double sum = Double.parseDouble(params[3]);

        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionService transactionService = serviceFactory.getTransactionService();

        try {
            int newId = serviceFactory.getIdGenerator().nextId();
            transactionService.updateTransaction(id, new Transaction(newId, description, sum));
            response = "Transaction successfully updated";
        } catch (ServiceException e) {
            response = "Error during updating transaction";
        }

        return response;
    }
}
