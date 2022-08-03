package pro.sky.skyprowebemployee;

import java.util.Collection;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);

    public Employee deleteEmployee(Employee employee);

    public Employee findEmployee(String firstName);

    public Collection<Employee> allEmployee();
}
