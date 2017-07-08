package ru.note.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Bucky on 06.07.2017.
 */

@Controller
@RequestMapping("/")
public class RegistryController {

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String userAuthorization(Model model) {
        return "authorization";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String userRegistration(Model model) {

        return null;
    }
}
