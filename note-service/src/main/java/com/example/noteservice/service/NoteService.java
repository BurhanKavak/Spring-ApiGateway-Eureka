package com.example.noteservice.service;

import com.example.noteservice.model.Note;

import java.util.List;

public interface NoteService {

    List<Note> notes();

    Note createNote(Note note);

    Note getNoteById(Long noteId);
}
