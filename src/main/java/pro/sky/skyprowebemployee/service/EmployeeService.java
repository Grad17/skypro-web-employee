package pro.sky.skyprowebemployee.service;

import pro.sky.skyprowebemployee.Employee;

import java.util.Collection;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);

    public Employee deleteEmployee(Employee employee);

    public Employee findEmployee(Employee employee);

    public Collection<Employee> allEmployee();

}
