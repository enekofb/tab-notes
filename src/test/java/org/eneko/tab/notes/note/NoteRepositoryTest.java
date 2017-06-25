package org.eneko.tab.notes.note;

import org.eneko.tab.notes.TabNotesApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by eneko on 25/06/17.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TabNotesApplication.class)
public class NoteRepositoryTest {

    @Autowired
    NoteRepository noteRepository;

    @Test
    public void canCreateEmptyNotes(){
        Note note = Note.builder().build();
        Note savedNote = noteRepository.save(note);
        assertThat(note,equalTo(savedNote));
    }

    @Test
    public void canCreateNotEmptyNotes(){
        Note note = Note.builder()
                .title("title")
                .text("text")
                .build();
        Note savedNote = noteRepository.save(note);
        assertThat(note,equalTo(savedNote));
    }

    @Test
    public void canFindNoteById(){
        Note note = Note.builder()
                .id("id")
                .title("title")
                .text("text")
                .build();
        Note savedNote = noteRepository.save(note);
        Note foundNote = noteRepository.findById("id");
        assertThat(foundNote,equalTo(note));
        assertThat(foundNote,equalTo(savedNote));
    }



}