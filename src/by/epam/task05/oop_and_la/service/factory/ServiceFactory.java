package by.epam.task05.oop_and_la.service.factory;


import by.epam.task05.oop_and_la.service.TransactionService;
import by.epam.task05.oop_and_la.service.UserService;
import by.epam.task05.oop_and_la.service.impl.TransactionServiceImpl;
import by.epam.task05.oop_and_la.service.impl.UserServiceImpl;
import by.epam.task05.oop_and_la.service.util.TransactionIdGenerator;

public class ServiceFactory {
    private TransactionIdGenerator idGenerator;
    {
        idGenerator = TransactionIdGenerator.getInstance();
    }

    private static final ServiceFactory instance = new ServiceFactory();

    private final TransactionService transactionService = new TransactionServiceImpl();
    private final UserService userService = new UserServiceImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TransactionService getTransactionService() {
        return transactionService;
    }

    public UserService getUserService() {
        return userService;
    }

    public TransactionIdGenerator getIdGenerator() {
        return idGenerator;
    }
}
