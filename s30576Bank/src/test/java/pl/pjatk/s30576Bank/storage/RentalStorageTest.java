package pl.pjatk.s30576Bank.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.pjatk.s30576Bank.Customer;
import pl.pjatk.s30576Bank.BankingOperation;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RentalStorageTest {
    private OperationStorage rentalStorage;

    @BeforeEach
    void setUp() {this.rentalStorage = new OperationStorage();}

    @Test
    void returnCorrectListOfRentals() {
        //GIVEN
        Customer car1 = new Customer("BMW", "E92", "1HGCM82633A123456", Standard.NORMAL);
        Customer car2 = new Customer("BMW", "E60", "2T3BFREV5JW567890", Standard.NORMAL);
        BankingOperation rental1 = new BankingOperation(1, "Patryk", "Kowalski", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 15), car1);
        BankingOperation rental2 = new BankingOperation(2, "Natan", "Nowak", LocalDate.of(2024, 12, 8), LocalDate.of(2024, 12, 11), car2);

        rentalStorage.addRental(rental1);
        rentalStorage.addRental(rental2);

        //WHEN
        List<BankingOperation> rentalList = rentalStorage.getRentalList();

        //THEN
        assertThat(rentalList).containsExactly(rental1, rental2);
    }

    @Test
    void shouldNotContainRentalNotAdded() {
        // GIVEN
        Customer car1 = new Customer("BMW", "E92", "1HGCM82633A123456", Standard.NORMAL);
        Customer car2 = new Customer("BMW", "E60", "2T3BFREV5JW567890", Standard.NORMAL);
        BankingOperation rental1 = new BankingOperation(1, "Patryk", "Kowalski", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 15), car1);
        BankingOperation rental2 = new BankingOperation(2, "Natan", "Nowak", LocalDate.of(2024, 12, 8), LocalDate.of(2024, 12, 11), car2);

        rentalStorage.addRental(rental1);

        // WHEN
        List<BankingOperation> rentals = rentalStorage.getRentalList();

        // THEN
        assertThat(rentals).doesNotContain(rental2);
    }

    @Test
    void shouldAllowAddingTheSameHireMultipleTimes() {
        // GIVEN
        Customer car = new Customer("BMW", "M5", "VIN123", Standard.NORMAL);
        BankingOperation rental = new BankingOperation(1, "Jan", "Kowalski", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 15), car);
        rentalStorage.addRental(rental);
        rentalStorage.addRental(rental);

        // WHEN
        List<BankingOperation> rentalList = rentalStorage.getRentalList();

        // THEN
        assertThat(rentalList).containsExactly(rental, rental);
    }

    @Test
    void shouldAddHireToList() {
        // GIVEN
        Customer car = new Customer("BMW", "E92", "1HGCM82633A123456", Standard.NORMAL);
        BankingOperation rental = new BankingOperation(1, "Jan", "Kowalski", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 15), car);

        // WHEN
        rentalStorage.addRental(rental);

        // THEN
        assertThat(rentalStorage.getRentalList()).contains(rental);
    }
}
