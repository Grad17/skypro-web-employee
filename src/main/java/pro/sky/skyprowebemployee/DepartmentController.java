package pro.sky.skyprowebemployee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(path = "/min.salary")
    public Employee typeMinSalaryDep(@RequestParam("department") int department) {
        return departmentService.typeMinSalaryDep(department);
    }
    @GetMapping(path = "/max.salary")
    public Employee typeMaxSalaryDep(@RequestParam("department") int department) {
        return departmentService.typeMaxSalaryDep(department);
    }
    @GetMapping(path = "/all/")
    public List<Employee> countAllFullNameDep(@RequestParam("department") int department) {
        return departmentService.countAllFullNameDep(department);
    }
    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> allEmployee() {
        return departmentService.allFullNameDep();
    }
}
