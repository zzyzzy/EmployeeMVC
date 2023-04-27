package project.spring4.mvc.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.spring4.mvc.employee.model.Employee;
import project.spring4.mvc.employee.service.EmployeeService;

@Controller
public class EmployeeController {

    private EmployeeService empsrv;

    @Autowired
    public EmployeeController(EmployeeService empsrv) {
        this.empsrv = empsrv;
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("emps", empsrv.readEmployee());
        mv.setViewName("emplist");
        return mv;
    }

    @GetMapping("/add")
    public String add() {

        return "emp";
    }

    @PostMapping("/add")
    public ModelAndView addok(Employee emp) {
        ModelAndView mv = new ModelAndView();
        String view = "empfail";

        if (empsrv.newEmployee(emp)) {
            //view = "empok";
            view = "redirect:/list";
        }
        mv.setViewName(view);

        return mv;
    }

    @GetMapping("/view")
    public ModelAndView view(@RequestParam int empid) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("emp", empsrv.readOneEmployee(empid));
        mv.setViewName("empview");

        return mv;
    }

}
