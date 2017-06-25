package org.eneko.tab.notes.note;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by eneko on 25/06/17.
 */
@RunWith(SpringRunner.class)
public class NoteTest {

    @Test
    public void canCreateEmptyNote() {
        Note note = Note.builder().build();
        assertThat(note, notNullValue());
    }

    @Test
    public void canCreateNoteWithTitleTextAndPassword() {
        String title = "dummy-title";
        String text = "dummy-text";
        String password = "dummy-password";
        Note note = Note.builder().
                title(title)
                .text(text)
                .password(password)
                .build();
        assertThat(note.getTitle(),equalTo(title));
        assertThat(note.getText(),equalTo(text));
        assertThat(note.getPassword(),equalTo(password));
    }
}