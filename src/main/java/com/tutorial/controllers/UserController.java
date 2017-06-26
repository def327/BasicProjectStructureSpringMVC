package com.tutorial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/password/restore"}
    )
    public ModelAndView showPasswordRecoveryPage(ModelAndView model) {
        model.setViewName("menu");
        model.addObject("message", "This page is used for password recovery");
        return model;
    }
}
