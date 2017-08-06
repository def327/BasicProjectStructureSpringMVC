package com.tutorial.controllers;

import com.tutorial.dao.DataSource;
import com.tutorial.entities.user.User;
import com.tutorial.entities.user.UserListJAXB;
import com.tutorial.utils.UsersListJAXBCreator;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Setter
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


    //REST-ful WEB-SERVICES
    @RequestMapping(value = "json/user/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getJsonUser(@PathVariable("id") BigInteger userId) {
        LOGGER.debug("GET : json/user/{}", userId);
        return dataSource.getUserById(userId);
    }

    @RequestMapping(value = "json/users", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> getJsonUsers() {
        LOGGER.debug("GET : json/users");
        return dataSource.getUsers();
    }

    @RequestMapping(value = "xml/user/{id}", method = RequestMethod.GET, produces = "application/xml")
    @ResponseBody
    public User getXmlUser(@PathVariable("id") BigInteger userId) {
        LOGGER.debug("GET : xml/user/{}", userId);
        return dataSource.getUserById(userId);
    }

    @RequestMapping(value = "xml/users", method = RequestMethod.GET, produces = "application/xml")
    @ResponseBody
    public UserListJAXB getXmlUsers() {
        LOGGER.debug("GET : xml/users");
        return UsersListJAXBCreator.createUserList(dataSource.getUsers());
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        LOGGER.debug("POST : /user");
        dataSource.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
