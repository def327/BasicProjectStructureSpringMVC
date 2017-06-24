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
    public ModelAndView showLoginPage(ModelAndView model) {
        model.setViewName("main");
        return model;
    }
}
