package com.tutorial.controllers;

import com.tutorial.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {


    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/"}
    )
    public ModelAndView showMainPage() {
        ModelAndView model = new ModelAndView("main", "user", new User());
        return model;
    }

    @RequestMapping(
            method = {RequestMethod.POST},
            value = {"/check-user"}
    )
    public ModelAndView checkUser(@ModelAttribute User user) {
        ModelAndView model = new ModelAndView();
        model.setViewName("menu");
        model.addObject(user);
        return model;
    }
}
