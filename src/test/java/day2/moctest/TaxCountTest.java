package day2.moctest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class TaxCountTest {

    @Mock
    EmployeeDAO employeeDAO = mock(EmployeeDAO.class);
    private TaxCount taxCount;
    //tworzenie mokowanej klasy employeeDAO

    @BeforeEach
    void setUp() {
        taxCount = new TaxCount();
    }

    @Test
    void getTax() {
        when(employeeDAO.getEmployee(1)).thenReturn(new Employee(1, "Darek", 100.0));
        TaxCount taxCount = new TaxCount(employeeDAO);
        assertThat(taxCount.getTax(1)).isEqualTo(19);
    }


    @Test
    void getTax1() {
        when(employeeDAO.getEmployee(1)).thenReturn(null);
        TaxCount taxCount = new TaxCount(employeeDAO);
        assertThat(taxCount.getTax(1)).isEqualTo(19);
        assertThrows(IllegalArgumentException.class, () -> taxCount.getTax(1));
    }
}