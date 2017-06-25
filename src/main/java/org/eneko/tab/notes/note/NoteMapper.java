package org.eneko.tab.notes.note;

import org.eneko.tab.notes.note.util.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by eneko on 25/06/17.
 */
@Component
public class NoteMapper {

    @Autowired
    EncryptService encryptService;

    public Note fromCreateNodeMapper(CreateNoteDAO createNoteDao){

        String encryptedText = encryptText(createNoteDao.getPassword(),createNoteDao.getText());

        Note note = Note.builder()
                .title(createNoteDao.getTitle())
                .text(encryptedText)
                .build();

        return note;
    }

    private String encryptText(String password, String text) {
        if(password.isEmpty())
            return "";
        encryptService.newEncryptSession(password);
        String encryptedText = encryptService.encrypt(text);
        encryptService.clearEncryptSession();
        return encryptedText;
    }
}
