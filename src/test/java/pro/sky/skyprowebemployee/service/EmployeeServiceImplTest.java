package pro.sky.skyprowebemployee.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.skyprowebemployee.Employee;
import pro.sky.skyprowebemployee.exeption.EmployeeAlreadyAddedException;
import pro.sky.skyprowebemployee.exeption.EmployeeDataEnteredIncorrectlyException;
import pro.sky.skyprowebemployee.exeption.EmployeeNotFoundException;
import pro.sky.skyprowebemployee.exeption.EmployeeStorageIsFullException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private Employee employee;
    private Employee employee1;
    private Employee employee2;

    private EmployeeServiceImpl service;

    @BeforeEach
    public void setUp() {
        service = new EmployeeServiceImpl();

        employee = new Employee("name", "lastName", 9, 888);
        employee1 = new Employee("name1", "lastName1", 10, 8881);
        employee2 = new Employee("name2", "lastName2", 20, 8882);

        service.addEmployee(employee);

    }

    @Test
    void addEmployeeNotNullTest() {
        Assertions.assertNotNull(employee);
    }

    @Test
    void addEmployeeStorageIsFullExceptionTest() {
        service.addEmployee(employee1);
        Assertions.assertThrows(EmployeeStorageIsFullException.class,
                () -> service.addEmployee(employee2));
    }

    @Test
    void addEmployeeAlreadyAddedExceptionTest() {
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> service.addEmployee(employee));
    }
    @Test
    void addEmployeeDataEnteredIncorrectlyExceptionTest() {
        Employee broken = new Employee(null, "broken", 1, 0);
        Assertions.assertThrows(EmployeeDataEnteredIncorrectlyException.class,
                () -> service.addEmployee(broken));
    }

    @Test
    void findEmployeeTest() {
        Assertions.assertEquals(employee, service.findEmployee(employee));
    }

    @Test
    void findEmployeeNotFoundExceptionTest() {
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> service.findEmployee(employee2));
    }

    @Test
    void findEmployeeDataEnteredIncorrectlyExceptionTest() {
        Employee broken = new Employee("broken", null, 1, 0);
        Assertions.assertThrows(EmployeeDataEnteredIncorrectlyException.class,
                () -> service.findEmployee(broken));
    }

    @Test
    void deleteEmployeeTest() {
        Assertions.assertEquals(employee, service.deleteEmployee(employee));
    }

    @Test
    void deleteEmployeeDataEnteredIncorrectlyExceptionTest() {
        Employee broken = new Employee(null, "broken", 1, 0);
        Assertions.assertThrows(EmployeeDataEnteredIncorrectlyException.class,
                () -> service.deleteEmployee(broken));
    }

    @Test
    void deleteEmployeeNotFoundExceptionTest() {
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> service.deleteEmployee(employee2));
    }
}