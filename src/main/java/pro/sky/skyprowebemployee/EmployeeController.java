package pro.sky.skyprowebemployee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    //    @GetMapping()
//    public String welcomeTest() {
//        return employeeService.welcomeTest();
//    }
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("department") int department,
                                @RequestParam("salary") int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        return employee;
    }

    @GetMapping(path = "/delete")
    public Employee deleteEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("department") int department,
                                   @RequestParam("salary") int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        return employee;
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("department") int department,
                                 @RequestParam("salary") int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        return employee;
    }

    @GetMapping(path = "/all")
    public Collection<Employee> allEmployee() {
        return employeeService.allEmployee();
    }
}
