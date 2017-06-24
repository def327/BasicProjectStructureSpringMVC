package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/menu"}
    )
    public ModelAndView serviceProcess(ModelAndView model) {
        model.setViewName("menu");
        model.addObject("message", "This is an additional page!");
        return model;
    }
}
