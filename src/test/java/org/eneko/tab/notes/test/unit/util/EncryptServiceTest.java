package org.eneko.tab.notes.test.unit.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by eneko on 25/06/17.
 */
@RunWith(SpringRunner.class)
public class EncryptServiceTest {

    private EncryptService encryptService;
    private String password;

    @Before
    public void setup(){
        password = "password";
        encryptService = new EncryptService();
        encryptService.newEncryptSession(password);
    }

    @After
    public void teardown(){
        encryptService.clearEncryptSession();;
        encryptService=null;
    }

    @Test
    public void canEncryptTextByPassword(){
        String text ="text";
        String encryptedText = encryptService.encrypt(text);
        assertThat(encryptedText,notNullValue());
        assertThat(encryptedText,is(not(equalTo(text))));
    }

    @Test
    public void canDecryptTextByPassword(){
        String text ="text";
        String encryptedText = encryptService.encrypt(text);
        String decrpytedText = encryptService.decrypt(encryptedText);
        assertThat(decrpytedText,notNullValue());
        assertThat(decrpytedText,is(equalTo(text)));
    }


}