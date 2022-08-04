package pro.sky.skyprowebemployee;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee typeMaxSalaryDep(int department) {
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
    @Override
    public Employee typeMinSalaryDep(int department) {
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
    @Override
    public List<Employee> countAllFullNameDep(int department) {
        List<Employee> allEmployeeDep = employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
        return allEmployeeDep;
    }
    @Override
    public Map<Integer, List<Employee>> allFullNameDep() {
        Map<Integer, List<Employee>> allEmployee = employeeService.allEmployee().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return allEmployee;
    }
}
