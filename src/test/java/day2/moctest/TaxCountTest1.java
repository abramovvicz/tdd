package day2.moctest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class TaxCountTest1 {

    @Mock
    EmployeeDAO employeeDAO = mock(EmployeeDAO.class);
    private TaxCount taxCount;
    //tworzenie mokowanej klasy employeeDAO

    @BeforeEach
    void setUp() {
        taxCount = new TaxCount();
    }


    @Test
    void toUpperCase() {
        when(employeeDAO.getEmployee(4)).thenReturn(new Employee(4, "Stefan", 100.0));
        TaxCount taxCount = new TaxCount(employeeDAO);
        assertThat(taxCount.toUpperCase(1)).startsWith("STE").endsWith("FAN").contains("     ");
    }

    @Test
    void toUpperCase1() {
        when(employeeDAO.getEmployee(4)).thenReturn(null);
        TaxCount taxCount = new TaxCount(employeeDAO);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> taxCount.toUpperCase(4));
        assertThat(illegalArgumentException.getMessage()).isEqualTo("dostałeś nulla");
    }
}