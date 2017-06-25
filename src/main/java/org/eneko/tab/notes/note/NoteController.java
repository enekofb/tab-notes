package org.eneko.tab.notes.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by eneko on 25/06/17.
 */
@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping(path = "/notes")
    public String createNote(@RequestBody CreateNoteDAO createdNoteDao) {
        return noteService.createNote(createdNoteDao);
    }

    @GetMapping(path = "/notes/{noteId}")
    public RetrievedNoteDAO findNoteByIdAndPassword(@PathVariable String noteId, @RequestParam String password) {
        return noteService.findNoteByIdAndPassword(noteId,password);
    }
}
