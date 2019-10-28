package by.epam.task05.oop_and_la.controller.impl;


import by.epam.task05.oop_and_la.bean.Transaction;
import by.epam.task05.oop_and_la.controller.command.Command;
import by.epam.task05.oop_and_la.service.TransactionService;
import by.epam.task05.oop_and_la.service.exception.ServiceException;
import by.epam.task05.oop_and_la.service.factory.ServiceFactory;

public class CreateTransaction implements Command {

    @Override
    public String execute(String request) {
        String[] params = request.split(" ");
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionService transactionService = serviceFactory.getTransactionService();

        try {
            int id = serviceFactory.getIdGenerator().nextId();
            String description = params[1];
            double sum = Double.parseDouble(params[2]);

            transactionService.createTransaction(new Transaction(id, description, sum));
            response = "Transaction successfully added";
        } catch (ServiceException e) {
            response = "Error during adding transaction";
            System.out.println(e);
        }

        return response;
    }
}
