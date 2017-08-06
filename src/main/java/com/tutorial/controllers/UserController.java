package com.tutorial.controllers;

import com.tutorial.dao.DataSource;
import com.tutorial.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@Controller
public class UserController {

    @Inject
    private DataSource dataSource;

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


    //REST WEB-SERVICES

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getUser(@PathVariable("id") BigInteger userId) {
        return dataSource.getUserById(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> getUsers() {
        return dataSource.getUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        dataSource.addUser(user);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
