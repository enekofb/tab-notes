package org.eneko.tab.notes.note.util;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.stereotype.Component;

/**
 * Created by eneko on 25/06/17.
 */
@Component
public class EncryptService {

    private BasicTextEncryptor textEncryptor;

    public EncryptService(){
        textEncryptor = new BasicTextEncryptor();
    }

    public void newEncryptSession(String password){
        textEncryptor.setPassword(password);
    }

    public void clearEncryptSession(){
        textEncryptor = new BasicTextEncryptor();
    }

    public String encrypt(String text) {
        return textEncryptor.encrypt(text);
    }

    public String decrypt(String text) {
        return textEncryptor.decrypt(text);
    }

}
