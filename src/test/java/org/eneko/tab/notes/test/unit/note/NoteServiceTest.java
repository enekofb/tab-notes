package org.eneko.tab.notes.test.unit.note;

import org.eneko.tab.notes.note.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by eneko on 25/06/17.
 */
@RunWith(SpringRunner.class)
public class NoteServiceTest {
    @Mock
    private NoteRepository noteRepository;

    @Mock
    private NoteMapper noteMapper;

    @InjectMocks
    private NoteService noteService;

    @Test
    public void canCreateNotes(){
        String title = "title";
        String text = "text";

        CreateNoteDAO createNoteDao = mock(CreateNoteDAO.class);
        when(createNoteDao.getText()).thenReturn(text);
        when(createNoteDao.getTitle()).thenReturn(title);

        Note note = mock(Note.class);
        when(note.getText()).thenReturn(text);
        when(note.getTitle()).thenReturn(title);
        when(note.getId()).thenReturn("noteId");

        when(noteMapper.fromCreateNodeMapper(createNoteDao)).thenReturn(note);
        when(noteRepository.save(note)).thenReturn(note);

        String noteId = noteService.createNote(createNoteDao);

        assertThat(noteId,notNullValue());
        assertThat(note.getTitle(),equalTo(createNoteDao.getTitle()));
        assertThat(note.getText(),equalTo(createNoteDao.getText()));
    }


}