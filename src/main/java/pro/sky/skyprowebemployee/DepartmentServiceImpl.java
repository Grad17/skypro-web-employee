package pro.sky.skyprowebemployee;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee typeMaxSalaryDep(int department) {
        return (Employee) employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }
    @Override
    public Employee typeMinSalaryDep(int department) {
        return (Employee) employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }
    @Override
    public List<Employee> countAllFullNameDep(int department) {
        List<Employee> allEmployeeDep = employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
        return allEmployeeDep;
    }
    @Override
    public List<Employee> allFullNameDep() {
        List<Employee> allEmployee = employeeService.allEmployee().stream()
                .sorted(Comparator.comparingInt(employee -> employee.getDepartment()))
                .toList();
        return allEmployee;
    }
}
