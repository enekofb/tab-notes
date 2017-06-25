package org.eneko.tab.notes.test.acceptance.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.eneko.tab.notes.note.Note;
import org.eneko.tab.notes.note.NoteRepository;
import org.eneko.tab.notes.test.unit.util.EncryptService;
import org.hamcrest.CoreMatchers;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by eneko on 25/06/17.
 */
public class RetrieveNoteStepDefs {

    @Autowired
    EncryptService encryptService;
    @Autowired
    NoteRepository noteRepository;

    private Note foundNote;
    private String noteId;
    private String noteClearText;
    private String foundNoteClearText;
    private EncryptionOperationNotPossibleException encryptionException;


    @Given("^I have a created a note with id \"([^\"]*)\" password \"([^\"]*)\"$")
    public void i_have_a_created_a_note_with_id(String noteId,String notePassword) throws Throwable {
        this.noteClearText = "text";
        this.encryptService.newEncryptSession(notePassword);
        Note existingNote =  Note.builder()
                .id(noteId)
                .title("title")
                .text(encryptService.encrypt(noteClearText))
                .build();
        Note createdNote = noteRepository.save(existingNote);
        assertThat(createdNote, CoreMatchers.notNullValue());
        encryptService.clearEncryptSession();
    }

    @When("^I retrieve a note with id \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_retrieve_a_note_with_id(String noteId,String password) throws Throwable {
        try{
            this.noteId = noteId;
            this.foundNote = noteRepository.findById(noteId);
            this.encryptService.newEncryptSession(password);
            this.foundNoteClearText = encryptService.decrypt(foundNote.getText());
            assertThat(foundNote,notNullValue());
            this.encryptService.clearEncryptSession();
        }catch (EncryptionOperationNotPossibleException ex){
            this.encryptionException = ex;
        }
    }

    @Then("^note has been successfully retrieved$")
    public void note_has_been_successfully_retrieved() throws Throwable {
        assertThat(foundNote.getId(),equalTo(noteId));
    }

    @Then("^note text has been successfully decrypted$")
    public void note_text_has_been_successfully_decrypted() throws Throwable {
        assertThat(foundNoteClearText,equalTo(noteClearText));
    }

    @Then("^note text has not been successfully decrypted$")
    public void note_text_has_not_been_successfully_decrypted() throws Throwable {
        assertThat(encryptionException,notNullValue());
        encryptionException = null;
    }

}
