package project.spring4.mvc.employee.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.spring4.mvc.employee.model.Employee;
import project.spring4.mvc.employee.service.EmployeeService;

@Controller
public class EmployeeController {

    private static final Logger logger =
                LogManager.getLogger(EmployeeController.class);

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

    @GetMapping("/remove")
    public String remove(@RequestParam int empid) {

        empsrv.removeEmployee(empid);

        return "redirect:/list";
    }


    @ExceptionHandler(BindException.class)
    public String typeMismatchParam(BindException ex) {
        logger.info("매개변수 관련 오류!!");
        logger.info(ex.getMessage());

        return "empfail";
    }

}
