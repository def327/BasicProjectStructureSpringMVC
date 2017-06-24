package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/main"}
    )
    public ModelAndView serviceProcess(ModelAndView model) {
        model.setViewName("main");
        model.addObject("message", "This is a main page for web application");
        return model;
    }
}
