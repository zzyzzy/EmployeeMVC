package project.spring4.mvc.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
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

}
