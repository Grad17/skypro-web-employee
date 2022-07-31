package pro.sky.skyprowebemployee;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employees = new HashMap<>(Map.of(
            "Василий", new Employee("Василий", "Пупкин"),
            "Владеяр", new Employee("Владеяр", "Чушкин"),
            "Петр", new Employee("Петр", "Сахаров"),
            "Кузьма", new Employee("Кузьма", "Кузин"),
            "Ирина", new Employee("Ирина", "Иванова"),
            "Виктория", new Employee("Виктория", "Галицина"),
            "Матвей", new Employee("Матвей", "Щукин"),
            "Ольга", new Employee("Ольга", "Петриченко"),
            "Евгений", new Employee("Евгений", "Люпин"),
            "Лидия", new Employee("Лидия", "Астапова")
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