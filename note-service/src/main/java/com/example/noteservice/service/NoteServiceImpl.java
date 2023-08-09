package com.example.noteservice.service;

import com.example.noteservice.client.UserFeignClient;
import com.example.noteservice.dto.UserIdResponse;
import com.example.noteservice.exception.NoteNotFoundException;
import com.example.noteservice.model.Note;
import com.example.noteservice.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    private final UserFeignClient feignClient;

    public NoteServiceImpl(NoteRepository noteRepository, UserFeignClient feignClient) {
        this.noteRepository = noteRepository;
        this.feignClient = feignClient;
    }

    @Override
    public List<Note> notes() {
        return noteRepository.findAll();
    }

    @Override
    public Note createNote(Note note) {
        UserIdResponse userIdResponse = feignClient.getUserById(note.getUserId());

        if (userIdResponse == null) {
            throw new RuntimeException("User not found ");
        }

        note.setUserId(userIdResponse.getId());
        return noteRepository.save(note);
    }

    @Override
    public Note getNoteById(Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException(noteId));

        UserIdResponse userIdResponse = feignClient.getUserById(note.getUserId());

        if (userIdResponse == null) {
            throw new RuntimeException("User not found ");
        }

        return note;
    }
}
