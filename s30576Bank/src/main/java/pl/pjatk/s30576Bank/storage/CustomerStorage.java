package pl.pjatk.s30576Bank.storage;

import org.springframework.stereotype.Component;
import pl.pjatk.s30576Bank.Customer;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerStorage {
    List<Customer> catalog;

    public CustomerStorage() {
        catalog = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        catalog.add(new Customer(1, "Natan", "Brzozowski", 15000));
        catalog.add(new Customer(2, "Patrk", "Szachniewicz", 25000));
        catalog.add(new Customer(3, "Jan", "Kowalski", 20000));
    }

    public List<Customer> getCatalog() {
        return catalog;
    }
}