package pl.pjatk.s30576Bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.s30576Bank.storage.OperationStorage;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentalOfficeTest {

    @Captor
    private ArgumentCaptor<BankingOperation> rentalCaptor;

    @Mock
    private OperationStorage rentalStorage;

    @InjectMocks
    private BankOffice rentalOffice;

    @Test
    void shouldPassCorrectRental() {
        //GIVE
        Customer car = new Customer("BMW", "E92", "VIN123", Standard.NORMAL);
        BankingOperation rental = new BankingOperation(1,"Jan","Kowalski", LocalDate.of(2024,12,10),LocalDate.of(2024,12,15), car);
        when(rentalStorage.getRentalList()).thenReturn(List.of());

        //WHEN
        rentalOffice.finalizeRental(rental);

        //THEN
        verify(rentalStorage).addRental(rentalCaptor.capture());
        BankingOperation capturedRental = rentalCaptor.getValue();
        assertThat(capturedRental).isNotNull();
        assertThat(capturedRental).isEqualTo(rental);
    }

    @Test
    void shouldReturnTrueWhenCarIsAvailable() {
        //GIVEN
        Customer car = new Customer("BMW", "E92", "VIN123", Standard.NORMAL);
        BankingOperation rental = new BankingOperation(1,"Jan","Kowalski", LocalDate.of(2024,12,10),LocalDate.of(2024,12,15), car);
        when(rentalStorage.getRentalList()).thenReturn(List.of());

        //WHEN
        boolean result = rentalOffice.isCarAvailable(car.getVin(), rental.getStartDate(), rental.getEndDate());

        //THEN
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseWhenCarIsNotAvailable() {
        //GIVEN
        Customer car = new Customer("BMW", "E92", "VIN123", Standard.NORMAL);
        BankingOperation rental = new BankingOperation(1,"Jan","Kowalski", LocalDate.of(2024,12,10),LocalDate.of(2024,12,15), car);
        BankingOperation existingRental = new BankingOperation(2, "Natan", "Nowak", LocalDate.of(2024, 12, 8), LocalDate.of(2024, 12, 11), car);
        when(rentalStorage.getRentalList()).thenReturn(List.of(rental));

        //WHEN
        boolean result = rentalOffice.isCarAvailable(car.getVin(), existingRental.getStartDate(), existingRental.getEndDate());

        //THEN
        assertThat(result).isFalse();
    }
}
