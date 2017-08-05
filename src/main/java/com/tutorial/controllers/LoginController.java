package com.tutorial.controllers;

import com.tutorial.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
    public ModelAndView checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model modelFromView) {

        ModelAndView model = new ModelAndView();
        if (bindingResult.hasErrors()) {
            model.setViewName("/main");
            return model;
        }

        model.setViewName("menu");
        model.addObject(user);
        return model;
    }
}
