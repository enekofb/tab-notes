package org.eneko.tab.notes.test.acceptance.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.eneko.tab.notes.TabNotesApplication;
import org.eneko.tab.notes.note.Note;
import org.eneko.tab.notes.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import sun.security.util.PendingException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by eneko on 25/06/17.
 */
@SpringBootTest(classes = TabNotesApplication.class)
@ContextConfiguration
public class CreateNoteStepDefs {
    @Autowired
    NoteRepository noteRepository;

    Note savedNote;

    @When("^I create an empty note$")
    public void i_create_an_empty_note() throws Throwable {
        Note note = Note.builder().build();
        savedNote = noteRepository.save(note);
        assertThat(note,equalTo(savedNote));
    }

    @Then("^note has been sucessfully created$")
    public void note_has_been_sucessfully_created() throws Throwable {
        assertThat(savedNote.getId(),notNullValue());

    }
}
