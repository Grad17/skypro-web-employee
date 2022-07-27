package pro.sky.skyprowebemployee;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Василий", "Пупкин"),
            new Employee("Владеяр", "Чушкин"),
            new Employee("Петр", "Сахаров"),
            new Employee("Кузьма", "Кузин"),
            new Employee("Ирина", "Иванова"),
            new Employee("Виктория", "Галицина"),
            new Employee("Матвей", "Щукин"),
            new Employee("Ольга", "Петриченко"),
            new Employee("Евгений", "Люпин"),
            new Employee("Лидия", "Астапова"),
            new Employee("Ivan", "Ivanov")
    ));
    private final static int maxEmployeeCount = 11;

    @Override
    public Employee addEmployee(Employee employee) {
        if (maxEmployeeCount == employees.size()) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        System.out.println("добавлен в список " + employee);
        return employee;
    }

    @Override
    public String deleteEmployee(Employee employee) {
        employees.remove(employee);
        System.out.println("удален по запросу " + employee);
        throw new EmployeeNotFoundException();
    }

    @Override
    public String findEmployee(Employee employee) {

        if (employee.getFirstName() == null || employee.getLastName() == null) {
            throw new EmployeeDataEnteredIncorrectlyException();
        }
        if (!employee.getFirstName().matches("\\w+") || employee.getLastName().matches("\\w+")) {

            throw new EmployeeNotFoundException();
        }
        for (Employee employee1 : employees) {
            return "по запросу " + employee + "найден " + employee;
        }
        return findEmployee(employee);
    }
    @Override
    public String allEmployee() {
        ListIterator iterator = employees.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        return allEmployee();
    }

    @Override
    public String welcomeTest(){
        return "Добро пожаловать в тест";
    }
}
