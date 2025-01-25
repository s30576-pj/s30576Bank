package pl.pjatk.s30576Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pjatk.s30576Bank.storage.CustomerStorage;

@SpringBootApplication
public class s30576BankApplication {
	private final BankOffice bankOffice;

	public s30576BankApplication(BankOffice bankOffice) {
		this.bankOffice = bankOffice;
		StartApplication();
	}

	public void StartApplication() {
		Customer customer1 = new Customer(1, "Natan", "Brzozowski", 10000);
		Customer customer2 = new Customer(2, "Patryk", "Szachniewicz", 15000);
		Customer customer3 = new Customer(3, "Jan", "Kowalski", 20000);


		BankingOperation operation1 = new BankingOperation(1,5000,"transfer");
		bankOffice.chooseOperation(operation1);

		BankingOperation operation2 = new BankingOperation(1,10000,"payment");
		bankOffice.chooseOperation(operation2);
	}

	public static void main(String[] args) {
		SpringApplication.run(s30576BankApplication.class, args);
	}

}