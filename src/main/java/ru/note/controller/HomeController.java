package ru.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.note.service.NoteService;

/**
 * Created by Bucky on 06.07.2017.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, params = "item")
    public String userAuthorization(@RequestParam String login,
                                    @RequestParam String password,
                                    Model model) {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String userRegistration(@RequestParam String login,
                                   @RequestParam String password,
                                   Model model) {

        return null;
    }
}
