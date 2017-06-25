package org.eneko.tab.notes.test.acceptance.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.eneko.tab.notes.note.CreateNoteDAO;
import org.eneko.tab.notes.note.Note;
import org.eneko.tab.notes.note.NoteController;
import org.eneko.tab.notes.note.RetrievedNoteDAO;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by eneko on 25/06/17.
 */
public class RetrieveNoteStepDefs {

    @Autowired
    NoteController noteController;

    private String noteClearText;
    private String foundNoteClearText;
    private EncryptionOperationNotPossibleException encryptionException;

    private String createdNoteId;
    private String createNotedPassword;
    private RetrievedNoteDAO retrievedNote;
    private CreateNoteDAO createNoteDao;


    @Given("^I have a created a note with password \"([^\"]*)\"$")
    public void i_have_a_created_a_note_with_id(String notePassword) throws Throwable {
        createNoteDao = CreateNoteDAO.builder()
                .title("title")
                .text("text")
                .password(notePassword)
                .build();
        this.createdNoteId = noteController.createNote(createNoteDao);
        this.createNotedPassword = notePassword;
        assertThat(createdNoteId,notNullValue());
    }

    @When("^I retrieve created note by id with password \"([^\"]*)\"$")
    public void i_retrieve_a_note_by_id_with_password(String password){
        try{
            retrievedNote = noteController.findNoteByIdAndPassword(this.createdNoteId,password);
            assertThat(retrievedNote,notNullValue());
        }catch (EncryptionOperationNotPossibleException ex){
            this.encryptionException = ex;
        }
    }

    @Then("^note has been successfully retrieved$")
    public void note_has_been_successfully_retrieved() throws Throwable {
        assertThat(retrievedNote.getTitle(),equalTo(createNoteDao.getTitle()));
    }

    @Then("^note text has been successfully decrypted$")
    public void note_text_has_been_successfully_decrypted() throws Throwable {
        assertThat(retrievedNote.getText(),equalTo(createNoteDao.getText()));
    }

    @Then("^note has not been successfully retrieved$")
    public void noteHasNotBeenSuccessfullyRetrieved() throws Throwable {
        assertThat(encryptionException,notNullValue());
        encryptionException = null;
    }
}
