package pro.sky.skyprowebemployee;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Василий", "Пупкин"),
            new Employee("Владеяр", "Чушкин"),
            new Employee("Петр", "Сахаров"),
            new Employee("Кузьма", "Кузин"),
            new Employee("Виктория", "Галицина"),
            new Employee("Матвей", "Щукин"),
            new Employee("Ольга", "Петриченко"),
            new Employee("Евгений", "Люпин"),
            new Employee("Лидия", "Астапова"),
            new Employee("Ирина", "Иванова")
    ));
    private final static int maxEmployeeCount = 11;
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employee.getFirstName() == null || employee.getLastName() == null) {
            throw new EmployeeDataEnteredIncorrectlyException();
        }
        if (maxEmployeeCount == employeeList.size()) {
            throw new EmployeeStorageIsFullException();
        }
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }
    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employee.getFirstName() == null || employee.getLastName() == null) {
            throw new EmployeeDataEnteredIncorrectlyException();
        }
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
        }
            return employee;

    }
    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employee.getFirstName() == null || employee.getFirstName() == null) {
            throw new EmployeeDataEnteredIncorrectlyException();
        }
        if (employeeList.contains(employee)) {
            return employee;
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> allEmployee() {
        return new ArrayList<>(employeeList);
    }


//    @Override
//    public String welcomeTest(){
//        return "Добро пожаловать в тест";
//    }
}
