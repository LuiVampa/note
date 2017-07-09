package ru.note.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.note.entity.UserEntity;
import ru.note.exception.IncorrectPasswordException;
import ru.note.service.NoteService;

/**
 * Created by Bucky on 06.07.2017.
 */

@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userAuthorization(@RequestParam String login,
                                    @RequestParam String password,
                                    Model model) {
        try {
            noteService.login(login, password);
        } catch (IncorrectPasswordException e) {
            log.info("Incorrect Password - {}", password, e);
            return "error";
        }
        return "note";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String userRegistration(@RequestParam String login,
                                   @RequestParam String password,
                                   Model model) {
        noteService.registerUser(login, password);
        return "redirect:/login?login=" + login + "&password=" + password;
    }
}
