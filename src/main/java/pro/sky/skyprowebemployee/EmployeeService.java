package pro.sky.skyprowebemployee;

import java.util.Collection;

public interface EmployeeService {


    Employee addEmployee(Employee employee);

    String deleteEmployee(Employee employee);

    String findEmployee(Employee employee);


    String allEmployee();

    String welcomeTest();
}
