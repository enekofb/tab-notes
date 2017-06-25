package org.eneko.tab.notes.test.acceptance.steps;

import cucumber.api.java.en.Given;
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

    private Note createNote;
    private Note createdNote;

    @Given("^I have an empty note$")
    public void iHaveAnEmptyNote() throws Throwable {
        createNote = Note.builder()
                .build();
        assertThat(createNote,notNullValue());
    }

    @Given("^I have a note with title \"([^\"]*)\" text \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_have_a_note_with_title_text_and_password(String title, String text, String password) throws Throwable {
        createNote = Note.builder()
                .title(title)
                .text(text)
                .password(password)
                .build();
        assertThat(createNote,notNullValue());
    }

    @When("^I create the note$")
    public void i_create_the_note() throws Throwable {
        createdNote = noteRepository.save(createNote);
        assertThat(createdNote,equalTo(createNote));
    }

    @Then("^note has been successfully created$")
    public void note_has_been_successfully_created() throws Throwable {
        assertThat(createdNote.getId(),notNullValue());
    }


}
