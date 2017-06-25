package org.eneko.tab.notes.note;

import lombok.AllArgsConstructor;
import org.eneko.tab.notes.note.util.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by eneko on 25/06/17.
 */
@Component
@AllArgsConstructor
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteMapper noteMapper;

    public String createNote(CreateNoteDAO createNoteDao) {
        Note createNote = noteMapper.fromCreateNodeMapper(createNoteDao);
        Note createdNote = noteRepository.save(createNote);
        return createdNote.getId();
    }
}
