package pl.pjatk.s30576Bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class RentalTest {

    @Test
    void shouldCorrectCalculatePrice() {
        //GIVEN
        Customer car = new Customer("BMW", "E92", "VIN123", Standard.NORMAL);
        BankingOperation rental = new BankingOperation(1,"Jan","Kowalski", LocalDate.of(2024,12,10),LocalDate.of(2024,12,15), car);

        //WHEN
        double result = rental.calculatePrice(car);

        //THEN
        assertThat(result).isEqualTo(2000.0);
    }
}
