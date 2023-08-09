package com.example.noteservice.controller;

import com.example.noteservice.model.Note;
import com.example.noteservice.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<Note>> notes() {
        return ResponseEntity.ok(noteService.notes());
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    @GetMapping("/getNoteById/{noteId}")
    public ResponseEntity<Note> getNoteById(@PathVariable("noteId") Long noteId) {
        return ResponseEntity.ok(noteService.getNoteById(noteId));
    }
}
