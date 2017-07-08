package ru.note.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.note.service.NoteService;

/**
 * Created by Bucky on 08.07.2017.
 */
@Configuration
@ComponentScan
public class NoteConfig {

    @Bean
    public NoteService noteService() {
        return new NoteService();
    }

}
