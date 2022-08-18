package pro.sky.skyprowebemployee;

import org.apache.commons.lang3.StringUtils;
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
    public Employee addEmployee(@RequestParam("firstName")String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("department") int department,
                                @RequestParam("salary") int salary) {
        if (StringUtils.isAlpha(firstName)&&StringUtils.isAlpha(lastName)){
            return new Employee(firstName, lastName, department, salary);
        }
        throw new EmployeeBadRequest400Exception();
    }

    @GetMapping(path = "/delete")
    public Employee deleteEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employeeService.deleteEmployee(employee);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employeeService.findEmployee(firstName);
    }

    @GetMapping(path = "/all")
    public Collection<Employee> allEmployee() {
        return employeeService.allEmployee();
    }
}
