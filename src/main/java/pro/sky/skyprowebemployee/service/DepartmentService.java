package pro.sky.skyprowebemployee.service;

import pro.sky.skyprowebemployee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee typeMaxSalaryDep(int department);

    Employee typeMinSalaryDep(int department);

    List<Employee> countAllFullNameDep(int department);

    Map<Integer, List<Employee>> allFullNameDep();
}
