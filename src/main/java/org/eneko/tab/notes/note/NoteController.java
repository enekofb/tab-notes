package org.eneko.tab.notes.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eneko on 25/06/17.
 */
@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    public String createNote(CreateNoteDAO createdNoteDao) {
        return noteService.createNote(createdNoteDao);
    }

    public RetrievedNoteDAO findNoteByIdAndPassword(String noteId, String password) {
        return noteService.findNoteByIdAndPassword(noteId,password);
    }
}
