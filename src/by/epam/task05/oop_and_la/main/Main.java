package by.epam.task05.oop_and_la.main;


import by.epam.task05.oop_and_la.bean.AuthorizationInfo;
import by.epam.task05.oop_and_la.controller.Controller;
import by.epam.task05.oop_and_la.service.TransactionService;
import by.epam.task05.oop_and_la.service.UserService;
import by.epam.task05.oop_and_la.service.factory.ServiceFactory;

public class Main {
    public static void main(String[] args) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();
        TransactionService transactionService = serviceFactory.getTransactionService();

        AuthorizationInfo authInfo = new AuthorizationInfo("Login", "Password");

        String response;

        Controller controller = Controller.getInstance();

        response = controller.executeTask("sign_in Login Password");
        System.out.println(response);

        response = controller.executeTask("create_transaction salary 100");
        System.out.println(response);

        response = controller.executeTask("create_transaction milk -5");
        System.out.println(response);

        response = controller.executeTask("create_transaction tea -3");
        System.out.println(response);

        response = controller.executeTask("read_transaction 3");
        System.out.println(response);

        response = controller.executeTask("update_transaction 7 forfeit 50");
        System.out.println(response);

        response = controller.executeTask("delete_transaction 2");
        System.out.println(response);
    }
}
