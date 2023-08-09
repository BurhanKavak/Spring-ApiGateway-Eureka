package com.example.noteservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoteNotFoundException extends RuntimeException{

    public NoteNotFoundException(Long noteId) {
        super("Note Not Found with id: " + noteId);
    }

}
