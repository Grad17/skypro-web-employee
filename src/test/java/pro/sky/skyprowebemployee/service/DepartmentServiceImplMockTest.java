package pro.sky.skyprowebemployee.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyprowebemployee.Employee;


import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplMockTest {

    List<Employee> expected = new ArrayList<>();

    private Employee employee = new Employee("name", "lastName", 9, 900);
    private Employee employee1 = new Employee("name1", "lastName1", 8, 990);
    private Employee employee2 = new Employee("name2", "lastName2", 9, 999);

    @Mock
    private EmployeeService employeeServiceMock = new EmployeeServiceImpl();

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    public void setUp() {
        expected.add(employee);
        expected.add(employee1);
        expected.add(employee2);
    }

    @Test
    void typeMaxSalaryDepTest() {
        Mockito.when(employeeServiceMock.allEmployee()).thenReturn(expected);
        assertEquals(employee2, departmentService.typeMaxSalaryDep(employee2.getDepartment()));
    }

    @Test
    void typeMinSalaryDepTest() {
        Mockito.when(employeeServiceMock.allEmployee()).thenReturn(expected);
        Assertions.assertEquals(employee, departmentService.typeMinSalaryDep(employee.getDepartment()));
    }

    @Test
    void countAllFullNameDepTest() {
        List<Employee> allFullNameInDep = expected.stream()
                .filter(employee -> employee.getDepartment() == 9)
                .collect(Collectors.toList());

        Mockito.when(employeeServiceMock.allEmployee()).thenReturn(expected);
        Assertions.assertEquals(allFullNameInDep, departmentService.countAllFullNameDep(9));
    }

    @Test
    void allFullNameDepTest() {
        Mockito.when(employeeServiceMock.allEmployee()).thenReturn(expected);
        Assertions.assertEquals(expected, employeeServiceMock.allEmployee());
    }
}