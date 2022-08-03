package pro.sky.skyprowebemployee;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "Василий", new Employee("Василий", "Пупкин", 1, 101_000),
            "Владеяр", new Employee("Владеяр", "Чушкин",1, 102_000),
            "Петр", new Employee("Петр", "Сахаров", 2, 98_000),
            "Кузьма", new Employee("Кузьма", "Кузин", 2, 80_500),
            "Ирина", new Employee("Ирина", "Иванова", 3, 150_000),
            "Виктория", new Employee("Виктория", "Галицина", 4, 120_000),
            "Матвей", new Employee("Матвей", "Щукин", 4, 80_000),
            "Ольга", new Employee("Ольга", "Петриченко", 4, 110_000),
            "Евгений", new Employee("Евгений", "Люпин", 5, 39_000),
            "Лидия", new Employee("Лидия", "Астапова", 5, 58_000)
    ));
    private final static int maxEmployeeCount = 11;

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee.getFirstName() == null || employee.getLastName() == null) {
            throw new EmployeeDataEnteredIncorrectlyException();
        }
        if (maxEmployeeCount == employees.size()) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employee.getFirstName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFirstName(), employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(Employee employee) {
        if (employee.getFirstName() == null || employee.getLastName() == null) {
            throw new EmployeeDataEnteredIncorrectlyException();
        }
        if (employees.containsKey(employee.getFirstName()))
            return employees.remove(employee.getFirstName());

        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName) {
        Employee employee = employees.get(firstName);
        if (employee.getFirstName() == null || employee.getLastName() == null) {
            throw new EmployeeDataEnteredIncorrectlyException();
        }
        if (employees.containsKey(employee.getFirstName())) {
            return employees.get(employee.getFirstName());
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> allEmployee() {
        return Collections.unmodifiableCollection(employees.values());
    }
}