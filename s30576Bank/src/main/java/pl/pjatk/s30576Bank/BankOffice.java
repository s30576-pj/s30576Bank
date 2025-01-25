package pl.pjatk.s30576Bank;

import org.springframework.stereotype.Component;
import pl.pjatk.s30576Bank.storage.CustomerStorage;
//import pl.pjatk.s30576Bank.storage.OperationStorage;

@Component
public class BankOffice {
//    private final OperationStorage operationStorage;
    private final CustomerStorage customerStorage;

    public BankOffice(CustomerStorage customerStorage) {
//        this.operationStorage = operationStorage;
        this.customerStorage = customerStorage;
    }

    public void chooseOperation(BankingOperation operation) {
        if (operation.getOperationName() == "transfer"){
            transferOperation(operation.getId(), operation.getPrice());
            System.out.println(operation.getOperationName());
        } else {
            paymentOparation(operation.getId(), operation.getPrice());
            System.out.println(operation.getOperationName());
        }
    }

    public void transferOperation(int id, double price) {
//        new_saldo = id.saldo + price
//        CustomerStorage.ge4

        System.out.println(id);
    }

    public void paymentOparation(int id, double price) {
//        new_saldo = id.saldo + price
        System.out.println(id);
    }
}