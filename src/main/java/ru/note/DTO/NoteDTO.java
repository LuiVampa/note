package ru.note.DTO;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Bucky on 09.07.2017.
 */
@Data
@Builder
public class NoteDTO {

    private Long id;
    private String content;
    private String name;
    private String date;
}
