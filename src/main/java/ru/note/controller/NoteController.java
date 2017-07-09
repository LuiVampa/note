package ru.note.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.note.service.NoteService;

/**
 * Created by Bucky on 10.07.2017.
 */
@Controller
@Slf4j
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String note(@RequestParam Integer page, Model model) {
        Long pageCount = noteService.pageCount();
        page = page > pageCount ? page - 1 : page;
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("notes", noteService.loadNotes(page));
        model.addAttribute("page", page);
        return "note";
    }

    @RequestMapping(value = "/notes/add", method = RequestMethod.POST)
    public String addNote(@RequestParam Long id,
                          @RequestParam Integer page,
                          @RequestParam String note,
                          Model model) {
        noteService.addNote(id, note);
        model.addAttribute("notes", noteService.loadNotes(page));
        return "notes";
    }

    @RequestMapping(value = "/notes/remove", method = RequestMethod.POST)
    public String removeNote(@RequestParam Long id,
                             @RequestParam Integer page,
                             @RequestParam Long noteId,
                             Model model) {
        noteService.removeNote(noteId);
        model.addAttribute("notes", noteService.loadNotes(page));
        return "notes";
    }

    @RequestMapping(value = "/notes/edit", method = RequestMethod.POST)
    @ResponseBody
    public String editNote(@RequestParam Long id,
                           @RequestParam Long noteId,
                           @RequestParam String content) {
        noteService.editNote(id, noteId, content);
        return content;
    }
}
