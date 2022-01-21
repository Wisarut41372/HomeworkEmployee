package nvc.bcit.soi5shopstart.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import nvc.bcit.soi5shopstart.model.Department;
import nvc.bcit.soi5shopstart.model.Employee;
import nvc.bcit.soi5shopstart.model.Projectt;
import nvc.bcit.soi5shopstart.repository.DepartmentRepository;

import nvc.bcit.soi5shopstart.repository.ProjectRepository;
import nvc.bcit.soi5shopstart.service.EmployeeService;





@Controller
public class MainController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ProjectRepository projectRepository;
    
    @GetMapping("/")
    public String index () {
        return "index";
    }
    
    @GetMapping("/employee")
    public ModelAndView employee() {
        List<Employee> employees = employeeService.findAll();
        return new ModelAndView("employee","employees",employees);
    }

    @GetMapping("/employee/new")
    public String newEmployee () {
        return "newemployee";
    }

    @GetMapping("/employee/edit")
    public String editEmployee () {
        return "editemployee";
    }

    @GetMapping("/department/employee")
    public ModelAndView getDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return new ModelAndView("department","departments",departments);
    }

    @GetMapping("/project/employee")
    public ModelAndView getProject(){
        List<Projectt> projectts = projectRepository.findAll();
        return new ModelAndView("project","projectts",projectts);
    }


//ค้นหาชื่อ
    @GetMapping("/employee/name/{name}")
    public ModelAndView getEmployeeByName(@PathVariable("name")String name){
        List<Employee> employees = employeeService.findByName(name);
        return new ModelAndView("employee","employees",employees);
    }
//ค้นหาเงินเดือน
    @GetMapping("/employee/salary/{salary}")
    public ModelAndView getEmployeeByName(@PathVariable("salary")int salary){
        List<Employee> employees = employeeService.findBySalary(salary);
        return new ModelAndView("employee","employees",employees);
    }
}
