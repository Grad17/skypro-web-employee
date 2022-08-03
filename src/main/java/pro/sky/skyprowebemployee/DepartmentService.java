package pro.sky.skyprowebemployee;

import java.util.List;

public interface DepartmentService {
    Employee typeMaxSalaryDep(int department);

    Employee typeMinSalaryDep(int department);

    List<Employee> countAllFullNameDep(int department);

    java.util.List<Employee> allFullNameDep();
}
