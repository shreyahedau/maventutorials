package com.maventutorials.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/index")
public class indexController
{

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    String login(@RequestParam(value = "error", required = false) String error, Model model, HttpServletRequest request)
    {
        if (error != null) {

            model.addAttribute("error", "Invalid username and password!");
        }

        return "login";
    }

    @RequestMapping(value = "/userLoginSuccess**", method = RequestMethod.GET)
    public ModelAndView userPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page - User Page!");
        model.addObject("role","USER");
        model.setViewName("welcomePage");

        return model;

    }

    @RequestMapping(value = "/adminLoginSuccess**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page - ADMIN Page!");
        model.addObject("role","ADMIN");
        model.setViewName("welcomePage");

        return model;

    }

   /* @RequestMapping(value = "/dba**", method = RequestMethod.GET)
    public ModelAndView dbaPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page - Database Page!");
        model.setViewName("welcomePage");

        return model;

    }*/
}
