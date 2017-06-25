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

    public RetrievedNoteDAO toRetrievedNoteDAO(Note foundNote, String password) {
        String decryptedText = decryptText(foundNote.getText(),password);
        return RetrievedNoteDAO.builder()
                .title(foundNote.getTitle())
                .text(decryptedText).build();
    }

    private String decryptText(String text, String password) {
        if(password.isEmpty())
            throw new RuntimeException("Invalid password");
        encryptService.newEncryptSession(password);
        String decryptedText = encryptService.decrypt(text);
        encryptService.clearEncryptSession();
        return decryptedText;
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
