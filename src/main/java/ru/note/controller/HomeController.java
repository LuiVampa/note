package ru.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.note.exception.IncorrectAuthorizationException;
import ru.note.exception.UnavailableLoginException;
import ru.note.service.AuthorizationService;

/**
 * Created by Bucky on 06.07.2017.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String userAuthorization(@RequestParam String login,
                                    @RequestParam String password) {
        String result;
        try {
            result = "notes?id="
                    + authorizationService.login(login, password)
                    + "&page=1";
        } catch (IncorrectAuthorizationException e) {
            result = "error";
        }
        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String userRegistration(@RequestParam String login,
                                   @RequestParam String password) {
        String result;
        try {
            result = "notes?id="
                    + authorizationService.registerUser(login, password)
                    + "&page=1";
        } catch (IncorrectAuthorizationException e) {
            result = "error";
        }
        return result;
    }
}
