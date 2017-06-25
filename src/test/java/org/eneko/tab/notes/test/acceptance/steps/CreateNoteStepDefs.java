package org.eneko.tab.notes.test.acceptance.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.eneko.tab.notes.TabNotesApplication;
import org.eneko.tab.notes.note.CreateNoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by eneko on 25/06/17.
 */
@SpringBootTest(classes = TabNotesApplication.class)
@ContextConfiguration(
        classes = TabNotesApplication.class,
        loader = SpringApplicationContextLoader.class)
@IntegrationTest
public class CreateNoteStepDefs {

    public static final String HTTP_LOCALHOST_8080_NOTES = "http://localhost:8080/notes";

    @Autowired
    RestTemplate noteServiceClient;

    private CreateNoteDAO createNoteDao;

    private String createNoteId;

    @Given("^I have an empty note$")
    public void iHaveAnEmptyNote() throws Throwable {
        createNoteDao = CreateNoteDAO.builder()
                .title("")
                .text("")
                .password("")
                .build();
        assertThat(createNoteDao,notNullValue());
    }

    @Given("^I have a note with title \"([^\"]*)\" text \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_have_a_note_with_title_text_and_password(String title, String text, String password) throws Throwable {
        createNoteDao = CreateNoteDAO.builder()
                .title(title)
                .text(text)
                .password(password)
                .build();

        assertThat(createNoteDao,notNullValue());
    }

    @When("^I create the note$")
    public void i_create_the_note() throws Throwable {
        createNoteId=noteServiceClient.postForObject(HTTP_LOCALHOST_8080_NOTES,createNoteDao,String.class);
        assertThat(createNoteId,notNullValue());
    }

    @Then("^note has been successfully created$")
    public void note_has_been_successfully_created() throws Throwable {
        assertThat(createNoteId,notNullValue());
    }
}
